decl-version 2.0
var-comparability implicit

ppt /:::CLASS
ppt-type class

ppt /&bySearch&200():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type bySearch&Input
	rep-type hashcode
variable input.s
	var-kind field s
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.type
	var-kind field type
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.y
	var-kind field y
	enclosing-var input
	dec-type int
	rep-type int
variable input.r
	var-kind field r
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.page
	var-kind field page
	enclosing-var input
	dec-type int
	rep-type int

ppt /&bySearch&200&Search():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type bySearch&Input
	rep-type hashcode
variable input.s
	var-kind field s
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.type
	var-kind field type
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.y
	var-kind field y
	enclosing-var input
	dec-type int
	rep-type int
variable input.r
	var-kind field r
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.page
	var-kind field page
	enclosing-var input
	dec-type int
	rep-type int

ppt /&bySearch&401():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type bySearch&Input
	rep-type hashcode
variable input.s
	var-kind field s
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.type
	var-kind field type
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.y
	var-kind field y
	enclosing-var input
	dec-type int
	rep-type int
variable input.r
	var-kind field r
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.page
	var-kind field page
	enclosing-var input
	dec-type int
	rep-type int

ppt /&bySearch&200():::EXIT1
ppt-type subexit
variable input
	var-kind variable
	dec-type bySearch&Input
	rep-type hashcode
variable input.s
	var-kind field s
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.type
	var-kind field type
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.y
	var-kind field y
	enclosing-var input
	dec-type int
	rep-type int
variable input.r
	var-kind field r
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.page
	var-kind field page
	enclosing-var input
	dec-type int
	rep-type int
variable return
	var-kind return
	dec-type bySearch&Output&200
	rep-type hashcode
variable return.Response
	var-kind field Response
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.Search
	var-kind field Search
	enclosing-var return
	dec-type Search[]
	rep-type hashcode
variable return.Search[..]
	var-kind array
	enclosing-var return.Search
	array 1
	dec-type Search[]
	rep-type hashcode[]
variable return.totalResults
	var-kind field totalResults
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

ppt /&bySearch&200&Search():::EXIT2
ppt-type subexit
variable input
	var-kind variable
	dec-type bySearch&Input
	rep-type hashcode
variable input.s
	var-kind field s
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.type
	var-kind field type
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.y
	var-kind field y
	enclosing-var input
	dec-type int
	rep-type int
variable input.r
	var-kind field r
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.page
	var-kind field page
	enclosing-var input
	dec-type int
	rep-type int
variable return
	var-kind return
	dec-type bySearch&Output&200&Search
	rep-type hashcode
variable return.Title
	var-kind field Title
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.Year
	var-kind field Year
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.imdbID
	var-kind field imdbID
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.Type
	var-kind field Type
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.Poster
	var-kind field Poster
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

ppt /&bySearch&401():::EXIT3
ppt-type subexit
variable input
	var-kind variable
	dec-type bySearch&Input
	rep-type hashcode
variable input.s
	var-kind field s
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.type
	var-kind field type
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.y
	var-kind field y
	enclosing-var input
	dec-type int
	rep-type int
variable input.r
	var-kind field r
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.page
	var-kind field page
	enclosing-var input
	dec-type int
	rep-type int
variable return
	var-kind return
	dec-type bySearch&Output&401
	rep-type hashcode
variable return.Response
	var-kind field Response
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.Error
	var-kind field Error
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

