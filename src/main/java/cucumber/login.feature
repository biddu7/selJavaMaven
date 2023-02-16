@tag
Feature: Login to Web Application
  I want to use this template for my feature file

 Background: 
 Given Browser is launched and website URL is entered

  @tag2
  Scenario Outline: Login credential test
    Given I am on target website login page
    
    When I enter <username> 
    And I enter <password> 
    And I clicked on "Sign In" button
    
    Then I am able to see landing page

    Examples: 
      | username      | password 					|
      | Joydeep Basu  | sad								|
      | Nibedita Basu | rahulshettyacademy|
