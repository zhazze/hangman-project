package com.hangmanProject;

import java.util.Scanner;

public class MainRunner {

    public static void main(String[] args) {
    	
    	// start of the game has: player input, create new game, welcome message
        Scanner scanner = new Scanner(System.in);
        GameManager hangmanGame = new GameManager();
        System.out.println("Welcome to Hangman!");

        while (!hangmanGame.isGameOver()) {
            System.out.println("Remaining guesses: " + hangmanGame.getRemainingGuesses());
            System.out.print("Enter your guess: ");
            String input = scanner.nextLine();

            if (input.length() != 1) {
                System.out.println("Please enter a single letter.");
                continue;
            }

            char guess = input.toUpperCase().charAt(0);
            hangmanGame.processGuess(guess);
            hangmanGame.displayHiddenWord();
        }

        if (hangmanGame.isWordGuessed()) {
            System.out.println("You win! The word was: " + hangmanGame.getSecretWord());
        } else {
            System.out.println("Game over. The word was: " + hangmanGame.getSecretWord());
        }
    }
}

