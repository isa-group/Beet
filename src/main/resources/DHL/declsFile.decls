decl-version 2.0
var-comparability implicit

ppt main.findByAddress_Input:::CLASS
ppt-type class

ppt main.findByAddress_Input:::OBJECT
ppt-type object
variable this
	var-kind variable
	dec-type main.findByAddress_Input
	rep-type java.lang.String
variable this.countryCode
	var-kind field countryCode
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.addressLocality
	var-kind field addressLocality
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.postalCode
	var-kind field postalCode
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.streetAddress
	var-kind field streetAddress
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.providerType
	var-kind field providerType
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.locationType
	var-kind field locationType
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.serviceType
	var-kind field serviceType
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.radius
	var-kind field radius
	enclosing-var this
	dec-type double
	rep-type double
variable this.limit
	var-kind field limit
	enclosing-var this
	dec-type double
	rep-type double


ppt main.findByAddress_Output_200:::CLASS
ppt-type class

ppt main.findByAddress_Output_200:::OBJECT
ppt-type object
variable this
	var-kind variable
	dec-type main.findByAddress_Output_200
	rep-type java.lang.String
variable this.locations
	var-kind field locations
	enclosing-var this
	dec-type main.locations[]
	rep-type java.lang.String
variable this.locations[..]
	var-kind array
	enclosing-var this.locations
	array 1
	dec-type main.locations[]
	rep-type java.lang.String[]

ppt main.findByAddress_Output_200_locations_openingHours:::OBJECT
ppt-type object
variable this
	var-kind variable
	dec-type main.findByAddress_Output_200_locations_openingHours
	rep-type java.lang.String
variable this.closes
	var-kind field closes
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.opens
	var-kind field opens
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.dayOfWeek
	var-kind field dayOfWeek
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String

ppt main.findByAddress_Output_200_locations_closurePeriods:::OBJECT
ppt-type object
variable this
	var-kind variable
	dec-type main.findByAddress_Output_200_locations_closurePeriods
	rep-type java.lang.String
variable this.type
	var-kind field type
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.fromDate
	var-kind field fromDate
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.toDate
	var-kind field toDate
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String

ppt main.findByAddress_Output_200_locations:::OBJECT
ppt-type object
variable this
	var-kind variable
	dec-type main.findByAddress_Output_200_locations
	rep-type java.lang.String
variable this.url
	var-kind field url
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.location
	var-kind variable
	enclosing-var this
	dec-type main.findByAddress_Output_200_locations_location
	rep-type java.lang.String
variable this.location.ids
	var-kind field ids
	enclosing-var this.location
	dec-type main.ids[]
	rep-type java.lang.String
variable this.location.ids[..]
	var-kind array
	enclosing-var this.location.ids
	array 1
	dec-type main.ids[]
	rep-type java.lang.String[]
variable this.location.keyword
	var-kind field keyword
	enclosing-var this.location
	dec-type java.lang.String
	rep-type java.lang.String
variable this.location.keywordId
	var-kind field keywordId
	enclosing-var this.location
	dec-type java.lang.String
	rep-type java.lang.String
variable this.location.type
	var-kind field type
	enclosing-var this.location
	dec-type java.lang.String
	rep-type java.lang.String
variable this.name
	var-kind field name
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.distance
	var-kind field distance
	enclosing-var this
	dec-type double
	rep-type double
variable this.place
	var-kind variable
	enclosing-var this
	dec-type main.findByAddress_Output_200_locations_place
	rep-type java.lang.String
variable this.place.address
	var-kind variable
	enclosing-var this.place
	dec-type main.findByAddress_Output_200_locations_address
	rep-type java.lang.String
variable this.place.address.countryCode
	var-kind field countryCode
	enclosing-var this.place.address
	dec-type java.lang.String
	rep-type java.lang.String
variable this.place.address.postalCode
	var-kind field postalCode
	enclosing-var this.place.address
	dec-type java.lang.String
	rep-type java.lang.String
