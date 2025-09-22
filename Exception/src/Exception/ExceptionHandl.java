package Exception;

public class ExceptionHandl {
	public static void main(String args[]) {
		int a = 10000;
		int b=2;
		try{
			int c=a/b;
			System.out.println("This is try block");
			}
		catch(Exception e) //if you know about exception then you can mention name ex:(ArithmeticException e)
		{
			System.out.println("This is Catch block");
			}
		}

}
