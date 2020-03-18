
public class Score {

	private int chanceToLive = 10;
	
	private int currentScore = 0;
	
	public int lostAChanceToLive() {
		//if chance to live greater than zero we will reduce score.
		if(chanceToLive > 0) {
			chanceToLive--;
		}else {
			chanceToLive = 0;	
		}
		return chanceToLive;
	}
	
	public int chancesRemaining() {
		return chanceToLive;
	}
	
	//to increase course
	public int increaseScore() {
		currentScore ++;
		return currentScore;
	}
}
