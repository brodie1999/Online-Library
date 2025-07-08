package Library;
// Casual will extend from User and will inherit and set values like to UserType and BorrowAmount
public class Casual extends User{

	private static final long serialVersionUID = 1L;
	private UserType type = UserType.Casual;
	private static int borrowAmount = 0;
	
	public Casual(String userName, String firstName, String Surname, String address, String Town, String postcode, String phoneNo, String dob, String password, int borrowAmount, UserType type) { 
		super(userName, firstName, Surname, address, Town, postcode, phoneNo, dob, password, borrowAmount, type);		
	}
}
