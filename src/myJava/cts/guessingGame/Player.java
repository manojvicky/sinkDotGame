package myJava.cts.guessingGame;

public class Player {
int number;
public void guessedNumber(){
	this.number = (int) (10*Math.random());
}
}
