# Beet
<img src="https://imgur.com/TOkDKjQ.png" alt="Beet logo" width="200">

Beet is a Daikon *front-end* (also known as instrumenter) that converts any OpenAPI specification and a collection of API requests (and responses) 
into a format processable by the [Daikon invariant detector](https://plse.cs.washington.edu/daikon/). Beet is one of the core components of AGORA, an approach for 
the **A**utomated **G**eneration of test **O**racles for **R**EST **A**PIs through the detection of invariants (properties of the output that should always hold).

AGORA aims to learn the expected behavior of an API by analyzing previous API requests and their corresponding responses. AGORA operates in 
black-box mode, making it applicable to any REST API and seamlessly integrable into existing API testing tools.

The test oracles generated by AGORA have revealed bugs in APIs with millions of users: Amadeus Hotel, GitHub, Marvel, OMDb and YouTube. 
Our reports have guided developers in improving their APIs, including bug fixes and documentation updates in GitHub.

# Index

1. [Wiki](#wiki)
2. [AGORA Overview](#agora-overview)
3. [Publication](#publication)
4. [Motivational example](#motivational-example)
5. [Types of errors detected by AGORA](#types-of-errors-detected-by-agora)
6. [Executing Beet](#executing-beet)
7. [Executing modified version of Daikon](#executing-modified-version-of-daikon)


# Wiki
In this page, you can find a brief description of Beet and AGORA workflows with an illustrating example. If you want to know more details about 
Beet instrumentation process, the types of invariants supported by our modified version of Daikon and the different configuration options, 
please refer to our [Wiki](https://github.com/isa-group/Beet/wiki).

# AGORA Overview
The image below shows an overview of the complete workflow of AGORA. At the core of the approach is Beet, that receives two inputs:

1.	The OAS specification of the API under test.
2.	A set of API requests with their corresponding responses.

As a result, Beet returns an instrumentation of the API requests consisting of a declaration file (describing the format of the API operations 
inputs and outputs) and a data trace file (specifying the values assigned to each input parameter and response field in each API call). This 
instrumentation is then processed by our customized version of Daikon, resulting in a set of likely invariants that can be potentially used as 
test oracles, once confirmed by the developer.

![AGORA workflow](https://i.imgur.com/hYa5EAl.png)

Additionally, the reported invariants can be converted into executable assertions using [PostmanAssertify](https://github.com/JuanCarlosAlonsoValenzuela/PostmanAssertify), a software tool that automatically generates a Postman collection containing a request for each response code of all the operations for which AGORA has detected invariants, each of them containing a test script with all the confirmed invariants implemented as assertions.

# Publication
AGORA has been accepted for publication in the technical track of the [*ACM SIGSOFT International Symposium on Software Testing and Analysis 2023 (ISSTA 2023)*](https://dl.acm.org/doi/10.1145/3597926.3598114) (pre-print available [here](https://www.javalenzuela.com/publication/2023_issta_agora/2023_issta_agora.pdf)), and received the [ACM SIGSOFT Distinguished Artifact Award](https://doi.org/10.5281/zenodo.7970822). 
A very preliminary version of AGORA (two-page abstract) obtained the first prize (graduate category) in the [ACM Student Research Competition of ESEC/FSE 2022](https://src.acm.org/candidates/2023), and the [second prize in the ACM Student Research Competition Grand Finals 2023](https://src.acm.org/grand-finalists/2023).

If you want to cite Beet or AGORA in your research, please use the BibTeX entry below.

```
@inproceedings{Alonso2023AGORA,
author = {Alonso, Juan C. and Segura, Sergio and Ruiz-Cort\'{e}s, Antonio},
title = {AGORA: Automated Generation of Test Oracles for REST APIs},
year = {2023},
isbn = {9798400702211},
publisher = {Association for Computing Machinery},
address = {New York, NY, USA},
url = {https://doi.org/10.1145/3597926.3598114},
doi = {10.1145/3597926.3598114},
abstract = {Test case generation tools for REST APIs have grown in number and complexity in recent years. However, their advanced capabilities for automated input generation contrast with the simplicity of their test oracles, which limit the types of failures they can detect to crashes, regressions, and violations of the API specification or design best practices. In this paper, we present AGORA, an approach for the automated generation of test oracles for REST APIs through the detection of invariants—properties of the output that should always hold. In practice, AGORA aims to learn the expected behavior of an API by analyzing previous API requests and their corresponding responses. For this, we extended the Daikon tool for dynamic detection of likely invariants, including the definition of new types of invariants and the implementation of an instrumenter called Beet. Beet converts any OpenAPI specification and a collection of API requests and responses to a format processable by Daikon. As a result, AGORA currently supports the detection of up to 105 different types of invariants in REST APIs. AGORA achieved a total precision of 81.2\% when tested on a dataset of 11 operations from 7 industrial APIs. More importantly, the test oracles generated by AGORA detected 6 out of every 10 errors systematically seeded in the outputs of the APIs under test. Additionally, AGORA revealed 11 bugs in APIs with millions of users: Amadeus, GitHub, Marvel, OMDb and YouTube. Our reports have guided developers in improving their APIs, including bug fixes and documentation updates in GitHub. Since it operates in black-box mode, AGORA can be seamlessly integrated into existing API testing tools.},
booktitle = {Proceedings of the 32nd ACM SIGSOFT International Symposium on Software Testing and Analysis},
pages = {1018–1030},
numpages = {13},
keywords = {automated testing, invariant detection, REST APIs, test oracle},
location = {Seattle, WA, USA},
series = {ISSTA 2023}
}
```

# Motivational example
The image below depicts an excerpt of a simplified version of the `getAlbumTracks` operation of the Spotify API. This document describes the API functionality 
in terms of the input parameters (lines 5-20) and the possible response formats (lines 21-61). This operation receives as input an album id (`id` parameter), a country 
code (`market`) and the maximum number of songs to fetch (`limit`) and returns the list of tracks of the album.

![OAS Spotify](https://imgur.com/aBlvpNQ.png)

The JSON below shows a response for the `getAlbumTracks` operation conforming to the provided specification. Existing approaches for automated testing of REST 
APIs would label this response as valid because the API is not returning a server error and the response is conformant to the API specification.

```
{
    "total": 14,
    "href": "https://api.spotify.com/albums/4Em5W5HgYEvhpc/tracks?limit=1&market=ES",
    "items": [
        {
            "artists": [
                {
                    "id": "2CvCyf1gEVhI0mX6aFXmVI",
                    "name": "Paul Simon"
                },
                {
                    "id": "70cRZdQywnSFp9pnc2WTCE",
                    "name": "Arthur Garfunkel"
                }
            ],
            "available_markets": [ "ES", "US", "JP" ],
            "id": "0gFvkiT2afIcJwNxXQ7W51",
            "name": "Mrs. Robinson",
            "explicit": false,
            "linked_from": {
                "id": "98cZPdKywnMGp8fnw2XTYU",
                "uri": "https://spotify.com/artist/98cZPdKywnMGp8fnw2XTYU"
            }
        }
    ]
}
```

However, there are many domain-specific test oracles that should be taken into consideration before considering this response as valid. For instance:
- The value of the `total` response field should be greater or equal to the number of returned results (i.e., the size of the `items` array).
- The value of the `limit` input parameter should be greater or equal to the number of returned results.
-	Certain response fields should follow specific formats, such as URLs (`href`, `uri`, etc.), database ids (`id` fields) or country codes (`available_markets`).
-	We should expect every track to have at least one artist.
<!-- -	The value of the `type` response field should be “artist” if the object is an artist, and “track” if the object is a track. -->
-	The value of the `href` response field should contain the database id and the market provided as inputs.
-	...

AGORA can learn all these test oracles by analyzing a small set of test cases for which only the inputs and outputs are known. The image below shows 
some of the invariants reported by AGORA for this operation:

![Sample invariants](https://imgur.com/Ck96XHr.png)

# Types of errors detected by AGORA

The invariants reported by AGORA play a dual role in fault detection:
- **Invalid invariants:** These are invariants reported by AGORA that reveal inconsistent behavior. For example, in the Amadeus Hotel API, AGORA detected hotel rooms with zero beds (invariant: `return.room.typeEstimated.beds>=0`). These invariants reveal faults detected during the invariant detection process and require of manual inspection to be confirmed as inconsistent.
- **Violated valid invariants:** The disappearance of a confirmed invariant (i.e., test oracle) when increasing the size of the input dataset reveals that a counterexample (i.e., failure) has been detected. Violated valid invariants can be automatically detected and indicate faults observed in production.

Our paper contains a section describing all the domain-specific faults detected in industrial APIs with millions of users worldwide.


# Executing Beet

This section describes how to use Beet to generate a declaration and a data trace file from an OAS specification and a set of API requests in CSV format. 
To execute Beet, run the `GenerateInstrumentation` class inside the main package. This class receives the following parameters:

- `openApiSpecPath`: Relative path to the OpenAPI specification of the API under test. Beet will use this file to create a declaration file describing the input and output format of every API operation.
- `testCasesFilePath`: Relative path to the CSV file, with each row containing an API operation input parameter values and the response in JSON format. Beet will use this file to create a data trace file containing the values assigned to each input and response field of the declaration file in each API request.
- `generateDtrace`: This Boolean parameter indicates whether Beet should generate a data trace file. If set to false, Beet will only generate a declaration file.
- `stringsToConsiderAsNull`: Some APIs use empty strings (“”) or specific keywords instead of null values. For instance, the OMDb API uses the string “N/A” instead of setting a response field as null. This behavior could result in the undesired suppression of valid invariants (e.g., suppression of the `return.href is an URL` invariant). To prevent this, you can use this parameter to specify a set of keywords that can be considered as null values, and thus ignored.

![Executing Beet](https://i.imgur.com/dXi8EKv.png)

Beet requires Java JDK 17 to run. The `src/test/resources/examples` directory of the repository contains examples belonging to different industrial APIs 
(Amadeus Hotel, GitHub, Marvel, OMDb, Spotify, Yelp and YouTube). 

The [Input CSV format](https://github.com/isa-group/Beet/wiki/Beet#input-csv-format) section of the repository wiki describes the format that the CSV files provided to Beet must follow.


# Executing modified version of Daikon
The files generated by Beet are used as input to [Daikon](https://plse.cs.washington.edu/daikon/) to detect invariants that, once confirmed by a developer, can be used as test oracles. We recommend using the modified version of Daikon presented in our paper instead of the default one. 

This version of Daikon has been modified based on an analysis of a systematically collected dataset of 40 APIs (+700 operations) and its precision outperforms the one achieved by the default version of Daikon by a margin of more than 30% (in the context of REST APIs). This version of Daikon supports a total of 105 different types of invariants. 

Please refer to our Wiki for a complete list of the [modifications performed on Daikon](https://github.com/isa-group/Beet/wiki/Modified-version-of-Daikon#modifications-on-daikon) and a [taxonomy of the supported invariants](https://github.com/isa-group/Beet/wiki/Modified-version-of-Daikon#invariants-taxonomy).

The source code of our modified version of Daikon can be found [here](https://github.com/JuanCarlosAlonsoValenzuela/daikon_modified). However, we recommend using the Docker image that we provide for an easier installation. 
[The official Daikon documentation](https://plse.cs.washington.edu/daikon/download/doc/) describes how to install and configure Daikon without using our image.

1.	First, we need to pull the image containing the modified version of Daikon:

```
docker pull javalenzuela/daikon_agora
```

2.	Next, we execute the container by specifying the absolute path of the folder containing the declaration and data trace files.

```
docker run --rm -v C:\pathToFolderContainingFilesInHost:/files javalenzuela/daikon_agora java -jar daikon_modified.jar /files/declsFile.decls /files/dtraceFile.dtrace > invariants.csv
```

For instance, if the folder `C:\myUser\instrumentation` contains the declaration and data trace files (and they are named `declsFile.decls` and `dtraceFile.dtrace`):

```
docker run --rm -v C:\myUser\instrumentation:/files javalenzuela/daikon_agora java -jar daikon_modified.jar /files/declsFile.decls /files/dtraceFile.dtrace > invariants.csv
```

This will result in a file in csv format  (as the one in the snippet below) containing the invariants detected in each program point. The [Daikon container configuration options](https://github.com/isa-group/Beet/wiki/Modified-version-of-Daikon#daikon-container-configuration-options) section of the repository 
Wiki describes the available configuration options when running this version of Daikon, such as the possibility of automatically discarding invariants of the Arithmetic 
comparisons category, which are the main cause behind the false positives reported by AGORA (according to the evaluation conducted in our paper).

```
pptname;invariant;invariantType;variables;postmanAssertion
/albums/{id}/tracks&getAlbumTracks&200&items&artists():::EXIT;LENGTH(return.href)==57;daikon.inv.unary.string.FixedLengthString;(return.href);pm.expect(return_href).to.have.length(57)
/albums/{id}/tracks&getAlbumTracks&200&items&artists():::EXIT;return.href is Url;daikon.inv.unary.string.IsUrl;(return.href);pm.expect(return_href).to.match(/^(?:(?:
9]+)(?:\.(?:[\w\u00a1-\uffff0-9]+-)*[\w\u00a1-\uffff0-9]+)*(?:\.(?:[a-zA-Z\u00a1-\uffff]{2,})))(?::\d{2,5})?(?:\/[^\s]*)?$/)
/albums/{id}/tracks&getAlbumTracks&200&items&artists():::EXIT;LENGTH(return.id)==22;daikon.inv.unary.string.FixedLengthString;(return.id);pm.expect(return_id).to.have.length(22)
/albums/{id}/tracks&getAlbumTracks&200&items&artists():::EXIT;"return.type == ""artist""";daikon.inv.unary.string.OneOfString;(return.type);"pm.expect([""artist""].includes(return_type)).to.be.true"
/albums/{id}/tracks&getAlbumTracks&200&items&artists():::EXIT;LENGTH(return.type)==6;daikon.inv.unary.string.FixedLengthString;(return.type);pm.expect(return_type).to.have.length(6)
/albums/{id}/tracks&getAlbumTracks&200&items&artists():::EXIT;LENGTH(return.uri)==37;daikon.inv.unary.string.FixedLengthString;(return.uri);pm.expect(return_uri).to.have.length(37)
/albums/{id}/tracks&getAlbumTracks&200&items&artists():::EXIT;return.id is a substring of return.href;daikon.inv.binary.twoString.StdString$SubString;(return.href, return.id);pm.expect(return_href.includes(return_id)).to.be.true
...
```
