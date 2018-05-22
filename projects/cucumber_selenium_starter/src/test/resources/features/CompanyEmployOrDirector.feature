Feature: Users that are a company that employs social care workers

  As a user that is a company that employs social care workers I wish to provide the companys information to register them for the scheme

  Scenario: User with a UK address can register for the scheme

    Given I am on the social care compliance homepage
    And I enter my full name as "name" and submit
    Then I enter the name of the company as "name" and submit