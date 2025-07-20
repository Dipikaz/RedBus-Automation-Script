
#RedBus Selenium Automation 🚌 #


#Overview

This project is a Java-based automation script using Selenium WebDriver to automate the bus search functionality on redbus.in. The script simulates a user's journey: searching for buses between two cities, applying filters, handling dynamic content loading (lazy loading), and finally, extracting and displaying the results.
The primary goal is to demonstrate proficiency in web automation, particularly in handling modern web application features like dynamic suggestion boxes, filters, and infinite scrolling.

#Features✨#
1. Launches and navigates to the RedBus website.
2. Automates selection of source ("Mumbai") and destination ("Pune") cities from dynamic search suggestions.
3. Applies multiple filters to the search results: Primo and Evening.
4. Handles lazy loading by programmatically scrolling down the page until all bus results are visible.
5. Extracts the names of all available bus operators after filters are applied.
6. Prints the name of each operator and the total count of buses found.

#Table of Contents#
1. Project Structure
2. Prerequisites
3. Installation
4. Usage
5. Expected Outcome

#Project Structure#
This project follows the standard Maven directory layout, which helps keep source code, test code, and resources organized.

RedBusAutomation/
│
├── pom.xml                  # Maven Project Object Model file for dependencies

│
├── .gitignore               # To exclude files like /target from Git
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── redBus/
│   │   │           └── RedBusAutomation.java   # Your main automation script
│   │   │
│   │   └── resources/
│   │       # (Optional: For non-code files like property configurations)
│   │
│   └── test/
│       ├── java/
│       │   # (Optional: For test scripts using JUnit or TestNG)
│       │
│       └── resources/
│           # (Optional: For resources needed by tests)
│
└── drivers/
    └── chromedriver.exe     # (Recommended: Store browser drivers here)
Explanation
pom.xml: The core of a Maven project. It defines the project's dependencies (like Selenium), plugins, and build settings.
src/main/java: This is where your main application source code resides. Your RedBusAutomation.java file is located here within its package structure (com/redBus).
src/test/java: This directory is for your test scripts. While your current project uses a main method for execution, a more advanced setup would use a testing framework like JUnit or TestNG, and those test files would go here.
drivers/: It's a common practice to create a directory at the project root to hold browser drivers like chromedriver.exe. This makes it easy to manage and reference them in your code.

#Prerequisites#
1. Before you begin, ensure you have the following installed on your system:
2. Java Development Kit (JDK): Version 8 or higher.
3. Selenium WebDriver: The script uses the Selenium library for Java.
4. Chrome Browser: The script is configured to run on Google Chrome.
5. ChromeDriver: The WebDriver executable for Chrome. Ensure it's compatible with your Chrome browser version and its path is configured in your system's PATH environment variable.
6. An IDE like Eclipse or IntelliJ IDEA with Maven or Gradle configured to handle dependencies.



#Installation#
1. Clone the repository:
git clone https://github.com/your-username/your-repository-name.git

2. Navigate to the project directory:
cd your-repository-name

3. Add Dependencies: If you are using a Maven project, add the following dependency to your pom.xml file:
<dependencies>
  <dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.22.0</version> </dependency>
</dependencies>
Then, update your project to download the dependencies.

#Usage#
1. Set up ChromeDriver:
    1. Download the appropriate ChromeDriver from the official site.
    2. Place the chromedriver.exe (or chromedriver for Linux/Mac) in a known directory.
    3. Make sure this directory is included in your system's PATH environment variable. Alternatively, you can specify the path directly in the code using :
       System.setProperty("webdriver.chrome.driver", "path/to/your/chromedriver");.
2. Run the project
    1. Open the project in your IDE (e.g., Eclipse, IntelliJ).
    2. Navigate to the RedBusAutomation.java file.
    3. Run the main() method. The script will open a Chrome browser window and execute the automation steps.

#Expected Outcome#

The console will display the total number of buses found after applying the 'Primo' and 'Evening' filters. Note: The code in the prompt currently prints this count, but the final extraction and printing of each operator's name is not yet implemented.


A sample output showing the bus count would look like this:
24 buses found

To complete the assignment, the logic to iterate through the final list of web elements and print the travelsName for each bus would be added after the lazy-loading while loop.













