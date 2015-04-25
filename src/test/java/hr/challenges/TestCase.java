package hr.challenges;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class TestCase {
	private File input;
	private File answer;
	private String id;

	public TestCase(String id) {
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}
	
	public InputStream getInpt() throws FileNotFoundException {
		return new FileInputStream(input);
	}

	public void setInput(File input) {
		this.input = input;
	}

	public void setAnswer(File answer) {
		this.answer = answer;
	}

	public boolean isCorrect(File output) throws FileNotFoundException {
		return readFile(output).equals(readFile(answer));
	}

	public String readFile(File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		String result = "";
		while (scanner.hasNext()) {
			result += scanner.next();
		}
		return result;
	}
}