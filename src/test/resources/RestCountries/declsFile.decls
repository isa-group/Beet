decl-version 2.0
var-comparability implicit

ppt main.v1Name_Input:::CLASS
ppt-type class

ppt main.v1Name_Input:::OBJECT
ppt-type object
variable this
	var-kind variable
	dec-type main.v1Name_Input
	rep-type java.lang.String
variable this.name
	var-kind field name
	enclosing-var this
	dec-type java.lang.String
	rep-type java.lang.String
variable this.fullText
	var-kind field fullText
	enclosing-var this
	dec-type boolean
	rep-type boolean


ppt main.v1Name_Output_200:::CLASS
ppt-type class

ppt main.v1Name_Output_200.array:::OBJECT
ppt-type object
variable this
	var-kind variable
	dec-type main.v1Name_Output_200.array
	rep-type java.lang.String
variable this.array
	var-kind field array
	enclosing-var this
	dec-type main.array[]
	rep-type java.lang.String
variable this.array[..]
	var-kind array
	enclosing-var this.array
	array 1
	dec-type main.array[]
	rep-type java.lang.String[]

ppt main.v1Name_Output_200.array.array:::OBJECT
ppt-type object
variable this
	var-kind variable
	dec-type main.v1Name_Output_200.array.array
	rep-type java.lang.String
variable this.array
	var-kind field array
	enclosing-var this
	dec-type main.array[]
	rep-type java.lang.String
variable this.array[..]
	var-kind array
	enclosing-var this.array
	array 1
	dec-type main.array[]
	rep-type java.lang.String[]

ppt main.v1Name_Output_200.array.array.array:::OBJECT
ppt-type object
variable this
	var-kind variable
	dec-type main.v1Name_Output_200.array.array.array
	rep-type java.lang.String
variable this.array
	var-kind field array
	enclosing-var this
	dec-type double[]
	rep-type java.lang.String
variable this.array[..]
	var-kind array
	enclosing-var this.array
	array 1
	dec-type double[]
	rep-type double[]


ppt main.v1name{name}:::CLASS
ppt-type class

ppt main.v1name{name}.v1Name_200.array(main.v1Name_Input):::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type main.v1Name_Input
	rep-type java.lang.String
variable input.name
	var-kind field name
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.fullText
	var-kind field fullText
	enclosing-var input
	dec-type boolean
	rep-type boolean

ppt main.v1name{name}.v1Name_200.array.array(main.v1Name_Input):::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type main.v1Name_Input
	rep-type java.lang.String
variable input.name
	var-kind field name
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.fullText
	var-kind field fullText
	enclosing-var input
	dec-type boolean
	rep-type boolean

ppt main.v1name{name}.v1Name_200.array.array.array(main.v1Name_Input):::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type main.v1Name_Input
	rep-type java.lang.String
variable input.name
	var-kind field name
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.fullText
	var-kind field fullText
	enclosing-var input
	dec-type boolean
	rep-type boolean

ppt main.v1name{name}.v1Name_200.array(main.v1Name_Input):::EXIT1
ppt-type subexit
variable input
	var-kind variable
	dec-type main.v1Name_Input
	rep-type java.lang.String
variable input.name
	var-kind field name
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.fullText
	var-kind field fullText
	enclosing-var input
	dec-type boolean
	rep-type boolean
variable return
	var-kind return
	dec-type main.v1Name_Output_200.array
	rep-type java.lang.String
variable return.array
	var-kind field array
	enclosing-var return
	dec-type main.array[]
	rep-type java.lang.String
variable return.array[..]
	var-kind array
	enclosing-var return.array
	array 1
	dec-type main.array[]
	rep-type java.lang.String[]

ppt main.v1name{name}.v1Name_200.array.array(main.v1Name_Input):::EXIT2
ppt-type subexit
variable input
	var-kind variable
	dec-type main.v1Name_Input
	rep-type java.lang.String
variable input.name
	var-kind field name
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.fullText
	var-kind field fullText
	enclosing-var input
	dec-type boolean
	rep-type boolean
variable return
	var-kind return
	dec-type main.v1Name_Output_200.array.array
	rep-type java.lang.String
variable return.array
	var-kind field array
	enclosing-var return
	dec-type main.array[]
	rep-type java.lang.String
variable return.array[..]
	var-kind array
	enclosing-var return.array
	array 1
	dec-type main.array[]
	rep-type java.lang.String[]

ppt main.v1name{name}.v1Name_200.array.array.array(main.v1Name_Input):::EXIT3
ppt-type subexit
variable input
	var-kind variable
	dec-type main.v1Name_Input
	rep-type java.lang.String
variable input.name
	var-kind field name
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.fullText
	var-kind field fullText
	enclosing-var input
	dec-type boolean
	rep-type boolean
variable return
	var-kind return
	dec-type main.v1Name_Output_200.array.array.array
	rep-type java.lang.String
variable return.array
	var-kind field array
	enclosing-var return
	dec-type double[]
	rep-type java.lang.String
variable return.array[..]
	var-kind array
	enclosing-var return.array
	array 1
	dec-type double[]
	rep-type double[]

