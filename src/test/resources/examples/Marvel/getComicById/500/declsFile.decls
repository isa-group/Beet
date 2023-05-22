decl-version 2.0
var-comparability implicit

ppt /v1/public/comics/{comicId}:::CLASS
ppt-type class

ppt /v1/public/comics/{comicId}&getComicIndividual&200():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type getComicIndividual&Input
	rep-type hashcode
variable input.comicId
	var-kind field comicId
	enclosing-var input
	dec-type int
	rep-type int

ppt /v1/public/comics/{comicId}&getComicIndividual&200&data&results&images():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type getComicIndividual&Input
	rep-type hashcode
variable input.comicId
	var-kind field comicId
	enclosing-var input
	dec-type int
	rep-type int

ppt /v1/public/comics/{comicId}&getComicIndividual&200&data&results&urls():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type getComicIndividual&Input
	rep-type hashcode
variable input.comicId
	var-kind field comicId
	enclosing-var input
	dec-type int
	rep-type int

ppt /v1/public/comics/{comicId}&getComicIndividual&200&data&results&stories&items():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type getComicIndividual&Input
	rep-type hashcode
variable input.comicId
	var-kind field comicId
	enclosing-var input
	dec-type int
	rep-type int

ppt /v1/public/comics/{comicId}&getComicIndividual&200&data&results&events&items():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type getComicIndividual&Input
	rep-type hashcode
variable input.comicId
	var-kind field comicId
	enclosing-var input
	dec-type int
	rep-type int

ppt /v1/public/comics/{comicId}&getComicIndividual&200&data&results&prices():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type getComicIndividual&Input
	rep-type hashcode
variable input.comicId
	var-kind field comicId
	enclosing-var input
	dec-type int
	rep-type int

ppt /v1/public/comics/{comicId}&getComicIndividual&200&data&results&creators&items():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type getComicIndividual&Input
	rep-type hashcode
variable input.comicId
	var-kind field comicId
	enclosing-var input
	dec-type int
	rep-type int

ppt /v1/public/comics/{comicId}&getComicIndividual&200&data&results&collectedIssues():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type getComicIndividual&Input
	rep-type hashcode
variable input.comicId
	var-kind field comicId
	enclosing-var input
	dec-type int
	rep-type int

ppt /v1/public/comics/{comicId}&getComicIndividual&200&data&results&characters&items():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type getComicIndividual&Input
	rep-type hashcode
variable input.comicId
	var-kind field comicId
	enclosing-var input
	dec-type int
	rep-type int

ppt /v1/public/comics/{comicId}&getComicIndividual&200&data&results():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type getComicIndividual&Input
	rep-type hashcode
variable input.comicId
	var-kind field comicId
	enclosing-var input
	dec-type int
	rep-type int

ppt /v1/public/comics/{comicId}&getComicIndividual&200&data&results&variants():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type getComicIndividual&Input
	rep-type hashcode
variable input.comicId
	var-kind field comicId
	enclosing-var input
	dec-type int
	rep-type int

ppt /v1/public/comics/{comicId}&getComicIndividual&200&data&results&collections():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type getComicIndividual&Input
	rep-type hashcode
variable input.comicId
	var-kind field comicId
	enclosing-var input
	dec-type int
	rep-type int

ppt /v1/public/comics/{comicId}&getComicIndividual&200&data&results&textObjects():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type getComicIndividual&Input
	rep-type hashcode
variable input.comicId
	var-kind field comicId
	enclosing-var input
	dec-type int
	rep-type int

ppt /v1/public/comics/{comicId}&getComicIndividual&200&data&results&dates():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type getComicIndividual&Input
	rep-type hashcode
variable input.comicId
	var-kind field comicId
	enclosing-var input
	dec-type int
	rep-type int

ppt /v1/public/comics/{comicId}&getComicIndividual&200():::EXIT1
ppt-type subexit
variable input
	var-kind variable
	dec-type getComicIndividual&Input
	rep-type hashcode
variable input.comicId
	var-kind field comicId
	enclosing-var input
	dec-type int
	rep-type int
variable return
	var-kind return
	dec-type getComicIndividual&Output&200
	rep-type hashcode
variable return.code
	var-kind field code
	enclosing-var return
	dec-type int
	rep-type int
variable return.status
	var-kind field status
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.copyright
	var-kind field copyright
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.attributionText
	var-kind field attributionText
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.attributionHTML
	var-kind field attributionHTML
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.data
	var-kind field data
	enclosing-var return
	dec-type getComicIndividual&Output&200&data
	rep-type hashcode
variable return.data.offset
	var-kind field offset
	enclosing-var return.data
	dec-type int
	rep-type int
variable return.data.limit
	var-kind field limit
	enclosing-var return.data
	dec-type int
	rep-type int
