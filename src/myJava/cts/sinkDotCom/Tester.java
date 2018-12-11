package myJava.cts.sinkDotCom;

//import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		SinkDotCom sdc = new SinkDotCom();
		sdc.startGame();
		for(int i=0;i<sdc.myGrid.length;i++){
			for(int j=0;j<sdc.myGrid.length;j++){
				System.out.print(" "+sdc.myGrid[i][j]+" ");
			}
			System.out.println("");
		}
		
//		SinkDotCom sdc1 = new SinkDotCom();
//		sdc1.startGame();
//		for(int i=0;i<sdc1.myGrid.length;i++){
//			for(int j=0;j<sdc1.myGrid.length;j++){
//				System.out.print(" "+sdc1.myGrid[i][j]+" ");
//			}
//			System.out.println("");
//		}
	}
}
