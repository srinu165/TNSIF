package Exception;

public class NestedTry {
	public static void main(String args[]) {
		try {
			try {
			int x=4;
			int y=0;
			int c = x/y;
			System.out.println(c);
			
			}
			catch(Exception e) {
				System.out.println("1st Catch Block");
			}
			try {
				String a = null;
				System.out.println(a.length());
			}
			catch(Exception e) {
				System.out.println("This is hello block");

			}
		}
		catch(Exception e) {
			System.out.println("This is last final block");

		}
		finally {
			System.out.println("This is final  block");

		}
	}

}
