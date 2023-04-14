Feature: Login functionality

Scenario Outline: Login with valid credentials

Given user navigate to login page
When user has entered valid email address <email>
And user has entered valid password <password>
And user click on login button
Then user should get successfully logged in

Examples:
|email                      |password  |
|kirankatkar10@gmail.com    |Kiran@1010|
|kirankatkar3317@gmail.com  |Kiran@3317|

Scenario: Login with invalid credentials

Given user navigate to login page
When user has entered invalid email address
And user has entered invalid password
And user click on login button
Then user should get a proper warning message about credentials mismatch

Scenario: Login with valid email and invalid password

Given user navigate to login page
When user has entered valid email address "kirankatkar10@gmail.com"
And user has entered invalid password
And user click on login button
Then user should get a proper warning message about credentials mismatch

Scenario: Login with invalid email and valid password

Given user navigate to login page
When user has entered invalid email address
And user has entered valid password "Kiran@1010"
And user click on login button
Then user should get a proper warning message about credentials mismatch

Scenario: Login without any credentials

Given user navigate to login page
When user dont enter any email in email field
And user dont enter any password in password field
And user click on login button
Then user should get a proper warning message about credentials mismatch







