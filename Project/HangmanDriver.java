import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
 
// this is my attempt at a hang man game, without the drawing. You just get to keep guessing until
// you get 6 incorrect guesses
public class HangmanDriver {
	
	static Scanner sc = new Scanner(System.in);
	
	static void Sleep(int time) {
		try {
		    TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
	    }
	}
	
	static void print(String sentence) {
		System.out.print(sentence);
	}
	
	static void println(String sentence) {
		System.out.println(sentence);
	}
	
	static boolean testGame() {
		char answer = ' ';
		 while(answer != 'y' || answer != 'n') {
			 print("Would you like to start a new game (y/n)? ");
			 answer = sc.next().charAt(0);
		     sc.nextLine();
			 if(answer == 'y') {
				 Sleep(1);
				 return true;
			 }
			 
			 else if(answer == 'n') {
				 Sleep(1);
				 println("Goodbye. ");
				 return false;
		      }
			 
			 else {
				 println("Invalid Input! Enter 'y' or 'n'");
				 Sleep(1); 
			 }
		 }
		 return false;
	}
	
	static boolean checkLists(ArrayList<Character> CheckList, ArrayList<String> GuessList, StringBuilder Guess, StringBuilder Check) {
		for(Character ch: CheckList) {
			Check.append(ch);
		}
		
		for(String str: GuessList) {
			Guess.append(str.charAt(0));
		}
		
		if(Check.toString().equals(Guess.toString())) {
			return true;
		}
		
		Guess.setLength(0);
		Check.setLength(0);
		return false;
	}

	public static void main(String[] args) {

		while(testGame()) {
			StringBuilder Guess = new StringBuilder();
			StringBuilder Check = new StringBuilder();
			ArrayList<String> GuessList = new ArrayList<>();
			ArrayList<Character> CheckList = new ArrayList<>();

			 // creates the sentence used for the game
			
			print("Enter a phrase you want to use: ");
			String gameWord = sc.nextLine();
			 
			for(int i = 0; i < gameWord.length();i++) {
				
				
				if(Character.isWhitespace(gameWord.charAt(i))) {
					
					GuessList.add("\t");
					CheckList.add('\t');
				
				} else {
					GuessList.add("_ ");
					CheckList.add(gameWord.charAt(i));
				}
			}
			
			println("Clear the console and hand the laptop over to the next player");
			Sleep(5);
			
			for(int i = 0; i < 200; i++) {
				println("\n\n");
			}
			
			println("You have 6 guesses to solve the phrase.");
			
			
			// total number of guesses
			int limit  = 6;
			
			do {
				switch(limit) {
					case 6:
						println("_______");
						println("|      |");
						println("|");
						println("|");
						println("|");
						println("|");
						println("|");
						println("|");
						println("|_____");
						break;
					case 5:
						println("_______");
						println("|      |");
						println("|      O");
						println("|");
						println("|");
						println("|");
						println("|");
						println("|");
						println("|_____");
						break;
					case 4:
						println("_______");
						println("|      |");
						println("|      O");
						println("|      |");
						println("|      |");
						println("|");
						println("|");
						println("|");
						println("|_____");
						break;
					case 3:
						println("_______");
						println("|      |");
						println("|      O");
						println("|     /|");
						println("|      |");
						println("|");
						println("|");
						println("|");
						println("|_____");
						break;
					case 2:
						println("_______");
						println("|      |");
						println("|      O");
						println("|     /|\\");
						println("|      |");
						println("|");
						println("|");
						println("|");
						println("|_____");
						break;
					case 1:
						println("_______");
						println("|      |");
						println("|      O");
						println("|     /|\\");
						println("|      |");
						println("|     /");
						println("|");
						println("|");
						println("|_____");
						break;
						
				}
				// prints the new guessing list with new letters
				println("");
				for(int i = 0; i < GuessList.size();i++) {
					print(GuessList.get(i));
				}	
				print("\nEnter your guess: ");
				String guess = sc.nextLine();
				println("");
				Sleep(1);
				// checks the guess and sets the letter on the list to view
				for(int i = 0; i < GuessList.size();i++) {
					if(String.valueOf(CheckList.get(i)).toLowerCase().equals(guess.toLowerCase())) {
						GuessList.set(i, CheckList.get(i).toString());
					}
				}
				
				// if the guess is not in the list, it will decrement the total guesses.
				if(!GuessList.contains(guess)) {
						limit--;
						println("Nope! Guesses Left: " + (limit));
						Sleep(1);

					}
				
				
				
				// checks if the user guessed all letters
				if(checkLists(CheckList,GuessList,Guess,Check)) {
					println(gameWord);
					println("\nYou Won!!");
					Sleep(2);
					System.exit(0);
				}
			} while(limit >0 );
			
			println("_______");
			println("|      |");
			println("|      O");
			println("|     /|\\");
			println("|      |");
			println("|     / \\");
			println("|");
			println("|");
			println("|_____");
			
			println("\nGame Over!");
			Sleep(1);
			println("The answer was: " + gameWord);
			Sleep(1);
			System.exit(0);
		}		
	}
}
	
