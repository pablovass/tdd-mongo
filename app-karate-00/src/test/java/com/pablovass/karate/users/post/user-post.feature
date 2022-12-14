Feature: Post user on regres

  Scenario: Post a user
    Given url  'https://reqres.in/api/users'
    And request {"name": "pablo vass", "job":  "developer"}
    When method POST
    Then status 201

  Scenario: Post a user without job
    Given url  "https://reqres.in/" + "/api/users"
    And request {"name": "matias"}
    When method POST
    Then status 201

  Scenario: Post a user with name invalid
    Given url  'https://reqres.in/api/users'
    And request {"name": "##/)(/)", "job":  "developer"}
    When method POST
    Then status 201

  Scenario: Post a user without name
    Given url  'https://reqres.in/api/users'
    And request {"job":  "developer"}
    When method POST
    Then status 201
