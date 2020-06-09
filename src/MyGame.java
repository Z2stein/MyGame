
public class MyGame {

	
	public static void main(String[] args) {
		
		int playerTurn = 1,LastPos=-1;
		
		Board myboard = new Board();
		
		myboard.Getboard();
		
		int wantedColumn=-1;
		
		for (int i = 0; i < 10; i++) {	
			while (LastPos==-1) {
			wantedColumn = myboard.RowAsk(playerTurn);
			LastPos=myboard.board[wantedColumn].DoTurn(playerTurn);
			}
			myboard.Getboard();
			myboard.Rereaction(wantedColumn, LastPos-1+2*playerTurn);
			playerTurn=(playerTurn+1)%2;
			LastPos=-1;
		}
	}
}