variable this.place.address.addressLocality
	var-kind field addressLocality
	enclosing-var this.place.address
	dec-type java.lang.String
	rep-type java.lang.String
variable this.place.address.streetAddress
	var-kind field streetAddress
	enclosing-var this.place.address
	dec-type java.lang.String
	rep-type java.lang.String
variable this.place.geo
	var-kind variable
	enclosing-var this.place
	dec-type main.findByAddress_Output_200_locations_geo
	rep-type java.lang.String
variable this.place.geo.latitude
	var-kind field latitude
	enclosing-var this.place.geo
	dec-type double
	rep-type double
variable this.place.geo.longitude
	var-kind field longitude
	enclosing-var this.place.geo
	dec-type double
	rep-type double
variable this.serviceTypes
	var-kind field serviceTypes
	enclosing-var this
	dec-type java.lang.String[]
	rep-type java.lang.String
variable this.serviceTypes[..]
	var-kind array
	enclosing-var this.serviceTypes
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable this.averageCapacityDayOfWeek
	var-kind field averageCapacityDayOfWeek
	enclosing-var this
	dec-type main.averageCapacityDayOfWeek[]
	rep-type java.lang.String
variable this.averageCapacityDayOfWeek[..]
	var-kind array
	enclosing-var this.averageCapacityDayOfWeek
	array 1
	dec-type main.averageCapacityDayOfWeek[]
	rep-type java.lang.String[]
variable this.availableCapacity
	var-kind field availableCapacity
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.openingHours
	var-kind field openingHours
	enclosing-var this
	dec-type main.openingHours[]
	rep-type java.lang.String
variable this.openingHours[..]
	var-kind array
	enclosing-var this.openingHours
	array 1
	dec-type main.openingHours[]
	rep-type java.lang.String[]
variable this.closurePeriods
	var-kind field closurePeriods
	enclosing-var this
	dec-type main.closurePeriods[]
	rep-type java.lang.String
variable this.closurePeriods[..]
	var-kind array
	enclosing-var this.closurePeriods
	array 1
	dec-type main.closurePeriods[]
	rep-type java.lang.String[]

ppt main.findByAddress_Output_200_locations_location_ids:::OBJECT
ppt-type object
variable this
	var-kind variable
	dec-type main.findByAddress_Output_200_locations_location_ids
	rep-type java.lang.String
variable this.locationId
	var-kind field locationId
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.provider
	var-kind field provider
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String

ppt main.findByAddress_Output_200_locations_averageCapacityDayOfWeek:::OBJECT
ppt-type object
variable this
	var-kind variable
	dec-type main.findByAddress_Output_200_locations_averageCapacityDayOfWeek
	rep-type java.lang.String
variable this.dayOfWeek
	var-kind field dayOfWeek
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.capacity
	var-kind field capacity
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String


ppt main.findByAddress_Output_400:::CLASS
ppt-type class

ppt main.findByAddress_Output_400:::OBJECT
ppt-type object
variable this
	var-kind variable
	dec-type main.findByAddress_Output_400
	rep-type java.lang.String
variable this.supermodelIoLogisticsPUDOApiProblemDetail
	var-kind variable
	enclosing-var this
	dec-type main.findByAddress_Output_400_supermodelIoLogisticsPUDOApiProblemDetail
	rep-type java.lang.String
variable this.supermodelIoLogisticsPUDOApiProblemDetail.status
	var-kind field status
	enclosing-var this.supermodelIoLogisticsPUDOApiProblemDetail
	dec-type double
	rep-type double
variable this.supermodelIoLogisticsPUDOApiProblemDetail.title
	var-kind field title
	enclosing-var this.supermodelIoLogisticsPUDOApiProblemDetail
	dec-type java.lang.String
	rep-type java.lang.String
variable this.supermodelIoLogisticsPUDOApiProblemDetail.detail
	var-kind field detail
	enclosing-var this.supermodelIoLogisticsPUDOApiProblemDetail
	dec-type java.lang.String
	rep-type java.lang.String


