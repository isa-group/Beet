decl-version 2.0
var-comparability implicit

ppt /users/{user_id}/playlists:::CLASS
ppt-type class

ppt /users/{user_id}/playlists&createPlaylist&201():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type createPlaylist&Input
	rep-type hashcode
variable input.user_id
	var-kind field user_id
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.Accept
	var-kind field Accept
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.name
	var-kind field name
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.description
	var-kind field description
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.public
	var-kind field public
	enclosing-var input
	dec-type boolean
	rep-type boolean
variable input.collaborative
	var-kind field collaborative
	enclosing-var input
	dec-type boolean
	rep-type boolean

ppt /users/{user_id}/playlists&createPlaylist&201&images():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type createPlaylist&Input
	rep-type hashcode
variable input.user_id
	var-kind field user_id
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.Accept
	var-kind field Accept
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.name
	var-kind field name
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.description
	var-kind field description
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.public
	var-kind field public
	enclosing-var input
	dec-type boolean
	rep-type boolean
variable input.collaborative
	var-kind field collaborative
	enclosing-var input
	dec-type boolean
	rep-type boolean

ppt /users/{user_id}/playlists&createPlaylist&201&tracks&items():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type createPlaylist&Input
	rep-type hashcode
variable input.user_id
	var-kind field user_id
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.Accept
	var-kind field Accept
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.name
	var-kind field name
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.description
	var-kind field description
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.public
	var-kind field public
	enclosing-var input
	dec-type boolean
	rep-type boolean
variable input.collaborative
	var-kind field collaborative
	enclosing-var input
	dec-type boolean
	rep-type boolean

ppt /users/{user_id}/playlists&createPlaylist&201():::EXIT1
ppt-type subexit
variable input
	var-kind variable
	dec-type createPlaylist&Input
	rep-type hashcode
variable input.user_id
	var-kind field user_id
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.Accept
	var-kind field Accept
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.name
	var-kind field name
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.description
	var-kind field description
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.public
	var-kind field public
	enclosing-var input
	dec-type boolean
	rep-type boolean
variable input.collaborative
	var-kind field collaborative
	enclosing-var input
	dec-type boolean
	rep-type boolean
variable return
	var-kind return
	dec-type createPlaylist&Output&201
	rep-type hashcode
variable return.primary_color
	var-kind field primary_color
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.collaborative
	var-kind field collaborative
	enclosing-var return
	dec-type boolean
	rep-type boolean
variable return.description
	var-kind field description
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.external_urls
	var-kind field external_urls
	enclosing-var return
	dec-type createPlaylist&Output&201&external_urls
	rep-type hashcode
variable return.external_urls.spotify
	var-kind field spotify
	enclosing-var return.external_urls
	dec-type java.lang.String
	rep-type java.lang.String
variable return.followers
	var-kind field followers
	enclosing-var return
	dec-type createPlaylist&Output&201&followers
	rep-type hashcode
variable return.followers.href
	var-kind field href
	enclosing-var return.followers
	dec-type java.lang.String
	rep-type java.lang.String
variable return.followers.total
	var-kind field total
	enclosing-var return.followers
	dec-type int
	rep-type int
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
variable return.owner
	var-kind field owner
	enclosing-var return
	dec-type createPlaylist&Output&201&owner
	rep-type hashcode
variable return.owner.display_name
	var-kind field display_name
	enclosing-var return.owner
	dec-type java.lang.String
	rep-type java.lang.String
variable return.owner.external_urls
	var-kind field external_urls
	enclosing-var return.owner
	dec-type createPlaylist&Output&201&external_urls
	rep-type hashcode
variable return.owner.external_urls.spotify
	var-kind field spotify
	enclosing-var return.owner.external_urls
	dec-type java.lang.String
	rep-type java.lang.String
variable return.owner.followers
	var-kind field followers
	enclosing-var return.owner
	dec-type createPlaylist&Output&201&followers
	rep-type hashcode
variable return.owner.followers.href
	var-kind field href
	enclosing-var return.owner.followers
	dec-type java.lang.String
	rep-type java.lang.String
variable return.owner.followers.total
	var-kind field total
	enclosing-var return.owner.followers
	dec-type int
	rep-type int
variable return.owner.href
	var-kind field href
	enclosing-var return.owner
	dec-type java.lang.String
	rep-type java.lang.String
variable return.owner.id
	var-kind field id
	enclosing-var return.owner
	dec-type java.lang.String
	rep-type java.lang.String
variable return.owner.type
	var-kind field type
	enclosing-var return.owner
	dec-type java.lang.String
	rep-type java.lang.String
