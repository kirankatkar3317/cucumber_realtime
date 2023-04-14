Feature: Registration Functionality

Scenario: User creates an account only with mandatory field

Given user navigate to Register page
When user enters below field
|firstName | kiran |
|lastName | katkar |
|telephone | 8286979108 |
And user select privacy policy
And user clicks on continue button
Then User account get successfully created

Scenario: User creates an account only with all field

Given user navigate to Register page
When user enters below field
|firstName | kiran1 |
|lastName| katkar1 |
|telephone| 8286979104 |
And user select yes for newsletter
And user select privacy policy
And user clicks on continue button
Then User account get successfully created

Scenario: User creates a duplicate account

Given user navigate to Register page
When user enters below duplicate field
|firstName | kiran |
|lastName | katkar |
|email | kirankatkar3317@gmail.com |
|telephone | 8286979103 |
|password | Kiran@3317 |
And user select yes for newsletter
And user select privacy policy
And user clicks on continue button
Then User should get a warning about duplicate email

Scenario: User creates an account without filling any details

Given user navigate to Register page
When user dont enters any field
And user clicks on continue button
Then User should get a warning messsge for every mandatory fields
