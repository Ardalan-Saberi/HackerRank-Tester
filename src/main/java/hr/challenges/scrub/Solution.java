package hr.challenges.scrub;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(System.in));
		
		String chunk = null;
		StringBuilder stringBuilder = new StringBuilder(2048);
		while((chunk = bufferedReader.readLine()) != null){
			stringBuilder.append(chunk);
		}
		
		String rawText = stringBuilder.toString();
		String scrubbedText = rawText.replaceAll("<script(.*)>(.+?)</script>", "");
		System.out.print(scrubbedText);

	}
}