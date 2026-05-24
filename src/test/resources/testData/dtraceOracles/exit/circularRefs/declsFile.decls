decl-version 2.0
var-comparability implicit

ppt /api/v1/holidays:::CLASS
ppt-type class

ppt /api/v1/holidays&Holidays&200():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type Holidays&Input
	rep-type hashcode
variable input.year
	var-kind field year
	enclosing-var input
	dec-type int
	rep-type int
variable input.federal
	var-kind field federal
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.optional
	var-kind field optional
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /api/v1/holidays&Holidays&200&holidays():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type Holidays&Input
	rep-type hashcode
variable input.year
	var-kind field year
	enclosing-var input
	dec-type int
	rep-type int
variable input.federal
	var-kind field federal
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.optional
	var-kind field optional
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /api/v1/holidays&Holidays&200&holidays&provinces():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type Holidays&Input
	rep-type hashcode
variable input.year
	var-kind field year
	enclosing-var input
	dec-type int
	rep-type int
variable input.federal
	var-kind field federal
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.optional
	var-kind field optional
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /api/v1/holidays&Holidays&200&holidays&provinces&holidays():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type Holidays&Input
	rep-type hashcode
variable input.year
	var-kind field year
	enclosing-var input
	dec-type int
	rep-type int
variable input.federal
	var-kind field federal
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.optional
	var-kind field optional
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /api/v1/holidays&Holidays&200():::EXIT1
ppt-type subexit
variable input
	var-kind variable
	dec-type Holidays&Input
	rep-type hashcode
variable input.year
	var-kind field year
	enclosing-var input
	dec-type int
	rep-type int
variable input.federal
	var-kind field federal
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.optional
	var-kind field optional
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type Holidays&Output&200
	rep-type hashcode
variable return.holidays
	var-kind field holidays
	enclosing-var return
	dec-type holidays[]
	rep-type hashcode
variable return.holidays[..]
	var-kind array
	enclosing-var return.holidays
	array 1
	dec-type holidays[]
	rep-type hashcode[]

ppt /api/v1/holidays&Holidays&200&holidays():::EXIT2
ppt-type subexit
variable input
	var-kind variable
	dec-type Holidays&Input
	rep-type hashcode
variable input.year
	var-kind field year
	enclosing-var input
	dec-type int
	rep-type int
variable input.federal
	var-kind field federal
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.optional
	var-kind field optional
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type Holidays&Output&200&holidays
	rep-type hashcode
variable return.id
	var-kind field id
	enclosing-var return
	dec-type int
	rep-type int
variable return.date
	var-kind field date
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.nameEn
	var-kind field nameEn
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.nameFr
	var-kind field nameFr
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.federal
	var-kind field federal
	enclosing-var return
	dec-type int
	rep-type int
variable return.observedDate
	var-kind field observedDate
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.provinces
	var-kind field provinces
	enclosing-var return
	dec-type provinces[]
	rep-type hashcode
variable return.provinces[..]
	var-kind array
	enclosing-var return.provinces
	array 1
	dec-type provinces[]
	rep-type hashcode[]
variable return.optional
	var-kind field optional
	enclosing-var return
	dec-type int
	rep-type int

ppt /api/v1/holidays&Holidays&200&holidays&provinces():::EXIT3
ppt-type subexit
variable input
	var-kind variable
	dec-type Holidays&Input
	rep-type hashcode
variable input.year
	var-kind field year
	enclosing-var input
	dec-type int
	rep-type int
variable input.federal
	var-kind field federal
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.optional
	var-kind field optional
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type Holidays&Output&200&holidays&provinces
	rep-type hashcode
variable return.id
	var-kind field id
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.nextHoliday
	var-kind field nextHoliday
	enclosing-var return
	dec-type Holidays&Output&200&holidays&provinces&nextHoliday
	rep-type hashcode
variable return.holidays
	var-kind field holidays
	enclosing-var return
	dec-type holidays[]
	rep-type hashcode
variable return.holidays[..]
	var-kind array
	enclosing-var return.holidays
	array 1
	dec-type holidays[]
	rep-type hashcode[]
variable return.nameFr
	var-kind field nameFr
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.nameEn
	var-kind field nameEn
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.sourceLink
	var-kind field sourceLink
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.sourceEn
	var-kind field sourceEn
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.optional
	var-kind field optional
	enclosing-var return
	dec-type int
	rep-type int

ppt /api/v1/holidays&Holidays&200&holidays&provinces&holidays():::EXIT4
ppt-type subexit
variable input
	var-kind variable
	dec-type Holidays&Input
	rep-type hashcode
variable input.year
	var-kind field year
	enclosing-var input
	dec-type int
	rep-type int
