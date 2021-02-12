package rps;

import java.util.Random;

public class Selected {
	enum SELECTION {ROCK, PAPER, SCISSORS}
	public SELECTION currentUserSelection = null;
	String oppSelectionString = "";
/*
 * 	Create method to randomly select one of the enum values
 */
	public SELECTION getRandom() {
		Random random = new Random();
		return SELECTION.values()[random.nextInt(SELECTION.values().length)];
	}
	public void rock() {
		currentUserSelection = SELECTION.ROCK;
	}
	public void paper() {
		currentUserSelection = SELECTION.PAPER;
	}
	public void scissors() {
		currentUserSelection = SELECTION.SCISSORS;
	}
/*
 * 	Create turn() method that contains the game logic.
 */
	public String turn() {
		String result = null;
		
		if(currentUserSelection == null)
			System.exit(1);
		else {
			SELECTION opponentSelection = getRandom();
			oppSelectionString = opponentSelection.toString();
			switch(currentUserSelection) {
			case ROCK:
				if(opponentSelection.toString().equals("ROCK")) 
					result = "Tie!";
				else if(opponentSelection.toString().equals("PAPER"))
					result = "Paper Beats Rock! Better Luck Next Time!";
				else if(opponentSelection.toString().equals("SCISSORS"))
					result = "Rock Beats Scissors! Congratulations!";
				break;
			case PAPER:
				if(opponentSelection.toString().equals("PAPER"))
					result = "Tie!";
				else if(opponentSelection.toString().equals("ROCK"))
					result = "Paper Beats Rock! Congratulations!";
				else if(opponentSelection.toString().equals("SCISSORS"))
					result = "Scissors Beats Paper! Better Luck Next Time!";
				break;
			case SCISSORS:
				if(opponentSelection.toString().equals("SCISSORS"))
					result = "Tie!";
				else if(opponentSelection.toString().equals("ROCK"))
					result = "Rock Beats Scissors! Better Luck Next Time!";
				else if(opponentSelection.toString().equals("PAPER"))
					result = "Scissors Beats Paper! Congratulations!";
				break;
			}
		}
		return result;
	}
/*
 * 	Create getter method used to return the randomly selected enum value as
 * 	a String
 */
	public String getOppSelection() {
		return oppSelectionString;
	}
}