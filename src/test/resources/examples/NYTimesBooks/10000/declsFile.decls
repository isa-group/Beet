decl-version 2.0
var-comparability implicit

ppt /lists.json:::CLASS
ppt-type class

ppt /lists.json&GET_lists-format&200():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type GET_lists-format&Input
	rep-type hashcode
variable input.list
	var-kind field list
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.bestsellers-date
	var-kind field bestsellers-date
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.published-date
	var-kind field published-date
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.offset
	var-kind field offset
	enclosing-var input
	dec-type int
	rep-type int

ppt /lists.json&GET_lists-format&200&results&reviews():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type GET_lists-format&Input
	rep-type hashcode
variable input.list
	var-kind field list
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.bestsellers-date
	var-kind field bestsellers-date
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.published-date
	var-kind field published-date
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.offset
	var-kind field offset
	enclosing-var input
	dec-type int
	rep-type int

ppt /lists.json&GET_lists-format&200&results&isbns():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type GET_lists-format&Input
	rep-type hashcode
variable input.list
	var-kind field list
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.bestsellers-date
	var-kind field bestsellers-date
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.published-date
	var-kind field published-date
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.offset
	var-kind field offset
	enclosing-var input
	dec-type int
	rep-type int

ppt /lists.json&GET_lists-format&200&results():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type GET_lists-format&Input
	rep-type hashcode
variable input.list
	var-kind field list
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.bestsellers-date
	var-kind field bestsellers-date
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.published-date
	var-kind field published-date
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.offset
	var-kind field offset
	enclosing-var input
	dec-type int
	rep-type int

ppt /lists.json&GET_lists-format&200&results&book_details():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type GET_lists-format&Input
	rep-type hashcode
variable input.list
	var-kind field list
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.bestsellers-date
	var-kind field bestsellers-date
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.published-date
	var-kind field published-date
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.offset
	var-kind field offset
	enclosing-var input
	dec-type int
	rep-type int

ppt /lists.json&GET_lists-format&200():::EXIT1
ppt-type subexit
variable input
	var-kind variable
	dec-type GET_lists-format&Input
	rep-type hashcode
variable input.list
	var-kind field list
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.bestsellers-date
	var-kind field bestsellers-date
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.published-date
	var-kind field published-date
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.offset
	var-kind field offset
	enclosing-var input
	dec-type int
	rep-type int
variable return
	var-kind return
	dec-type GET_lists-format&Output&200
	rep-type hashcode
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
variable return.num_results
	var-kind field num_results
	enclosing-var return
	dec-type int
	rep-type int
variable return.last_modified
	var-kind field last_modified
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.results
	var-kind field results
	enclosing-var return
	dec-type results[]
	rep-type hashcode
variable return.results[..]
	var-kind array
	enclosing-var return.results
	array 1
	dec-type results[]
	rep-type hashcode[]

ppt /lists.json&GET_lists-format&200&results&reviews():::EXIT2
ppt-type subexit
variable input
	var-kind variable
	dec-type GET_lists-format&Input
	rep-type hashcode
variable input.list
	var-kind field list
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.bestsellers-date
	var-kind field bestsellers-date
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.published-date
	var-kind field published-date
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.offset
	var-kind field offset
	enclosing-var input
	dec-type int
	rep-type int
variable return
	var-kind return
	dec-type GET_lists-format&Output&200&results&reviews
	rep-type hashcode
variable return.book_review_link
	var-kind field book_review_link
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.first_chapter_link
	var-kind field first_chapter_link
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.sunday_review_link
	var-kind field sunday_review_link
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.article_chapter_link
	var-kind field article_chapter_link
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

ppt /lists.json&GET_lists-format&200&results&isbns():::EXIT3
ppt-type subexit
variable input
	var-kind variable
	dec-type GET_lists-format&Input
	rep-type hashcode
variable input.list
	var-kind field list
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.bestsellers-date
	var-kind field bestsellers-date
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.published-date
	var-kind field published-date
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.offset
	var-kind field offset
	enclosing-var input
	dec-type int
	rep-type int
variable return
	var-kind return
	dec-type GET_lists-format&Output&200&results&isbns
	rep-type hashcode
variable return.isbn10
	var-kind field isbn10
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.isbn13
	var-kind field isbn13
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

ppt /lists.json&GET_lists-format&200&results():::EXIT4
ppt-type subexit
variable input
	var-kind variable
	dec-type GET_lists-format&Input
	rep-type hashcode
variable input.list
	var-kind field list
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.bestsellers-date
	var-kind field bestsellers-date
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.published-date
	var-kind field published-date
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.offset
	var-kind field offset
	enclosing-var input
	dec-type int
	rep-type int
variable return
	var-kind return
	dec-type GET_lists-format&Output&200&results
	rep-type hashcode
variable return.list_name
	var-kind field list_name
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.display_name
	var-kind field display_name
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.bestsellers_date
	var-kind field bestsellers_date
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.published_date
	var-kind field published_date
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.rank
	var-kind field rank
	enclosing-var return
	dec-type int
	rep-type int
variable return.rank_last_week
	var-kind field rank_last_week
	enclosing-var return
	dec-type int
	rep-type int
variable return.weeks_on_list
	var-kind field weeks_on_list
	enclosing-var return
	dec-type int
	rep-type int
variable return.asterisk
	var-kind field asterisk
	enclosing-var return
	dec-type int
	rep-type int
variable return.dagger
	var-kind field dagger
	enclosing-var return
	dec-type int
	rep-type int
variable return.amazon_product_url
	var-kind field amazon_product_url
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.isbns
	var-kind field isbns
	enclosing-var return
	dec-type isbns[]
	rep-type hashcode
variable return.isbns[..]
	var-kind array
	enclosing-var return.isbns
	array 1
	dec-type isbns[]
	rep-type hashcode[]
variable return.book_details
	var-kind field book_details
	enclosing-var return
	dec-type book_details[]
	rep-type hashcode
variable return.book_details[..]
	var-kind array
	enclosing-var return.book_details
	array 1
	dec-type book_details[]
	rep-type hashcode[]
variable return.reviews
	var-kind field reviews
	enclosing-var return
	dec-type reviews[]
	rep-type hashcode
variable return.reviews[..]
	var-kind array
	enclosing-var return.reviews
	array 1
	dec-type reviews[]
	rep-type hashcode[]

ppt /lists.json&GET_lists-format&200&results&book_details():::EXIT5
ppt-type subexit
variable input
	var-kind variable
	dec-type GET_lists-format&Input
	rep-type hashcode
variable input.list
	var-kind field list
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.bestsellers-date
	var-kind field bestsellers-date
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.published-date
	var-kind field published-date
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.offset
	var-kind field offset
	enclosing-var input
	dec-type int
	rep-type int
variable return
	var-kind return
	dec-type GET_lists-format&Output&200&results&book_details
	rep-type hashcode
variable return.title
	var-kind field title
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.description
	var-kind field description
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.contributor
	var-kind field contributor
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.author
	var-kind field author
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.contributor_note
	var-kind field contributor_note
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.price
	var-kind field price
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.age_group
	var-kind field age_group
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.publisher
	var-kind field publisher
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.primary_isbn13
	var-kind field primary_isbn13
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.primary_isbn10
	var-kind field primary_isbn10
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

