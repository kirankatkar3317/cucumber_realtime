Feature: Search functionality

Scenario: user searches for valid product

Given user opens the application
When user enter product "HP" in search box field
And user click on search button
Then user should get valid product in search results

Scenario: user searches for invalid product

Given user opens the application
When user enter product "Honda" in search box field
And user click on search button
Then user should get a messege about product in search results

Scenario: user searches without any product

Given user opens the application
When user dont enter product in search box field
And user click on search button
Then user should get a messege about product in search results