variable input.federal
	var-kind field federal
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.optional
	var-kind field optional
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type Holidays&Output&200&holidays&provinces&holidays
	rep-type hashcode
variable return.id
	var-kind field id
	enclosing-var return
	dec-type int
	rep-type int
variable return.date
	var-kind field date
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.nameEn
	var-kind field nameEn
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.nameFr
	var-kind field nameFr
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.federal
	var-kind field federal
	enclosing-var return
	dec-type int
	rep-type int
variable return.observedDate
	var-kind field observedDate
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.provinces
	var-kind field provinces
	enclosing-var return
	dec-type provinces[]
	rep-type hashcode
variable return.provinces[..]
	var-kind array
	enclosing-var return.provinces
	array 1
	dec-type provinces[]
	rep-type hashcode[]
variable return.optional
	var-kind field optional
	enclosing-var return
	dec-type int
	rep-type int


ppt /api/v1/provinces:::CLASS
ppt-type class

ppt /api/v1/provinces&Provinces&200():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type Provinces&Input
	rep-type hashcode
variable input.year
	var-kind field year
	enclosing-var input
	dec-type int
	rep-type int
variable input.optional
	var-kind field optional
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /api/v1/provinces&Provinces&200&provinces():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type Provinces&Input
	rep-type hashcode
variable input.year
	var-kind field year
	enclosing-var input
	dec-type int
	rep-type int
variable input.optional
	var-kind field optional
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /api/v1/provinces&Provinces&200&provinces&holidays():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type Provinces&Input
	rep-type hashcode
variable input.year
	var-kind field year
	enclosing-var input
	dec-type int
	rep-type int
variable input.optional
	var-kind field optional
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /api/v1/provinces&Provinces&200():::EXIT5
ppt-type subexit
variable input
	var-kind variable
	dec-type Provinces&Input
	rep-type hashcode
variable input.year
	var-kind field year
	enclosing-var input
	dec-type int
	rep-type int
variable input.optional
	var-kind field optional
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type Provinces&Output&200
	rep-type hashcode
variable return.provinces
	var-kind field provinces
	enclosing-var return
	dec-type provinces[]
	rep-type hashcode
variable return.provinces[..]
	var-kind array
	enclosing-var return.provinces
	array 1
	dec-type provinces[]
	rep-type hashcode[]

ppt /api/v1/provinces&Provinces&200&provinces():::EXIT6
ppt-type subexit
variable input
	var-kind variable
	dec-type Provinces&Input
	rep-type hashcode
variable input.year
	var-kind field year
	enclosing-var input
	dec-type int
	rep-type int
variable input.optional
	var-kind field optional
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type Provinces&Output&200&provinces
	rep-type hashcode
variable return.id
	var-kind field id
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.nextHoliday
	var-kind field nextHoliday
	enclosing-var return
	dec-type Provinces&Output&200&provinces&nextHoliday
	rep-type hashcode
variable return.holidays
	var-kind field holidays
	enclosing-var return
	dec-type holidays[]
	rep-type hashcode
variable return.holidays[..]
	var-kind array
	enclosing-var return.holidays
	array 1
	dec-type holidays[]
	rep-type hashcode[]
variable return.nameFr
	var-kind field nameFr
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.nameEn
	var-kind field nameEn
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.sourceLink
	var-kind field sourceLink
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.sourceEn
	var-kind field sourceEn
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.optional
	var-kind field optional
	enclosing-var return
	dec-type int
	rep-type int

ppt /api/v1/provinces&Provinces&200&provinces&holidays():::EXIT7
ppt-type subexit
variable input
	var-kind variable
	dec-type Provinces&Input
	rep-type hashcode
variable input.year
	var-kind field year
	enclosing-var input
	dec-type int
	rep-type int
variable input.optional
	var-kind field optional
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type Provinces&Output&200&provinces&holidays
	rep-type hashcode
variable return.id
	var-kind field id
	enclosing-var return
	dec-type int
	rep-type int
variable return.date
	var-kind field date
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.nameEn
	var-kind field nameEn
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.nameFr
	var-kind field nameFr
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.federal
	var-kind field federal
	enclosing-var return
	dec-type int
	rep-type int
variable return.observedDate
	var-kind field observedDate
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.provinces
	var-kind field provinces
	enclosing-var return
	dec-type provinces[]
	rep-type hashcode
variable return.provinces[..]
	var-kind array
	enclosing-var return.provinces
	array 1
	dec-type provinces[]
	rep-type hashcode[]
variable return.optional
	var-kind field optional
	enclosing-var return
	dec-type int
	rep-type int


ppt /api/v1/provinces/{provinceId}:::CLASS
ppt-type class

