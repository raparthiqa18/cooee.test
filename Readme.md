#Crypto Testing Assignment

Implementation of Crypto.com test assignment 

#Architecture

**Task A:** Check tomorrow weather forecast from 9-day forecast screen

1. Cucumber for BDD testing framework
2. Appium for Mobile Automation 
3. Cucumber reporting 

**How it works:**

    a. TestRunner file would execute the scenarios under the features folder, with tag as @Test.
    b. Each step in scenario would have a stepdefinition (src/test/java/Steps)
    c. For readability and reusability POM design strategy is used

**Task B:** Extract the relative humidity for the day after tomorrow

1. Cucumber for BDD testing framework
2. Rest Assured uisng Java language to Automate Rest APIs
3. Cucumber Reporting 

**How it works:**

    a. TestRunner file would execute the scenarios under the features folder, with tag as @Test.
    b. Each step in scenario would have a stepdefinition (src/test/java/Steps)
    c. For readability and reusability RestassuredExtensions class is created that contains the Rest API related methods

*To run the test:*

1. Run "TestRunner" class at location src/test/java/Runners
2. Cucumber Report will be generated in target\cucumber-reports folder as index.html file
