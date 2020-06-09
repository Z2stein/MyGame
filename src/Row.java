
public class Row {
	int[] field = new int[9];
	int lastPosition;
	public Row() {
	

		field= new int[] {1,1,1,-1,-1,-1,0,0,0};
		//System.out.println("initialisierung");
		lastPosition=-1;
	}
	
	public int getVal(int id) {
		
		return field[id];
	}
	
	public boolean setVal(int Row, int Val) {
		field[Row] = Val;
		
		if (field[Row]==Val) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int LastPos(int playerTurn) {
		int lastpos=-1;
		
		if(playerTurn==1) {
			
			for (int i = 0; i < field.length; i++) {
				if (field[i] == 1) {
					lastpos = i;
		}	}   }
		if(playerTurn==0) {
			
			for (int i = 8; i>-1; i--) {
				if (field[i] == 0) {
					lastpos = i;
		}	}   }
		
		
		
		return lastpos;
	}
		
	public int DoTurn(int playerTurn) {
	

		
		if (playerTurn==1) {
			
			lastPosition=LastPos(playerTurn);
			
			if ( (lastPosition==-1) || (field[lastPosition]==-1) || (lastPosition==8) ) {
				System.out.println("denied");
				return -1;
			}
			else if (field[lastPosition+1]==0) {
				System.out.println("denied: these is already a stone of yopur opponent");
				return -1;
			}
			for (int i = 8; i >-1 ; i--) {
				if (field[i]==1) {
					field[i+1]=1;
					field[i]=-1;
		}	}	}
		else if (playerTurn==0) {
			
			lastPosition=LastPos(playerTurn);
			
			if ( (lastPosition==-1) || (field[lastPosition]==-1) || (lastPosition==0) ) {
				System.out.println("denied");
				return -1;
			}
			else if (field[lastPosition+1]==1) {
				System.out.println("denied: these is already a stone of yopur opponent");
				return -1;
			}
			for (int i = 0; i <9 ; i++) {
				if (field[i]==0) {
					field[i-1]=0;
					field[i]=-1;
		}	}	}
		
		else {
			System.out.println("Error no Turn");
			return -1;
		}
			
			
		return lastPosition;
		
	}

	
	
}
/*
 * 1
 * 1
 * -1
 * -1
 * 0
 * 0
 */

