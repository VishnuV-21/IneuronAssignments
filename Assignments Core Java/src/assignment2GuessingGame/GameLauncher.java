package assignment2GuessingGame;

import java.util.Scanner;

class Guesser {
	String name;
	int age;
	int GuesserGuessed;

	public int guesserGuessANumber() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of the guesser");
		name = sc.nextLine();
		int len=name.length();
		if (len<=1) {
			System.out.println("Please enter a valid name!");
			System.exit(0);
		} else {
			System.out.println("Please enter your age:");
			age = sc.nextInt();
			if (age <= 4) {
				System.out.println("You are not old enough to understand the game. let's play again after 1 year");
				System.exit(0);
			} else {
				System.out.println("Hello " + name + " Please guess a number to get the game started.");
				GuesserGuessed = sc.nextInt();
				System.out.println("Now its the players chance to guess!");
			}
		}
		return GuesserGuessed;
	}
}

class Players {
	int playerGuesses;
	int age;
	String name;

	int playersGuessANumber() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the name of the player:");
		name = sc.nextLine();
		if (name.length() < 2) {
			System.out.println("Please enter a valid name!");
			System.exit(0);
		} else {
			System.out.println("Please enter the age of the player:");
			age = sc.nextInt();
			if (age <= 4) {
				System.out.println("You are not old enough to understand the game. let's play again after 1 year");
				System.exit(0);
			} else {
				
				System.out.println("Hello " + name + " Please guess a number that the guesser guessed.");
				playerGuesses = sc.nextInt();
			}
		}
		return playerGuesses;
	}
}

class Umpire {
	int numFromGuesser;
	int numFromPlayer1;
	int numFromPlayer2;
	int numFromPlayer3;

	public void startGame() {
		System.out.println("Welcome to the Guessing game! Let's guess it out.");
		getNumFromGuesser();
	}

	public void getNumFromGuesser() {
		Guesser guesser = new Guesser();
		numFromGuesser = guesser.guesserGuessANumber();
	}

	public void getNumFromPlayer() {
		Players player1 = new Players();
		Players player2 = new Players();
		Players player3 = new Players();
		numFromPlayer1 = player1.playersGuessANumber();
		numFromPlayer2 = player2.playersGuessANumber();
		numFromPlayer3 = player3.playersGuessANumber();
	}

	public void compare() {
		if (numFromGuesser == numFromPlayer1) {
			if (numFromGuesser == numFromPlayer2 && numFromGuesser == numFromPlayer3) {
				System.out.println("Game tied, Everyone wins");
			} else if (numFromGuesser == numFromPlayer2) {
				System.out.println("Player 1 and 2 are the winners");
			} else if (numFromGuesser == numFromPlayer3) {
				System.out.println("Player 1 and 3 are the winners");
			} else {
				System.out.println("Player 1 is the winner");
			}
		} else if (numFromGuesser == numFromPlayer2) {
			if (numFromGuesser == numFromPlayer3) {
				System.out.println("Player 2 and 3 are the winners");
			} else {
				System.out.println("Player 2 is the winner");
			}
		} else {
			System.out.println("Player 3 is the winner");
		}
		endOfTheGame();
	}
	public void endOfTheGame() {
		System.out.println("Thanks for Playing with us! Have a nice day.");
	}
}


public class GameLauncher {
	public static void main(String[] args) {
		Umpire umpire = new Umpire();
		umpire.startGame();
		umpire.getNumFromPlayer();
		umpire.compare();
		
		

	}
}
