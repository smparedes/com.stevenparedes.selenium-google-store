Feature: Google Store Home page
  Scenario: Verify adding the Game item called Stadia Premiere Edition to the cart on store.google.com
    Given I navigate to the Google store
    And I see Stadia Premiere Edition as the page Title
    When I select the Buy option
    And I click the Buy button
    And I click the Go to cart button
    Then I see the cart subtotal