variable return.data.total
	var-kind field total
	enclosing-var return.data
	dec-type int
	rep-type int
variable return.data.count
	var-kind field count
	enclosing-var return.data
	dec-type int
	rep-type int
variable return.data.results
	var-kind field results
	enclosing-var return.data
	dec-type results[]
	rep-type hashcode
variable return.data.results[..]
	var-kind array
	enclosing-var return.data.results
	array 1
	dec-type results[]
	rep-type hashcode[]
variable return.etag
	var-kind field etag
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

ppt /v1/public/comics/{comicId}&getComicIndividual&200&data&results&images():::EXIT2
ppt-type subexit
variable input
	var-kind variable
	dec-type getComicIndividual&Input
	rep-type hashcode
variable input.comicId
	var-kind field comicId
	enclosing-var input
	dec-type int
	rep-type int
variable return
	var-kind return
	dec-type getComicIndividual&Output&200&data&results&images
	rep-type hashcode
variable return.path
	var-kind field path
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.extension
	var-kind field extension
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

ppt /v1/public/comics/{comicId}&getComicIndividual&200&data&results&urls():::EXIT3
ppt-type subexit
variable input
	var-kind variable
	dec-type getComicIndividual&Input
	rep-type hashcode
variable input.comicId
	var-kind field comicId
	enclosing-var input
	dec-type int
	rep-type int
variable return
	var-kind return
	dec-type getComicIndividual&Output&200&data&results&urls
	rep-type hashcode
variable return.type
	var-kind field type
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.url
	var-kind field url
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

ppt /v1/public/comics/{comicId}&getComicIndividual&200&data&results&stories&items():::EXIT4
ppt-type subexit
variable input
	var-kind variable
	dec-type getComicIndividual&Input
	rep-type hashcode
variable input.comicId
	var-kind field comicId
	enclosing-var input
	dec-type int
	rep-type int
variable return
	var-kind return
	dec-type getComicIndividual&Output&200&data&results&stories&items
	rep-type hashcode
variable return.resourceURI
	var-kind field resourceURI
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

ppt /v1/public/comics/{comicId}&getComicIndividual&200&data&results&events&items():::EXIT5
ppt-type subexit
variable input
	var-kind variable
	dec-type getComicIndividual&Input
	rep-type hashcode
variable input.comicId
	var-kind field comicId
	enclosing-var input
	dec-type int
	rep-type int
variable return
	var-kind return
	dec-type getComicIndividual&Output&200&data&results&events&items
	rep-type hashcode
variable return.resourceURI
	var-kind field resourceURI
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.name
	var-kind field name
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

ppt /v1/public/comics/{comicId}&getComicIndividual&200&data&results&prices():::EXIT6
ppt-type subexit
variable input
	var-kind variable
	dec-type getComicIndividual&Input
	rep-type hashcode
variable input.comicId
	var-kind field comicId
	enclosing-var input
	dec-type int
	rep-type int
variable return
	var-kind return
	dec-type getComicIndividual&Output&200&data&results&prices
	rep-type hashcode
variable return.type
	var-kind field type
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.price
	var-kind field price
	enclosing-var return
	dec-type double
	rep-type double

ppt /v1/public/comics/{comicId}&getComicIndividual&200&data&results&creators&items():::EXIT7
ppt-type subexit
variable input
	var-kind variable
	dec-type getComicIndividual&Input
	rep-type hashcode
variable input.comicId
	var-kind field comicId
	enclosing-var input
	dec-type int
	rep-type int
variable return
	var-kind return
	dec-type getComicIndividual&Output&200&data&results&creators&items
	rep-type hashcode
variable return.resourceURI
	var-kind field resourceURI
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.name
	var-kind field name
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.role
	var-kind field role
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

ppt /v1/public/comics/{comicId}&getComicIndividual&200&data&results&collectedIssues():::EXIT8
ppt-type subexit
variable input
	var-kind variable
	dec-type getComicIndividual&Input
	rep-type hashcode
variable input.comicId
	var-kind field comicId
	enclosing-var input
	dec-type int
	rep-type int
variable return
	var-kind return
	dec-type getComicIndividual&Output&200&data&results&collectedIssues
	rep-type hashcode
variable return.resourceURI
	var-kind field resourceURI
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.name
	var-kind field name
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

ppt /v1/public/comics/{comicId}&getComicIndividual&200&data&results&characters&items():::EXIT9
ppt-type subexit
variable input
	var-kind variable
	dec-type getComicIndividual&Input
	rep-type hashcode
variable input.comicId
	var-kind field comicId
	enclosing-var input
	dec-type int
	rep-type int
