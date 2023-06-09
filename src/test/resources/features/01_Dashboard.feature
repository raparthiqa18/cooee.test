Feature: Verify user dashboard

  @Test
  Scenario Outline: To verify user can view the dashboard
    Given I have open the admin portal
    When login to the admin portal
    Then Capture the "<email>" user's number of subscriptions
    When I login to the application "/cooee/user/login" using "<email>" and "<password>"
    Then I should be able to see the  history of plans subscribed
    When User login to the mobile app using the "<email>" and "<password>"
    And Plans should match as displayed in admin portal

    Examples:
      | email                        | password |
      | ayush.bhatnagar@advantal.net | Test@123 |
#      | surbhi.joshi@advantal.net    | Test@123 |

