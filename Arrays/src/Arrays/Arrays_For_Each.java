package Arrays;

public class Arrays_For_Each {
	public void see() {
		int l [][] = new  int[3][4];
		System.out.println("------------------------------------FOR-EACH-METHD (OR) ENHANCED-LOOP--------------------------------------------------------------------------------");
		for(int i=0;i<=2;i++) {
			for(int j=0 ; j<=3 ;j++) {
				 l[i][j] = (int)(Math.random()*10);
			}
		}
		for(int [] x:l) {
			for(int y:x) {
				
				System.out.print(" " +y);
				
			}
			System.out.println();
		}
	}

}

