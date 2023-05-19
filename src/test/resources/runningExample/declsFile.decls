decl-version 2.0
var-comparability implicit

ppt main.albums{id}tracks:::CLASS
ppt-type class

ppt main.albums{id}tracks.getAlbumTracks&200(main.getAlbumTracks&Input):::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type main.getAlbumTracks&Input
	rep-type hashcode
variable input.id
	var-kind field id
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.market
	var-kind field market
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.limit
	var-kind field limit
	enclosing-var input
	dec-type int
	rep-type int

ppt main.albums{id}tracks.getAlbumTracks&200&items&artists(main.getAlbumTracks&Input):::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type main.getAlbumTracks&Input
	rep-type hashcode
variable input.id
	var-kind field id
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.market
	var-kind field market
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.limit
	var-kind field limit
	enclosing-var input
	dec-type int
	rep-type int

ppt main.albums{id}tracks.getAlbumTracks&200&items(main.getAlbumTracks&Input):::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type main.getAlbumTracks&Input
	rep-type hashcode
variable input.id
	var-kind field id
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.market
	var-kind field market
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.limit
	var-kind field limit
	enclosing-var input
	dec-type int
	rep-type int

ppt main.albums{id}tracks.getAlbumTracks&400(main.getAlbumTracks&Input):::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type main.getAlbumTracks&Input
	rep-type hashcode
variable input.id
	var-kind field id
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.market
	var-kind field market
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.limit
	var-kind field limit
	enclosing-var input
	dec-type int
	rep-type int

ppt main.albums{id}tracks.getAlbumTracks&200(main.getAlbumTracks&Input):::EXIT1
ppt-type subexit
variable input
	var-kind variable
	dec-type main.getAlbumTracks&Input
	rep-type hashcode
variable input.id
	var-kind field id
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.market
	var-kind field market
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.limit
	var-kind field limit
	enclosing-var input
	dec-type int
	rep-type int
variable return
	var-kind return
	dec-type main.getAlbumTracks&Output&200
	rep-type hashcode
variable return.total
	var-kind field total
	enclosing-var return
	dec-type int
	rep-type int
variable return.href
	var-kind field href
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.items
	var-kind field items
	enclosing-var return
	dec-type main.items[]
	rep-type hashcode
variable return.items[..]
	var-kind array
	enclosing-var return.items
	array 1
	dec-type main.items[]
	rep-type hashcode[]

ppt main.albums{id}tracks.getAlbumTracks&200&items&artists(main.getAlbumTracks&Input):::EXIT2
ppt-type subexit
variable input
	var-kind variable
	dec-type main.getAlbumTracks&Input
	rep-type hashcode
variable input.id
	var-kind field id
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.market
	var-kind field market
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.limit
	var-kind field limit
	enclosing-var input
	dec-type int
	rep-type int
variable return
	var-kind return
	dec-type main.getAlbumTracks&Output&200&items&artists
	rep-type hashcode
variable return.id
	var-kind field id
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.name
	var-kind field name
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

ppt main.albums{id}tracks.getAlbumTracks&200&items(main.getAlbumTracks&Input):::EXIT3
ppt-type subexit
variable input
	var-kind variable
	dec-type main.getAlbumTracks&Input
	rep-type hashcode
variable input.id
	var-kind field id
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.market
	var-kind field market
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.limit
	var-kind field limit
	enclosing-var input
	dec-type int
	rep-type int
variable return
	var-kind return
	dec-type main.getAlbumTracks&Output&200&items
	rep-type hashcode
variable return.artists
	var-kind field artists
	enclosing-var return
	dec-type main.artists[]
	rep-type hashcode
variable return.artists[..]
	var-kind array
	enclosing-var return.artists
	array 1
	dec-type main.artists[]
	rep-type hashcode[]
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
variable return.id
	var-kind field id
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.name
	var-kind field name
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.explicit
	var-kind field explicit
	enclosing-var return
	dec-type boolean
	rep-type boolean
variable return.linked_from
	var-kind field linked_from
	enclosing-var return
	dec-type main.getAlbumTracks&Output&200&items&linked_from
	rep-type hashcode
variable return.linked_from.id
	var-kind field id
	enclosing-var return.linked_from
	dec-type java.lang.String
	rep-type java.lang.String
variable return.linked_from.uri
	var-kind field uri
	enclosing-var return.linked_from
	dec-type java.lang.String
	rep-type java.lang.String

ppt main.albums{id}tracks.getAlbumTracks&400(main.getAlbumTracks&Input):::EXIT4
ppt-type subexit
variable input
	var-kind variable
	dec-type main.getAlbumTracks&Input
	rep-type hashcode
variable input.id
	var-kind field id
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.market
	var-kind field market
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.limit
	var-kind field limit
	enclosing-var input
	dec-type int
	rep-type int
variable return
	var-kind return
	dec-type main.getAlbumTracks&Output&400
	rep-type hashcode
variable return.status
	var-kind field status
	enclosing-var return
	dec-type int
	rep-type int
variable return.message
	var-kind field message
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

