Feature: Users that pay for their own care can register

  As a user who pays for their own care I should be able to provide my details and register for the scheme.

  Scenario: User with a UK address can register for the scheme

    Given I am on the social care compliance homepage
    When I click on the 'Someone who pays for care directly' radio button
    And I enter my full name as "name" and submit
    Then I click on the 'Yes' radio button and submit
    And I enter my address and submit
      | Field           | Value           |
      | addressLine1    | 123 Fake Street |
      | addressLine2    | Fake Street     |
      | postcode        | NE98 1ZZ        |
    Then I enter my telephone number as "07700000000" and submit
    And I select 'No' I do not have an email address and submit
    Then  I select 'No' I do not have a UTR and submit
    And I select 'No' I do not have a PAYE ref and submit
    Then  I will be shown my answers and confirm they are correct