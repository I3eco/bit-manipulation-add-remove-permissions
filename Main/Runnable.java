package Main;

import java.util.Scanner;

public class Runnable {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String check = "Yes";
		
		System.out.println("Please give name of the user: ");
		User user = new User(sc.nextLine());
		
		do {
			System.out.println("Do you want to change a permission: Yes/No");
			if (User.isYes(sc.nextLine())) {
				System.out.println("Do you want to give permission (answer No to remove): Yes/No");
				if (User.isYes(sc.nextLine())) {
					User.showPermissions(user);
					user.addPermission(sc.nextShort());
					sc.nextLine();
				} else {
					User.showPermissions(user);
					user.removePermission(sc.nextShort());
					sc.nextLine();
				}
				user.showInfo(user);
			}
			System.out.println("Do you want to continue: Yes/No");
			check = sc.nextLine();
		} while (User.isYes(check));


	}

}