ppt /api/v1/provinces/{provinceId}&Province&200():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type Province&Input
	rep-type hashcode
variable input.provinceId
	var-kind field provinceId
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.year
	var-kind field year
	enclosing-var input
	dec-type int
	rep-type int
variable input.optional
	var-kind field optional
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /api/v1/provinces/{provinceId}&Province&200&province&holidays():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type Province&Input
	rep-type hashcode
variable input.provinceId
	var-kind field provinceId
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.year
	var-kind field year
	enclosing-var input
	dec-type int
	rep-type int
variable input.optional
	var-kind field optional
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /api/v1/provinces/{provinceId}&Province&200():::EXIT8
ppt-type subexit
variable input
	var-kind variable
	dec-type Province&Input
	rep-type hashcode
variable input.provinceId
	var-kind field provinceId
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.year
	var-kind field year
	enclosing-var input
	dec-type int
	rep-type int
variable input.optional
	var-kind field optional
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type Province&Output&200
	rep-type hashcode
variable return.province
	var-kind field province
	enclosing-var return
	dec-type Province&Output&200&province
	rep-type hashcode
variable return.province.id
	var-kind field id
	enclosing-var return.province
	dec-type java.lang.String
	rep-type java.lang.String
variable return.province.nextHoliday
	var-kind field nextHoliday
	enclosing-var return.province
	dec-type Province&Output&200&nextHoliday
	rep-type hashcode
variable return.province.holidays
	var-kind field holidays
	enclosing-var return.province
	dec-type holidays[]
	rep-type hashcode
variable return.province.holidays[..]
	var-kind array
	enclosing-var return.province.holidays
	array 1
	dec-type holidays[]
	rep-type hashcode[]
variable return.province.nameFr
	var-kind field nameFr
	enclosing-var return.province
	dec-type java.lang.String
	rep-type java.lang.String
variable return.province.nameEn
	var-kind field nameEn
	enclosing-var return.province
	dec-type java.lang.String
	rep-type java.lang.String
variable return.province.sourceLink
	var-kind field sourceLink
	enclosing-var return.province
	dec-type java.lang.String
	rep-type java.lang.String
variable return.province.sourceEn
	var-kind field sourceEn
	enclosing-var return.province
	dec-type java.lang.String
	rep-type java.lang.String
variable return.province.optional
	var-kind field optional
	enclosing-var return.province
	dec-type int
	rep-type int

ppt /api/v1/provinces/{provinceId}&Province&200&province&holidays():::EXIT9
ppt-type subexit
variable input
	var-kind variable
	dec-type Province&Input
	rep-type hashcode
variable input.provinceId
	var-kind field provinceId
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.year
	var-kind field year
	enclosing-var input
	dec-type int
	rep-type int
variable input.optional
	var-kind field optional
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type Province&Output&200&province&holidays
	rep-type hashcode
variable return.id
	var-kind field id
	enclosing-var return
	dec-type int
	rep-type int
variable return.date
	var-kind field date
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.nameEn
	var-kind field nameEn
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.nameFr
	var-kind field nameFr
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.federal
	var-kind field federal
	enclosing-var return
	dec-type int
	rep-type int
variable return.observedDate
	var-kind field observedDate
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.provinces
	var-kind field provinces
	enclosing-var return
	dec-type provinces[]
	rep-type hashcode
variable return.provinces[..]
	var-kind array
	enclosing-var return.provinces
	array 1
	dec-type provinces[]
	rep-type hashcode[]
variable return.optional
	var-kind field optional
	enclosing-var return
	dec-type int
	rep-type int


ppt /api/v1/holidays/{holidayId}:::CLASS
ppt-type class

ppt /api/v1/holidays/{holidayId}&Holiday&200():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type Holiday&Input
	rep-type hashcode
variable input.holidayId
	var-kind field holidayId
	enclosing-var input
	dec-type int
	rep-type int
variable input.year
	var-kind field year
	enclosing-var input
	dec-type int
	rep-type int
variable input.optional
	var-kind field optional
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /api/v1/holidays/{holidayId}&Holiday&200&holiday&provinces&holidays():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type Holiday&Input
	rep-type hashcode
variable input.holidayId
	var-kind field holidayId
	enclosing-var input
	dec-type int
	rep-type int
variable input.year
	var-kind field year
	enclosing-var input
	dec-type int
	rep-type int
variable input.optional
	var-kind field optional
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /api/v1/holidays/{holidayId}&Holiday&200&holiday&provinces():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type Holiday&Input
	rep-type hashcode
variable input.holidayId
	var-kind field holidayId
	enclosing-var input
	dec-type int
	rep-type int
