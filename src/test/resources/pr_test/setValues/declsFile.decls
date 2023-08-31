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

ppt /albums/{id}/tracks&getAlbumTracks&200&items&artists():::ENTER
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
variable return.href
	var-kind field href
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
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
variable return.limit
	var-kind field limit
	enclosing-var return
	dec-type int
	rep-type int
variable return.next
	var-kind field next
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.offset
	var-kind field offset
	enclosing-var return
	dec-type int
	rep-type int
variable return.previous
	var-kind field previous
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.total
	var-kind field total
	enclosing-var return
	dec-type int
	rep-type int

ppt /albums/{id}/tracks&getAlbumTracks&200&items&artists():::EXIT2
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
	dec-type getAlbumTracks&Output&200&items&artists
	rep-type hashcode
variable return.external_urls
	var-kind field external_urls
	enclosing-var return
	dec-type getAlbumTracks&Output&200&items&artists&external_urls
	rep-type hashcode
variable return.href
	var-kind field href
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
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
variable return.type
	var-kind field type
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.uri
	var-kind field uri
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

ppt /albums/{id}/tracks&getAlbumTracks&200&items():::EXIT3
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
variable return.artists
	var-kind field artists
	enclosing-var return
	dec-type artists[]
	rep-type hashcode
variable return.artists[..]
	var-kind array
	enclosing-var return.artists
	array 1
	dec-type artists[]
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
variable return.disc_number
	var-kind field disc_number
	enclosing-var return
	dec-type int
	rep-type int
variable return.duration_ms
	var-kind field duration_ms
	enclosing-var return
	dec-type int
	rep-type int
variable return.explicit
	var-kind field explicit
	enclosing-var return
	dec-type boolean
	rep-type boolean
variable return.external_urls
	var-kind field external_urls
	enclosing-var return
	dec-type getAlbumTracks&Output&200&items&external_urls
	rep-type hashcode
variable return.href
	var-kind field href
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.id
	var-kind field id
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.is_local
	var-kind field is_local
	enclosing-var return
	dec-type boolean
	rep-type boolean
variable return.is_playable
	var-kind field is_playable
	enclosing-var return
	dec-type boolean
	rep-type boolean
variable return.linked_from
	var-kind field linked_from
	enclosing-var return
	dec-type getAlbumTracks&Output&200&items&linked_from
	rep-type hashcode
variable return.linked_from.external_urls
	var-kind field external_urls
	enclosing-var return.linked_from
	dec-type getAlbumTracks&Output&200&items&external_urls
	rep-type hashcode
variable return.linked_from.href
	var-kind field href
	enclosing-var return.linked_from
	dec-type java.lang.String
	rep-type java.lang.String
variable return.linked_from.id
	var-kind field id
	enclosing-var return.linked_from
	dec-type java.lang.String
	rep-type java.lang.String
variable return.linked_from.type
	var-kind field type
	enclosing-var return.linked_from
	dec-type java.lang.String
	rep-type java.lang.String
variable return.linked_from.uri
	var-kind field uri
	enclosing-var return.linked_from
	dec-type java.lang.String
	rep-type java.lang.String
variable return.name
	var-kind field name
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.preview_url
	var-kind field preview_url
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.restrictions
	var-kind field restrictions
	enclosing-var return
	dec-type getAlbumTracks&Output&200&items&restrictions
	rep-type hashcode
variable return.restrictions.reason
	var-kind field reason
	enclosing-var return.restrictions
	dec-type java.lang.String
	rep-type java.lang.String
variable return.track_number
	var-kind field track_number
	enclosing-var return
	dec-type int
	rep-type int
variable return.type
	var-kind field type
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.uri
	var-kind field uri
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

