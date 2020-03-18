import java.io.File;
import java.util.Scanner;

public class Game extends GameLogic {

	GameData data;
	String answer;
	LetterBank letterBank;
	Hangman man;
	Score score;
	Scanner s;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game g = new Game();
		g.launchGame();

	}
	
	public void launchGame() {
		System.out.println("Welcome to Hangman\n");
		System.out.println("1. Start the Game");
		System.out.println("2. View Rules\n");
		System.out.println("Enter 1 to start game or 2 to view the game rules.");
		man = new Hangman();
		score = new Score();
		s = new Scanner(System.in);
		int userChoice = s.nextInt();
		if (userChoice == 1){
			startGame();
		}else {
			//implementing abstract class we are calling gamelogic show rules which is abstract class
			GameLogic logic = new Game();
			logic.showRules();	
		}
		
	}
	//show rules and also ask user want to exit or do uyou want to enter game
	public void showRules() {
		System.out.println("YOU CAN ONLY ENTER LETTERS IN UPPER CASE");
		System.out.println("YOU HAVE ONLY 10 CHANCES FOR THE ENTIRE GAME OF 5 LEVELS");
		System.out.println("AFTER EACH LEVEL YOU WILL GET SCORE");
		System.out.println("------------------------------------");
		System.out.println("\n------- DO YOU WANT TO ENTER GAME ? ------");
	    System.out.println("-------PRESS Y - Yes , N - No IN UPPER CASE------");
	    s = new Scanner(System.in);
	    String enterGame = s.next();
	    if (enterGame.equals("Y")) {
	    	Game g = new Game();
	    	g.launchGame();
	    }else {
	    	System.out.println("-------EXIT RULES-------");
	    }
	}
	//to start game with categories
    public void startGame() {
    	System.out.println("------- THE GAME IS STARTED ------\n");
		
    	System.out.println("1. Countries");
		System.out.println("2. Animals");
		System.out.println("3. Occupation");
		System.out.println("Please select a category");
		int userChoice = s.nextInt();
		
	    data = new GameData(userChoice);
	    //intilaizing letter bank object or class
	    letterBank = new LetterBank();
	    
	    if(data.getGameFinished() == false) {
	    	//calling start level method with level parameter
	    	startLevel(data.getCurrentLevel());
		}
	    
	}
    
    public void askForRestartGame() {
    	System.out.println("\n------- DO YOU WANT TO CONTINUE GAME ? ------");
 	    System.out.println("-------PRESS Y - Yes , N - No ------");
 	    String restartGame = s.next();
 	    if (restartGame.equals("Y")) {
 	    	launchGame();
 	    }
 	    else if(restartGame.equals("N")){
 	    	System.out.println("-------EXIT-------");
 	    }
 	    else {
 	    	System.out.println("enter correct letter whic is also need to be in uppder case");
 	    }
  	   
    }
    
    public void startLevel(int level) {
    	
    	letterBank.clearData();
    	
    	System.out.println("------- LEVEL "+level+": ------");
		letterBank.showLetterBank(letterBank.availableLetters);
		
		//show first question
		System.out.println("\nHere is your  word");
		answer = data.getWord();
		//calling show dashes which is in main class
		showDashes(answer);
		
		//Wait for user to enter answer and exception
		try {
			//calling checkAnswer methos in main class.
			checkAnswer();
		} catch (UserInputException e) {
			System.out.println("------- UH OH  ------" + e.getMessage());
		}
		
    }
    
    public void showDashes(String word) {
    	System.out.println("\n");
    	System.out.println("YOUR WORD:");
    	//tocharARray conver the word into character array
    	char[] charArray = word.toCharArray();
    	for (int i = 0;i<charArray.length;i++) {
    		char c = charArray[i];
    		if (c == ' ') {
    			System.out.print(" ");
    		}else {
    			System.out.print("_");
    			System.out.print(" ");
    		}
    	}
    }
    
    //This method prints the appropriate characters in dashes based on the characters entered by user
    //This method returns TRUE if user has succeesfully finished the word.
    //This method returns FALSE if there is one or more dashes reamining to be filled.
    public boolean updateDashes(String word) {
    	System.out.println("\n");
    	System.out.println("YOUR WORD:");
    	char[] charArray = word.toCharArray(); //PIG
    	char[] userChars = letterBank.userEnteredChars;//P
    	int dashCount = 0;
    	for (int i = 0;i<charArray.length;i++) {
    		char c = charArray[i];
    		if (c == ' ') {
    			System.out.print(" ");
    		}else {
    			if (contains(c,userChars) == true) {//check if P exists
    				System.out.print(c); //print 
        			System.out.print(" ");
    			}else{
    				System.out.print("_");
        			System.out.print(" ");
        			dashCount ++;
    			}
    			
    		}
    	}
    	
    	if (dashCount == 0) {
    		return true;
    	}
    	
    	return false;
    }
    
    public void enteredSameLetter() {
    	System.out.println("\n");
    	System.out.println("... OH NO!  You ALREADY entered this letter :( ...\n");
    	updateDashes(answer);
//    	int chanceToLive = score.lostAChanceToLive();
//    	man.drawHangman(chanceToLive);
//    	if (chanceToLive == 0) {
//    		System.out.println("\n");
//        	System.out.println("... GAME OVER :( ...\n");
//        	data.setGameFinished(true);
//        	askForRestartGame();
//       	}	
    }
    
    public void enteredWrongLetter(char c) {
    	//reduce score & show hangman && show letter bank & continue asking user input
		letterBank.updateIncorrectLetters(c);
		System.out.println("\n");
    	System.out.println("... OH NO!  You got it WRONG :( ...\n");
    	updateDashes(answer);
    	int chanceToLive = score.lostAChanceToLive();
    	man.drawHangman(chanceToLive);
    	if (chanceToLive == 0) {
    		System.out.println("\n");
        	System.out.println("... GAME OVER  ...\n");
    	}else {
	    	System.out.println("Enter your letter again");
	    }
    }
    
    
    public void checkAnswer() throws UserInputException {
    	System.out.println("\n");
    	System.out.println("Please type a word in UPPER case and press enter.");
    	
    	//Need to continue this loop till game ends 
			while (s.hasNext()) {
				
				//Check if user entered single char or double char
				char[] userInput = s.next().toCharArray();
				if (userInput.length == 1) {
					
					char c = userInput[0];
			    	//check if this character exists in the answer/word
			    	char[] answerArray = answer.toCharArray();
			    	
			    	//check if user has already entered the letter or not
			    	if (contains(c,letterBank.userEnteredChars) == true) {
			    		enteredSameLetter();
			    		//it will tell the value of the chances remainng
			    		int chanceToLive = score.chancesRemaining();
			        	if (chanceToLive == 0) {
			        	  break;
			        	}
			    	}else {
			    		
			    		letterBank.updateLetterBank(c);
			        	if (contains(c,answerArray) == true) {
			        		//updated letter bank
			        		System.out.println("\n");
			            	System.out.println("...You got it right...\n");
			            	
			            	//update the dashes
			        		if (updateDashes(answer) == true) {
			        			levelFinished();
			        			break;
			              	}else {
			        			//user has not done yet, so wait for him to finish the words. 
			        			//Do nothing here
			        		}
			        	}else {
			        		enteredWrongLetter(c);
			        		int chanceToLive = score.chancesRemaining();
				        	if (chanceToLive == 0) {
				        	  break;
				        	}
			        	}
			  	}
			  }else {
				throw new UserInputException("User has entered invalid input");
			  }  	
			}

	}

	
    
    public void levelFinished() {
    	//User finished a word successfully, so show the next word and increase score.
		int currentScore = score.increaseScore();
    	System.out.println("...CURRENT SCORE: " + String.valueOf(currentScore) +"...\n");
    	
    	//clear entered chars
    	letterBank.clearData();
    	
    	//increase the level
    	data.setCurrentLevel(data.getCurrentLevel()+1);
    	
    	if(data.getCurrentLevel() <= 5) {
    		startLevel(data.getCurrentLevel());
    	}else {
    	    userWonPrint();
    	}
    }
    
    boolean contains(char c, char[] array) {
    	for (int i=0;i<array.length;i++) {
        	char x = array[i];
            if (x == c) {
                return true;
            }
        }
        return false;
    }
    
    
    public void userWonPrint() {
    	if(data.getCurrentLevel() > 5) {
    		System.out.println("you won the game");
    		askForRestartGame();
    	}
    }
}
