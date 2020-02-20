Feature: Login feature
  As user, I want to be able to log in with etsy account, as wll as with google and facebook accounts.

  Scenario: Login with etsy credentials(positive)
    Given use clicks on etsy get started
    When user logs in with etsy credentials
    Then user verifies that etsy logo is displayed