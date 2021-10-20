Feature: Login to an e-commerce website

  Scenario Outline: Verify users can login to portal with valid credentials
    Given User visits e-commerce website
    When User enters valid username "<username>" and valid password "<password>"
    Then User can logged in successfully

    Examples:
    | username | password |
    | testuser412@grr.la | 2t8zmqzL |
#    | testuser4554@test.com | P@ssword123 |

  Scenario Outline: Verify users cannot login to portal with invalid credentials
    Given User visits e-commerce website
    When User enters valid username "<username>" and invalid password "<password>"
    Then User cannot log in

    Examples:
      | username | password |
      | testuser412@grr.la | 2t8zmqL |

  Scenario Outline: Verify users cannot login to portal with invalid credentials
    Given User visits e-commerce website
    When User enters invalid username "<username>" and valid password "<password>"
    Then User cannot log in

    Examples:
      | username | password |
      | testuser42@grr.la | 2t8zmqzL |