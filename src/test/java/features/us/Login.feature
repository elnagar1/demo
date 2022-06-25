Feature: Automated End2End Tests
  Description: The purpose of this feature is to test End 2 End integration.
@stop
  Scenario Outline: Normal Order Cycle
    Given user is on Login Page
    When  insert "<Email>" and "<Password>" and click sign in
    And   click side menu and click order and then click order list
    And   click in advanced search and then insert order number and click search
    Then  you can view you order


    Examples:
      | Email              |  Password              |
      | mohamed.abdelhy@shgardi.app |123456            |


  Scenario Outline: Normal Order Cycle2
    Given user is on Login Page
    When  insert "<Email>" and "<Password>" and click sign in
    And   click side menu and click order and then click order list
    And   click in advanced search and then insert order number and click search
    Then  you can view you order


    Examples:
      | Email              |  Password              |
      | mohamed.abdelhy@shgardi.app |123456            |