variable input.year
	var-kind field year
	enclosing-var input
	dec-type int
	rep-type int
variable input.optional
	var-kind field optional
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /api/v1/holidays/{holidayId}&Holiday&200():::EXIT10
ppt-type subexit
variable input
	var-kind variable
	dec-type Holiday&Input
	rep-type hashcode
variable input.holidayId
	var-kind field holidayId
	enclosing-var input
	dec-type int
	rep-type int
variable input.year
	var-kind field year
	enclosing-var input
	dec-type int
	rep-type int
variable input.optional
	var-kind field optional
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type Holiday&Output&200
	rep-type hashcode
variable return.holiday
	var-kind field holiday
	enclosing-var return
	dec-type Holiday&Output&200&holiday
	rep-type hashcode
variable return.holiday.id
	var-kind field id
	enclosing-var return.holiday
	dec-type int
	rep-type int
variable return.holiday.date
	var-kind field date
	enclosing-var return.holiday
	dec-type java.lang.String
	rep-type java.lang.String
variable return.holiday.nameEn
	var-kind field nameEn
	enclosing-var return.holiday
	dec-type java.lang.String
	rep-type java.lang.String
variable return.holiday.nameFr
	var-kind field nameFr
	enclosing-var return.holiday
	dec-type java.lang.String
	rep-type java.lang.String
variable return.holiday.federal
	var-kind field federal
	enclosing-var return.holiday
	dec-type int
	rep-type int
variable return.holiday.observedDate
	var-kind field observedDate
	enclosing-var return.holiday
	dec-type java.lang.String
	rep-type java.lang.String
variable return.holiday.provinces
	var-kind field provinces
	enclosing-var return.holiday
	dec-type provinces[]
	rep-type hashcode
variable return.holiday.provinces[..]
	var-kind array
	enclosing-var return.holiday.provinces
	array 1
	dec-type provinces[]
	rep-type hashcode[]
variable return.holiday.optional
	var-kind field optional
	enclosing-var return.holiday
	dec-type int
	rep-type int

ppt /api/v1/holidays/{holidayId}&Holiday&200&holiday&provinces&holidays():::EXIT11
ppt-type subexit
variable input
	var-kind variable
	dec-type Holiday&Input
	rep-type hashcode
variable input.holidayId
	var-kind field holidayId
	enclosing-var input
	dec-type int
	rep-type int
variable input.year
	var-kind field year
	enclosing-var input
	dec-type int
	rep-type int
variable input.optional
	var-kind field optional
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type Holiday&Output&200&holiday&provinces&holidays
	rep-type hashcode
variable return.id
	var-kind field id
	enclosing-var return
	dec-type int
	rep-type int
variable return.date
	var-kind field date
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.nameEn
	var-kind field nameEn
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.nameFr
	var-kind field nameFr
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.federal
	var-kind field federal
	enclosing-var return
	dec-type int
	rep-type int
variable return.observedDate
	var-kind field observedDate
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.provinces
	var-kind field provinces
	enclosing-var return
	dec-type provinces[]
	rep-type hashcode
variable return.provinces[..]
	var-kind array
	enclosing-var return.provinces
	array 1
	dec-type provinces[]
	rep-type hashcode[]
variable return.optional
	var-kind field optional
	enclosing-var return
	dec-type int
	rep-type int

ppt /api/v1/holidays/{holidayId}&Holiday&200&holiday&provinces():::EXIT12
ppt-type subexit
variable input
	var-kind variable
	dec-type Holiday&Input
	rep-type hashcode
variable input.holidayId
	var-kind field holidayId
	enclosing-var input
	dec-type int
	rep-type int
variable input.year
	var-kind field year
	enclosing-var input
	dec-type int
	rep-type int
variable input.optional
	var-kind field optional
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type Holiday&Output&200&holiday&provinces
	rep-type hashcode
variable return.id
	var-kind field id
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.nextHoliday
	var-kind field nextHoliday
	enclosing-var return
	dec-type Holiday&Output&200&holiday&provinces&nextHoliday
	rep-type hashcode
variable return.holidays
	var-kind field holidays
	enclosing-var return
	dec-type holidays[]
	rep-type hashcode
variable return.holidays[..]
	var-kind array
	enclosing-var return.holidays
	array 1
	dec-type holidays[]
	rep-type hashcode[]
variable return.nameFr
	var-kind field nameFr
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.nameEn
	var-kind field nameEn
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.sourceLink
	var-kind field sourceLink
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.sourceEn
	var-kind field sourceEn
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.optional
	var-kind field optional
	enclosing-var return
	dec-type int
	rep-type int


ppt /api/v1/spec:::CLASS
ppt-type class

