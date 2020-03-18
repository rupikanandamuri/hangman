
public class Hangman {

	public void drawHangman(int punishLevel) {
	    if (punishLevel == 9) {
	    	drawHangmanOne();
	       }
	    if (punishLevel == 8) {
	    	drawHangmanTwo();
	    	}
	    if (punishLevel == 7) {
	    	drawHangmanThree();
	    	}
	    if (punishLevel == 6) {
	    	drawHangmanFour();
	    	}
	    if (punishLevel == 5) {
	    	drawHangmanFive();
	    	}
	    if (punishLevel == 4) {
	    	drawHangmanSix();
	    	}
	    if (punishLevel == 3) {
	    	drawHangmanSeven();
	    	}
	    if (punishLevel == 2) {
	    	drawHangmanEight();
	    	}
	    if (punishLevel == 1) {
	    	drawHangmanNine();
	    	}
	    if (punishLevel == 0) {
	    	drawHangmanTen();
	    	}

   }
	
	
     public void drawHangmanOne() {

		String x =
				"          \n" +
				"		   \n" +
				"		   \n" +
				"		   \n" +
				"		   \n" +
				"		   \n" +
				"		   \n" +
				"		   \n" +
				"		 ___\n" +
				"		|   |______\n" +
				"		|          |\n" +
				"		|__________|";
		System.out.println(x);
	}

     public void drawHangmanTwo() {

    	 String x =
 				"" +
 				"		  |\n" +
 				"		  |\n" +
 				"		  |\n" +
 				"		  |\n" +
 				"		  |\n" +
 				"		  |\n" +
 				"		  |\n" +
 				"		 _|_\n" +
 				"		|   |______\n" +
 				"		|          |\n" +
 				"		|__________|";
 		System.out.println(x);
 	}

     public void drawHangmanThree() {

 		String x =
 				"                   ---------\n" +
 				"		  |         \n" +
 				"		  |         \n" +
 				"		  |         \n" +
 				"		  |         \n" +
 				"		  |         \n" +
 				"		  |\n" +
 				"		  |\n" +
 				"		 _|_\n" +
 				"		|   |______\n" +
 				"		|          |\n" +
 				"		|__________|";
 		System.out.println(x);
 	}

     public void drawHangmanFour() {

 		String x =
 				"                   ---------\n" +
 				"		  |         |\n" +
 				"		  |   \n" +
 				"		  |   \n" +
 				"		  |   \n" +
 				"		  |   \n" +
 				"		  |\n" +
 				"		  |\n" +
 				"		 _|_\n" +
 				"		|   |______\n" +
 				"		|          |\n" +
 				"		|__________|";
 		System.out.println(x);
 	}

     public void drawHangmanFive() {

 		String x =
 				"                   ---------\n" +
 				"		  |         |\n" +
 				"		  |         o    \n" +
 				"		  |  \n" +
 				"		  |  \n" +
 				"		  |  \n" +
 				"		  |\n" +
 				"		  |\n" +
 				"		 _|_\n" +
 				"		|   |______\n" +
 				"		|          |\n" +
 				"		|__________|";
 		System.out.println(x);
 	}

     public void drawHangmanSix() {

 		String x =
 				"                   ---------\n" +
 				"		  |         |\n" +
 				"		  |         o    \n" +
 				"		  |         |   \n" +
 				"		  |  \n" +
 				"		  |  \n" +
 				"		  |\n" +
 				"		  |\n" +
 				"		 _|_\n" +
 				"		|   |______\n" +
 				"		|          |\n" +
 				"		|__________|";
 		System.out.println(x);
 	}

     public void drawHangmanSeven() {

 		String x =
 				"                   ---------\n" +
 				"		  |         |\n" +
 				"		  |         o    \n" +
 				"		  |        /|   \n" +
 				"		  | \n" +
 				"		  | \n" +
 				"		  |\n" +
 				"		  |\n" +
 				"		 _|_\n" +
 				"		|   |______\n" +
 				"		|          |\n" +
 				"		|__________|";
 		System.out.println(x);
 	}

     public void drawHangmanEight() {

 		String x =
 				"                   ---------\n" +
 				"		  |         |\n" +
 				"		  |         o    \n" +
 				"		  |        /|\\   \n" +
 				"		  |\n" +
 				"		  |\n" +
 				"		  |\n" +
 				"		  |\n" +
 				"		 _|_\n" +
 				"		|   |______\n" +
 				"		|          |\n" +
 				"		|__________|";
 		System.out.println(x);
 	}

     public void drawHangmanNine() {

 		String x =
 				"                   ---------\n" +
 				"		  |         |\n" +
 				"		  |         o    \n" +
 				"		  |        /|\\   \n" +
 				"		  |         |\n" +
 				"		  |        /  \n" +
 				"		  |\n" +
 				"		  |\n" +
 				"		 _|_\n" +
 				"		|   |______\n" +
 				"		|          |\n" +
 				"		|__________|";
 		System.out.println(x);
 	}
     public void drawHangmanTen() {

 		String x =
 				"                   ---------\n" +
 				"		  |         |\n" +
 				"		  |         o    \n" +
 				"		  |        /|\\   \n" +
 				"		  |         |\n" +
 				"		  |        / \\ \n" +
 				"		  |\n" +
 				"		  |\n" +
 				"		 _|_\n" +
 				"		|   |______\n" +
 				"		|          |\n" +
 				"		|__________|";
 		System.out.println(x);
 	}


}
