package Inheritance;
import java.util.Scanner;
public class HierachycalInher {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 Hierarchical ob = new  Hierarchical ();
		 H n = new  H ();
		 I a = new  I ();
		 E h = new  E ();
		 int i = 4;
		 while(true) {
		 System.out.println("ENTER YOUR CHOICE");
		 int ch = sc.nextInt();
		 switch(ch) {
		 case 1 :ob.Main();
		 break ;
		 case 2 :n.name();
		 break ;
		 case 3 : a.age();
		 break ;
		 case 4 :  h.height();

		 break ;
			 
		 }
		 }
		 
	}

}