variable return
	var-kind return
	dec-type getComicIndividual&Output&200&data&results&characters&items
	rep-type hashcode
variable return.resourceURI
	var-kind field resourceURI
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.name
	var-kind field name
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.role
	var-kind field role
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

ppt /v1/public/comics/{comicId}&getComicIndividual&200&data&results():::EXIT10
ppt-type subexit
variable input
	var-kind variable
	dec-type getComicIndividual&Input
	rep-type hashcode
variable input.comicId
	var-kind field comicId
	enclosing-var input
	dec-type int
	rep-type int
variable return
	var-kind return
	dec-type getComicIndividual&Output&200&data&results
	rep-type hashcode
variable return.id
	var-kind field id
	enclosing-var return
	dec-type int
	rep-type int
variable return.digitalId
	var-kind field digitalId
	enclosing-var return
	dec-type int
	rep-type int
variable return.title
	var-kind field title
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.issueNumber
	var-kind field issueNumber
	enclosing-var return
	dec-type double
	rep-type double
variable return.variantDescription
	var-kind field variantDescription
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.description
	var-kind field description
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.modified
	var-kind field modified
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.isbn
	var-kind field isbn
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.upc
	var-kind field upc
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.diamondCode
	var-kind field diamondCode
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.ean
	var-kind field ean
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.issn
	var-kind field issn
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.format
	var-kind field format
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.pageCount
	var-kind field pageCount
	enclosing-var return
	dec-type int
	rep-type int
variable return.textObjects
	var-kind field textObjects
	enclosing-var return
	dec-type textObjects[]
	rep-type hashcode
variable return.textObjects[..]
	var-kind array
	enclosing-var return.textObjects
	array 1
	dec-type textObjects[]
	rep-type hashcode[]
variable return.resourceURI
	var-kind field resourceURI
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.urls
	var-kind field urls
	enclosing-var return
	dec-type urls[]
	rep-type hashcode
variable return.urls[..]
	var-kind array
	enclosing-var return.urls
	array 1
	dec-type urls[]
	rep-type hashcode[]
variable return.series
	var-kind field series
	enclosing-var return
	dec-type getComicIndividual&Output&200&data&results&series
	rep-type hashcode
variable return.series.resourceURI
	var-kind field resourceURI
	enclosing-var return.series
	dec-type java.lang.String
	rep-type java.lang.String
variable return.series.name
	var-kind field name
	enclosing-var return.series
	dec-type java.lang.String
	rep-type java.lang.String
variable return.variants
	var-kind field variants
	enclosing-var return
	dec-type variants[]
	rep-type hashcode
variable return.variants[..]
	var-kind array
	enclosing-var return.variants
	array 1
	dec-type variants[]
	rep-type hashcode[]
variable return.collections
	var-kind field collections
	enclosing-var return
	dec-type collections[]
	rep-type hashcode
variable return.collections[..]
	var-kind array
	enclosing-var return.collections
	array 1
	dec-type collections[]
	rep-type hashcode[]
variable return.collectedIssues
	var-kind field collectedIssues
	enclosing-var return
	dec-type collectedIssues[]
	rep-type hashcode
variable return.collectedIssues[..]
	var-kind array
	enclosing-var return.collectedIssues
	array 1
	dec-type collectedIssues[]
	rep-type hashcode[]
variable return.dates
	var-kind field dates
	enclosing-var return
	dec-type dates[]
	rep-type hashcode
variable return.dates[..]
	var-kind array
	enclosing-var return.dates
	array 1
	dec-type dates[]
	rep-type hashcode[]
variable return.prices
	var-kind field prices
	enclosing-var return
	dec-type prices[]
	rep-type hashcode
variable return.prices[..]
	var-kind array
	enclosing-var return.prices
	array 1
	dec-type prices[]
	rep-type hashcode[]
variable return.thumbnail
	var-kind field thumbnail
	enclosing-var return
	dec-type getComicIndividual&Output&200&data&results&thumbnail
	rep-type hashcode
variable return.thumbnail.path
	var-kind field path
	enclosing-var return.thumbnail
	dec-type java.lang.String
	rep-type java.lang.String
variable return.thumbnail.extension
	var-kind field extension
	enclosing-var return.thumbnail
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
variable return.creators
	var-kind field creators
	enclosing-var return
	dec-type getComicIndividual&Output&200&data&results&creators
	rep-type hashcode
variable return.creators.available
	var-kind field available
	enclosing-var return.creators
	dec-type int
	rep-type int
variable return.creators.returned
	var-kind field returned
	enclosing-var return.creators
	dec-type int
	rep-type int
variable return.creators.collectionURI
	var-kind field collectionURI
	enclosing-var return.creators
	dec-type java.lang.String
	rep-type java.lang.String
