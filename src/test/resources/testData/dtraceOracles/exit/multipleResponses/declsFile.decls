decl-version 2.0
var-comparability implicit

ppt /multipleOperationsEndpoint:::CLASS
ppt-type class

ppt /multipleOperationsEndpoint&multipleOperationsEndpoint&200():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type multipleOperationsEndpoint&Input
	rep-type hashcode
variable input.inputParameter
	var-kind field inputParameter
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /multipleOperationsEndpoint&multipleOperationsEndpoint&200&arrayOfObjectsProperty():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type multipleOperationsEndpoint&Input
	rep-type hashcode
variable input.inputParameter
	var-kind field inputParameter
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /multipleOperationsEndpoint&multipleOperationsEndpoint&400():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type multipleOperationsEndpoint&Input
	rep-type hashcode
variable input.inputParameter
	var-kind field inputParameter
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /multipleOperationsEndpoint&multipleOperationsEndpoint&200():::EXIT1
ppt-type subexit
variable input
	var-kind variable
	dec-type multipleOperationsEndpoint&Input
	rep-type hashcode
variable input.inputParameter
	var-kind field inputParameter
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type multipleOperationsEndpoint&Output&200
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

ppt /multipleOperationsEndpoint&multipleOperationsEndpoint&200&arrayOfObjectsProperty():::EXIT2
ppt-type subexit
variable input
	var-kind variable
	dec-type multipleOperationsEndpoint&Input
	rep-type hashcode
variable input.inputParameter
	var-kind field inputParameter
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type multipleOperationsEndpoint&Output&200&arrayOfObjectsProperty
	rep-type hashcode
variable return.property1
	var-kind field property1
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

ppt /multipleOperationsEndpoint&multipleOperationsEndpoint&400():::EXIT3
ppt-type subexit
variable input
	var-kind variable
	dec-type multipleOperationsEndpoint&Input
	rep-type hashcode
variable input.inputParameter
	var-kind field inputParameter
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type multipleOperationsEndpoint&Output&400
	rep-type hashcode
variable return.errorDescription
	var-kind field errorDescription
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