ppt main.find-by-address:::CLASS
ppt-type class

ppt main.find-by-address.findByAddress_200(main.findByAddress_Input):::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type main.findByAddress_Input
	rep-type java.lang.String
variable input.countryCode
	var-kind field countryCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.addressLocality
	var-kind field addressLocality
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.postalCode
	var-kind field postalCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.streetAddress
	var-kind field streetAddress
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.providerType
	var-kind field providerType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.locationType
	var-kind field locationType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.serviceType
	var-kind field serviceType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.radius
	var-kind field radius
	enclosing-var input
	dec-type double
	rep-type double
variable input.limit
	var-kind field limit
	enclosing-var input
	dec-type double
	rep-type double

ppt main.find-by-address.findByAddress_200_locations_openingHours(main.findByAddress_Input):::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type main.findByAddress_Input
	rep-type java.lang.String
variable input.countryCode
	var-kind field countryCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.addressLocality
	var-kind field addressLocality
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.postalCode
	var-kind field postalCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.streetAddress
	var-kind field streetAddress
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.providerType
	var-kind field providerType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.locationType
	var-kind field locationType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.serviceType
	var-kind field serviceType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.radius
	var-kind field radius
	enclosing-var input
	dec-type double
	rep-type double
variable input.limit
	var-kind field limit
	enclosing-var input
	dec-type double
	rep-type double

ppt main.find-by-address.findByAddress_200_locations_closurePeriods(main.findByAddress_Input):::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type main.findByAddress_Input
	rep-type java.lang.String
variable input.countryCode
	var-kind field countryCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.addressLocality
	var-kind field addressLocality
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.postalCode
	var-kind field postalCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.streetAddress
	var-kind field streetAddress
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.providerType
	var-kind field providerType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.locationType
	var-kind field locationType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.serviceType
	var-kind field serviceType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.radius
	var-kind field radius
	enclosing-var input
	dec-type double
	rep-type double
variable input.limit
	var-kind field limit
	enclosing-var input
	dec-type double
	rep-type double

ppt main.find-by-address.findByAddress_200_locations(main.findByAddress_Input):::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type main.findByAddress_Input
	rep-type java.lang.String
variable input.countryCode
	var-kind field countryCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.addressLocality
	var-kind field addressLocality
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.postalCode
	var-kind field postalCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.streetAddress
	var-kind field streetAddress
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.providerType
	var-kind field providerType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.locationType
	var-kind field locationType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.serviceType
	var-kind field serviceType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.radius
	var-kind field radius
	enclosing-var input
	dec-type double
	rep-type double
variable input.limit
	var-kind field limit
	enclosing-var input
	dec-type double
	rep-type double

ppt main.find-by-address.findByAddress_200_locations_location_ids(main.findByAddress_Input):::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type main.findByAddress_Input
	rep-type java.lang.String
variable input.countryCode
	var-kind field countryCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.addressLocality
	var-kind field addressLocality
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.postalCode
	var-kind field postalCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.streetAddress
	var-kind field streetAddress
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.providerType
	var-kind field providerType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.locationType
	var-kind field locationType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.serviceType
	var-kind field serviceType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.radius
	var-kind field radius
	enclosing-var input
	dec-type double
	rep-type double
variable input.limit
	var-kind field limit
	enclosing-var input
	dec-type double
	rep-type double

ppt main.find-by-address.findByAddress_200_locations_averageCapacityDayOfWeek(main.findByAddress_Input):::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type main.findByAddress_Input
	rep-type java.lang.String
variable input.countryCode
	var-kind field countryCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.addressLocality
	var-kind field addressLocality
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.postalCode
	var-kind field postalCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.streetAddress
	var-kind field streetAddress
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.providerType
	var-kind field providerType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.locationType
	var-kind field locationType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.serviceType
	var-kind field serviceType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.radius
	var-kind field radius
	enclosing-var input
	dec-type double
	rep-type double
variable input.limit
	var-kind field limit
	enclosing-var input
	dec-type double
	rep-type double

