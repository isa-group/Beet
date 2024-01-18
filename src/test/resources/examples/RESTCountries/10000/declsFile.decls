decl-version 2.0
var-comparability implicit

ppt /v3.1/alpha:::CLASS
ppt-type class

ppt /v3.1/alpha&v31ListOfCodes&200%array():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type v31ListOfCodes&Input
	rep-type hashcode
variable input.codes
	var-kind field codes
	enclosing-var input
	dec-type java.lang.String[]
	rep-type hashcode
variable input.codes[..]
	var-kind array
	enclosing-var input.codes
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]

ppt /v3.1/alpha&v31ListOfCodes&200():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type v31ListOfCodes&Input
	rep-type hashcode
variable input.codes
	var-kind field codes
	enclosing-var input
	dec-type java.lang.String[]
	rep-type hashcode
variable input.codes[..]
	var-kind array
	enclosing-var input.codes
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]

ppt /v3.1/alpha&v31ListOfCodes&200%array():::EXIT1
ppt-type subexit
variable input
	var-kind variable
	dec-type v31ListOfCodes&Input
	rep-type hashcode
variable input.codes
	var-kind field codes
	enclosing-var input
	dec-type java.lang.String[]
	rep-type hashcode
variable input.codes[..]
	var-kind array
	enclosing-var input.codes
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable return
	var-kind return
	dec-type v31ListOfCodes&Output&200%array
	rep-type hashcode
variable return.array
	var-kind field array
	enclosing-var return
	dec-type array[]
	rep-type hashcode
variable return.array[..]
	var-kind array
	enclosing-var return.array
	array 1
	dec-type array[]
	rep-type hashcode[]

ppt /v3.1/alpha&v31ListOfCodes&200():::EXIT2
ppt-type subexit
variable input
	var-kind variable
	dec-type v31ListOfCodes&Input
	rep-type hashcode
variable input.codes
	var-kind field codes
	enclosing-var input
	dec-type java.lang.String[]
	rep-type hashcode
variable input.codes[..]
	var-kind array
	enclosing-var input.codes
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable return
	var-kind return
	dec-type v31ListOfCodes&Output&200
	rep-type hashcode
variable return.name
	var-kind field name
	enclosing-var return
	dec-type v31ListOfCodes&Output&200&name
	rep-type hashcode
variable return.name.common
	var-kind field common
	enclosing-var return.name
	dec-type java.lang.String
	rep-type java.lang.String
variable return.name.official
	var-kind field official
	enclosing-var return.name
	dec-type java.lang.String
	rep-type java.lang.String
variable return.name.nativeName
	var-kind field nativeName
	enclosing-var return.name
	dec-type v31ListOfCodes&Output&200&nativeName
	rep-type hashcode
variable return.tld
	var-kind field tld
	enclosing-var return
	dec-type java.lang.String[]
	rep-type hashcode
variable return.tld[..]
	var-kind array
	enclosing-var return.tld
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable return.cca2
	var-kind field cca2
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.ccn3
	var-kind field ccn3
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.cca3
	var-kind field cca3
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.cioc
	var-kind field cioc
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.independent
	var-kind field independent
	enclosing-var return
	dec-type boolean
	rep-type boolean
variable return.status
	var-kind field status
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.unMember
	var-kind field unMember
	enclosing-var return
	dec-type boolean
	rep-type boolean
variable return.currencies
	var-kind field currencies
	enclosing-var return
	dec-type v31ListOfCodes&Output&200&currencies
	rep-type hashcode
variable return.idd
	var-kind field idd
	enclosing-var return
	dec-type v31ListOfCodes&Output&200&idd
	rep-type hashcode
variable return.idd.root
	var-kind field root
	enclosing-var return.idd
	dec-type java.lang.String
	rep-type java.lang.String
variable return.idd.suffixes
	var-kind field suffixes
	enclosing-var return.idd
	dec-type java.lang.String[]
	rep-type hashcode
variable return.idd.suffixes[..]
	var-kind array
	enclosing-var return.idd.suffixes
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable return.capital
	var-kind field capital
	enclosing-var return
	dec-type java.lang.String[]
	rep-type hashcode
variable return.capital[..]
	var-kind array
	enclosing-var return.capital
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable return.altSpellings
	var-kind field altSpellings
	enclosing-var return
	dec-type java.lang.String[]
	rep-type hashcode
variable return.altSpellings[..]
	var-kind array
	enclosing-var return.altSpellings
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable return.region
	var-kind field region
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.subregion
	var-kind field subregion
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.languages
	var-kind field languages
	enclosing-var return
	dec-type v31ListOfCodes&Output&200&languages
	rep-type hashcode
variable return.translations
	var-kind field translations
	enclosing-var return
	dec-type v31ListOfCodes&Output&200&translations
	rep-type hashcode
variable return.latlng
	var-kind field latlng
	enclosing-var return
	dec-type double[]
	rep-type hashcode
variable return.latlng[..]
	var-kind array
	enclosing-var return.latlng
	array 1
	dec-type double[]
	rep-type double[]
variable return.landlocked
	var-kind field landlocked
	enclosing-var return
	dec-type boolean
	rep-type boolean
