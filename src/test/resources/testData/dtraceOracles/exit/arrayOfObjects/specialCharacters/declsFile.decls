decl-version 2.0
var-comparability implicit

ppt /arrayOfObjectsEndpoint:::CLASS
ppt-type class

ppt /arrayOfObjectsEndpoint&arrayOfObjectsEndpoint&200():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type arrayOfObjectsEndpoint&Input
	rep-type hashcode
variable input.inputParameter
	var-kind field inputParameter
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /arrayOfObjectsEndpoint&arrayOfObjectsEndpoint&200&array.Of.Objects.Property():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type arrayOfObjectsEndpoint&Input
	rep-type hashcode
variable input.inputParameter
	var-kind field inputParameter
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /arrayOfObjectsEndpoint&arrayOfObjectsEndpoint&200():::EXIT1
ppt-type subexit
variable input
	var-kind variable
	dec-type arrayOfObjectsEndpoint&Input
	rep-type hashcode
variable input.inputParameter
	var-kind field inputParameter
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type arrayOfObjectsEndpoint&Output&200
	rep-type hashcode
variable return.stringProperty
	var-kind field stringProperty
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.array&Of&Objects&Property
	var-kind field array&Of&Objects&Property
	enclosing-var return
	dec-type array&Of&Objects&Property[]
	rep-type hashcode
variable return.array&Of&Objects&Property[..]
	var-kind array
	enclosing-var return.array&Of&Objects&Property
	array 1
	dec-type array&Of&Objects&Property[]
	rep-type hashcode[]

ppt /arrayOfObjectsEndpoint&arrayOfObjectsEndpoint&200&array.Of.Objects.Property():::EXIT2
ppt-type subexit
variable input
	var-kind variable
	dec-type arrayOfObjectsEndpoint&Input
	rep-type hashcode
variable input.inputParameter
	var-kind field inputParameter
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type arrayOfObjectsEndpoint&Output&200&array.Of.Objects.Property
	rep-type hashcode
variable return.property&1
	var-kind field property&1
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.property&2
	var-kind field property&2
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

