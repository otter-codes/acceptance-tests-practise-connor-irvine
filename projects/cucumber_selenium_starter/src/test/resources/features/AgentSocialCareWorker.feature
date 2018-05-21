Feature: Users that are agent or representative of a company that employs social care workers

  As a user that is an agent or representative of a company that employs social care workers I wish to provide the companys information to register them for the scheme

  Scenario: User with a UK address can register for the scheme

    Given I am on the social care compliance homepage
    When I click on the 'An agent or representative of a company that employs social care workers' radio button
    Then I enter the name of the company as "name" and submit
    And I click on the 'Yes' radio button and submit
    Then I enter the company address and submit
      | Field           | Value           |
      | addressLine1    | 123 Fake Street |
      | addressLine2    | Fake Street     |
      | postcode        | NE98 1ZZ        |
    And  I select 'No' I do not have a UTR and submit
    And I select 'No' I do not have a PAYE ref and submit
    Then I enter my full name as "name" and submit
    And I select 'Yes' I do have a UK address and submit
    Then I enter my address and submit
      | Field           | Value           |
      | addressLine1    | 123 Fake Street |
      | addressLine2    | Fake Street     |
      | postcode        | NE98 1ZZ        |
    Then I enter my telephone number as "07700000000" and submit
    And I select 'No' I do not have an email address and submit
    Then I will be shown my answers and confirm they are correct
