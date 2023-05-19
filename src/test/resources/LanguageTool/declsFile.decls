decl-version 2.0
var-comparability implicit

ppt main.check_Input:::CLASS
ppt-type class

ppt main.check_Input:::OBJECT
ppt-type object
variable this
	var-kind variable
	dec-type main.check_Input
	rep-type java.lang.String
variable this.text
	var-kind field text
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.data
	var-kind field data
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.language
	var-kind field language
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.altLanguages
	var-kind field altLanguages
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.username
	var-kind field username
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.apiKey
	var-kind field apiKey
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.dicts
	var-kind field dicts
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.motherTongue
	var-kind field motherTongue
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.preferredVariants
	var-kind field preferredVariants
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.enabledRules
	var-kind field enabledRules
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.disabledRules
	var-kind field disabledRules
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.enabledCategories
	var-kind field enabledCategories
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.disabledCategories
	var-kind field disabledCategories
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.enabledOnly
	var-kind field enabledOnly
	enclosing-var this
	dec-type boolean
	rep-type boolean
variable this.level
	var-kind field level
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String


ppt main.check_Output_200:::CLASS
ppt-type class

ppt main.check_Output_200:::OBJECT
ppt-type object
variable this
	var-kind variable
	dec-type main.check_Output_200
	rep-type java.lang.String
variable this.software
	var-kind variable
	enclosing-var this
	dec-type main.check_Output_200_software
	rep-type java.lang.String
variable this.software.name
	var-kind field name
	enclosing-var this.software
	dec-type java.lang.String
	rep-type java.lang.String
variable this.software.version
	var-kind field version
	enclosing-var this.software
	dec-type java.lang.String
	rep-type java.lang.String
variable this.software.buildDate
	var-kind field buildDate
	enclosing-var this.software
	dec-type java.lang.String
	rep-type java.lang.String
variable this.software.apiVersion
	var-kind field apiVersion
	enclosing-var this.software
	dec-type int
	rep-type int
variable this.software.status
	var-kind field status
	enclosing-var this.software
	dec-type java.lang.String
	rep-type java.lang.String
variable this.software.premium
	var-kind field premium
	enclosing-var this.software
	dec-type boolean
	rep-type boolean
variable this.language
	var-kind variable
	enclosing-var this
	dec-type main.check_Output_200_language
	rep-type java.lang.String
variable this.language.name
	var-kind field name
	enclosing-var this.language
	dec-type java.lang.String
	rep-type java.lang.String
variable this.language.code
	var-kind field code
	enclosing-var this.language
	dec-type java.lang.String
	rep-type java.lang.String
variable this.language.detectedLanguage
	var-kind variable
	enclosing-var this.language
	dec-type main.check_Output_200_detectedLanguage
	rep-type java.lang.String
variable this.language.detectedLanguage.name
	var-kind field name
	enclosing-var this.language.detectedLanguage
	dec-type java.lang.String
	rep-type java.lang.String
variable this.language.detectedLanguage.code
	var-kind field code
	enclosing-var this.language.detectedLanguage
	dec-type java.lang.String
	rep-type java.lang.String
variable this.matches
	var-kind field matches
	enclosing-var this
	dec-type main.matches[]
	rep-type java.lang.String
variable this.matches[..]
	var-kind array
	enclosing-var this.matches
	array 1
	dec-type main.matches[]
	rep-type java.lang.String[]

ppt main.check_Output_200_matches_rule_urls:::OBJECT
ppt-type object
variable this
	var-kind variable
	dec-type main.check_Output_200_matches_rule_urls
	rep-type java.lang.String
variable this.value
	var-kind field value
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String

ppt main.check_Output_200_matches_replacements:::OBJECT
ppt-type object
variable this
	var-kind variable
	dec-type main.check_Output_200_matches_replacements
	rep-type java.lang.String
variable this.value
	var-kind field value
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String

ppt main.check_Output_200_matches:::OBJECT
ppt-type object
variable this
	var-kind variable
	dec-type main.check_Output_200_matches
	rep-type java.lang.String
variable this.message
	var-kind field message
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.shortMessage
	var-kind field shortMessage
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.offset
	var-kind field offset
	enclosing-var this
	dec-type int
	rep-type int
variable this.length
	var-kind field length
	enclosing-var this
	dec-type int
	rep-type int
variable this.replacements
	var-kind field replacements
	enclosing-var this
	dec-type main.replacements[]
	rep-type java.lang.String
variable this.replacements[..]
	var-kind array
	enclosing-var this.replacements
	array 1
	dec-type main.replacements[]
	rep-type java.lang.String[]
