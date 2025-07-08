package Library;
// FullMem will extend from User and will inherit and set values like to UserType and BorrowAmount
public class FullMem extends User{
	
	private static final long serialVersionUID = 1L;
	private UserType type = UserType.Full;
	private static int borrowAmount = 4; 
	
	public FullMem(String userName, String firstName, String Surname, String address, String Town, String postcode, String phoneNo, String dob, String password, int borrowAmount, UserType type) { 
		super(userName, firstName, Surname, address, Town, postcode, phoneNo, dob, password, borrowAmount, type);
		
	}	
}