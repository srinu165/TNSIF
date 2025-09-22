package Task;

public class Task {

	public static void main(String[] args) {
		String r = "Hello Seenu This is TNS";
		System.out.println(r.length());
		try {
		System.out.println(r.charAt(34));
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