variable this.context
	var-kind variable
	enclosing-var this
	dec-type main.check_Output_200_matches_context
	rep-type java.lang.String
variable this.context.text
	var-kind field text
	enclosing-var this.context
	dec-type java.lang.String
	rep-type java.lang.String
variable this.context.offset
	var-kind field offset
	enclosing-var this.context
	dec-type int
	rep-type int
variable this.context.length
	var-kind field length
	enclosing-var this.context
	dec-type int
	rep-type int
variable this.sentence
	var-kind field sentence
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.rule
	var-kind variable
	enclosing-var this
	dec-type main.check_Output_200_matches_rule
	rep-type java.lang.String
variable this.rule.id
	var-kind field id
	enclosing-var this.rule
	dec-type java.lang.String
	rep-type java.lang.String
variable this.rule.subId
	var-kind field subId
	enclosing-var this.rule
	dec-type java.lang.String
	rep-type java.lang.String
variable this.rule.description
	var-kind field description
	enclosing-var this.rule
	dec-type java.lang.String
	rep-type java.lang.String
variable this.rule.urls
	var-kind field urls
	enclosing-var this.rule
	dec-type main.urls[]
	rep-type java.lang.String
variable this.rule.urls[..]
	var-kind array
	enclosing-var this.rule.urls
	array 1
	dec-type main.urls[]
	rep-type java.lang.String[]
variable this.rule.issueType
	var-kind field issueType
	enclosing-var this.rule
	dec-type java.lang.String
	rep-type java.lang.String
variable this.rule.category
	var-kind variable
	enclosing-var this.rule
	dec-type main.check_Output_200_matches_category
	rep-type java.lang.String
variable this.rule.category.id
	var-kind field id
	enclosing-var this.rule.category
	dec-type java.lang.String
	rep-type java.lang.String
variable this.rule.category.name
	var-kind field name
	enclosing-var this.rule.category
	dec-type java.lang.String
	rep-type java.lang.String


ppt main.check:::CLASS
ppt-type class

ppt main.check.check_200(main.check_Input):::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type main.check_Input
	rep-type java.lang.String
variable input.text
	var-kind field text
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.data
	var-kind field data
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.language
	var-kind field language
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.altLanguages
	var-kind field altLanguages
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.username
	var-kind field username
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.apiKey
	var-kind field apiKey
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.dicts
	var-kind field dicts
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.motherTongue
	var-kind field motherTongue
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.preferredVariants
	var-kind field preferredVariants
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.enabledRules
	var-kind field enabledRules
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.disabledRules
	var-kind field disabledRules
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.enabledCategories
	var-kind field enabledCategories
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.disabledCategories
	var-kind field disabledCategories
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.enabledOnly
	var-kind field enabledOnly
	enclosing-var input
	dec-type boolean
	rep-type boolean
variable input.level
	var-kind field level
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt main.check.check_200_matches_rule_urls(main.check_Input):::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type main.check_Input
	rep-type java.lang.String
variable input.text
	var-kind field text
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.data
	var-kind field data
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.language
	var-kind field language
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.altLanguages
	var-kind field altLanguages
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.username
	var-kind field username
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.apiKey
	var-kind field apiKey
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.dicts
	var-kind field dicts
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.motherTongue
	var-kind field motherTongue
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.preferredVariants
	var-kind field preferredVariants
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.enabledRules
	var-kind field enabledRules
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.disabledRules
	var-kind field disabledRules
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.enabledCategories
	var-kind field enabledCategories
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.disabledCategories
	var-kind field disabledCategories
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.enabledOnly
	var-kind field enabledOnly
	enclosing-var input
	dec-type boolean
	rep-type boolean
variable input.level
	var-kind field level
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt main.check.check_200_matches_replacements(main.check_Input):::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type main.check_Input
	rep-type java.lang.String
variable input.text
	var-kind field text
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.data
	var-kind field data
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.language
	var-kind field language
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.altLanguages
	var-kind field altLanguages
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.username
	var-kind field username
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.apiKey
	var-kind field apiKey
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.dicts
	var-kind field dicts
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.motherTongue
	var-kind field motherTongue
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.preferredVariants
	var-kind field preferredVariants
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.enabledRules
	var-kind field enabledRules
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.disabledRules
	var-kind field disabledRules
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.enabledCategories
	var-kind field enabledCategories
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.disabledCategories
	var-kind field disabledCategories
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.enabledOnly
	var-kind field enabledOnly
	enclosing-var input
	dec-type boolean
	rep-type boolean
variable input.level
	var-kind field level
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt main.check.check_200_matches(main.check_Input):::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type main.check_Input
	rep-type java.lang.String
