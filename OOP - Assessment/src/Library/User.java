package Library;

import java.io.Serializable;


public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String firstName; 
	private String Surname; 
	private String address; 
	private String Town; 
	private String postcode; 
	private String phoneNo; 
	private String dob; 
	private String password;
	private int borrowAmount;
		
	private UserType grade;
	
	//private ArrayList<stock> currentHolding;
	
	public User(String userName, String firstName, String Surname, String address, String Town, String postcode, String phoneNo, String dob, String password, int borrowAmount, UserType grade) { 
		this.userName = userName;
		this.firstName = firstName;
		this.Surname = Surname; 
		this.address = address; 
		this.Town = Town; 
		this.postcode = postcode; 
		this.phoneNo = phoneNo; 
		this.dob = dob; 
		this.password = password; 
		this.borrowAmount = borrowAmount;
		this.grade = grade; 
	}	
	
	// Getters and setters	
	public String getUserName() { 
		return userName; 
	}
	
	public void setUsername(String userName) { 
		this.userName = userName; 
	}
	
	public String getfName() { 
		return firstName; 
	}
	
	public void setfName(String firstName) { 
		this.firstName = firstName; 		 
	}
	
	public String getPassword() { 
		return password; 
	}
	
	public void setPassword(String Password) { 
		this.password = Password; 
	}
	
	
	public String getSurname() { 
		return Surname;
	}
	
	public void setSurname(String surname) { 
		this.Surname = surname;
	}
	
	public String getAddress() { 
		return address; 
	}
	
	public void setAddress(String address) { 
		this.address = address; 
	}
	
	public String getTown() { 
		return Town;
	}
	
	public void setTown(String Town) { 
		this.Town = Town;
	}
	
	public String getPostCode() { 
		return postcode; 
	}
	
	public void setPostcode(String postcode) { 
		this.postcode = postcode; 
	}
	
	public String getPhoneNo() { 
		return phoneNo; 
	}
	
	public void setPhoneNo(String phoneNo) { 
		this.phoneNo = phoneNo; 
	}
	
	public String getDOB() { 
		return dob; 
	}
	
	public void setDOB(String dob) { 
		this.dob = dob; 
	}
	
	
	public UserType getType() { 
		return grade; 
	}
	
	// Get Full member borrow Amount
	public int getBorrowAmount() { 
		return borrowAmount;
	}
	
	public void setBorrowAmount(int b) { 
		this.borrowAmount = b--; 
	}
	
	@Override
	public String toString() { 
		return "Username: " + userName +"\nName: " + firstName + "\nSurname: " + Surname + "\nAddress: " + address + "\nTown: " + Town  + "\npostcode: " + postcode + "\nPhone Number: " 
			   + phoneNo + "\nDate of Birth: " + dob + "\npasssword: " + password + "\nUser Grade: " + grade;
	}	
}