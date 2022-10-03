import java.util.Scanner;

public class Testing {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mainMenu();

		System.out.println("Enter choice");
		int choice = scan.nextInt();
		
		switch(choice) {
		case 1:
			 
			break;
		}
	}

	public static void mainMenu() {
		System.out.println("Welcome Resturent Management");
		System.out.println("1) Hotel Details");
		System.out.println("2) Admin ");
		System.out.println("3) Customer");
		System.out.println("4) Exit");
	}

}