variable return.owner.uri
	var-kind field uri
	enclosing-var return.owner
	dec-type java.lang.String
	rep-type java.lang.String
variable return.public
	var-kind field public
	enclosing-var return
	dec-type boolean
	rep-type boolean
variable return.snapshot_id
	var-kind field snapshot_id
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.tracks
	var-kind field tracks
	enclosing-var return
	dec-type createPlaylist&Output&201&tracks
	rep-type hashcode
variable return.tracks.href
	var-kind field href
	enclosing-var return.tracks
	dec-type java.lang.String
	rep-type java.lang.String
variable return.tracks.items
	var-kind field items
	enclosing-var return.tracks
	dec-type items[]
	rep-type hashcode
variable return.tracks.items[..]
	var-kind array
	enclosing-var return.tracks.items
	array 1
	dec-type items[]
	rep-type hashcode[]
variable return.tracks.limit
	var-kind field limit
	enclosing-var return.tracks
	dec-type int
	rep-type int
variable return.tracks.next
	var-kind field next
	enclosing-var return.tracks
	dec-type java.lang.String
	rep-type java.lang.String
variable return.tracks.offset
	var-kind field offset
	enclosing-var return.tracks
	dec-type int
	rep-type int
variable return.tracks.previous
	var-kind field previous
	enclosing-var return.tracks
	dec-type java.lang.String
	rep-type java.lang.String
variable return.tracks.total
	var-kind field total
	enclosing-var return.tracks
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

ppt /users/{user_id}/playlists&createPlaylist&201&images():::EXIT2
ppt-type subexit
variable input
	var-kind variable
	dec-type createPlaylist&Input
	rep-type hashcode
variable input.user_id
	var-kind field user_id
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.Accept
	var-kind field Accept
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.name
	var-kind field name
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.description
	var-kind field description
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.public
	var-kind field public
	enclosing-var input
	dec-type boolean
	rep-type boolean
variable input.collaborative
	var-kind field collaborative
	enclosing-var input
	dec-type boolean
	rep-type boolean
variable return
	var-kind return
	dec-type createPlaylist&Output&201&images
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

ppt /users/{user_id}/playlists&createPlaylist&201&tracks&items():::EXIT3
ppt-type subexit
variable input
	var-kind variable
	dec-type createPlaylist&Input
	rep-type hashcode
variable input.user_id
	var-kind field user_id
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.Accept
	var-kind field Accept
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.name
	var-kind field name
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.description
	var-kind field description
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.public
	var-kind field public
	enclosing-var input
	dec-type boolean
	rep-type boolean
variable input.collaborative
	var-kind field collaborative
	enclosing-var input
	dec-type boolean
	rep-type boolean
variable return
	var-kind return
	dec-type createPlaylist&Output&201&tracks&items
	rep-type hashcode
variable return.added_at
	var-kind field added_at
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.added_by
	var-kind field added_by
	enclosing-var return
	dec-type createPlaylist&Output&201&tracks&items&added_by
	rep-type hashcode
variable return.added_by.display_name
	var-kind field display_name
	enclosing-var return.added_by
	dec-type java.lang.String
	rep-type java.lang.String
variable return.added_by.external_urls
	var-kind field external_urls
	enclosing-var return.added_by
	dec-type createPlaylist&Output&201&tracks&items&external_urls
	rep-type hashcode
variable return.added_by.external_urls.spotify
	var-kind field spotify
	enclosing-var return.added_by.external_urls
	dec-type java.lang.String
	rep-type java.lang.String
variable return.added_by.followers
	var-kind field followers
	enclosing-var return.added_by
	dec-type createPlaylist&Output&201&tracks&items&followers
	rep-type hashcode
variable return.added_by.followers.href
	var-kind field href
	enclosing-var return.added_by.followers
	dec-type java.lang.String
	rep-type java.lang.String
variable return.added_by.followers.total
	var-kind field total
	enclosing-var return.added_by.followers
	dec-type int
	rep-type int
variable return.added_by.href
	var-kind field href
	enclosing-var return.added_by
	dec-type java.lang.String
	rep-type java.lang.String
variable return.added_by.id
	var-kind field id
	enclosing-var return.added_by
	dec-type java.lang.String
	rep-type java.lang.String
variable return.added_by.type
	var-kind field type
	enclosing-var return.added_by
	dec-type java.lang.String
	rep-type java.lang.String
variable return.added_by.uri
	var-kind field uri
	enclosing-var return.added_by
	dec-type java.lang.String
	rep-type java.lang.String
variable return.is_local
	var-kind field is_local
	enclosing-var return
	dec-type boolean
	rep-type boolean
variable return.track
	var-kind field track
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

