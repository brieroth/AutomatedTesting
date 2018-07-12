Feature: Working with a Stack
  As a person
  I want to add clothes in a cart
  So that I can buy an item.

  Scenario: Push an item into a stack
    Given an empty stack
    When I push an item into the stack
    Then the stack contains one item

  Scenario: Push two items into a stack
    Given an empty stack
    When I push an item into the stack
    And I push another item into the stack
    Then the stack contains two items