variable input.text
	var-kind field text
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.data
	var-kind field data
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.language
	var-kind field language
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.altLanguages
	var-kind field altLanguages
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.username
	var-kind field username
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.apiKey
	var-kind field apiKey
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.dicts
	var-kind field dicts
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.motherTongue
	var-kind field motherTongue
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.preferredVariants
	var-kind field preferredVariants
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.enabledRules
	var-kind field enabledRules
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.disabledRules
	var-kind field disabledRules
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.enabledCategories
	var-kind field enabledCategories
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.disabledCategories
	var-kind field disabledCategories
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.enabledOnly
	var-kind field enabledOnly
	enclosing-var input
	dec-type boolean
	rep-type boolean
variable input.level
	var-kind field level
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt main.check.check_200(main.check_Input):::EXIT1
ppt-type subexit
variable input
	var-kind variable
	dec-type main.check_Input
	rep-type java.lang.String
variable input.text
	var-kind field text
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.data
	var-kind field data
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.language
	var-kind field language
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.altLanguages
	var-kind field altLanguages
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.username
	var-kind field username
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.apiKey
	var-kind field apiKey
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.dicts
	var-kind field dicts
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.motherTongue
	var-kind field motherTongue
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.preferredVariants
	var-kind field preferredVariants
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.enabledRules
	var-kind field enabledRules
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.disabledRules
	var-kind field disabledRules
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.enabledCategories
	var-kind field enabledCategories
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.disabledCategories
	var-kind field disabledCategories
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.enabledOnly
	var-kind field enabledOnly
	enclosing-var input
	dec-type boolean
	rep-type boolean
variable input.level
	var-kind field level
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type main.check_Output_200
	rep-type java.lang.String
variable return.software
	var-kind return
	enclosing-var return
	dec-type main.check_Output_200_software
	rep-type java.lang.String
variable return.software.name
	var-kind field name
	enclosing-var return.software
	dec-type java.lang.String
	rep-type java.lang.String
variable return.software.version
	var-kind field version
	enclosing-var return.software
	dec-type java.lang.String
	rep-type java.lang.String
variable return.software.buildDate
	var-kind field buildDate
	enclosing-var return.software
	dec-type java.lang.String
	rep-type java.lang.String
variable return.software.apiVersion
	var-kind field apiVersion
	enclosing-var return.software
	dec-type int
	rep-type int
variable return.software.status
	var-kind field status
	enclosing-var return.software
	dec-type java.lang.String
	rep-type java.lang.String
variable return.software.premium
	var-kind field premium
	enclosing-var return.software
	dec-type boolean
	rep-type boolean
variable return.language
	var-kind return
	enclosing-var return
	dec-type main.check_Output_200_language
	rep-type java.lang.String
variable return.language.name
	var-kind field name
	enclosing-var return.language
	dec-type java.lang.String
	rep-type java.lang.String
variable return.language.code
	var-kind field code
	enclosing-var return.language
	dec-type java.lang.String
	rep-type java.lang.String
variable return.language.detectedLanguage
	var-kind return
	enclosing-var return.language
	dec-type main.check_Output_200_detectedLanguage
	rep-type java.lang.String
variable return.language.detectedLanguage.name
	var-kind field name
	enclosing-var return.language.detectedLanguage
	dec-type java.lang.String
	rep-type java.lang.String
variable return.language.detectedLanguage.code
	var-kind field code
	enclosing-var return.language.detectedLanguage
	dec-type java.lang.String
	rep-type java.lang.String
variable return.matches
	var-kind field matches
	enclosing-var return
	dec-type main.matches[]
	rep-type java.lang.String
variable return.matches[..]
	var-kind array
	enclosing-var return.matches
	array 1
	dec-type main.matches[]
	rep-type java.lang.String[]

ppt main.check.check_200_matches_rule_urls(main.check_Input):::EXIT2
ppt-type subexit
variable input
	var-kind variable
	dec-type main.check_Input
	rep-type java.lang.String
variable input.text
	var-kind field text
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.data
	var-kind field data
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.language
	var-kind field language
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.altLanguages
	var-kind field altLanguages
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.username
	var-kind field username
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.apiKey
	var-kind field apiKey
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.dicts
	var-kind field dicts
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.motherTongue
	var-kind field motherTongue
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.preferredVariants
	var-kind field preferredVariants
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.enabledRules
	var-kind field enabledRules
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.disabledRules
	var-kind field disabledRules
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.enabledCategories
	var-kind field enabledCategories
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.disabledCategories
	var-kind field disabledCategories
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.enabledOnly
	var-kind field enabledOnly
	enclosing-var input
	dec-type boolean
	rep-type boolean
