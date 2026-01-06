

@tag
Feature: purchase the order from Ecomerce Website

Background:
Given I landed on Ecommerce Page

@Tag 
Scenario Outline: Positive Test of Submitting the order
    Given Logged in with username <name> and Password <password>
    When I add product <productName> to Cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is dispplayed on ConfirmationPage
    
    Examples:
	|name				|password     	|productName    |
	|shiv123@gmail.com  |Shiv@123456    |IPHONE 13 PRO  |