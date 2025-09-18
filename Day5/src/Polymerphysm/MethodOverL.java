package Polymerphysm;
class Main{
	final int a=66;
	public void box(int k,int m) {
		
		k=a;
		System.out.println(+k+ "and " +(k*m));
	}
	public void box2(int q,float l,int s) {
		System.out.println(+(q*l*s));
		System.out.println("HELLO");
	}
}

public class MethodOverL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Main m = new Main();
m.box(34, 45);
m.box2(56, 66, 55);

}
}