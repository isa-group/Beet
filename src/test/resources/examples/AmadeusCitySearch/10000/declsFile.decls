decl-version 2.0
var-comparability implicit

ppt /reference-data/locations/cities:::CLASS
ppt-type class

ppt /reference-data/locations/cities&GETCities&200():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type GETCities&Input
	rep-type hashcode
variable input.countryCode
	var-kind field countryCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.keyword
	var-kind field keyword
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.max
	var-kind field max
	enclosing-var input
	dec-type int
	rep-type int
variable input.include
	var-kind field include
	enclosing-var input
	dec-type java.lang.String[]
	rep-type hashcode
variable input.include[..]
	var-kind array
	enclosing-var input.include
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]

ppt /reference-data/locations/cities&GETCities&200&data&relationships():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type GETCities&Input
	rep-type hashcode
variable input.countryCode
	var-kind field countryCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.keyword
	var-kind field keyword
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.max
	var-kind field max
	enclosing-var input
	dec-type int
	rep-type int
variable input.include
	var-kind field include
	enclosing-var input
	dec-type java.lang.String[]
	rep-type hashcode
variable input.include[..]
	var-kind array
	enclosing-var input.include
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]

ppt /reference-data/locations/cities&GETCities&200&warnings():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type GETCities&Input
	rep-type hashcode
variable input.countryCode
	var-kind field countryCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.keyword
	var-kind field keyword
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.max
	var-kind field max
	enclosing-var input
	dec-type int
	rep-type int
variable input.include
	var-kind field include
	enclosing-var input
	dec-type java.lang.String[]
	rep-type hashcode
variable input.include[..]
	var-kind array
	enclosing-var input.include
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]

ppt /reference-data/locations/cities&GETCities&200&data():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type GETCities&Input
	rep-type hashcode
variable input.countryCode
	var-kind field countryCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.keyword
	var-kind field keyword
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.max
	var-kind field max
	enclosing-var input
	dec-type int
	rep-type int
variable input.include
	var-kind field include
	enclosing-var input
	dec-type java.lang.String[]
	rep-type hashcode
variable input.include[..]
	var-kind array
	enclosing-var input.include
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]

ppt /reference-data/locations/cities&GETCities&200():::EXIT1
ppt-type subexit
variable input
	var-kind variable
	dec-type GETCities&Input
	rep-type hashcode
variable input.countryCode
	var-kind field countryCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.keyword
	var-kind field keyword
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.max
	var-kind field max
	enclosing-var input
	dec-type int
	rep-type int
variable input.include
	var-kind field include
	enclosing-var input
	dec-type java.lang.String[]
	rep-type hashcode
variable input.include[..]
	var-kind array
	enclosing-var input.include
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable return
	var-kind return
	dec-type GETCities&Output&200
	rep-type hashcode
variable return.warnings
	var-kind field warnings
	enclosing-var return
	dec-type warnings[]
	rep-type hashcode
variable return.warnings[..]
	var-kind array
	enclosing-var return.warnings
	array 1
	dec-type warnings[]
	rep-type hashcode[]
variable return.meta
	var-kind field meta
	enclosing-var return
	dec-type GETCities&Output&200&meta
	rep-type hashcode
variable return.meta.count
	var-kind field count
	enclosing-var return.meta
	dec-type int
	rep-type int
variable return.meta.links
	var-kind field links
	enclosing-var return.meta
	dec-type GETCities&Output&200&links
	rep-type hashcode
variable return.meta.links.self
	var-kind field self
	enclosing-var return.meta.links
	dec-type java.lang.String
	rep-type java.lang.String
variable return.data
	var-kind field data
	enclosing-var return
	dec-type data[]
	rep-type hashcode
variable return.data[..]
	var-kind array
	enclosing-var return.data
	array 1
	dec-type data[]
	rep-type hashcode[]
variable return.included
	var-kind field included
	enclosing-var return
	dec-type GETCities&Output&200&included
	rep-type hashcode
variable return.included.airports
	var-kind field airports
	enclosing-var return.included
	dec-type GETCities&Output&200&airports
	rep-type hashcode