ppt main.find-by-address.findByAddress_400(main.findByAddress_Input):::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type main.findByAddress_Input
	rep-type java.lang.String
variable input.countryCode
	var-kind field countryCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.addressLocality
	var-kind field addressLocality
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.postalCode
	var-kind field postalCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.streetAddress
	var-kind field streetAddress
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.providerType
	var-kind field providerType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.locationType
	var-kind field locationType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.serviceType
	var-kind field serviceType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.radius
	var-kind field radius
	enclosing-var input
	dec-type double
	rep-type double
variable input.limit
	var-kind field limit
	enclosing-var input
	dec-type double
	rep-type double

ppt main.find-by-address.findByAddress_200(main.findByAddress_Input):::EXIT1
ppt-type subexit
variable input
	var-kind variable
	dec-type main.findByAddress_Input
	rep-type java.lang.String
variable input.countryCode
	var-kind field countryCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.addressLocality
	var-kind field addressLocality
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.postalCode
	var-kind field postalCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.streetAddress
	var-kind field streetAddress
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.providerType
	var-kind field providerType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.locationType
	var-kind field locationType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.serviceType
	var-kind field serviceType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.radius
	var-kind field radius
	enclosing-var input
	dec-type double
	rep-type double
variable input.limit
	var-kind field limit
	enclosing-var input
	dec-type double
	rep-type double
variable return
	var-kind return
	dec-type main.findByAddress_Output_200
	rep-type java.lang.String
variable return.locations
	var-kind field locations
	enclosing-var return
	dec-type main.locations[]
	rep-type java.lang.String
variable return.locations[..]
	var-kind array
	enclosing-var return.locations
	array 1
	dec-type main.locations[]
	rep-type java.lang.String[]

ppt main.find-by-address.findByAddress_200_locations_openingHours(main.findByAddress_Input):::EXIT2
ppt-type subexit
variable input
	var-kind variable
	dec-type main.findByAddress_Input
	rep-type java.lang.String
variable input.countryCode
	var-kind field countryCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.addressLocality
	var-kind field addressLocality
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.postalCode
	var-kind field postalCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.streetAddress
	var-kind field streetAddress
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.providerType
	var-kind field providerType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.locationType
	var-kind field locationType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.serviceType
	var-kind field serviceType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.radius
	var-kind field radius
	enclosing-var input
	dec-type double
	rep-type double
variable input.limit
	var-kind field limit
	enclosing-var input
	dec-type double
	rep-type double
variable return
	var-kind return
	dec-type main.findByAddress_Output_200_locations_openingHours
	rep-type java.lang.String
variable return.closes
	var-kind field closes
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.opens
	var-kind field opens
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.dayOfWeek
	var-kind field dayOfWeek
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

ppt main.find-by-address.findByAddress_200_locations_closurePeriods(main.findByAddress_Input):::EXIT3
ppt-type subexit
variable input
	var-kind variable
	dec-type main.findByAddress_Input
	rep-type java.lang.String
variable input.countryCode
	var-kind field countryCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.addressLocality
	var-kind field addressLocality
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.postalCode
	var-kind field postalCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.streetAddress
	var-kind field streetAddress
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.providerType
	var-kind field providerType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.locationType
	var-kind field locationType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.serviceType
	var-kind field serviceType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.radius
	var-kind field radius
	enclosing-var input
	dec-type double
	rep-type double
variable input.limit
	var-kind field limit
	enclosing-var input
	dec-type double
	rep-type double
variable return
	var-kind return
	dec-type main.findByAddress_Output_200_locations_closurePeriods
	rep-type java.lang.String
variable return.type
	var-kind field type
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.fromDate
	var-kind field fromDate
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.toDate
	var-kind field toDate
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

ppt main.find-by-address.findByAddress_200_locations(main.findByAddress_Input):::EXIT4
ppt-type subexit
variable input
	var-kind variable
	dec-type main.findByAddress_Input
	rep-type java.lang.String
