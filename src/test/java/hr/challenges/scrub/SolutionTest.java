package hr.challenges.scrub;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import hr.challenges.SolutionTester;
import hr.challenges.TestCase;

@RunWith(Parameterized.class)
public class SolutionTest extends SolutionTester {

	@Parameters
	public static Iterable<TestCase> testData() throws URISyntaxException,
			IOException {
		runnable = new Runnable() {
			@Override
			public void run() {
				try {
					Solution.main(null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		return loadTestCase();
	}

	@Parameter
	public TestCase testCase;
	
	
	@Test
	public void doTest()
			throws URISyntaxException, IOException {
		assertTrue("Test " + testCase.getId() + " Failed",testMain(testCase));
	}
	

}
