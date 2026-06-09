# E-Commerce QA Assignment

## Project Overview

This project automates critical user journeys of an e-commerce application using Selenium WebDriver, Java, TestNG, Maven, and Page Object Model (POM).

### Automated Test Scenarios

1. Registration.
2. Successful Login
3. Add Product to Cart
4. Checkout Flow

---

## Technology Stack

* Java 17
* Selenium WebDriver
* TestNG
* Maven
* Page Object Model (POM)

---

## Project Structure

src/test/java

* pageObjects

  * AccountPage.java
  * CartPage.java
  * CheckoutPage.java
  * HomePage.java
  * LoginPage.java
  * SignupPage.java

* testCases

  * RegistrationTest.java
  * LoginTest.java
  * AddToCartTest.java
  * CheckoutTest.java

* utilities

  * BaseTest.java
  * WaitUtils.java
  * config.properties

Other Files

* pom.xml
* testng.xml (If you are executing the Checkout Flow, please run it through the testng.xml suite).

---

## Prerequisites

Before execution, ensure the following are installed:

* Java JDK 17
* Maven
* Google Chrome Browser
* Eclipse IDE

---

## Setup Instructions

### Clone Repository

git clone <repository-url>

### Open Project

1. Open Eclipse
2. Import Existing Maven Project
3. Select project folder

### Install Dependencies

Right Click Project → Maven → Update Project

or

mvn clean install

---

## Execute Tests

### Run From Eclipse

Right Click → testng.xml → Run As → TestNG Suite

### Run From Command Line

mvn clean test

---

## Assertions Used

### Login Verification

Verify user logs in successfully.

### Add To Cart Verification

Verify product is displayed in cart.

### Checkout Verification

Verify checkout page or order confirmation is displayed.

---

## Explicit Waits

The framework uses WebDriverWait to handle dynamic elements and synchronization.

---

## Assumptions

* Test environment is available and stable.
* User account already exists.
* Internet connection is active.
* Chrome browser is installed.

---

## Challenges Faced

* Handling dynamic web elements.
* Synchronization issues.
* Managing popups and modal windows.
* Maintaining stable execution across browser updates.

---

## Execution Evidence

Execution screenshots and TestNG reports are attached in the submission package.

Report Location:

test-output/index.html

test-output/emailable-report.html

---

## Author

Manish Arya
QA Automation Engineer
