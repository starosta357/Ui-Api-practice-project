# Explanation for this project

### How to run:

- use [maven command](https://www.jetbrains.com/help/idea/work-with-maven-goals.html#run_maven_goal_run_config) to execute tests that you need:
1) to run all api tests use: -Dsurefire.suiteXmlFiles=src\test\resources\testng-api.xml -Denvironment=prod clean test
2) to run all ui tests use: -Dbrowser=chrome -Dsurefire.suiteXmlFiles=src\test\resources\testng-ui.xml -Denvironment=prod clean test
3) to run all tests use: -Dbrowser=chrome -Dsurefire.suiteXmlFiles=src\test\resources\testng-all.xml -Denvironment=prod clean test

- It is easy to change browser, just instead chrome use ie, or firefox, or edge.
- Also if you would like to change environment you need to add your property and change in command environment to your property.
- And if you need to run same particular test, you are able to create your own .xml file, as an example use one of the existing one(testng-all, testng-api, testng-ui)

### How to see the results:

1) U can use log... Just kidding :)
2) After test run you will be able to see new folder target in scope of your project. This is simple TestNG report, and to open it you need to open target/surefire-reports/index.html in your browser.
3) I also implement allure reporting but first of all you need to [install](https://docs.qameta.io/allure/#_windows) allure on your machine. And after test run you need to run next command in the terminal: allure serve allure-results. This command will generate allure report, witch, from my point of view, more relevant and better to use in a future with CI/CD tools like Jenkins or TeamCity.

### Tools and approach description:

In scope of implementation I more thinking about the building framework that can be easier reuse and improving in the future. Thus, from your vision some code will be redundant, and we can discuss it, but in many case I think about future and how other teammates will add new functionality.

1) Selenium - as a simple way to automate ui tests.
2) WebDriverManager - convenient way to fix support problem with different webDrivers.
3) TestNG - definitely better then JUnit framework because has features like @DataProvider, that can be useful in the future.
4) Hamcrest - declarative way to create good-descriptive matches.
5) org.apache.logging.log4j - library for logging, simple but better to have in your project.
6) io.rest-assured - simple way to build on this base your own framework for api testing. 