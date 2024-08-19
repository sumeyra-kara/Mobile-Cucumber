Feature: getir e2e Test

  @getir
  Scenario: e2e Test for getir app
    Given user opens getir and enters username "hello@getir.com" and password "hello"
    Then verify that user logins successfully