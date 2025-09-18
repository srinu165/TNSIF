package Abstract;
import java.util.Scanner;
public abstract class AbstractDemo {
abstract void show();

}
class tkr extends AbstractDemo{
	public void show() {
		while(true) {
		Scanner sc = new Scanner(System.in);
		System.out.println("WELL COME TO BBRS GAME");
		System.out.println("1.Register");
		System.out.println("2.login");
		System.out.println("3.Play Game");
		int ch = sc. nextInt();
		switch(ch) {
		case 1:
			System.out.println("Enter your Name:");
			String name = sc.next();
			System.out.println("Enter your Email:");
			String mail = sc.next();
			break;
		case 2:
			
			
			System.out.println("Enter your Name:");
			String n = sc.next();
			System.out.println("CORRECT");
			String m = sc.next();
//			if(n==name || m==mail) {
//				System.out.println("CORRECT");
//			}
//			else {
//					System.out.println("INCORRECT");
//				}
//			break;
			
		case 3:
			
			System.out.println("Play Game");
		default :
			System.out.println("Choose Correct");
		}
	}
	}
	
}
