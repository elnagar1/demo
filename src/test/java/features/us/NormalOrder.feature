Feature: Automated End2End Normal Order
  Description: The purpose of this feature is to test End 2 End integration.

  @stop
  Scenario Outline: Login Cycle
    Given user is on Login Page
    When  insert "<Email>" and "<Password>" and click sign in
    And   click side menu and click order and then click order list
    And   click in advanced search and then insert order number and click search
    Then  you can view you order


    Examples:
      | Email                       | Password |
      | mohamed.abdelhy@shgardi.app | 123456   |


  Scenario Outline : Normal Order Cycle Login
    Given user is on Login screen
    When  Click skip button
    And Change country and choose egypt
    And    insert "<phone>"  click continue and insert "<Password>" and click sign in
    Then  you can view  Home


    Examples:
      | phone       | Password |
      | 01150300594 | 123456   |


  Scenario Outline: Normal Order Cycle
    Given user is on Home screen
    When  Click search button
    And Click menu button and choose anything then click done
    And    click search button and insert "<address>"
    And choose one result and click next button
    And enter your products Click Checkout
    And Choose Order price and click submit
    And Choose payment type cash and then click place order
    Then  assert


    Examples:
      | address     |
      | 01150300594 |


