package Exception;

public class MulCatch {

	public static void main(String[] args) {
		int a = 10000;
		int b=2;
		try{
			int c=a/b;
			String s = null;
			System.out.println("This is try block");
			System.out.println(s.length());

			}
		catch(ArithmeticException e) //if you know about exception then you can mention name ex:(ArithmeticException e)
		{
			System.out.println("This is Catch block");
			}
		
			catch(Exception e) {
				System.out.println("This is second catch block");

		}

	}

}
