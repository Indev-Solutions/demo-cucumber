package com.indevsolutions.example.cucumber.context;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:feature")
public class CucumberIntegrationTest {

}
