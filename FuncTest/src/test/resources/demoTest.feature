Feature: multiple browser demo
  To test baidu search feature with multiple browser
  TestNG’s @BeforeClass → Cucumber’s @Before → Cucumber Background → Cucumber Scenario → Cucumber’s @After → TestNG’s @AfterClass


    #to test production env
    #Given user is on user baidu webpage https://www.baidu.com
    #Given user open user baidu webpage https://www.baidu.com

  @Smoke
  Scenario Outline: Verify baidu search feature, covering normal searching keywords, javascript, empty
    Given User is on "<Url>" page
    When User enter "<searchKeywords>" in search box "<textboxId>"
    And User clicks on Search button "<buttonId>"
    Then user should see "<searchResultPage>"
    Examples:
      | Url                   | searchKeywords                      | textboxId | buttonId | searchResultPage |
      | https://www.baidu.com | Cucumber Demo                       | kw        | su       | Cucumber Demo    |
      | https://www.baidu.com | <script> alert("testing") </script> | kw        | su       | <script>         |
      | https://www.baidu.com |                                     | kw        | su       | remain           |