decl-version 2.0
var-comparability implicit

ppt /exitOfTypeNestedArrayEndpoint:::CLASS
ppt-type class

ppt /exitOfTypeNestedArrayEndpoint&exitOfTypeNestedArrayEndpoint&200():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type exitOfTypeNestedArrayEndpoint&Input
	rep-type hashcode
variable input.inputParameter
	var-kind field inputParameter
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /exitOfTypeNestedArrayEndpoint&exitOfTypeNestedArrayEndpoint&200&nestedArrayProperty():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type exitOfTypeNestedArrayEndpoint&Input
	rep-type hashcode
variable input.inputParameter
	var-kind field inputParameter
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /exitOfTypeNestedArrayEndpoint&exitOfTypeNestedArrayEndpoint&200&nestedArrayProperty%array():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type exitOfTypeNestedArrayEndpoint&Input
	rep-type hashcode
variable input.inputParameter
	var-kind field inputParameter
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /exitOfTypeNestedArrayEndpoint&exitOfTypeNestedArrayEndpoint&200&nestedArrayProperty%array%array():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type exitOfTypeNestedArrayEndpoint&Input
	rep-type hashcode
variable input.inputParameter
	var-kind field inputParameter
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /exitOfTypeNestedArrayEndpoint&exitOfTypeNestedArrayEndpoint&200():::EXIT1
ppt-type subexit
variable input
	var-kind variable
	dec-type exitOfTypeNestedArrayEndpoint&Input
	rep-type hashcode
variable input.inputParameter
	var-kind field inputParameter
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type exitOfTypeNestedArrayEndpoint&Output&200
	rep-type hashcode
variable return.stringProperty
	var-kind field stringProperty
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.nestedArrayProperty
	var-kind field nestedArrayProperty
	enclosing-var return
	dec-type nestedArrayProperty[]
	rep-type hashcode
variable return.nestedArrayProperty[..]
	var-kind array
	enclosing-var return.nestedArrayProperty
	array 1
	dec-type nestedArrayProperty[]
	rep-type hashcode[]

ppt /exitOfTypeNestedArrayEndpoint&exitOfTypeNestedArrayEndpoint&200&nestedArrayProperty():::EXIT2
ppt-type subexit
variable input
	var-kind variable
	dec-type exitOfTypeNestedArrayEndpoint&Input
	rep-type hashcode
variable input.inputParameter
	var-kind field inputParameter
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type exitOfTypeNestedArrayEndpoint&Output&200&nestedArrayProperty
	rep-type hashcode
variable return.propertyOfArray
	var-kind field propertyOfArray
	enclosing-var return
	dec-type double
	rep-type double

ppt /exitOfTypeNestedArrayEndpoint&exitOfTypeNestedArrayEndpoint&200&nestedArrayProperty%array():::EXIT3
ppt-type subexit
variable input
	var-kind variable
	dec-type exitOfTypeNestedArrayEndpoint&Input
	rep-type hashcode
variable input.inputParameter
	var-kind field inputParameter
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type exitOfTypeNestedArrayEndpoint&Output&200&nestedArrayProperty%array
	rep-type hashcode
variable return.array
	var-kind field array
	enclosing-var return
	dec-type array[]
	rep-type hashcode
variable return.array[..]
	var-kind array
	enclosing-var return.array
	array 1
	dec-type array[]
	rep-type hashcode[]

ppt /exitOfTypeNestedArrayEndpoint&exitOfTypeNestedArrayEndpoint&200&nestedArrayProperty%array%array():::EXIT4
ppt-type subexit
variable input
	var-kind variable
	dec-type exitOfTypeNestedArrayEndpoint&Input
	rep-type hashcode
variable input.inputParameter
	var-kind field inputParameter
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type exitOfTypeNestedArrayEndpoint&Output&200&nestedArrayProperty%array%array
	rep-type hashcode
variable return.array
	var-kind field array
	enclosing-var return
	dec-type array[]
	rep-type hashcode
variable return.array[..]
	var-kind array
	enclosing-var return.array
	array 1
	dec-type array[]
	rep-type hashcode[]