ppt /reference-data/locations/cities&GETCities&200&data&relationships():::EXIT2
ppt-type subexit
variable input
	var-kind variable
	dec-type GETCities&Input
	rep-type hashcode
variable input.countryCode
	var-kind field countryCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.keyword
	var-kind field keyword
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.max
	var-kind field max
	enclosing-var input
	dec-type int
	rep-type int
variable input.include
	var-kind field include
	enclosing-var input
	dec-type java.lang.String[]
	rep-type hashcode
variable input.include[..]
	var-kind array
	enclosing-var input.include
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable return
	var-kind return
	dec-type GETCities&Output&200&data&relationships
	rep-type hashcode
variable return.id
	var-kind field id
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.type
	var-kind field type
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.href
	var-kind field href
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

ppt /reference-data/locations/cities&GETCities&200&warnings():::EXIT3
ppt-type subexit
variable input
	var-kind variable
	dec-type GETCities&Input
	rep-type hashcode
variable input.countryCode
	var-kind field countryCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.keyword
	var-kind field keyword
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.max
	var-kind field max
	enclosing-var input
	dec-type int
	rep-type int
variable input.include
	var-kind field include
	enclosing-var input
	dec-type java.lang.String[]
	rep-type hashcode
variable input.include[..]
	var-kind array
	enclosing-var input.include
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable return
	var-kind return
	dec-type GETCities&Output&200&warnings
	rep-type hashcode
variable return.code
	var-kind field code
	enclosing-var return
	dec-type int
	rep-type int
variable return.title
	var-kind field title
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.detail
	var-kind field detail
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.status
	var-kind field status
	enclosing-var return
	dec-type int
	rep-type int
variable return.source
	var-kind field source
	enclosing-var return
	dec-type GETCities&Output&200&warnings&source
	rep-type hashcode
variable return.source.parameter
	var-kind field parameter
	enclosing-var return.source
	dec-type java.lang.String
	rep-type java.lang.String
variable return.source.pointer
	var-kind field pointer
	enclosing-var return.source
	dec-type java.lang.String
	rep-type java.lang.String
variable return.source.example
	var-kind field example
	enclosing-var return.source
	dec-type java.lang.String
	rep-type java.lang.String

ppt /reference-data/locations/cities&GETCities&200&data():::EXIT4
ppt-type subexit
variable input
	var-kind variable
	dec-type GETCities&Input
	rep-type hashcode
variable input.countryCode
	var-kind field countryCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.keyword
	var-kind field keyword
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.max
	var-kind field max
	enclosing-var input
	dec-type int
	rep-type int
variable input.include
	var-kind field include
	enclosing-var input
	dec-type java.lang.String[]
	rep-type hashcode
variable input.include[..]
	var-kind array
	enclosing-var input.include
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable return
	var-kind return
	dec-type GETCities&Output&200&data
	rep-type hashcode
variable return.type
	var-kind field type
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.relationships
	var-kind field relationships
	enclosing-var return
	dec-type relationships[]
	rep-type hashcode
variable return.relationships[..]
	var-kind array
	enclosing-var return.relationships
	array 1
	dec-type relationships[]
	rep-type hashcode[]
variable return.subType
	var-kind field subType
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.name
	var-kind field name
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.iataCode
	var-kind field iataCode
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.address
	var-kind field address
	enclosing-var return
	dec-type GETCities&Output&200&data&address
	rep-type hashcode
variable return.address.postalCode
	var-kind field postalCode
	enclosing-var return.address
	dec-type java.lang.String
	rep-type java.lang.String
variable return.address.countryCode
	var-kind field countryCode
	enclosing-var return.address
	dec-type java.lang.String
	rep-type java.lang.String
variable return.address.stateCode
	var-kind field stateCode
	enclosing-var return.address
	dec-type java.lang.String
	rep-type java.lang.String
variable return.geoCode
	var-kind field geoCode
	enclosing-var return
	dec-type GETCities&Output&200&data&geoCode
	rep-type hashcode
variable return.geoCode.latitude
	var-kind field latitude
	enclosing-var return.geoCode
	dec-type double
	rep-type double
variable return.geoCode.longitude
	var-kind field longitude
	enclosing-var return.geoCode
	dec-type double
	rep-type double

