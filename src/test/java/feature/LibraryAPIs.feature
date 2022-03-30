Feature: Validating Library API's 
@AddPlace @Regression
Scenario Outline:: Verify if Book is Added Successfully using AddBook API
	Given Add Book Payload with "<name>""<isbn>" <aisle> "<author>"
	When Calls "addBookAPI" Using "Post" Http Request
	Then The API call got success with status code 200
	And "Msg" in response body is "successfully added"	

Examples:
|	name																|	isbn	|	aisle	|	author		|
|	Learn Selenium Automation with Java	|	asdc	| 1009	|	Aravinth	|

@GetPlace @Regression
Scenario Outline: Verify if Book is Retrived Successfully using GetBook API
	Given Get Book Payload
	When Calls "getBookAPI" Using "Get" Http Request
	Then The API call got success with status code 200
	And "isbn" in response body is "[<isbn>]"
	And "aisle" in response body is "[<aisle>]" 

Examples:
|	name																|	isbn	|	aisle	|	author		|
|	Learn Selenium Automation with Java	|	asdc	| 1009	|	Aravinth	|

@DeletePlace @Regression
Scenario: Verify if Book is Deleted Successfully using DeleteBook API
	Given Delete Book Payload
	When Calls "deleteBookAPI" Using "Post" Http Request
	Then The API call got success with status code 200
	And "msg" in response body is "book is successfully deleted"

	
	