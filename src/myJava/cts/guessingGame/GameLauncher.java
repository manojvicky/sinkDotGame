package myJava.cts.guessingGame;

public class GameLauncher {
	Player p1;
	Player p2;
	Player p3;
	
public void startGame(){
	p1= new Player();
	p2= new Player();
	p3= new Player();
	int i = 0;
	int j = 0;
	int P1Won = 0;
	int P2Won = 0;
	int P3Won = 0;
	while(true){
		i++;
		int number = (int) (10*Math.random());
		System.out.println("Guess number between 0-9");
		System.out.println("Number to be Guessed is "+ number);
		
		p1.guessedNumber();
		p2.guessedNumber();
		p3.guessedNumber();
		
		System.out.println("Number guessed by player 1 is "+ p1.number);
		System.out.println("Number guessed by player 2 is "+ p2.number);
		System.out.println("Number guessed by player 3 is "+ p3.number);
		if(number==p1.number || number==p2.number || number==p3.number){
			if(number==p1.number){
				P1Won++;
			}
			if(number==p2.number){
				P2Won++;
			}
			if(number==p3.number){
				P3Won++;
			}
		if(number==p1.number && number==p2.number && number==p3.number){
			if(j<3){
			number = (int) (10*Math.random());
			j++;
			continue;
			}
			
			System.out.println("No. of time game played: "+ i+" j: "+ j);
			System.out.println("No. of time Player 1 Won : "+ P1Won);
			System.out.println("No. of time Player 2 Won : "+ P2Won);
			System.out.println("No. of time Player 3 Won : "+ P3Won);
			System.out.println("No. of time When nobody wins : "+ (i-(P3Won+P2Won+P1Won)));
			break;
		}else{
			System.out.println("No body Wins. Please try again");
		}
		
	}
	}
}


}
