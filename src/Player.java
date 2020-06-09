import java.util.Scanner;

public class Player {

	int RowAsk(int PlayerTurn) {
		boolean valid = false;
		int Row=-1;
		while (!valid) {
			System.out.printf("Spieler %d, bitte wählen sie eine Reihe zwischen 0 und 8!\n",PlayerTurn);
			Row = new Scanner(System.in).nextInt();
			
			if ( Row < 9 && Row > -1) {
				
			}
			else {
				System.out.println("unvalid input, pls retry");
			}
		}


		return Row;
		
		
	}
	
	
}