variable input.countryCode
	var-kind field countryCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.addressLocality
	var-kind field addressLocality
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.postalCode
	var-kind field postalCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.streetAddress
	var-kind field streetAddress
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.providerType
	var-kind field providerType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.locationType
	var-kind field locationType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.serviceType
	var-kind field serviceType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.radius
	var-kind field radius
	enclosing-var input
	dec-type double
	rep-type double
variable input.limit
	var-kind field limit
	enclosing-var input
	dec-type double
	rep-type double
variable return
	var-kind return
	dec-type main.findByAddress_Output_200_locations
	rep-type java.lang.String
variable return.url
	var-kind field url
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.location
	var-kind return
	enclosing-var return
	dec-type main.findByAddress_Output_200_locations_location
	rep-type java.lang.String
variable return.location.ids
	var-kind field ids
	enclosing-var return.location
	dec-type main.ids[]
	rep-type java.lang.String
variable return.location.ids[..]
	var-kind array
	enclosing-var return.location.ids
	array 1
	dec-type main.ids[]
	rep-type java.lang.String[]
variable return.location.keyword
	var-kind field keyword
	enclosing-var return.location
	dec-type java.lang.String
	rep-type java.lang.String
variable return.location.keywordId
	var-kind field keywordId
	enclosing-var return.location
	dec-type java.lang.String
	rep-type java.lang.String
variable return.location.type
	var-kind field type
	enclosing-var return.location
	dec-type java.lang.String
	rep-type java.lang.String
variable return.name
	var-kind field name
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.distance
	var-kind field distance
	enclosing-var return
	dec-type double
	rep-type double
variable return.place
	var-kind return
	enclosing-var return
	dec-type main.findByAddress_Output_200_locations_place
	rep-type java.lang.String
variable return.place.address
	var-kind return
	enclosing-var return.place
	dec-type main.findByAddress_Output_200_locations_address
	rep-type java.lang.String
variable return.place.address.countryCode
	var-kind field countryCode
	enclosing-var return.place.address
	dec-type java.lang.String
	rep-type java.lang.String
variable return.place.address.postalCode
	var-kind field postalCode
	enclosing-var return.place.address
	dec-type java.lang.String
	rep-type java.lang.String
variable return.place.address.addressLocality
	var-kind field addressLocality
	enclosing-var return.place.address
	dec-type java.lang.String
	rep-type java.lang.String
variable return.place.address.streetAddress
	var-kind field streetAddress
	enclosing-var return.place.address
	dec-type java.lang.String
	rep-type java.lang.String
variable return.place.geo
	var-kind return
	enclosing-var return.place
	dec-type main.findByAddress_Output_200_locations_geo
	rep-type java.lang.String
variable return.place.geo.latitude
	var-kind field latitude
	enclosing-var return.place.geo
	dec-type double
	rep-type double
variable return.place.geo.longitude
	var-kind field longitude
	enclosing-var return.place.geo
	dec-type double
	rep-type double
variable return.serviceTypes
	var-kind field serviceTypes
	enclosing-var return
	dec-type java.lang.String[]
	rep-type java.lang.String
variable return.serviceTypes[..]
	var-kind array
	enclosing-var return.serviceTypes
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable return.averageCapacityDayOfWeek
	var-kind field averageCapacityDayOfWeek
	enclosing-var return
	dec-type main.averageCapacityDayOfWeek[]
	rep-type java.lang.String
variable return.averageCapacityDayOfWeek[..]
	var-kind array
	enclosing-var return.averageCapacityDayOfWeek
	array 1
	dec-type main.averageCapacityDayOfWeek[]
	rep-type java.lang.String[]
variable return.availableCapacity
	var-kind field availableCapacity
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.openingHours
	var-kind field openingHours
	enclosing-var return
	dec-type main.openingHours[]
	rep-type java.lang.String
variable return.openingHours[..]
	var-kind array
	enclosing-var return.openingHours
	array 1
	dec-type main.openingHours[]
	rep-type java.lang.String[]
