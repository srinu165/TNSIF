package Inheritance;

public class Multilevelnh {
	int n = 10;
	public void age() {
		
	
	System.out.println("This is my age"+n);
	}
	

}
class Gend extends Multilevelnh{
	public void gend() {
		System.out.println("Male");
	}
}
class Roll extends Gend{
	public void roll() {
		System.out.println("05L6");
	}
}