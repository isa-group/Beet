decl-version 2.0
var-comparability implicit

ppt /primitiveInputsEndpoint/{stringInPath}:::CLASS
ppt-type class

ppt /primitiveInputsEndpoint/{stringInPath}&primitiveInputsEndpoint&200():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type primitiveInputsEndpoint&Input
	rep-type hashcode
variable input.doubleInQuery
	var-kind field doubleInQuery
	enclosing-var input
	dec-type double
	rep-type double
variable input.string&In&Path
	var-kind field string&In&Path
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

ppt /primitiveInputsEndpoint/{stringInPath}&primitiveInputsEndpoint&200():::EXIT1
ppt-type subexit
variable input
	var-kind variable
	dec-type primitiveInputsEndpoint&Input
	rep-type hashcode
variable input.doubleInQuery
	var-kind field doubleInQuery
	enclosing-var input
	dec-type double
	rep-type double
variable input.string&In&Path
	var-kind field string&In&Path
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
	dec-type primitiveInputsEndpoint&Output&200
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

