$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Include/features/HerokuAppFeature/HomePage/Regression/P1Regression.feature");
formatter.feature({
  "name": "Regression test cases",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Regression"
    }
  ]
});
formatter.scenario({
  "name": "C00003-Navigate to basic auth link",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Regression"
    },
    {
      "name": "@TC\u003dC00003"
    }
  ]
});
formatter.step({
  "name": "User launched URL",
  "keyword": "When "
});
formatter.match({
  "location": "LoginStepDefination.verify_user_able_to_launch_url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "get the all link",
  "keyword": "And "
});
formatter.match({
  "location": "HomePageModuleStepDefination.get_the_all_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Navigate to basic auth link",
  "keyword": "And "
});
formatter.match({
  "location": "HomePageModuleStepDefination.navigate_to_basic_auth_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify the element on auth link",
  "keyword": "And "
});
formatter.match({
  "location": "HomePageModuleStepDefination.verify_element_on_auth_link()"
});
formatter.result({
  "status": "passed"
});
});