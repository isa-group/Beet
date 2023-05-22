decl-version 2.0
var-comparability implicit

ppt /artists/{id}/albums:::CLASS
ppt-type class

ppt /artists/{id}/albums&getArtistAlbums&200():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type getArtistAlbums&Input
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
variable input.include_groups
	var-kind field include_groups
	enclosing-var input
	dec-type java.lang.String[]
	rep-type hashcode
variable input.include_groups[..]
	var-kind array
	enclosing-var input.include_groups
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable input.market
	var-kind field market
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /artists/{id}/albums&getArtistAlbums&200&items&images():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type getArtistAlbums&Input
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
variable input.include_groups
	var-kind field include_groups
	enclosing-var input
	dec-type java.lang.String[]
	rep-type hashcode
variable input.include_groups[..]
	var-kind array
	enclosing-var input.include_groups
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable input.market
	var-kind field market
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /artists/{id}/albums&getArtistAlbums&200&items&artists():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type getArtistAlbums&Input
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
variable input.include_groups
	var-kind field include_groups
	enclosing-var input
	dec-type java.lang.String[]
	rep-type hashcode
variable input.include_groups[..]
	var-kind array
	enclosing-var input.include_groups
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable input.market
	var-kind field market
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /artists/{id}/albums&getArtistAlbums&200&items():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type getArtistAlbums&Input
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
variable input.include_groups
	var-kind field include_groups
	enclosing-var input
	dec-type java.lang.String[]
	rep-type hashcode
variable input.include_groups[..]
	var-kind array
	enclosing-var input.include_groups
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable input.market
	var-kind field market
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /artists/{id}/albums&getArtistAlbums&200():::EXIT1
ppt-type subexit
variable input
	var-kind variable
	dec-type getArtistAlbums&Input
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
variable input.include_groups
	var-kind field include_groups
	enclosing-var input
	dec-type java.lang.String[]
	rep-type hashcode
variable input.include_groups[..]
	var-kind array
	enclosing-var input.include_groups
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable input.market
	var-kind field market
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type getArtistAlbums&Output&200
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

ppt /artists/{id}/albums&getArtistAlbums&200&items&images():::EXIT2
ppt-type subexit
variable input
	var-kind variable
	dec-type getArtistAlbums&Input
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
variable input.include_groups
	var-kind field include_groups
	enclosing-var input
	dec-type java.lang.String[]
	rep-type hashcode
variable input.include_groups[..]
	var-kind array
	enclosing-var input.include_groups
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable input.market
	var-kind field market
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type getArtistAlbums&Output&200&items&images
	rep-type hashcode
variable return.height
	var-kind field height
	enclosing-var return
	dec-type int
	rep-type int
variable return.url
	var-kind field url
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.width
	var-kind field width
	enclosing-var return
	dec-type int
	rep-type int

ppt /artists/{id}/albums&getArtistAlbums&200&items&artists():::EXIT3
ppt-type subexit
variable input
	var-kind variable
	dec-type getArtistAlbums&Input
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
variable input.include_groups
	var-kind field include_groups
	enclosing-var input
	dec-type java.lang.String[]
	rep-type hashcode
variable input.include_groups[..]
	var-kind array
	enclosing-var input.include_groups
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable input.market
	var-kind field market
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type getArtistAlbums&Output&200&items&artists
	rep-type hashcode
variable return.external_urls
	var-kind field external_urls
	enclosing-var return
	dec-type getArtistAlbums&Output&200&items&artists&external_urls
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

ppt /artists/{id}/albums&getArtistAlbums&200&items():::EXIT4
ppt-type subexit
variable input
	var-kind variable
	dec-type getArtistAlbums&Input
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
variable input.include_groups
	var-kind field include_groups
	enclosing-var input
	dec-type java.lang.String[]
	rep-type hashcode
variable input.include_groups[..]
	var-kind array
	enclosing-var input.include_groups
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable input.market
	var-kind field market
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type getArtistAlbums&Output&200&items
	rep-type hashcode
variable return.album_type
	var-kind field album_type
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
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
variable return.external_urls
	var-kind field external_urls
	enclosing-var return
	dec-type getArtistAlbums&Output&200&items&external_urls
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
variable return.images
	var-kind field images
	enclosing-var return
	dec-type images[]
	rep-type hashcode
variable return.images[..]
	var-kind array
	enclosing-var return.images
	array 1
	dec-type images[]
	rep-type hashcode[]
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
variable return.album_group
	var-kind field album_group
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
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
variable return.release_date
	var-kind field release_date
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.release_date_precision
	var-kind field release_date_precision
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.total_tracks
	var-kind field total_tracks
	enclosing-var return
	dec-type int
	rep-type int

