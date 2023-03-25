Feature: Verify HK Observatory mobile application returns 9-Day forecast

#  @Test
  Scenario: To verify next day forecast is returned by HK Observatory app
    Given Application is up and running
    When NineDay Forecast option is selected
    Then Validate NineDay Forecast is displayed
    And Validate next day forecast is displayed