variable return.closurePeriods
	var-kind field closurePeriods
	enclosing-var return
	dec-type main.closurePeriods[]
	rep-type java.lang.String
variable return.closurePeriods[..]
	var-kind array
	enclosing-var return.closurePeriods
	array 1
	dec-type main.closurePeriods[]
	rep-type java.lang.String[]

ppt main.find-by-address.findByAddress_200_locations_location_ids(main.findByAddress_Input):::EXIT5
ppt-type subexit
variable input
	var-kind variable
	dec-type main.findByAddress_Input
	rep-type java.lang.String
variable input.countryCode
	var-kind field countryCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.addressLocality
	var-kind field addressLocality
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.postalCode
	var-kind field postalCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.streetAddress
	var-kind field streetAddress
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.providerType
	var-kind field providerType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.locationType
	var-kind field locationType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.serviceType
	var-kind field serviceType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.radius
	var-kind field radius
	enclosing-var input
	dec-type double
	rep-type double
variable input.limit
	var-kind field limit
	enclosing-var input
	dec-type double
	rep-type double
variable return
	var-kind return
	dec-type main.findByAddress_Output_200_locations_location_ids
	rep-type java.lang.String
variable return.locationId
	var-kind field locationId
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.provider
	var-kind field provider
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

ppt main.find-by-address.findByAddress_200_locations_averageCapacityDayOfWeek(main.findByAddress_Input):::EXIT6
ppt-type subexit
variable input
	var-kind variable
	dec-type main.findByAddress_Input
	rep-type java.lang.String
variable input.countryCode
	var-kind field countryCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.addressLocality
	var-kind field addressLocality
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.postalCode
	var-kind field postalCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.streetAddress
	var-kind field streetAddress
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.providerType
	var-kind field providerType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.locationType
	var-kind field locationType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.serviceType
	var-kind field serviceType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.radius
	var-kind field radius
	enclosing-var input
	dec-type double
	rep-type double
variable input.limit
	var-kind field limit
	enclosing-var input
	dec-type double
	rep-type double
variable return
	var-kind return
	dec-type main.findByAddress_Output_200_locations_averageCapacityDayOfWeek
	rep-type java.lang.String
variable return.dayOfWeek
	var-kind field dayOfWeek
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.capacity
	var-kind field capacity
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

ppt main.find-by-address.findByAddress_400(main.findByAddress_Input):::EXIT7
ppt-type subexit
variable input
	var-kind variable
	dec-type main.findByAddress_Input
	rep-type java.lang.String
variable input.countryCode
	var-kind field countryCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.addressLocality
	var-kind field addressLocality
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.postalCode
	var-kind field postalCode
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.streetAddress
	var-kind field streetAddress
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.providerType
	var-kind field providerType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.locationType
	var-kind field locationType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.serviceType
	var-kind field serviceType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.radius
	var-kind field radius
	enclosing-var input
	dec-type double
	rep-type double
variable input.limit
	var-kind field limit
	enclosing-var input
	dec-type double
	rep-type double
variable return
	var-kind return
	dec-type main.findByAddress_Output_400
	rep-type java.lang.String
variable return.supermodelIoLogisticsPUDOApiProblemDetail
	var-kind return
	enclosing-var return
	dec-type main.findByAddress_Output_400_supermodelIoLogisticsPUDOApiProblemDetail
	rep-type java.lang.String
variable return.supermodelIoLogisticsPUDOApiProblemDetail.status
	var-kind field status
	enclosing-var return.supermodelIoLogisticsPUDOApiProblemDetail
	dec-type double
	rep-type double
variable return.supermodelIoLogisticsPUDOApiProblemDetail.title
	var-kind field title
	enclosing-var return.supermodelIoLogisticsPUDOApiProblemDetail
	dec-type java.lang.String
	rep-type java.lang.String
variable return.supermodelIoLogisticsPUDOApiProblemDetail.detail
	var-kind field detail
	enclosing-var return.supermodelIoLogisticsPUDOApiProblemDetail
	dec-type java.lang.String
	rep-type java.lang.String

