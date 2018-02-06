Feature: Search item
  As a user
  I want to be able to search for product items
  So that I can find products

  @SmokeTest
  Scenario Outline: Search with correct request
    Given I am on main page
    When I input search request "<request>"
    And I submit search button
    Then I should be on search page
    And Page title should be equal to searched request "<request>"

    Examples:
      | request   |
      | Now Foods |
      | Atkins    |