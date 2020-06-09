import java.util.Scanner;

public class Board {


	Row[] board  = new Row[9];
	
	
	
	public Board() {
			for (int i = 0; i < board.length; i++) {
				board[i] = new Row();
			}
		
		}
	
	//System.out.println(board[8].getVal(8));
	
	int RowAsk(int PlayerTurn) {
		boolean valid = false;
		int Row=-1;
		while (!valid) {
			System.out.printf("\nSpieler %d, bitte wählen sie eine Reihe zwischen 0 und 8!\n",PlayerTurn);
			Row = new Scanner(System.in).nextInt();
			//System.out.println("understood: "+ Row);
			
			if ( Row < 9 && Row > -1) {
				valid=true;
				}
			else {
				System.out.println("unvalid input, pls retry");
			}
		}


		return Row;
		
		
	}
	
	public void Getboard() {
		System.out.printf("\n");
		String val ;
		System.out.println("   #  0 1 2 3 4 5 6 7 8\n # # # # # # # # # # # ");
		
		for (int i = 0; i < 9; i++) {
		
		System.out.printf("%2d # ",i);
		
		for (int j = 0; j < 9; j++) {
			
			if(board[j].getVal(i)==-1) {
				val = "";
			}
			else {
				val = Integer.toString(board[j].getVal(i));
				
			}
			//System.out.print(board[j].getVal(i));
			System.out.printf("%2s",val);
			
		}
		System.out.printf("\n");
		}
	}
	
	protected void Rereaction(int choosenX, int choosenY) {
		
		if (board[choosenX].getVal(choosenY)==-1) {
			return;
		}
		
		System.out.printf("\n Start rereact with X: %d und Y: %d    the value is:  %d",choosenX,choosenY,board[choosenX].getVal(choosenY));

		if (board[choosenX].getVal(choosenY)==0) { //playerturn # 0 so rereaction is from 1
			try {
				if (board[choosenX+1].getVal(choosenY-1) == 1) {
					System.out.println("ich bin da");
					board[choosenX+1].setVal(choosenY-1, -1);
					board[choosenX].setVal(choosenY,1);
					this.Getboard();
					this.Rereaction(choosenX, choosenY);
				}
				else {
					System.out.println("\n1:  The Value is: "+board[choosenX-1].getVal(choosenY+1));
				}
			} catch (Exception e) {
				System.out.printf("\nNo rereaction because of end of Board");
			}
			
		}
		else if (board[choosenX].getVal(choosenY)==1) { //playerturn # 1
			
			try {
				if (board[choosenX-1].getVal(choosenY+1) == 0) {
					board[choosenX-1].setVal(choosenY+1, -1);
					board[choosenX].setVal(choosenY,0);
					this.Getboard();
					this.Rereaction(choosenX, choosenY);
				}
				else {
					System.out.println("\n2:  The Value is: "+board[choosenX-1].getVal(choosenY+1));
				}

			} catch (Exception e) {
				System.out.printf("\nNo rereaction because of end of Board");
			}
		}
		else {
			System.out.println("Error 5001: invalid input for Rereaction");
			return;
		}
		
		
		return;
	}

	public void Reaction(int choosenX,int choosenY, int playerTurn) {
		//int lastpos = board[choosenX].LastPos(playerTurn);
		
		if (playerTurn==0) {
			if(board[choosenX].getVal(choosenY) == 0 && board[choosenX+1].getVal(choosenY-1) == 1) {
				board[choosenX].setVal(choosenY, -1);
				board[choosenX+1].setVal(choosenY-1,0);		
				this.Getboard();
				this.Rereaction(choosenX+1, choosenY-1);
				return;
			}
		}	
		
		if (playerTurn==1) {
			if(board[choosenX].getVal(choosenY) == 1 && board[choosenX-1].getVal(choosenY+1) == 0) {
				board[choosenX].setVal(choosenY, -1);
				board[choosenX-1].setVal(choosenY+1,1);
				System.out.println("yoyoyo");
				this.Getboard();
				this.Rereaction(choosenX-1, choosenY+1);
				return;
			}
		}
		
System.out.println("Error 5002: Fx:Reaction wthout result");
	}

	
	
}
