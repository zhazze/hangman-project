package com.hangmanProject;

import java.util.Random;

public class WordGenerator {
	
	private static String[] wordList = {"NETHERLAND", "MALAYSIA", "PAKISTAN", "NORWAY", "SWEDEN", "ICELAND", "MEXICO", "MMONGOLIA"};
	private static Random random = new Random();
	
	public static String getRandomWord() {
		int randomIndex = random.nextInt(wordList.length);
		return wordList[randomIndex];
	}

}