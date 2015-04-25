package hr.challenges;

import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class SolutionTester {
	final static String testPrefix = "t";
	final static String testInputSuffix = ".in";
	final static String testAnswerSuffix = ".ans";
	final static String testOutputSuffix = ".out";

	protected static Runnable runnable;

	protected boolean testMain(TestCase testCase) throws URISyntaxException,
			IOException {

		System.setIn(testCase.getInpt());

		File outputFile = new File(testPrefix + testCase.getId()
				+ testOutputSuffix);
		if (!outputFile.exists()) {
			outputFile.createNewFile();
		}

		PrintStream stdout = System.out;

		PrintStream outputStream = new PrintStream(new BufferedOutputStream(
				new FileOutputStream(outputFile)));
		System.setOut(outputStream);

		runnable.run();

		outputStream.close();
		System.setOut(stdout);
		
		return testCase.isCorrect(outputFile);		
	}

	protected static List<TestCase> loadTestCase()
			throws URISyntaxException, IOException {
		HashMap<String, TestCase> testCaseMap = new HashMap<>();

		String location = runnable.getClass().getName();

		location = location.substring(0, location.lastIndexOf(".")).replace(
				".", "/");
		for (File file : getResourceListing(runnable.getClass(), location)) {
			String testId = file.getName();
			if (testId.startsWith(testPrefix)) {
				testId = testId.substring(1);
				if (testId.endsWith(testInputSuffix)) {
					testId = testId.substring(0,
							testId.lastIndexOf(testInputSuffix));

					if (testCaseMap.containsKey(testId)) {
						testCaseMap.get(testId).setInput(file);
						;
					} else {
						TestCase newTestCase = new TestCase(testId);
						newTestCase.setInput(file);
						testCaseMap.put(testId, newTestCase);
					}
				} else if (testId.endsWith(testAnswerSuffix)) {
					testId = testId.substring(0,
							testId.lastIndexOf(testAnswerSuffix));
					if (testCaseMap.containsKey(testId)) {
						testCaseMap.get(testId).setAnswer(file);
					} else {
						TestCase newTestCase = new TestCase(testId);
						newTestCase.setAnswer(file);
						testCaseMap.put(testId, newTestCase);
					}
				}
			}
		}

		List<TestCase> testCaseList = new ArrayList<TestCase>();
		testCaseList.addAll(testCaseMap.values());
		return testCaseList;
	}

	private static File[] getResourceListing(Class clazz, String path)
			throws URISyntaxException, IOException {
		URL dirURL = clazz.getClassLoader().getResource(path);
		if (dirURL != null && dirURL.getProtocol().equals("file")) {
			/* A file path: easy enough */
			File dir = new File(dirURL.toURI());
			return dir.listFiles();
		}

		if (dirURL == null) {
			/*
			 * In case of a jar file, we can't actually find a directory. Have
			 * to assume the same jar as clazz.
			 */
			String me = clazz.getName().replace(".", "/") + ".class";
			dirURL = clazz.getClassLoader().getResource(me);
		}

		if (dirURL.getProtocol().equals("jar")) {
			/* A JAR path */
			String jarPath = dirURL.getPath().substring(5,
					dirURL.getPath().indexOf("!")); // strip out only the JAR
													// file
			JarFile jar = new JarFile(URLDecoder.decode(jarPath, "UTF-8"));
			Enumeration<JarEntry> entries = jar.entries(); // gives ALL entries
															// in jar
			Set<File> result = new HashSet<File>(); // avoid duplicates in case
													// it is a subdirectory
			while (entries.hasMoreElements()) {
				String name = entries.nextElement().getName();
				if (name.startsWith(path)) { // filter according to the path
					File entryFile = new File(name);
					result.add(entryFile);
				}
			}

			return result.toArray(new File[result.size()]);
		}

		throw new UnsupportedOperationException("Cannot list files for URL "
				+ dirURL);
	}

}
