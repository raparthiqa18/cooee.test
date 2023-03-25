Feature:
  Verify Hong Kong Observatory API returns 9-Day forecast feature

#  @Test
  Scenario Outline: Verify 9-Day ForeCase API returns next day's Relative Humidity
    When User performs GET operation for "/weatherAPI/opendata/weather.php" and queryparams as "<dataType>" "<lang>"
    Then Response should be successfully returned
    And Response should contain Relative Humidity for Day after tomorrow
    Then Response should be successfully returned
    And Response should contain Relative Humidity for Day after tomorrow
    Then Response should be successfully returned
    And Response should contain Relative Humidity for Day after tomorrow

    Examples:
      | dataType | lang |Status|
      | fnd      | en   |Succes|
      | fnd      | en   |Fail|

