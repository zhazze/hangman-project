package com.hangmanProject;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
	
	// attributes of the game
	private String secretWord;
	private List<Character> playerGuesses;
	private static int remainingGuesses;
    
    // constructor to initialize the game
	public GameManager() {
    	secretWord = WordGenerator.getRandomWord().toUpperCase();
    	playerGuesses = new ArrayList<>();
    	remainingGuesses = 8;
    }
    
    // validating the player's guess input
    public void processGuess(char guess) {
        char upperCaseGuess = Character.toUpperCase(guess);
        
        // ensures a letter is input
        if (!Character.isLetter(upperCaseGuess)) {
            System.out.println("Please enter a valid letter.");
            return;
        }
        
        // ensures a letter that has not been input yet
        if (playerGuesses.contains(upperCaseGuess)) {
            System.out.println("You have already guessed this letter, choose another letter.");
            return;
        }
        
        // checks if the letter is found in secret word
        // if not found, the index of the letter will return -1
        playerGuesses.add(upperCaseGuess);
        
        if (secretWord.indexOf(upperCaseGuess) == -1) {
            remainingGuesses--;
            System.out.println("Your guess was: " + upperCaseGuess);
            System.out.println("There are no " + upperCaseGuess + "'s in the word.");
        } else {
        	System.out.println("You guessed " + upperCaseGuess + " correctly!");
        }
        
        displayGuessedLetters();
    }
    
    
    // allowing game to loop properly
    public boolean isGameOver() {
        return isWordGuessed() || remainingGuesses == 0;
    }
    
    // set up win or lose conditions
    public boolean isWordGuessed() {
        for (char letter : secretWord.toCharArray()) {
            if (!playerGuesses.contains(Character.toUpperCase(letter))) {
                return false;
            }
        }
        return true;
    }

    // displaying the random word as hidden (dashes) to the player
    public void displayHiddenWord() {
        StringBuilder hiddenWord = new StringBuilder();
        for (int i = 0; i < secretWord.length(); i++) {
            char currentChar = secretWord.charAt(i);

            if (playerGuesses.contains(currentChar)) {
                hiddenWord.append(currentChar);
            } else {
                hiddenWord.append("-");
            }
        }
        if (!isGameOver()) {
        	System.out.println("The word now looks like this: " + hiddenWord.toString());
        }
    }
    
    // list of guesses displayed to player
    private void displayGuessedLetters() {
    	
    	if (!isGameOver()) {
	    	System.out.println("You have guessed these letters: ");
	    	for (char guess : playerGuesses) {
	    		System.out.print(guess + " ");
	    	}
	    	System.out.println();
    	}
    }

	public static int getRemainingGuesses() {
		return remainingGuesses;
	}

	public String getSecretWord() {
		return secretWord;
	}

}
