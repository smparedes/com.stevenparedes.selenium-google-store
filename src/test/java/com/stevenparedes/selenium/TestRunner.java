package com.stevenparedes.selenium;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

// This class is the Runner class.
// Option A: Use maven
// 1. Open terminal or command prompt
// 2. cd to main project folder and type: mvn clean test
//
// Option B: If using Eclipse: To run test with JUnit Tests follow these steps
// 1. At the top main menu of Eclipse -> Run -> Run as -> JUnit Test
// 2. If the Save and Launch modal window appears, Click the "OK" button

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features/")
public class TestRunner {
}