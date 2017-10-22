package hangmanapplication;


import java.io.IOException;
import java.util.Scanner;

public class HanmanApplication {

	public static void main(String[] args) throws IOException{

		// How do we play the game
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n 			=====Welcome to Hangman!=====\n\n"
				+ "I will pick a word and you will try to guess it character by character.\n"
				+ "If you guess wrong 6 times, then I win.\n"
				+ "If you can guess it before then, you win.\n"
				+ "Are you ready? I hope so because I am");
		System.out.println();
	
		System.out.println("I have picked my word.\n"
				+ "Below is a picture, and below that is your current guess,which starts off as nothing.\n"
				+ "Every time you guess incorecttely.\n"
				+ "I add a body part to the picture.\n"
				+ "When there is a full person, you lose");
		
		// Allows for multiple games
		boolean doYouWantToPlay = true;
		while(doYouWantToPlay){
			
			// Setting up the game
			System.out.println();
			System.out.println("Alright! Let's Play!");
			Hangman game = new Hangman();
			
			// Playing the game
			do {
				// Draw the things...
				System.out.println();
				System.out.println(game.drawPicture());
				System.out.println();
				System.out.println(game.getFormalCurrentGuess());
				//System.out.print(game.mysteryWord);
				System.out.println();
				
				// Get the guess
				System.out.println("Enter a character that you think is in the word");
				char guess = (sc.next().toLowerCase()).charAt(0);
				System.out.println();
				
				// Check if the character is guessed already
				while(game.isGuessedAlready(guess)){
					System.out.println("Try again! You've already guessed that character");
					guess = (sc.next().toLowerCase()).charAt(0);
				}
				
				// Play the guess
				if (game.playGuess(guess)) {
					System.out.println("Great guess! That character is in the word!");
				}else{
					System.out.println("Unfortunately, that character isn't in the word!");
				}
				
				// Play the game
			} 
			while (!game.gameOver()); // Keep playing until the game is over
			
			
			// Play again or no?
			System.out.println();
			System.out.println("Do you want to play another game? Enter Y if you do.");
			Character response = (sc.next().toUpperCase()).charAt(0);
			doYouWantToPlay = (response == 'Y');
		}
		
	}

}
