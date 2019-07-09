Feature: API

  Scenario Outline: First POST request
    Given user is authorized to make post
    When user creates post with <title> and <content>
    Then user gets 201 status code and verifies it
  Examples:
    |title|content|
    |     |       |
    |     |       |