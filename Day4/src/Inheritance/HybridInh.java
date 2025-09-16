package Inheritance;
import java.util.Scanner;
public class HybridInh {
	public void showroom() {
	System.out.println(" WEL COME TO L6 CAR SHOEROOM");
	

}
}
class Z extends HybridInh{
	public void model() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("SELECT YOUR CAR  MODEL");
		String m = sc.next();
		
	}
}
class Y extends HybridInh {
	public void color() {
		Scanner sc = new Scanner(System.in);
		System.out.println("SELECT YOUR CAR  colorL");
		String color = sc.next();
		
	}
}
class X extends Y{
	public void price(){
		System.out.println("Total car price is : 2000000");
		
	}
}

class W extends X{
	public void greet(){
		System.out.println("Thank YOU");
		
	}
}