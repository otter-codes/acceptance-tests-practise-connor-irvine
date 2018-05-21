Feature: Users that are social care workers

  As a user is a social care worker I want to be able to provide my details and let HMRC know that I believe that I have been underpaid.

  Scenario: Social Care Workers cannot register for so Social Care Compliance Scheme so are provided to a link advising on National Living Wage

    Given I am on the social care compliance homepage
    When I click on the 'Social Care Worker' radio button
    Then I should be on the "Social Care Worker" page with a link to advice on the National Living Wage
