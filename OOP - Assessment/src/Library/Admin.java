package Library;

public class Admin extends User  {
	// Admin class extends from stock and will store User values 
	private static final long serialVersionUID = 1L;
	private UserType type = UserType.Admin;
	private static int borrowAmount = 0;
	//Admin constructor  
	public Admin(String userName, String firstName, String Surname, String address, String Town, String postcode, String phoneNo, String dob, String password, int borrowAmount, UserType type) { 
		super(userName, firstName, Surname, address, Town, postcode, phoneNo, dob, password, borrowAmount, type);		
	}

}
