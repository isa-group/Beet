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

ppt /arrayOfObjectsEndpoint&arrayOfObjectsEndpoint&200&arrayOfObjectsProperty():::ENTER
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
variable return.arrayOfObjectsProperty
	var-kind field arrayOfObjectsProperty
	enclosing-var return
	dec-type arrayOfObjectsProperty[]
	rep-type hashcode
variable return.arrayOfObjectsProperty[..]
	var-kind array
	enclosing-var return.arrayOfObjectsProperty
	array 1
	dec-type arrayOfObjectsProperty[]
	rep-type hashcode[]

ppt /arrayOfObjectsEndpoint&arrayOfObjectsEndpoint&200&arrayOfObjectsProperty():::EXIT2
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
	dec-type arrayOfObjectsEndpoint&Output&200&arrayOfObjectsProperty
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

