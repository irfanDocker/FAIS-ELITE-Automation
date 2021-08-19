package com.dmos.steps;
import static org.junit.Assert.fail;

import java.io.BufferedReader;

import components.Pa11y508Components;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
public class AccessabilitySteps  extends ScenarioSteps {

	@Step("^Test accessability for \"([^\"]*)\" with Pally$")
	public void test_accessability_for_with_Pally(String arg1) throws Throwable {
		BufferedReader r = Pa11y508Components.test508(arg1);

		String line;
		String errCode = "Error:";
		int count = 0;
		while (true) {
			line = r.readLine();
			if (line == null) {
				break;
			}
			if (line.contains(errCode)) {
				count = count + 1;
			}
		}

		if (count > 0) {
			fail("508 errors for: " + arg1);
		}
	}
	
}
