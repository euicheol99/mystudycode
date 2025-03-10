package z.practice.interface1;

public class Run {
	public static void main(String[] args) {
		PhoneController pc= new PhoneController();
		for(String p : pc.method()) {
			System.out.println(p);
		}
		
		
	}
}
