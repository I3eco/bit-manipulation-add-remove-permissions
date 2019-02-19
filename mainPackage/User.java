package Main;

public class User {
	String name;
	private short permissions;

	User(String name) {
		this.name = name;
		this.permissions = 0;
	}
	
	public static boolean isYes (String yesNo) {
		if(yesNo.equals("Yes") ||
			yesNo.equals("yes") ||
			yesNo.equals("Y") ||
			yesNo.equals("y")) {
			return true;
		}
		
		return false;
	}
	
	public static boolean isNo (String yesNo) {
		if(yesNo.equals("No") ||
			yesNo.equals("no") ||
			yesNo.equals("N") ||
			yesNo.equals("n")) {
			return true;
		}
		
		return false;
	}
	
	private String checkPermission (short position) {
		String yesNo;
		short check = this.permissions;
		check = (short) (check & (1 << position - 1));
		
		if(check != 0) {
			yesNo = "Yes";
		} else {
			yesNo = "No";		}
		
		return yesNo;
	}
	
	public void addPermission (short position) {
			this.permissions = (short) (this.permissions | (1 << position - 1));
	}
	
	public void removePermission (short position) {
		if (isYes(checkPermission(position))) {
			this.permissions = (short) (this.permissions ^ (1 << position - 1));
		}
	}

	public void showInfo(User u) {
		String yesNo = "";
		yesNo = checkPermission((short) 1);
		System.out.println("1. Can " + u.name + " be user: " + yesNo);
		yesNo = checkPermission((short) 2);
		System.out.println("2. Can " + u.name + " be VIP user: " + yesNo);
		yesNo = checkPermission((short) 3);
		System.out.println("3. Can " + u.name + " have read permissions: " + yesNo);
		yesNo = checkPermission((short) 4);
		System.out.println("4. Can " + u.name + " have read/write permissions: " + yesNo);
		yesNo = checkPermission((short) 5);
		System.out.println("5. Can " + u.name + " be admin: " + yesNo);
	}
	
	public static void showPermissions(User user) {
		String yesNo = "";
		System.out.println("Choose a number for permission to change :");
		yesNo = user.checkPermission((short) 1);
		System.out.println("1. User - " + yesNo);
		yesNo = user.checkPermission((short) 2);
		System.out.println("2. VIP user - " + yesNo);
		yesNo = user.checkPermission((short) 3);
		System.out.println("3. Read - " + yesNo);
		yesNo = user.checkPermission((short) 4);
		System.out.println("4. Read/Write - " + yesNo);
		yesNo = user.checkPermission((short) 5);
		System.out.println("5. Admin - " + yesNo);
	}

}
