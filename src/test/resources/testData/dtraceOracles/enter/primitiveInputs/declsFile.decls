decl-version 2.0
var-comparability implicit

ppt main.primitiveInputsEndpoint{stringInPath}:::CLASS
ppt-type class

ppt main.primitiveInputsEndpoint{stringInPath}.primitiveInputsEndpoint&200(main.primitiveInputsEndpoint&Input):::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type main.primitiveInputsEndpoint&Input
	rep-type hashcode
variable input.doubleInQuery
	var-kind field doubleInQuery
	enclosing-var input
	dec-type double
	rep-type double
variable input.stringInPath
	var-kind field stringInPath
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.integerInHeader
	var-kind field integerInHeader
	enclosing-var input
	dec-type int
	rep-type int
variable input.booleanInForm
	var-kind field booleanInForm
	enclosing-var input
	dec-type boolean
	rep-type boolean

ppt main.primitiveInputsEndpoint{stringInPath}.primitiveInputsEndpoint&200(main.primitiveInputsEndpoint&Input):::EXIT1
ppt-type subexit
variable input
	var-kind variable
	dec-type main.primitiveInputsEndpoint&Input
	rep-type hashcode
variable input.doubleInQuery
	var-kind field doubleInQuery
	enclosing-var input
	dec-type double
	rep-type double
variable input.stringInPath
	var-kind field stringInPath
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.integerInHeader
	var-kind field integerInHeader
	enclosing-var input
	dec-type int
	rep-type int
variable input.booleanInForm
	var-kind field booleanInForm
	enclosing-var input
	dec-type boolean
	rep-type boolean
variable return
	var-kind return
	dec-type main.primitiveInputsEndpoint&Output&200
	rep-type hashcode
variable return.property1
	var-kind field property1
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.property2
	var-kind field property2
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

