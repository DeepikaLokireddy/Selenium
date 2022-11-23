package Stepdefinition;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="D:/eclipseworkspace/testing/src/test/resources/Features/t4.feature",
glue= {"Stepdefinition"},plugin= {"pretty"})
public class test2 {

	
	}

