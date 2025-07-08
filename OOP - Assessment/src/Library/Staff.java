package Library;

public class Staff extends User {
	// Staff class extends from stock and will store user values and set a borrowAmount and UserType for this user

	private static final long serialVersionUID = 1L;
	private UserType type = UserType.Staff;
	private static int borrowAmount = 6;
	// Staff constructor
	public Staff(String userName, String firstName, String Surname, String address, String Town, String postcode, String phoneNo, String dob, String password, int borrowAmount, UserType type) { 
		super(userName, firstName, Surname, address, Town, postcode, phoneNo, dob, password, borrowAmount, type);		
	}	
}