variable input.level
	var-kind field level
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type main.check_Output_200_matches_rule_urls
	rep-type java.lang.String
variable return.value
	var-kind field value
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

ppt main.check.check_200_matches_replacements(main.check_Input):::EXIT3
ppt-type subexit
variable input
	var-kind variable
	dec-type main.check_Input
	rep-type java.lang.String
variable input.text
	var-kind field text
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.data
	var-kind field data
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.language
	var-kind field language
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.altLanguages
	var-kind field altLanguages
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.username
	var-kind field username
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.apiKey
	var-kind field apiKey
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.dicts
	var-kind field dicts
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.motherTongue
	var-kind field motherTongue
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.preferredVariants
	var-kind field preferredVariants
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.enabledRules
	var-kind field enabledRules
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.disabledRules
	var-kind field disabledRules
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.enabledCategories
	var-kind field enabledCategories
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.disabledCategories
	var-kind field disabledCategories
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.enabledOnly
	var-kind field enabledOnly
	enclosing-var input
	dec-type boolean
	rep-type boolean
variable input.level
	var-kind field level
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type main.check_Output_200_matches_replacements
	rep-type java.lang.String
variable return.value
	var-kind field value
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

ppt main.check.check_200_matches(main.check_Input):::EXIT4
ppt-type subexit
variable input
	var-kind variable
	dec-type main.check_Input
	rep-type java.lang.String
variable input.text
	var-kind field text
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.data
	var-kind field data
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.language
	var-kind field language
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.altLanguages
	var-kind field altLanguages
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.username
	var-kind field username
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.apiKey
	var-kind field apiKey
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.dicts
	var-kind field dicts
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.motherTongue
	var-kind field motherTongue
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.preferredVariants
	var-kind field preferredVariants
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.enabledRules
	var-kind field enabledRules
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.disabledRules
	var-kind field disabledRules
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.enabledCategories
	var-kind field enabledCategories
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.disabledCategories
	var-kind field disabledCategories
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.enabledOnly
	var-kind field enabledOnly
	enclosing-var input
	dec-type boolean
	rep-type boolean
variable input.level
	var-kind field level
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type main.check_Output_200_matches
	rep-type java.lang.String
variable return.message
	var-kind field message
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.shortMessage
	var-kind field shortMessage
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.offset
	var-kind field offset
	enclosing-var return
	dec-type int
	rep-type int
variable return.length
	var-kind field length
	enclosing-var return
	dec-type int
	rep-type int
variable return.replacements
	var-kind field replacements
	enclosing-var return
	dec-type main.replacements[]
	rep-type java.lang.String
variable return.replacements[..]
	var-kind array
	enclosing-var return.replacements
	array 1
	dec-type main.replacements[]
	rep-type java.lang.String[]
variable return.context
	var-kind return
	enclosing-var return
	dec-type main.check_Output_200_matches_context
	rep-type java.lang.String
variable return.context.text
	var-kind field text
	enclosing-var return.context
	dec-type java.lang.String
	rep-type java.lang.String
variable return.context.offset
	var-kind field offset
	enclosing-var return.context
	dec-type int
	rep-type int
variable return.context.length
	var-kind field length
	enclosing-var return.context
	dec-type int
	rep-type int
variable return.sentence
	var-kind field sentence
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.rule
	var-kind return
	enclosing-var return
	dec-type main.check_Output_200_matches_rule
	rep-type java.lang.String
variable return.rule.id
	var-kind field id
	enclosing-var return.rule
	dec-type java.lang.String
	rep-type java.lang.String
variable return.rule.subId
	var-kind field subId
	enclosing-var return.rule
	dec-type java.lang.String
	rep-type java.lang.String
variable return.rule.description
	var-kind field description
	enclosing-var return.rule
	dec-type java.lang.String
	rep-type java.lang.String
variable return.rule.urls
	var-kind field urls
	enclosing-var return.rule
	dec-type main.urls[]
	rep-type java.lang.String
variable return.rule.urls[..]
	var-kind array
	enclosing-var return.rule.urls
	array 1
	dec-type main.urls[]
	rep-type java.lang.String[]
variable return.rule.issueType
	var-kind field issueType
	enclosing-var return.rule
	dec-type java.lang.String
	rep-type java.lang.String
variable return.rule.category
	var-kind return
	enclosing-var return.rule
	dec-type main.check_Output_200_matches_category
	rep-type java.lang.String
variable return.rule.category.id
	var-kind field id
	enclosing-var return.rule.category
	dec-type java.lang.String
	rep-type java.lang.String
variable return.rule.category.name
	var-kind field name
	enclosing-var return.rule.category
	dec-type java.lang.String
	rep-type java.lang.String

