decl-version 2.0
var-comparability implicit

ppt /primitiveExitEndpoint:::CLASS
ppt-type class

ppt /primitiveExitEndpoint&primitiveExitEndpoint&200():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type primitiveExitEndpoint&Input
	rep-type hashcode
variable input.inputParameter
	var-kind field inputParameter
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /primitiveExitEndpoint&primitiveExitEndpoint&200():::EXIT1
ppt-type subexit
variable input
	var-kind variable
	dec-type primitiveExitEndpoint&Input
	rep-type hashcode
variable input.inputParameter
	var-kind field inputParameter
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type primitiveExitEndpoint&Output&200
	rep-type hashcode
variable return.stringProperty
	var-kind field stringProperty
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.double&Property
	var-kind field double&Property
	enclosing-var return
	dec-type double
	rep-type double
variable return.integerProperty
	var-kind field integerProperty
	enclosing-var return
	dec-type int
	rep-type int
variable return.boolean&Property
	var-kind field boolean&Property
	enclosing-var return
	dec-type boolean
	rep-type boolean

