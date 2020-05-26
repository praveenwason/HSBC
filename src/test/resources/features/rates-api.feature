Feature: Foreign exchange rate api

  Scenario: get latest rates
    Given api is available
    When there is a GET request
    Then status code is 200
    And currency "rates.CAD" rate is 1.5261

  Scenario: verify response for incomplete url
    Given api is available
    When there is a GET request for incomplete url
    Then status code is 400

  Scenario: get foreign exchange rates
    Given api is available
    When there is a GET request for exchange rates on "2020-04-21"
    Then status code is 200
    And currency "rates.USD" rate is 1.0837
    And date is "2020-04-21"

  Scenario: get foreign exchange rates on future date
    Given api is available
    When there is a GET request for exchange rates on "2021-05-26"
    Then currency "rates.BRL" rate is 6.0243
    And date is "2020-05-25"


