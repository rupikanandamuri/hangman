
public class LetterBank {

	public char[] availableLetters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	public char[] userEnteredChars = new char[26];
	//we need index to add to array
	int lastIndex = 0;
	
	public char[] incorrectLetters = new char[26];
	int lastIncorrectIndex = 0;
	
	//to show show available letters
	public void showLetterBank(char[] array) {
		
		System.out.print("[");
		for(int i =0;i<array.length;i++) {
			char c = array[i];
			System.out.print(c);
			//to display dashes b/w character and charatcer.
			System.out.print("--");		
		}
		System.out.print("]");
	}
	
	public void updateLetterBank(char c) {
		//replace c with * in the array
		char[] temp = availableLetters;
		for(int i = 0;i<temp.length;i++) {
			char d = temp[i];
			if (d == c) {
				availableLetters[i] = '*';
			}
		}
		//update user char array
		userEnteredChars[lastIndex] = c;
		lastIndex++;
		System.out.print("\n LETTER BANK:");
		showLetterBank(availableLetters);
		System.out.print("\n");
	}   
	
	public void updateIncorrectLetters(char c){
	    incorrectLetters[lastIncorrectIndex] = c;
		lastIncorrectIndex ++;
		System.out.print("\n INCORRECT WORDS:");
		showLetterBank(incorrectLetters);
		System.out.print("\n");
	}
	
	public void clearData() {
		availableLetters = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		userEnteredChars = new char[26];
		lastIndex = 0;
		lastIncorrectIndex = 0;
	}
	
}