variable return.borders
	var-kind field borders
	enclosing-var return
	dec-type java.lang.String[]
	rep-type hashcode
variable return.borders[..]
	var-kind array
	enclosing-var return.borders
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable return.area
	var-kind field area
	enclosing-var return
	dec-type double
	rep-type double
variable return.demonyms
	var-kind field demonyms
	enclosing-var return
	dec-type v31ListOfCodes&Output&200&demonyms
	rep-type hashcode
variable return.demonyms.eng
	var-kind field eng
	enclosing-var return.demonyms
	dec-type v31ListOfCodes&Output&200&eng
	rep-type hashcode
variable return.demonyms.eng.f
	var-kind field f
	enclosing-var return.demonyms.eng
	dec-type java.lang.String
	rep-type java.lang.String
variable return.demonyms.eng.m
	var-kind field m
	enclosing-var return.demonyms.eng
	dec-type java.lang.String
	rep-type java.lang.String
variable return.demonyms.fra
	var-kind field fra
	enclosing-var return.demonyms
	dec-type v31ListOfCodes&Output&200&fra
	rep-type hashcode
variable return.demonyms.fra.f
	var-kind field f
	enclosing-var return.demonyms.fra
	dec-type java.lang.String
	rep-type java.lang.String
variable return.demonyms.fra.m
	var-kind field m
	enclosing-var return.demonyms.fra
	dec-type java.lang.String
	rep-type java.lang.String
variable return.flag
	var-kind field flag
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.maps
	var-kind field maps
	enclosing-var return
	dec-type v31ListOfCodes&Output&200&maps
	rep-type hashcode
variable return.maps.googleMaps
	var-kind field googleMaps
	enclosing-var return.maps
	dec-type java.lang.String
	rep-type java.lang.String
variable return.maps.openStreetMaps
	var-kind field openStreetMaps
	enclosing-var return.maps
	dec-type java.lang.String
	rep-type java.lang.String
variable return.population
	var-kind field population
	enclosing-var return
	dec-type int
	rep-type int
variable return.gini
	var-kind field gini
	enclosing-var return
	dec-type v31ListOfCodes&Output&200&gini
	rep-type hashcode
variable return.fifa
	var-kind field fifa
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.car
	var-kind field car
	enclosing-var return
	dec-type v31ListOfCodes&Output&200&car
	rep-type hashcode
variable return.car.signs
	var-kind field signs
	enclosing-var return.car
	dec-type java.lang.String[]
	rep-type hashcode
variable return.car.signs[..]
	var-kind array
	enclosing-var return.car.signs
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable return.car.side
	var-kind field side
	enclosing-var return.car
	dec-type java.lang.String
	rep-type java.lang.String
variable return.timezones
	var-kind field timezones
	enclosing-var return
	dec-type java.lang.String[]
	rep-type hashcode
variable return.timezones[..]
	var-kind array
	enclosing-var return.timezones
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable return.continents
	var-kind field continents
	enclosing-var return
	dec-type java.lang.String[]
	rep-type hashcode
variable return.continents[..]
	var-kind array
	enclosing-var return.continents
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable return.flags
	var-kind field flags
	enclosing-var return
	dec-type v31ListOfCodes&Output&200&flags
	rep-type hashcode
variable return.flags.png
	var-kind field png
	enclosing-var return.flags
	dec-type java.lang.String
	rep-type java.lang.String
variable return.flags.svg
	var-kind field svg
	enclosing-var return.flags
	dec-type java.lang.String
	rep-type java.lang.String
variable return.flags.alt
	var-kind field alt
	enclosing-var return.flags
	dec-type java.lang.String
	rep-type java.lang.String
variable return.coatOfArms
	var-kind field coatOfArms
	enclosing-var return
	dec-type v31ListOfCodes&Output&200&coatOfArms
	rep-type hashcode
variable return.coatOfArms.png
	var-kind field png
	enclosing-var return.coatOfArms
	dec-type java.lang.String
	rep-type java.lang.String
variable return.coatOfArms.svg
	var-kind field svg
	enclosing-var return.coatOfArms
	dec-type java.lang.String
	rep-type java.lang.String
variable return.startOfWeek
	var-kind field startOfWeek
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.capitalInfo
	var-kind field capitalInfo
	enclosing-var return
	dec-type v31ListOfCodes&Output&200&capitalInfo
	rep-type hashcode
variable return.capitalInfo.latlng
	var-kind field latlng
	enclosing-var return.capitalInfo
	dec-type double[]
	rep-type hashcode
variable return.capitalInfo.latlng[..]
	var-kind array
	enclosing-var return.capitalInfo.latlng
	array 1
	dec-type double[]
	rep-type double[]
variable return.postalCode
	var-kind field postalCode
	enclosing-var return
	dec-type v31ListOfCodes&Output&200&postalCode
	rep-type hashcode
variable return.postalCode.format
	var-kind field format
	enclosing-var return.postalCode
	dec-type java.lang.String
	rep-type java.lang.String
variable return.postalCode.regex
	var-kind field regex
	enclosing-var return.postalCode
	dec-type java.lang.String
	rep-type java.lang.String

