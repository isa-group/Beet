decl-version 2.0
var-comparability implicit

ppt /albums/{id}/tracks:::CLASS
ppt-type class

ppt /albums/{id}/tracks&getAlbumTracks&200():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type getAlbumTracks&Input
	rep-type hashcode
variable input.id
	var-kind field id
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.limit
	var-kind field limit
	enclosing-var input
	dec-type int
	rep-type int
variable input.offset
	var-kind field offset
	enclosing-var input
	dec-type int
	rep-type int
variable input.market
	var-kind field market
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /albums/{id}/tracks&getAlbumTracks&200&items():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type getAlbumTracks&Input
	rep-type hashcode
variable input.id
	var-kind field id
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.limit
	var-kind field limit
	enclosing-var input
	dec-type int
	rep-type int
variable input.offset
	var-kind field offset
	enclosing-var input
	dec-type int
	rep-type int
variable input.market
	var-kind field market
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /albums/{id}/tracks&getAlbumTracks&200():::EXIT1
ppt-type subexit
variable input
	var-kind variable
	dec-type getAlbumTracks&Input
	rep-type hashcode
variable input.id
	var-kind field id
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.limit
	var-kind field limit
	enclosing-var input
	dec-type int
	rep-type int
variable input.offset
	var-kind field offset
	enclosing-var input
	dec-type int
	rep-type int
variable input.market
	var-kind field market
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type getAlbumTracks&Output&200
	rep-type hashcode
variable return.items
	var-kind field items
	enclosing-var return
	dec-type items[]
	rep-type hashcode
variable return.items[..]
	var-kind array
	enclosing-var return.items
	array 1
	dec-type items[]
	rep-type hashcode[]

ppt /albums/{id}/tracks&getAlbumTracks&200&items():::EXIT2
ppt-type subexit
variable input
	var-kind variable
	dec-type getAlbumTracks&Input
	rep-type hashcode
variable input.id
	var-kind field id
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.limit
	var-kind field limit
	enclosing-var input
	dec-type int
	rep-type int
variable input.offset
	var-kind field offset
	enclosing-var input
	dec-type int
	rep-type int
variable input.market
	var-kind field market
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type getAlbumTracks&Output&200&items
	rep-type hashcode
variable return.available_markets
	var-kind field available_markets
	enclosing-var return
	dec-type java.lang.String[]
	rep-type hashcode
variable return.available_markets[..]
	var-kind array
	enclosing-var return.available_markets
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]

