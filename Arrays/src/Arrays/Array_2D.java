package Arrays;

class Array_2D extends Arrays {
	int [][] n = {{1,2,3},{3,2,1},{1,2,3}};
	public void show() {
		System.out.println("------------------------------------2D-ARRAYS--------------------------------------------------------------------------------");

		for(int i=0;i<=2;i++) {
			for(int j=0 ; j<=2;j++) {
		
		System.out.print(n[i][j]+" ");
	}
System.out.println( );
}
}}