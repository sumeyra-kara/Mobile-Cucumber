Feature: getir e2e Test

  @getir
  Scenario: e2e Test for getir app
    Given user opens getir and enters username "hello@getir.com" and password "hello"
    Then verify that user logins successfully
    When user clicks on the basket button
    Then verify that basket is empty and text is "There is no result"
    When user navigates back main page
    Then verify that menu list size is 10
    When user clicks on the menu "Fit & Form"
    And user makes scroll and adds two item
      | Ürün 46 |
      | Ürün 47 |
    And user clicks on the basket button
    Then verify that amount text is "Total Amount : 605 ₺"