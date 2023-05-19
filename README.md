## Table of contents

1. [AGORA overview](#agora-overview)
1. [Beet execution example](#beet-execution-example)
   1. [Generation of declaration file](#generation-of-declaration-file)
   1. [Generation of data trace file](#generation-of-data-trace-file)
1. [Modifications on Daikon](#modifications-on-daikon)
   1. [Added invariants](#added-invariants)
   1. [Disabled invariants](#disabled-invariants)
   1. [Enabled invariants](#enabled-invariants)
   1. [Changes in computeConfidence functions](#changes-in-computeconfidence-functions)
   1. [Suppression of derived variables](#suppression-of-derived-variables)
   1. [Invariants disabled in the default Daikon configuration](#invariants-disabled-in-the-default-daikon-configuration)

## AGORA overview
The image below shows an overview of AGORA, an approach for the automated generation of test oracles for REST APIs. At the core of the approach is Beet, a novel Daikon instrumenter. Beet receives two inputs:

1. The OAS specification of the API under test.
1. A set of API requests with their corresponding responses.

As a result, Beet returns an instrumentation of the API requests consisting on a declaration file (describing the format of the API operations inputs and outputs) and a data trace file (specifying the values assigned to each input parameter and response field in each API call). This instrumentation is then processed by our customized version of Daikon, resulting in a set of likely invariants that can be potentially used as test oracles, once confirmed by the developer.

![AGORA workflow](https://imgur.com/bOIIMyq.png)

The following sections describe the functionality of Beet through a running example.

## Beet execution example

### Generation of declaration file
A declaration file specifies the structure of all the points of a program, including classes, objects, inputs and outputs of all the methods and functions that compose it. Since we are working in a black box testing context where we do not have access to the API source code, the only types of program points returned by Beet will be those that model the format of the inputs (ENTER) and outputs (EXIT).

To explain in detail the structure of a declaration file and exemplify the instrumentation process without showing redundant information, a simplified version of the "Get Album Tracks" operation of the Spotify API, shown in the Listing below, will be used as an example.

![OAS example](https://i.imgur.com/HZbivGu.png)

This operation receives parameters of different datatypes (`id` and `market` are strings, whereas `limit` is numeric) which are sent in different parts of the HTTP request (path and query). On the other hand, there are two possible types of response, each with its corresponding status code (lines 25 and 68).

The format of the response with code 200 illustrates the most common characteristics of the responses returned by an API, containing properties of different primitive datatypes (numeric, strings and  booleans), arrays of objects (property `items` on lines 34-67, and property `artists` on lines 39-47), arrays of primitive types (`available_markets`, lines 49-52, is an array of strings) and objects nested inside objects (each element of the object array `items` contains as a property an object `linked_from`, lines 61-67).

The Listing below displays a JSON that follows the response format of the 200-code responses.

![Example of JSON response](https://i.imgur.com/wAtftyf.png)

Beet would use the OAS from specification to generate a declaration file containing the input and output formats for each of the operations. This declaration file would follow the structure shown in the Listing below.

![Structure of declaration file](https://i.imgur.com/zHmmal0.png)

The declaration file starts by specifying the version of the file format (line 1), followed by all the program points of the API to be instrumented (in this case, it will be only ENTER and EXIT program points). There will be at least one ENTER and EXIT program point for each response code; each property of type array of objects will have its own ENTER and EXIT program points.

Using different program points depending on the response code allows, among other things, to detect invariants in the inputs that indicate the reasons why a certain type of response has been obtained. For example, if the Spotify API is well implemented, it should return a validation error (code 400) if the user enters invalid values for the numeric parameter `limit` (0 or a negative value) or for the string parameters `market` or `id` (for example, with an incorrect length).

Thus, for the program point that models inputs for which a valid output has been returned (`getAlbumTracks&200():::ENTER`), invariants that model this behavior will be obtained (`input. limit >= 1`,  `LENGTH(input.market)==2` and `LENGTH(input.id)==22`) that will not necessarily be present in the inputs of API requests that have returned a validation error (`getAlbumTracks&400()::::ENTER`).

Program points representing inputs will have exactly the same structure, differing only by their name (line 1), the Listing below shows an example of an ENTER program point.

![Example of ENTER program point](https://i.imgur.com/Z56NWgh.png)

Each program point begins with the specification of its name (line 1) followed by the type of program point (line 2). This is followed by the declarations of all variables involved in the program point. In this Listing, there is a variable of type object (`input`) that represents the whole input, with its properties being the different input parameters (`input.id`, `input.market` and `input.limit`). Each variable can contain the following fields:

* **var-kind \<kind\>:** Specifies the variable type. In our context, its possible values are:
    - **variable:** Used for input variables.
    - **return:** Used for output variables.
    - **field \<var-name\>:** Used for sub-properties of variables.
    - **array:** Used if the variable represents the elements of an array.

* **enclosing-var \<enclosing-var-name\>:** Used if the variable is a property of a variable of type object.

* **dec-type \<language-declaration\>:** Name of the variable datatype used in the original program. Primitive types must follow Java naming conventions (`int`, `boolean`, `double` or `java.lang.String`), whereas any value is accepted for objects.

* **rep-type \<daikon-type\>:** Specified the Daikon datatype used for representing the variable in the data trace file. The values of this field can be either `int`, `boolean`, `double` or `java.lang.String` for primitive variables, or `hashcode` for variables of type object.

* **array \<dim\>:** Number of dimensions of the array. Its value can be either 1 if the variable is an array, and 0 otherwise. The default value is 0.

![Example of EXIT program point (first nesting level)](https://i.imgur.com/2gComZ4.png)

The Listing above shows the program point that specifies the format of the API output when it returns a 200 code. The EXIT program points are numbered (line 1) and labeled as subexit (line 2). This is because, in other programming languages, a method may have several exits on different lines, which Daikon joins when reporting invariants.

When declaring an EXIT program point, it is necessary to include the input variables at the beginning again, which allows detecting invariants that compare variables of the inputs to variables of the outputs, such as `input.limit >= size(return.items[])`.

The output variables are found from line 5 of the Listing, where the object `return`, which contains all the fields of the response as properties, is found. Note that, in this case, its var-kind is return instead of variable.

As mentioned in describing the format of the response in the illustrative example, the `items` property of the response (`return.items` in the declaration file), is an array of object-like elements, each of which represents a song or track. When specifying an array property in a declaration, it is necessary to use two variables, one of type object represented by a hashcode that acts as a pointer (lines 19-23), and one of type array containing the array elements (lines 24-29).

The second variable, the one that defines the array elements, is declared as an array type (line 25), so it is necessary to specify that its dimensionality is not 0 (line 27), and its enclosing-var is the pointer (line 26). Since `return.items` is an array of objects, its representation will be an array of hashcodes (line 29).

Using only the hashcode of the elements of arrays of objects, no invariants related to these objects can be extracted, except those related to the size of the array, such as `input.limit >= size(return.items[])`. For this reason, a new program point is defined whose variables are the properties of the object type that compose it.

![Second EXIT nesting level](https://i.imgur.com/FxMbau4.png)

Note that the nesting hierarchy is represented using the “&” character as a separator to distinguish the different nesting levels (line 1). This program point contains two arrays, one of objects (lines 9-19) and one of strings (lines 20-30). Although it will be necessary to define a new nesting level (`200&items&artists`) for the array of objects, this will not occur with the array of strings, since the elements that compose it can be represented in a data trace file without resorting to a new nesting level.

In addition to these array-type properties, the Listing above also contains a nested object (`return.linked_from`, lines 39-53) with two primitive properties (`return.linked_from.id` and `return.linked_from.uri`), for which it is not necessary to create a new nesting level.

### Generation of data trace file
A data trace file contains the values assigned to each of the program variables (each of them belonging to a program point previously defined in the declaration file) throughout its execution. The Listing below contains a fragment of a data trace file corresponding to an input program point. As in the declaration file, the ENTER program points of the same test case will be identical, differing only by their name (line 1).

![ENTER data trace](https://i.imgur.com/oMACfrB.png)

Each representation of a program point in a data trace file has the following components:

* Program point name (line 1)
* For each variable:
    - Variable name (lines 2, 5, 8 and 11)
    - Variable value (lines 3, 6, 9 and 12):
        - If the variable is numeric, its value will be a sequence of digits that may be preceded by a minus sign. In the case of double type variables, a period may be used to indicate decimal digits.
        - If the variable is a string, its value must be enclosed in double quotes.
        - If the variable is an object, it will be represented by a hashcode, without quotation marks.
        - If the variable is an array, the array elements will be separated by spaces. The array elements will be between the characters “[” and “]”.
    - Modified bit (lines 4, 7, 10 and 13): Its value will be 1 if the variable has been assigned, and 0 otherwise.

The Listing below shows the structure that the complete data trace file will have for the running example, composed by a single test case. Note that each EXIT must be accompanied by its corresponding ENTER and that the same pair of inputs and outputs may be repeated in the same test if there is more than one element within an array of objects, as is the case for elements of type artist (lines 13-22).

![Structure of the data trace file](https://i.imgur.com/yNsaWvr.png)

The Listing below shows the value of the EXIT program point for the first nesting level of the response. As in the declaration file, when declaring an EXIT program point it is necessary to include the input variables at the beginning again.

![First data trace EXIT nesting level](https://i.imgur.com/Y8Uec0e.png)

In addition to two primitive variables (`return.total` and `return.href`), this EXIT contains a property of type array of objects (`return.items`), which is represented by two variables, an object type variable  acting as pointer represented by a hashcode (lines 13-15) and the variable containing the array elements, represented in this case by hashcodes (lines 16-18).

Next, a pair of program points (an ENTER and an EXIT) will be added for each element of the object array, as `return.items` contains only one element, only one ENTER and one EXIT will be generated, the latter represented in the Listing below. This program point contains the nested object `return.linked.linked_from` (lines 31-39), the array of objects `return.artists` (lines 7-12), and the array of strings `return.available.markets` (lines 13-18). In the case of `return.available.markets`, since it is an array with primitive elements, it is not necessary to define a new nesting level to detect invariants (such as `All the elements of return.markets have length 2`).

![Second data trace EXIT nesting level](https://i.imgur.com/lreisdM.png)

Finally, two pairs of ENTER and EXIT will be generated, one for each element of `return.artists`.

![Third data trace EXIT nesting level](https://i.imgur.com/z7rmJrn.png)


## Modifications on Daikon

This section describes the changes performed in Daikon version 5.8.10 (released on November 2021)

Section [Invariants disabled in the default Daikon configuration](#invariants-disabled-in-the-default-daikon-configuration) contains the 13 invariants that we disabled in the default Daikon configuration to avoid a combinatorial explosions
of string comparisons and a high number of false positives.


### Added invariants

1. **IsUrl:** Indicates that the value of a string variable is always a URL. Represented as `x is Url`.

1. **SequenceStringElementsAreUrl:** Indicates that all elements of an array of strings are URLs. Represented
   as `All the elements of x are URLs`.

1. **FixedLengthString:** Indicates that the value of a string variable always has a fixed length n. Represented
   as `LENGTH(x)==n`.

1. **SequenceFixedLengthString:** Indicates that all the elements of an array of strings have a fixed length n.
   Represented as `All the elements of x have LENGTH=n`.

1. **IsNumeric:** Indicates that the characters of a string variable are always numeric. Represented as `x is
   Numeric`.

1. **SequenceStringElementsAreNumeric:** Indicates that the characters of all the elements of an array of
   strings are always numeric. Represented as `All the elements of x are Numeric`.

1. **IsEmail:** Indicates that the value of a string type variable is always an email. Represented as `x is Email`.

1. **SequenceStringElementsAreEmail:** Indicates that all elements of an array of strings are emails.
   Represented as `All the elements of x are emails`.

1. **IsDateDDMMYYYY:** Indicates that the value of a string variable is always a date following the format
   DD/MM/YYYY (the separator can be “/” or “-“). Represented as `x is a Date. Format: DD/MM/YYYY`.

1. **SequenceStringElementsAreDateDDMMYYYY:** Indicates that all the elements of an array of strings are
   dates following the format DD/MM/YYYY. Represented as `All the elements of x are dates`.
   Format: DD/MM/YYYY.

1. **IsDateMMDDYYYY:** Indicates that the value of a string variable is always a date following the format
   MM/DD/YYYY (the separator can be “/” or “-“). Represented as `x is a Date. Format: MM/DD/YYYY`.

1. **SequenceStringElementsAreDateMMDDYYYY:** Indicates that all the elements of an array of strings are
   dates following the format MM/DD/YYYY. Represented as `All the elements of x are dates`.
   Format: MM/DD/YYYY.

1. **IsDateYYYYMMDD:** Indicates that the value of a string variable is always a date following the format
   YYYY/MM/DD (the separator can be “/” or “-“). Represented as `x is a Date. Format: YYYY/MM/DD`.

1. **SequenceStringElementsAreDateYYYYMMDD:** Indicates that all the elements of an array of strings are
   dates following the format YYYY/MM/DD. Represented as `All the elements of x are dates.
   Format: YYYY/MM/DD`.

1. **IsHour:** Indicates that the value of a string variable is always a time in 24-hour format. Represented as `x
   is Hour: HH:MM 24-hour format, optional leading 0`.

1. **SequenceStringElementsAreHour:** Indicates that all elements of an array of strings are hours in 24-hour
   format. Represented as `All the elements of x are Hours: HH:MM 24-hour format,
   optional leading 0`.

1. **IsHourAMPM:** Indicates that the value of a string variable is always a time in 12-hour format. Represented
   as `x is Hour: HH:MM 12-hour format, optional leading 0`.

1. **SequenceStringElementsAreHourAMPM:** Indicates that all elements of an array of strings are hours in
   12-hour format. Represented as `All the elements of x are Hours: HH:MM 12-hour format,
   optional leading 0, mandatory meridiems (AM/PM)`.

1. **IsHourWithSeconds:** Indicates that the value of a string variable is always a time in 24-hour format,
   including seconds. Represented as `x is Hour: HH:MM:SS 24-hour format with optional
   leading 0`.

1. **SequenceStringElementsAreHourWithSeconds:** Indicates that all elements of an array of strings are hours
   in 24-hour format, including seconds. Represented as `All the elements of x are Hours:
   HH:MM:SS 24-hour format with optional leading 0`.

1. **IsTimestampYYYYMMHHThhmmssmm:** Indicates that the value of a string variable is always a timestamp.
   Represented as x is Timestamp. Format: `YYYY-MM-DDTHH:MM:SS.mmZ (Miliseconds are
   optional)`.

1. **SequenceStringElementsAreTimestampYYYYMMHHThhmmssmm:** Indicates that all elements of an array
   of strings are timestamps. Represented as All the elements of x are Timestamps. Format:
   `YYYY-MM-DDTHH:MM:SS.mmZ (Miliseconds are optional)`.

### Disabled invariants
Section [5.5 Invariant list](https://plse.cs.washington.edu/daikon/download/doc/daikon.html#Invariant-list) of the Daikon user manual contains a description of each one of these invariants.

1. **daikon.inv.unary.scalar.NonZero**
1. **daikon.inv.unary.scalar.NonZeroFloat**
1. **daikon.inv.unary.scalar.RangeInt.PowerOfTwo**
1. **daikon.inv.unary.sequence.EltNonZero**
1. **daikon.inv.unary.sequence.EltNonZeroFloat**
1. **daikon.inv.unary.sequence.EltRangeInt.PowerOfTwo**
1. **daikon.inv.binary.twoScalar.IntNonEqual**
1. **daikon.inv.binary.twoScalar.FloatNonEqual**
1. **daikon.inv.binary.twoScalar.LinearBinary**
1. **daikon.inv.binary.twoScalar.LinearBinaryFloat**
1. **daikon.inv.binary.twoString.StringNonEqual**
1. **daikon.inv.binary.twoString.StringLessThan**
1. **daikon.inv.binary.twoString.StringGreaterThan**
1. **daikon.inv.binary.twoString.StringLessEqual**
1. **daikon.inv.binary.twoString.StringGreaterEqual**
1. **daikon.inv.binary.twoSequence.SeqSeqStringEqual**
1. **daikon.inv.binary.twoSequence.SeqSeqStringLessThan**
1. **daikon.inv.binary.twoSequence.SeqSeqStringGreaterThan**
1. **daikon.inv.binary.twoSequence.SeqSeqStringLessEqual**
1. **daikon.inv.binary.twoSequence.SeqSeqStringGreaterEqual**
1. **daikon.inv.binary.twoSequence.PairwiseStringLessThan**
1. **daikon.inv.binary.twoSequence.PairwiseStringGreaterThan**
1. **daikon.inv.binary.twoSequence.PairwiseStringLessEqual**
1. **daikon.inv.binary.twoSequence.PairwiseStringGreaterEqual**
1. **daikon.inv.ternary.threeScalar.LinearTernary**
1. **daikon.inv.ternary.threeScalar.LinearTernaryFloat**
1. **daikon.inv.binary.twoScalar.NumericInt.Divides**
1. **daikon.inv.binary.twoScalar.NumericInt.Square**
1. **daikon.inv.binary.twoScalar.NumericFloat.Divides**
1. **daikon.inv.binary.twoScalar.NumericFloat.Square**
1. **daikon.inv.binary.twoSequence.PairwiseNumericInt.Divides**
1. **daikon.inv.binary.twoSequence.PairwiseNumericInt.Square**
1. **daikon.inv.binary.twoSequence.PairwiseNumericFloat.Divides**
1. **daikon.inv.binary.twoSequence.PairwiseNumericFloat.Square**
1. **daikon.inv.binary.twoSequence.PairwiseLinearBinary**
1. **daikon.inv.binary.twoSequence.PairwiseLinearBinaryFloat**

### Enabled invariants
Section [5.5 Invariant list](https://plse.cs.washington.edu/daikon/download/doc/daikon.html#Invariant-list) of the Daikon user manual contains a description of each one of these invariants.

1. **daikon.inv.binary.twoString.StdString.SubString:** We applied two modifications on this invariant:
    - We added a property that sets a minimum string length (2 by default) in order to avoid reporting that a string that is always empty is always a substring of every other string in the program point.

    - This invariant may report redundant information that would bloat our results, for example, if x is a substring of y and y is a substring of z, Daikon would report the invariants: “x is substring of y”, “y is substring of z” and “x is substring of z”. In this situation we consider the “x is substring of z” invariant redundant and modified Daikon so it would not report redundant invariants, in order to avoid bloating the results.

1. **daikon.inv.binary.twoSequence.SubSequence**
1. **daikon.inv.binary.twoSequence.SubSequenceFloat**
1. **daikon.inv.binary.twoSequence.SubSet**
1. **daikon.inv.binary.twoSequence.SubSetFloat**
1. **daikon.inv.binary.twoSequence.SuperSequence**
1. **daikon.inv.binary.twoSequence.SuperSequenceFloat**
1. **daikon.inv.binary.twoSequence.SuperSet**
1. **daikon.inv.binary.twoSequence.SuperSetFloat**

### Changes in computeConfidence functions
At the end of the Daikon execution, the `computeConfidence` function is executed for every invariant that has not been falsified, returning a number between 0 and 1.
If this number achieves a certain threshold, the invariant is considered to be statistically justified and it is reported to the user. We found some invariants for which
Daikon always returned a confidence of 1.

```
protected double computeConfidence() {
   return CONFIDENCE_JUSTIFIED;
}
```

We modified these functions to return 1 only if there was at least one occurrence of the invariant during the program execution.

```
protected double computeConfidence() {
    if (ppt.num_samples() == 0) {
      return CONFIDENCE_UNJUSTIFIED;
    }
return CONFIDENCE_JUSTIFIED;
}
```

These are the invariants for which we modified the `computeConfidence` function:

* Unary:
    - Scalar:
        - RangeFloat
        - RangeInt
    - Sequence:
        - EltRangeFloat
        - EltRangeInt
* Binary:
    - SequenceString:
        - MemberString
    - SequenceScalar:
        - Member
        - MemberFloat
    - TwoSequence:
        - Reverse
    - ReverseFloat
        - SubSequence
        - SubSequenceFloat
        - Subset

### Suppression of derived variables

A derived variable is an expression that does not appear directly in the instrumented program,
but which Daikon uses as a variable for invariant detection.
For example, for array variables, Daikon generates a derived variable whose value is its size,
allowing to detect invariants such as `input.limit >= size(return.items)`.

However, there are derived variables that do not provide any relevant information, this is the case of the derived variable
`orig()`, which indicates the value of a variable at the input program point and is used to make comparisons with
the value of the same variable at the output program point. In the context of black box testing of RESTful APIs, the value
of the input parameters does not change at any time, so Daikon would only detect equality invariants between the parameter
value at the input and output (`input.limit == orig(input.limit)`) that will always be satisfied.
For this reason, this derived variable has been disabled.

In some cases, Daikon applies the `shift` derived variable (consisting on decreasing the value of a numerical variable by a shift value)
to try to find relations between numerical variables (e.g., `input-1 > return`), we disabled this derived variable because it would most likely
report misleading information.

### Invariants disabled in the default Daikon configuration
Section [5.5 Invariant list](https://plse.cs.washington.edu/daikon/download/doc/daikon.html#Invariant-list) of the Daikon user manual contains a description of each one of these invariants.

1. **daikon.inv.binary.twoString.StringNonEqual**
1. **daikon.inv.binary.twoString.StringLessThan**
1. **daikon.inv.binary.twoString.StringGreaterThan**
1. **daikon.inv.binary.twoString.StringLessEqual**
1. **daikon.inv.binary.twoString.StringGreaterEqual**
1. **daikon.inv.binary.twoSequence.SeqSeqStringLessThan**
1. **daikon.inv.binary.twoSequence.SeqSeqStringGreaterThan**
1. **daikon.inv.binary.twoSequence.SeqSeqStringLessEqual**
1. **daikon.inv.binary.twoSequence.SeqSeqStringGreaterEqual**
1. **daikon.inv.binary.twoSequence.PairwiseStringLessThan**
1. **daikon.inv.binary.twoSequence.PairwiseStringGreaterThan**
1. **daikon.inv.binary.twoSequence.PairwiseStringLessEqual**
1. **daikon.inv.binary.twoSequence.PairwiseStringGreaterEqual**




