decl-version 2.0
var-comparability implicit

ppt main.findAirports_Input:::CLASS
ppt-type class

ppt main.findAirports_Input:::OBJECT
ppt-type object
variable this
	var-kind variable
	dec-type main.findAirports_Input
	rep-type java.lang.String
variable this.iata
	var-kind field iata
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.icao
	var-kind field icao
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String


ppt main.findAirports_Output_200:::CLASS
ppt-type class

ppt main.findAirports_Output_200:::OBJECT
ppt-type object
variable this
	var-kind variable
	dec-type main.findAirports_Output_200
	rep-type java.lang.String
variable this.id
	var-kind field id
	enclosing-var this
	dec-type int
	rep-type int
variable this.iata
	var-kind field iata
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.icao
	var-kind field icao
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.name
	var-kind field name
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.location
	var-kind field location
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.street_number
	var-kind field street_number
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.street
	var-kind field street
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.city
	var-kind field city
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.county
	var-kind field county
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.state
	var-kind field state
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.country_iso
	var-kind field country_iso
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.country
	var-kind field country
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.postal_code
	var-kind field postal_code
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.phone
	var-kind field phone
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.latitude
	var-kind field latitude
	enclosing-var this
	dec-type double
	rep-type double
variable this.longitude
	var-kind field longitude
	enclosing-var this
	dec-type double
	rep-type double
variable this.uct
	var-kind field uct
	enclosing-var this
	dec-type int
	rep-type int
variable this.website
	var-kind field website
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String


ppt main.airport:::CLASS
ppt-type class

ppt main.airport.findAirports_200(main.findAirports_Input):::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type main.findAirports_Input
	rep-type java.lang.String
variable input.iata
	var-kind field iata
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.icao
	var-kind field icao
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt main.airport.findAirports_200(main.findAirports_Input):::EXIT1
ppt-type subexit
variable input
	var-kind variable
	dec-type main.findAirports_Input
	rep-type java.lang.String
variable input.iata
	var-kind field iata
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.icao
	var-kind field icao
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type main.findAirports_Output_200
	rep-type java.lang.String
variable return.id
	var-kind field id
	enclosing-var return
	dec-type int
	rep-type int
variable return.iata
	var-kind field iata
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.icao
	var-kind field icao
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.name
	var-kind field name
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.location
	var-kind field location
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.street_number
	var-kind field street_number
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.street
	var-kind field street
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.city
	var-kind field city
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.county
	var-kind field county
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.state
	var-kind field state
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.country_iso
	var-kind field country_iso
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.country
	var-kind field country
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.postal_code
	var-kind field postal_code
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.phone
	var-kind field phone
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.latitude
	var-kind field latitude
	enclosing-var return
	dec-type double
	rep-type double
variable return.longitude
	var-kind field longitude
	enclosing-var return
	dec-type double
	rep-type double
variable return.uct
	var-kind field uct
	enclosing-var return
	dec-type int
	rep-type int
variable return.website
	var-kind field website
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