variable return.creators.items
	var-kind field items
	enclosing-var return.creators
	dec-type items[]
	rep-type hashcode
variable return.creators.items[..]
	var-kind array
	enclosing-var return.creators.items
	array 1
	dec-type items[]
	rep-type hashcode[]
variable return.characters
	var-kind field characters
	enclosing-var return
	dec-type getComicIndividual&Output&200&data&results&characters
	rep-type hashcode
variable return.characters.available
	var-kind field available
	enclosing-var return.characters
	dec-type int
	rep-type int
variable return.characters.returned
	var-kind field returned
	enclosing-var return.characters
	dec-type int
	rep-type int
variable return.characters.collectionURI
	var-kind field collectionURI
	enclosing-var return.characters
	dec-type java.lang.String
	rep-type java.lang.String
variable return.characters.items
	var-kind field items
	enclosing-var return.characters
	dec-type items[]
	rep-type hashcode
variable return.characters.items[..]
	var-kind array
	enclosing-var return.characters.items
	array 1
	dec-type items[]
	rep-type hashcode[]
variable return.stories
	var-kind field stories
	enclosing-var return
	dec-type getComicIndividual&Output&200&data&results&stories
	rep-type hashcode
variable return.stories.available
	var-kind field available
	enclosing-var return.stories
	dec-type int
	rep-type int
variable return.stories.returned
	var-kind field returned
	enclosing-var return.stories
	dec-type int
	rep-type int
variable return.stories.collectionURI
	var-kind field collectionURI
	enclosing-var return.stories
	dec-type java.lang.String
	rep-type java.lang.String
variable return.stories.items
	var-kind field items
	enclosing-var return.stories
	dec-type items[]
	rep-type hashcode
variable return.stories.items[..]
	var-kind array
	enclosing-var return.stories.items
	array 1
	dec-type items[]
	rep-type hashcode[]
variable return.events
	var-kind field events
	enclosing-var return
	dec-type getComicIndividual&Output&200&data&results&events
	rep-type hashcode
variable return.events.available
	var-kind field available
	enclosing-var return.events
	dec-type int
	rep-type int
variable return.events.returned
	var-kind field returned
	enclosing-var return.events
	dec-type int
	rep-type int
variable return.events.collectionURI
	var-kind field collectionURI
	enclosing-var return.events
	dec-type java.lang.String
	rep-type java.lang.String
variable return.events.items
	var-kind field items
	enclosing-var return.events
	dec-type items[]
	rep-type hashcode
variable return.events.items[..]
	var-kind array
	enclosing-var return.events.items
	array 1
	dec-type items[]
	rep-type hashcode[]

ppt /v1/public/comics/{comicId}&getComicIndividual&200&data&results&variants():::EXIT11
ppt-type subexit
variable input
	var-kind variable
	dec-type getComicIndividual&Input
	rep-type hashcode
variable input.comicId
	var-kind field comicId
	enclosing-var input
	dec-type int
	rep-type int
variable return
	var-kind return
	dec-type getComicIndividual&Output&200&data&results&variants
	rep-type hashcode
variable return.resourceURI
	var-kind field resourceURI
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.name
	var-kind field name
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

ppt /v1/public/comics/{comicId}&getComicIndividual&200&data&results&collections():::EXIT12
ppt-type subexit
variable input
	var-kind variable
	dec-type getComicIndividual&Input
	rep-type hashcode
variable input.comicId
	var-kind field comicId
	enclosing-var input
	dec-type int
	rep-type int
variable return
	var-kind return
	dec-type getComicIndividual&Output&200&data&results&collections
	rep-type hashcode
variable return.resourceURI
	var-kind field resourceURI
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.name
	var-kind field name
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

ppt /v1/public/comics/{comicId}&getComicIndividual&200&data&results&textObjects():::EXIT13
ppt-type subexit
variable input
	var-kind variable
	dec-type getComicIndividual&Input
	rep-type hashcode
variable input.comicId
	var-kind field comicId
	enclosing-var input
	dec-type int
	rep-type int
variable return
	var-kind return
	dec-type getComicIndividual&Output&200&data&results&textObjects
	rep-type hashcode
variable return.type
	var-kind field type
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.language
	var-kind field language
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.text
	var-kind field text
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

ppt /v1/public/comics/{comicId}&getComicIndividual&200&data&results&dates():::EXIT14
ppt-type subexit
variable input
	var-kind variable
	dec-type getComicIndividual&Input
	rep-type hashcode
variable input.comicId
	var-kind field comicId
	enclosing-var input
	dec-type int
	rep-type int
variable return
	var-kind return
	dec-type getComicIndividual&Output&200&data&results&dates
	rep-type hashcode
variable return.type
	var-kind field type
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.date
	var-kind field date
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

