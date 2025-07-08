package Library;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.text.SimpleDateFormat;
import java.awt.desktop.UserSessionEvent;
import java.io.*;
// Main class This will house all main functions for users
public class Glencaldy implements Serializable {

	private static final long serialVersionUID = 1L;
	//Create user List
	public static ArrayList<User> users = new ArrayList<User>(); // Must be public in order for Catalogue to access
	public static ArrayList<Stock> stock = new ArrayList<Stock>(); // Must be public in order for Catalogue to access

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		
		// DE-Serialize Array upon startup
		try { 
			
			//Create Users 
			FullMem adam = new FullMem("GoodSoup", "Adam", "Driver", "90 Kirkcaldy street", "Kirkcaldy", "KY9 XYR", "0159223489", "10/11/1998", "fifeCollege2021", 4, UserType.Full);
			FullMem coop = new FullMem("InterCoop", "Cooper", "McConaughey", "1 Gargantua", "Space", "GXX GKY", "01233 9087", "04/11/1969", "Intersteller", 4, UserType.Full);
			FullMem iain = new FullMem("iainBanks21", "Iain", "Banks", "17 Barn road", "Edinburgh", "EH11 8HB", "01782 5567", "11/03/1989", "Banks22", 4, UserType.Full);
			Casual don = new Casual("FamilyIsKey","Don", "Family", "56 Lochgelly", "Lochgelly", "KY5 TYU", "01592 34980", "19/12/1990", "fifeCollege2020", 0,  UserType.Casual);
			Casual alex = new Casual("AlexATP","Alexander", "Zverev", "81 Sydney", "Melbourne", "MUI UHG", "01765 23590", "20/04/1997", "ZverevAUS", 0,  UserType.Casual);
			Casual Stef = new Casual("StefanNum1","Stefanous", "Tsitsipas", "01 Greek Palace", "Greece", "GEE IPO", "45512 24345", "12/07/1998", "StefanoTheGreat", 0,  UserType.Casual);
			Admin chief = new Admin("Weapon", "Master", "Chief", "49 Zeta ring", "Halo", "HTY XUR", "117", "12/12/2546", "halo", 1, UserType.Admin);
			Staff john = new Staff("xComunicado", "John", "Wick", "78 Mustang Place", "Continental", "KYT CVR", "01787 34982", "02/09/1964", "parabellum", 6, UserType.Staff);
			Staff jack = new Staff("JWall99", "Jack", "Wall", "56 Black ops", "Treyarch", "KY2 XTB", "07869 512876", "12/11/1989", "Adren2", 6, UserType.Staff);
			Staff joel = new Staff("TheLastOfJoel", "Joel", "Miller", "5 TLOU Place", "TLOU", "TLO JUK", "07891 29345", "18/07/1967", "MillerJoel", 6, UserType.Staff);
			
			users.add(adam);
			users.add(coop);
			users.add(iain);
			users.add(don);
			users.add(alex);
			users.add(Stef);
			users.add(chief); 
			users.add(john);
			users.add(jack);
			users.add(joel);
		
//			// This will make users persistent throughout the app
//			//String userPath = "F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserInfo\\Info.ser";
//			String userPath = "C:\\OOP - Assessment\\UserInfo\\Info.ser";
//			FileOutputStream sins = new FileOutputStream(userPath);
//			ObjectOutputStream oins = new ObjectOutputStream(sins);
//			oins.writeObject(users);
//			System.out.println("Stock written to file");	
//			oins.close();
//			sins.close();
			
			//Create stock
			Book Shining = new Book("1", 92, "Stephen King", "The Shining", 3.50, "Horror", "Doubleday", 310, ItemType.book, false, "N/A");
			Book cyberpunk = new Book("2", 1001, "Philip K. Dick", "Do Androids Dream of Electric Sheep", 4.99, "Science Fiction", "Doubleday", 210, ItemType.book, false, "N/A");
			Journal journal1 = new Journal("1", 1101, 1, "01/04/2017", "Java life", 2.00, "Coding", "Fife College", 115, ItemType.journals, false, "N/A");
			Journal journal2 = new Journal("2", 1101, 2, "01/07/2019", "Java the hut", 5.49, "lifestyle", "Fife College", 105, ItemType.journals, false, "N/A");
			Video spiderMan = new Video("1", 167, "MP4", "Action", "Spider-man: No Way Home", 15.00, "Marvel", "DVD", ItemType.video, false, "N/A");
			Video venom = new Video("2", 145, "MP4", "Action", "Venom: Let there be Carnage", 12.00, "Marvel", "DVD", ItemType.video, false, "N/A");
			Video witcher = new Video("3", 451, "MP4", "Action/Adventure", "The Witcher", 17.99, "Netflix", "DVD", ItemType.video, false, "xComunicado");
			Disc BlackKeys = new Disc("1", 78, "CD", 1, "The Black Keys", "Attack & Release", 8.00, "Easy Eye", "Disk Case", ItemType.compactDisc, false, "N/A");
			Disc RCHP = new Disc("2", 67, "CD", 1, "Red Hot Chilli Peppers", "Stadium Arcadium", 6.00, "Warner", "Disk Case", ItemType.compactDisc, false, "N/A");
			
			// Add stock	
			stock.add(Shining);
			stock.add(cyberpunk);
			stock.add(journal1); 
			stock.add(journal2);
			stock.add(spiderMan); 
			stock.add(venom); 
			stock.add(witcher);
			stock.add(BlackKeys); 
			stock.add(RCHP);
						
			// This will save all objects of Users. If Users password is changed. 
			// This will save all instances of stock objects. If any loans are changed etc this will load them in upon beginning
			//String userPath1 = "F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserInfo\\info.ser";
			String userPath1 = "C:\\OOP - Assessment\\UserInfo\\info.ser";		
			FileInputStream file = new FileInputStream(userPath1);
     		ObjectInputStream object = new ObjectInputStream(file);
			users = (ArrayList<User>) object.readObject();
			
			file.close();
			object.close(); 	
			// De - Serialize Array Upon startup			
			String stockPath = "C:\\OOP - Assessment\\stockInfo\\stockInfo.ser";
			FileInputStream sins1 = new FileInputStream(stockPath);
     		ObjectInputStream oins1 = new ObjectInputStream(sins1);
			stock = (ArrayList<Stock>) oins1.readObject();
			
			oins1.close();
			sins1.close(); 
					
			System.out.println("De-Serialized ArrayList(User) data saved in info.ser\n");
			System.out.println("De-Serialized ArrayList(stock) data saved in stockInfo.ser\n");
			System.out.println("Loading Glencaldy Library system....");
			login();			
			} catch (EOFException e) {				
				System.out.println("Error. End of file");
			} catch (ClassNotFoundException ioe) {
				System.out.println("Error! file not found");				
			} 		
	} // End of Main
	
	// Allows users to edit their profile 
	private void editProfile() {
		// Allow user to edit their profile
		String l; 
		do { 
			Scanner scan = new Scanner(System.in);			
			System.out.println("What would you like to edit?:");
			System.out.println("1 - Change username");
			System.out.println("2 - Change Password");
			System.out.println("3 - Change Address");
			System.out.println("4 - Change Firstname");
			System.out.println("5 - Change surname");
			System.out.println("6 - Change Town");
			System.out.println("7 - Change Postcode");
			System.out.println("8 - Change Phone Number");
			System.out.println("9 - Change Date of birth");
			System.out.println("10 - Menu");
			l = scan.next(); 
			
			switch(l) { 
			case "1": // Change username
				Scanner username = new Scanner(System.in);
				String uname;
				System.out.println("To change your username, please enter your Username to begin:");
				// Get password
				System.out.println("Enter your username: ");
				uname = username.nextLine();
				
				Iterator<User> us = users.iterator();
				while (us.hasNext()) { 
					User Users = us.next();
					
					if (Users.getUserName().contains(uname)) {
						// use setPassword setter
						Scanner newUname = new Scanner(System.in);
						
						System.out.println("Enter your new username: ");
						String newUsername = newUname.next();
						
						Users.setUsername(newUsername);				
						System.out.println("Your new username is: " + newUsername);
						//newPword.close();
						Catalogue catalogue = new Catalogue();
						catalogue.genInstanceReport();
						
						// Serialize Array					
						try { 
							//FileOutputStream fos = new FileOutputStream("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserInfo\\info.ser");
							FileOutputStream fos = new FileOutputStream("C:\\OOP - Assessment\\UserInfo\\info.ser");
							ObjectOutputStream oos = new ObjectOutputStream(fos);
							oos.writeObject(users);
							oos.close(); 
							fos.close(); 
							System.out.printf("Serialized ArrayList(Users) data saved in info.ser\n");						
						}catch (IOException ioe) { 
							System.out.println("Error! file not found");
							ioe.printStackTrace();
						}
						
						Catalogue catalogue1 = new Catalogue();
						catalogue1.genInstanceReport();
					System.out.println("Please login with your new username");
					login();
					}	
				}
				break; 
			case "2": // Change password
				Scanner password = new Scanner(System.in);
				String pword;
				System.out.println("To change your password, please enter your password to begin:");
				// Get password
				System.out.println("Enter your password: ");
				pword = password.nextLine();
				// if statement to check which user is changing their password
				Iterator<User> u = users.iterator();
				while (u.hasNext()) { 
					User Users = u.next();
					
					if (Users.getPassword().contains(pword)) {
						// use setPassword setter
						Scanner newPword = new Scanner(System.in);
						
						System.out.println("Enter your new password: ");
						String newPassword = newPword.next();
						
						Users.setPassword(newPassword);				
						System.out.println("Your new password is: " + newPassword);						
					}	
				}
					Catalogue catalogue2 = new Catalogue();
					catalogue2.genInstanceReport();
					
					// Serialize Array					
					try { 
						//FileOutputStream fos = new FileOutputStream("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserInfo\\info.ser");
						FileOutputStream fos = new FileOutputStream("C:\\OOP - Assessment\\UserInfo\\info.ser");
						ObjectOutputStream oos = new ObjectOutputStream(fos);
						oos.writeObject(users);
						oos.close(); 
						fos.close(); 
						System.out.printf("Serialized ArrayList(Users) data saved in info.ser\n");						
					}catch (IOException ioe) { 
						System.out.println("Error! file not found");						
					}
					
				System.out.println("Please login with your new password");
				login();
				break; 
			case "3": // Change Address
				Scanner UserName = new Scanner(System.in);
				String uName;
				System.out.println("Enter your userName to change your Address: "); 				
				uName = UserName.next(); 
				
				Iterator<User> use = users.iterator(); 
				while (use.hasNext()) { 
					User o = use.next(); 
					
					if (o.getUserName().contains(uName)) {
						Scanner newAddress = new Scanner(System.in); 
						System.out.println("Enter your new Address: ");
						String address = newAddress.nextLine(); 
						address.trim();
						o.setAddress(address);
						System.out.println("Your new Address is: " + o.getAddress());
					}					
				}
				
				Catalogue catalogue3 = new Catalogue();
				catalogue3.genInstanceReport();
					
					// Serialize Array					
					try { 
						//FileOutputStream fos = new FileOutputStream("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserInfo\\info.ser");
						FileOutputStream fos = new FileOutputStream("C:\\OOP - Assessment\\UserInfo\\info.ser");
						ObjectOutputStream oos = new ObjectOutputStream(fos);
						oos.writeObject(users);
						oos.close(); 
						fos.close(); 
						System.out.printf("Serialized ArrayList(Users) data saved in info.ser\n");						
					}catch (IOException ioe) { 
						System.out.println("Error! file not found");
						//ioe.printStackTrace();
					}
					
				System.out.println("Please login to make changes");
				login();
				break; 
			case "4": // Change FirstName
				Scanner un = new Scanner(System.in);
				String userName;
				System.out.println("Enter your userName to change your firstname: "); 				
				userName = un.next(); 
				
				Iterator<User> user = users.iterator(); 
				while (user.hasNext()) { 
					User o = user.next(); 
					
					if (o.getUserName().contains(userName)) {
						Scanner newName = new Scanner(System.in); 
						System.out.println("Enter your new name: ");
						String fName = newName.nextLine(); 
						fName.trim();
						o.setfName(fName);
						System.out.println("Your first name is now: " + o.getfName());
					}					
				}
					// Serialize Array					
					try { 
						//FileOutputStream fos = new FileOutputStream("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserInfo\\info.ser");
						FileOutputStream fos = new FileOutputStream("C:\\OOP - Assessment\\UserInfo\\info.ser");
						ObjectOutputStream oos = new ObjectOutputStream(fos);
						oos.writeObject(users);
						oos.close(); 
						fos.close(); 
						System.out.printf("Serialized ArrayList(Users) data saved in info.ser\n");						
					}catch (IOException ioe) { 
						System.out.println("Error! file not found");						
					}
					
					//This will generate an instance report before making the user to login.
				Catalogue catalogue4 = new Catalogue();
				catalogue4.genInstanceReport();
				
				System.out.println("Please login to make changes");
				login();
				
				break; 
			case "5": // Change surname
				Scanner un1 = new Scanner(System.in);
				String userName1;
				System.out.println("Enter your userName to change your firstname: "); 				
				userName1 = un1.next(); 
				
				Iterator<User> user1 = users.iterator(); 
				while (user1.hasNext()) { 
					User o = user1.next(); 
					
					if (o.getUserName().contains(userName1)) {
						Scanner newSurname = new Scanner(System.in); 
						System.out.println("Enter your new name: ");
						String sName = newSurname.nextLine(); 
						sName.trim();
						o.setSurname(sName);
						System.out.println("Your first name is now: " + o.getSurname());
					}					
				}
				//This will generate an instance report before making the user to login.
				Catalogue catalogue5 = new Catalogue();
				catalogue5.genInstanceReport();
					
					// Serialize Array					
					try { 
						//FileOutputStream fos = new FileOutputStream("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserInfo\\info.ser");
						FileOutputStream fos = new FileOutputStream("C:\\OOP - Assessment\\UserInfo\\info.ser");
						ObjectOutputStream oos = new ObjectOutputStream(fos);
						oos.writeObject(users);
						oos.close(); 
						fos.close(); 
						System.out.printf("Serialized ArrayList(Users) data saved in info.ser\n");						
					}catch (IOException ioe) { 
						System.out.println("Error! file not found");
						
					}					
				System.out.println("Please login to make changes");
				login();
				break; 
			case "6": // Change Town
				Scanner un2 = new Scanner(System.in);
				String userName2; 
				System.out.println("Enter your Username to change your Town: ");
				userName2 = un2.next(); 
				
				Iterator<User> user2 = users.iterator();
				while(user2.hasNext()) { 
					User o = user2.next();
					
					if (o.getUserName().contains(userName2)) { 
						Scanner newTown = new Scanner(System.in);
						System.out.println("Enter your new Town: ");
						String town = newTown.next(); 
						town.trim(); 
						o.setTown(town);
						System.out.println("Your new Town is: " + o.getTown());
					}
				}
				
				Catalogue catalogue6 = new Catalogue();
				catalogue6.genInstanceReport();
					
					// Serialize Array					
					try { 
						//FileOutputStream fos = new FileOutputStream("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserInfo\\info.ser");
						FileOutputStream fos = new FileOutputStream("C:\\OOP - Assessment\\UserInfo\\info.ser");
						ObjectOutputStream oos = new ObjectOutputStream(fos);
						oos.writeObject(users);
						oos.close(); 
						fos.close(); 
						System.out.printf("Serialized ArrayList(Users) data saved in info.ser\n");						
					}catch (IOException ioe) { 
						System.out.println("Error! file not found");
						
					}
					
				System.out.println("Please login to make changes");
				login();
				break;
			case "7": // Change Postcode
				Scanner un3 = new Scanner(System.in);
				String userName3; 
				System.out.println("Enter your username in order to change your Post code"); 
				userName3 = un3.next(); 
				
				Iterator<User> user3 = users.iterator(); 
				while(user3.hasNext()) { 
					User o = user3.next(); 
					
					if (o.getUserName().contains(userName3)) { 
						Scanner post = new Scanner(System.in); 
						System.out.println("Enter your new PostCode: ");
						String postCode = post.next(); 
						
						postCode.trim(); 
						
						o.setPostcode(postCode);
						System.out.println("Your new postcode is: " + o.getPostCode());
					}
				}
				
				Catalogue catalogue7 = new Catalogue();
				catalogue7.genInstanceReport();
					
					// Serialize Array					
					try { 
						//FileOutputStream fos = new FileOutputStream("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserInfo\\info.ser");
						FileOutputStream fos = new FileOutputStream("C:\\OOP - Assessment\\UserInfo\\info.ser");
						ObjectOutputStream oos = new ObjectOutputStream(fos);
						oos.writeObject(users);
						oos.close(); 
						fos.close(); 
						System.out.printf("Serialized ArrayList(Users) data saved in info.ser\n");						
					}catch (IOException ioe) { 
						System.out.println("Error! file not found");
						
					}
					
				System.out.println("Please login to make changes");
				login();
				break;
			case "8": // PhoneNumber 
				Scanner un4 = new Scanner(System.in); 
				String userName4; 
				System.out.println("Enter your username in order to change your PhoneNumber: ");
				userName4 = un4.next(); 
				
				Iterator<User> user4 = users.iterator(); 
				while(user4.hasNext()) { 
					User o = user4.next(); 
					
					if (o.getUserName().contains(userName4)) { 
						Scanner phone = new Scanner(System.in); 
						System.out.println("Enter your new Phone Number: ");
						String phoneNumber = phone.next(); 
						
						phoneNumber.trim(); 
						
						o.setPhoneNo(phoneNumber);
						System.out.println("Your new Phone Number is: " + o.getPhoneNo());
					}
				}
				
				Catalogue catalogue8 = new Catalogue();
				catalogue8.genInstanceReport();
					
					// Serialize Array					
					try { 
						//FileOutputStream fos = new FileOutputStream("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserInfo\\info.ser");
						FileOutputStream fos = new FileOutputStream("C:\\OOP - Assessment\\UserInfo\\info.ser");
						ObjectOutputStream oos = new ObjectOutputStream(fos);
						oos.writeObject(users);
						oos.close(); 
						fos.close(); 
						System.out.printf("Serialized ArrayList(Users) data saved in info.ser\n");						
					}catch (IOException ioe) { 
						System.out.println("Error! file not found");
						
					}
					System.out.println("Please login to make changes");
					login();
				break;
			case "9": // Date of birth 
				Scanner un5 = new Scanner(System.in); 
				String userName5; 
				System.out.println("Enter your username in order to change your DoB: ");
				userName5 = un5.next(); 
				
				Iterator<User> user5 = users.iterator(); 
				while(user5.hasNext()) { 
					User o = user5.next(); 
					
					if (o.getUserName().contains(userName5)) { 
						Scanner DOB = new Scanner(System.in); 
						System.out.println("Enter your new Phone Number: ");
						String DoB = DOB.next(); 
						
						DoB.trim(); 
						
						o.setDOB(DoB);
						System.out.println("Your new Phone Number is: " + o.getDOB());
					}
				}
				
				Catalogue catalogue9 = new Catalogue();
				catalogue9.genInstanceReport();
					
					// Serialize Array					
					try { 
						//FileOutputStream fos = new FileOutputStream("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserInfo\\info.ser");
						FileOutputStream fos = new FileOutputStream("C:\\OOP - Assessment\\UserInfo\\info.ser");
						ObjectOutputStream oos = new ObjectOutputStream(fos);
						oos.writeObject(users);
						oos.close(); 
						fos.close(); 
						System.out.printf("Serialized ArrayList(Users) data saved in info.ser\n");						
					}catch (IOException ioe) { 
						System.out.println("Error! file not found");
						
					}
					System.out.println("Please login to make changes");
					login();
				break;
			case "10": // Exit to menu 
				// This saves the user from having to login back into the program. 
				Scanner getUser = new Scanner(System.in); 
				String currentUser;
				
				System.out.println("Enter your UserName: ");
				currentUser = getUser.next(); 
				
				Iterator<User> User = users.iterator(); 
				while (User.hasNext()) { 
					User o = User.next();
					if (o.getUserName().contains(currentUser)) { 
						if (o.getType() == UserType.Staff) { 
							staffMenu();
						} else if (o.getType() == UserType.Casual) { 
							CasualMenu();
						} else if (o.getType() == UserType.Full) { 
							fullMenu();
						}
					}
				}				
				break;
			default: 
				System.out.println("Error. Incorrect input");
				break; 
			}
		} while (l != "10");
	} // End of Change Password
	// View all current users on the app
	private void viewAllUsers() { 
		String l; 
		do {
			Scanner option = new Scanner(System.in);
			System.out.println("Options: ");
			System.out.println("1 - View all Admin users");
			System.out.println("2 - View all Staff users");
			System.out.println("3 - View all Full users");
			System.out.println("4 - View all casual users");
			System.out.println("5 - Menu");
			l = option.next();
		
			switch(l) { 
			case "1": // View all Admin users
				Iterator<User> u = users.iterator(); 
				while(u.hasNext()) { 
					User user = u.next(); 
					if (user.getType() == UserType.Admin) { 
						System.out.println("\n*** All Admin users ***\n");
						System.out.println("Username: " + user.getUserName());
						System.out.println("Name: " + user.getfName() + "\n");
					}
				}
				break;
			case "2": // View all Staff users
				Iterator<User> u1 = users.iterator(); 
				while(u1.hasNext()) { 
					User user = u1.next(); 
					if (user.getType() == UserType.Staff) { 
						System.out.println("\n*** All Staff users ***\n");
						System.out.println("Username: " + user.getUserName());
						System.out.println("Name: " + user.getfName());
						System.out.println("Password: " + user.getPassword() + "\n");
					}
				}
				break;
			case "3": // View all Full users
				Iterator<User> u2 = users.iterator(); 
				while(u2.hasNext()) { 
					User user = u2.next(); 
					if (user.getType() == UserType.Full) { 
						System.out.println("\n*** All Full users ***\n");
						System.out.println("Username: " + user.getUserName());
						System.out.println("Name: " + user.getfName());
						System.out.println("Password: " + user.getPassword() + "\n");
						System.out.println("Borrow Amount: " + user.getBorrowAmount() + "\n");
					}
				}
				break;
			case "4":
				Iterator<User> u3 = users.iterator(); 
				while(u3.hasNext()) { 
					User user = u3.next(); 
					if (user.getType() == UserType.Casual) { 
						System.out.println("\n*** All Casual users ***\n");
						System.out.println("Username: " + user.getUserName());
						System.out.println("Name: " + user.getfName());
						System.out.println("Password: " + user.getPassword() + "\n");
					}
				}
				break;
			case "5": 
				adminMenu();
				break; 
			default: 
				System.out.println("Incorrect input");
				break;
			}
		} while (l != "5");
	}
	// List all logins 
	private void listLogins() {  
		String l; 
		do {
			Scanner logs = new Scanner(System.in);
			System.out.println("Options: ");
			System.out.println("1 - View Admin logs");
			System.out.println("2 - View staff logs");
			System.out.println("3 - View Full user logs");
			System.out.println("4 - View casual user logs");
			System.out.println("5 - Menu");
			l = logs.next(); 
			
			switch (l) { 
			case "1": // View admin logs
				try {
					
					//File f = new File("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\LoginAdmin.txt");
					File f = new File("C:\\OOP - Assessment\\LoginAdmin.txt");
					if (f.exists()) {
						System.out.println("All Admin logs:");
						Scanner reader = new Scanner(f);
						while (reader.hasNextLine()) { 
							String log = reader.nextLine();
							System.out.println(log);
						}			
					} else { 
						System.out.println("No Admin logs to show");
					}
				} catch (FileNotFoundException e) {
					System.out.println("Error. File not found");
				}
				break;
			case "2": // View Staff logs
				try {				
					//File f = new File("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\LoginStaff.txt");
					File f = new File("C:\\OOP - Assessment\\LoginStaff.txt");
					if (f.exists()) {
						System.out.println("All Staff logs:");
						Scanner reader = new Scanner(f);
						while (reader.hasNextLine()) { 
							String log = reader.nextLine();
							System.out.println(log);
						}			
					} else { 
						System.out.println("No Staff logs to show");
						}
					
					} catch (FileNotFoundException e) {
						System.out.println("Error. File not found");
					}
				break; 
			case "3": 
				try {				
					//File f = new File("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\LoginFull.txt");
					File f = new File("C:\\OOP - Assessment\\LoginFull.txt");
					if (f.exists()) {
						System.out.println("All Full user logs:");
						Scanner reader = new Scanner(f);
						while (reader.hasNextLine()) { 
							String log = reader.nextLine();
							System.out.println(log);
						}			
					} else { 
						System.out.println("No Full member logs to show");
						}
					
					} catch (FileNotFoundException e) {
						System.out.println("Error. File not found");
					}
				break; 
			case "4": 
				try {				
					//File f = new File("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\LoginCasual.txt");
					File f = new File("C:\\OOP - Assessment\\LoginCasual.txt");
					if (f.exists()) {
						System.out.println("All Full user logs:");
						Scanner reader = new Scanner(f);
						while (reader.hasNextLine()) { 
							String log = reader.nextLine();
							System.out.println(log);
						}							
					} else { 
						System.out.println("No Casual Member logs to show");
						}				
					} catch (FileNotFoundException e) {
						System.out.println("Error. File not found");
					}			
				break;
			case "5": 
				adminMenu();
				break;
			default: 
				System.out.println("Error. Incorrect input");
				break;
			}
		} while (l != "5");
	}
	// Display Login menu to users
	public static void login() { 
		Scanner log = new Scanner(System.in);		
		//Variables go here
		String in;
	
		try {
			do {
				
				System.out.println("Welcome to Glencaldy Library System");
				System.out.println("===================================\n");
				System.out.println("1 - Login");
				System.out.println("2 - Exit");
				log.hasNext();
				in = log.next();
							
				switch(in) { 				
				case "1": 
					System.out.println("Please enter your login details");
					Scanner usr = new Scanner (System.in);
					Scanner pwd = new Scanner (System.in);					
					
					String userName, password;
					
					System.out.println("Enter your Username: ");				
					userName = usr.nextLine();				
					
					System.out.println("Enter your password: ");
					password = pwd.nextLine();	
					
					Iterator<User> u = users.iterator();
					while (u.hasNext()) {										
						User Users = u.next();
						
						if (Users.getUserName().contains(userName) && Users.getPassword().contains(password) && Users.getType()  == UserType.Admin) { 					 
							try { 
								//Get login details of the user that has currently logged and write to file									
									//FileWriter myWriter = new FileWriter("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\LoginAdmin.txt", true);	
									FileWriter myWriter = new FileWriter("C:\\OOP - Assessment\\LoginAdmin.txt", true);
									// Write username and grade to file 								
									myWriter.write("\nUser: " + Users.getUserName() + " Grade: " + Users.getType());
									SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
									Date date = new Date();
									myWriter.write("\nLogin in time: " + formatter.format(date));
									myWriter.close();	 
								} catch (IOException e) { 
									System.out.println("An error occured");
									//e.printStackTrace();
								}		
							
								System.out.println("Welcome " + Users.getfName() + " to Glencaldy Library\n");
								Glencaldy cat = new Glencaldy();
								cat.adminMenu();							
					 }
					if (Users.getUserName().contains(userName) && Users.getPassword().contains(password) && Users.getType() == UserType.Full) { 					 
						try {						
							
							//FileWriter myWriter = new FileWriter("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\LoginFull.txt", true);
							FileWriter myWriter = new FileWriter("C:\\OOP - Assessment\\LoginFull.txt", true);
							SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
							Date date = new Date();
							myWriter.write("User: " + Users.toString() + "\nLogin in time: " + formatter.format(date));
							myWriter.close();	
						
							//FileWriter userWriter = new FileWriter("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserLogin\\" + Users.getUserName() + ".txt", true);	
							FileWriter userWriter = new FileWriter("C:\\OOP - Assessment\\UserLogin\\" + Users.getUserName() + ".txt", true);
							Date uDate = new Date(); 
							userWriter.write("\nUsername: " + Users.getUserName() + "\nLogin in time: " + formatter.format(uDate));
							userWriter.close(); 
							
							} catch (IOException e) { 
								System.out.println("An error occured");
								//e.printStackTrace();
						}						
						System.out.println("Welcome " + Users.getfName() + " to Glencaldy Library\n");
						Glencaldy cat = new Glencaldy();
						cat.fullMenu();											
					 } 
					if (Users.getUserName().contains(userName) && Users.getPassword().contains(password) && Users.getType() == UserType.Staff) { 					 
						try {						
							//FileWriter myWriter = new FileWriter("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\LoginStaff.txt", true);
							FileWriter myWriter = new FileWriter("C:\\OOP - Assessment\\LoginStaff.txt", true);
							SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
							Date date = new Date();
							myWriter.write("User: " + Users.toString() + "\nLogin in time: " + formatter.format(date));
							myWriter.close();		
							
							//FileWriter userWriter = new FileWriter("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserLogin\\" + Users.getUserName() + ".txt", true);	
							FileWriter userWriter = new FileWriter("C:\\OOP - Assessment\\UserLogin\\" + Users.getUserName() + ".txt", true);
							Date uDate = new Date(); 
							userWriter.write("\nUsername: " + Users.getUserName() + "\nLogin in time: " + formatter.format(uDate));
							userWriter.close();
							
							} catch (IOException e) { 
								System.out.print("\nAn error occured\n");
								//e.printStackTrace();
						}						
						System.out.println("Welcome " + Users.getfName() + " to Glencaldy Library\n");
						Glencaldy cat = new Glencaldy();
						cat.staffMenu();											
					 } 
					if (Users.getUserName().contains(userName) && Users.getPassword().contains(password) && Users.getType() == UserType.Casual) { 					 
						try {						
							//FileWriter myWriter = new FileWriter("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\LoginCasual.txt", true);
							FileWriter myWriter = new FileWriter("C:\\OOP - Assessment\\LoginCasual.txt", true);
							SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
							Date date = new Date();
							myWriter.write("User: " + Users.toString() + "\nLogin in time: " + formatter.format(date));
							myWriter.close();	
							
							//FileWriter userWriter = new FileWriter("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserLogin\\" + Users.getUserName() + ".txt", true);						
							FileWriter userWriter = new FileWriter("C:\\OOP - Assessment\\UserLogin\\" + Users.getUserName() + ".txt", true);						
							Date uDate = new Date(); 
							userWriter.write("\nUsername: " + Users.getUserName() + "\nLogin in time: " + formatter.format(uDate));
							userWriter.close();
							
							} catch (IOException e) { 
								System.out.println("An error occured");
								//e.printStackTrace();
						}						
						System.out.println("Welcome " + Users.getfName() + " to Glencaldy Library *Casual Member*\n");
						Glencaldy cat = new Glencaldy();
						cat.CasualMenu();											
					 }
					
					// Display error message 
					if (!u.hasNext()) { 
						System.out.println("Error. User doesn't exist");
					}
				} // End of iterator			
					break; // End of case 1				
				case "2": 
					System.out.println("Exited Glencaldy Library System");
					
					// Serialize Array when closing
					try { 
						//FileOutputStream fos = new FileOutputStream("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserInfo\\info.ser");
						FileOutputStream fos = new FileOutputStream("C:\\OOP - Assessment\\UserInfo\\info.ser");
						ObjectOutputStream oos = new ObjectOutputStream(fos);
						oos.writeObject(users);
						oos.close(); 
						fos.close(); 
						System.out.printf("Serialized ArrayList(Users) data saved in info.ser\n");
						// This will save all instances of stock objects. If any loans are changed etc this will load them in upon beginning
						//FileOutputStream stocks = new FileOutputStream("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\stockInfo\\stockInfo.ser");
						FileOutputStream stocks = new FileOutputStream("C:\\OOP - Assessment\\stockInfo\\stockInfo.ser");
						ObjectOutputStream objectStockInfo = new ObjectOutputStream(stocks);
						objectStockInfo.writeObject(stock);
						stocks.close(); 
						objectStockInfo.close();
						
					}catch (IOException ioe) { 
						System.out.println("Error! file not found");
						ioe.printStackTrace();
					}
					
					System.exit(Integer.parseInt(in));
					
					break;
				default: 
					System.out.println("Error! Please enter the correct input");  
					break;
				}	//End of Switch
			
			} while (in != "2"); // End of While loop
		//log.close();
		} catch (NoSuchElementException e) { 
			//e.printStackTrace();
			System.out.println("Error caught");			
		}
	}
	// Display menu for Admins
	public void adminMenu() { 
		Scanner input = new Scanner(System.in);
		int selection;
		do {
			//Display menu			
			System.out.println("************** ADMIN ********************");
			System.out.println("Please select what you would like to do: ");
			System.out.println("1 - Search Library System");
			System.out.println("2 - Update user loans");
			System.out.println("3 - Add new items");
			System.out.println("4 - Add new User");
			System.out.println("5 - List all Users");
			System.out.println("6 - List all logins");
			System.out.println("7 - Record loan");
			System.out.println("8 - Edit stock");
			System.out.println("9 - View All Loans");
			System.out.println("0 - Exit");
			selection = input.nextInt();
			
			switch (selection) { 
			case 1: 
				// Search item class 
				Catalogue cat = new Catalogue();
				cat.search();
				break;
			case 2: 
				// Update user Loans							
				Catalogue update = new Catalogue(); 
				update.updateLoans();
				break; 
			case 3: 
				Catalogue add = new Catalogue();
				add.addItems();
				break;
			case 4: 
				addNewUsers();
				break; 
			case 5: 				 
				viewAllUsers();
				break; 
			case 6: 				
				listLogins();
				break;
			case 7: 
				Catalogue loan = new Catalogue(); 
				loan.loan();
				break;
			case 8:
				Catalogue editStock = new Catalogue();
				editStock.editStock();
				break;
			case 9: // View all Loans				
				try {
					//File dPath = new File("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserLoans");
					File dPath = new File("C:\\OOP - Assessment\\UserLoans");
					File files[] = dPath.listFiles();
					System.out.println("************* View All Loans *************");
					Scanner sc = null; 
					for (File file: files) { 
						//Instantiating scanner class
						try {
							sc = new Scanner(file);
							String input1; 
							StringBuffer sb = new StringBuffer();
							while(sc.hasNextLine()) { 
								input1 = sc.nextLine();
								sb.append(input1+" ");
							}
							System.out.println(sb.toString() + "\n");
						} catch (FileNotFoundException e) {
							System.out.println("Error file not found");
						}
					}
				} catch (NullPointerException f) { 
					System.out.println("Error! No Loans to display");
				}
				break;
			case 0:
				System.out.println("You have logged out");
				//Get log out date of logout time
			
				try { 									
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
					Date date = new Date();
					String textAppend = "\nLogout date: " + formatter.format(date);
					//BufferedWriter writer = new BufferedWriter(new FileWriter("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\LoginAdmin.txt", true));
					BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\OOP - Assessment\\LoginCasual.txt", true));
					writer.write(textAppend);
					writer.close();
				} catch (IOException e) { 
					System.out.println("An error has occured");
					
				}	
				// Serialize Array				
				try { 
					//FileOutputStream fos = new FileOutputStream("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserInfo\\info.ser");
					FileOutputStream fos = new FileOutputStream("C:\\OOP - Assessment\\UserInfo\\info.ser");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(users);
					oos.close(); 
					fos.close(); 
					System.out.printf("Serialized ArrayList(Users) data saved in info.ser\n");
					// This will save all instances of stock objects. If any loans are changed etc this will load them in upon beginning
					//FileOutputStream stocks = new FileOutputStream("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\stockInfo\\stockInfo.ser");
					FileOutputStream stocks = new FileOutputStream("C:\\OOP - Assessment\\stockInfo\\stockInfo.ser");
					ObjectOutputStream objectStockInfo = new ObjectOutputStream(stocks);
					objectStockInfo.writeObject(stock);
					stocks.close(); 
					objectStockInfo.close();
					
				}catch (IOException ioe) { 
					System.out.println("Error! file not found");
					ioe.printStackTrace();
				}
				
				System.exit(selection);
				break;
			default: 
				System.out.println("Error. Please enter the correct input");
				break;
			}
		} while(selection != 3);
		input.close();
	}
	// Add new user to the system 
	private void addNewUsers() {  
		Scanner input = new Scanner(System.in); 
		String l; 
		do {
			System.out.println("1 - Add Admin user");
			System.out.println("2 - Add Staff user");
			System.out.println("3 - Add Full user");
			System.out.println("4 - Add Casual user");
			System.out.println("5 - Menu");
			
			l = input.next(); 
			
			switch(l) {
			case "1": // Add Admin user
				System.out.println("\nAdd UserName: ");
				Scanner newUserName = new Scanner(System.in);
				String username = newUserName.next(); 
				
				System.out.println("Add password: ");
				Scanner newPassword = new Scanner(System.in); 
				String password = newPassword.next(); 
			
				System.out.println("Add firstname: ");
				Scanner newFName = new Scanner(System.in); 
				String uFirstName = newFName.next(); 
				
				System.out.println("Add surname: ");
				Scanner newSur = new Scanner(System.in); 
				String newSurname = newSur.next(); 
				
				System.out.println("Enter Address: ");
				Scanner newAddress = new Scanner(System.in); 
				String a = newAddress.next(); 
				
				System.out.println("Enter Town: ");
				Scanner t = new Scanner(System.in); 
				String town = t.next(); 
				
				System.out.println("Enter postcode: ");
				Scanner p = new Scanner(System.in); 
				String postCode = p.next(); 
				
				System.out.println("Enter PhoneNo: ");
				Scanner Num = new Scanner(System.in); 
				String phoneNum = Num.next(); 
				
				System.out.println("Enter DOB: ");
				Scanner d = new Scanner(System.in); 
				String dob = d.next(); 
				
				int borrowAmount = 0; 
				System.out.println("Admins cannot borrow Items themselves"); 
				
				UserType setGrade = UserType.Admin; 			
				
				users.add(new User(username, uFirstName, newSurname, a, town, postCode, phoneNum, dob, password, borrowAmount, setGrade));				
				
				System.out.println("Admin User has been added");
				Catalogue catalogue = new Catalogue();
				catalogue.genInstanceReport();
				// Serialize Array				
				try { 
					//FileOutputStream fos = new FileOutputStream("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserInfo\\info.ser");
					FileOutputStream fos = new FileOutputStream("C:\\OOP - Assessment\\UserInfo\\info.ser");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(users);
					oos.close(); 
					fos.close(); 
					System.out.printf("Serialized ArrayList(Users) data saved in info.ser\n");		
				} catch (IOException ioe) { 
					System.out.println("Error! file not found");					
				}
				
				break;
			case "2": // Add Staff User
				System.out.println("\nAdd UserName: ");
				Scanner newUserName1 = new Scanner(System.in);
				String username1 = newUserName1.next(); 
				
				System.out.println("Add password: ");
				Scanner newPassword1 = new Scanner(System.in); 
				String password1 = newPassword1.next(); 
								
				System.out.println("Add firstname: ");
				Scanner newFName1 = new Scanner(System.in); 
				String uFirstName1 = newFName1.next(); 
				
				System.out.println("Add surname: ");
				Scanner newSur1 = new Scanner(System.in); 
				String newSurname1 = newSur1.next(); 
				
				System.out.println("Enter Address: ");
				Scanner newAddress1 = new Scanner(System.in); 
				String a1 = newAddress1.next(); 
				
				System.out.println("Enter Town: ");
				Scanner t1 = new Scanner(System.in); 
				String town1 = t1.next(); 
				
				System.out.println("Enter postcode: ");
				Scanner p1 = new Scanner(System.in); 
				String postCode1 = p1.next(); 
				
				System.out.println("Enter PhoneNo: ");
				Scanner Num1 = new Scanner(System.in); 
				String phoneNum1 = Num1.next(); 
				
				System.out.println("Enter DOB: ");
				Scanner d1 = new Scanner(System.in); 
				String dob1 = d1.next(); 
				
				int borrowAmount1 = 6; 
				System.out.println("Borrow amount for staff set at: " + borrowAmount1);
				
				UserType setGrade1 = UserType.Staff; 			
				
				users.add(new User(username1, uFirstName1, newSurname1, a1, town1, postCode1, phoneNum1, dob1, password1, borrowAmount1, setGrade1));
				
				System.out.println("Staff User has been added");
				
				Catalogue catalogue1 = new Catalogue();
				catalogue1.genInstanceReport();
				// Serialize Array				
				try { 
					//FileOutputStream fos = new FileOutputStream("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserInfo\\info.ser");
					FileOutputStream fos = new FileOutputStream("C:\\OOP - Assessment\\UserInfo\\info.ser");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(users);
					oos.close(); 
					fos.close(); 
					System.out.printf("Serialized ArrayList(Users) data saved in info.ser\n");				
				} catch (IOException ioe) { 
					System.out.println("Error! file not found");					
				}
				
				break;
			case "3": // Add Full User
				System.out.println("\nAdd UserName: ");
				Scanner newUserName2 = new Scanner(System.in);
				String username2 = newUserName2.next(); 
				
				System.out.println("Add password: ");
				Scanner newPassword2 = new Scanner(System.in); 
				String password2 = newPassword2.next(); 
							
				System.out.println("Add firstname: ");
				Scanner newFName2 = new Scanner(System.in); 
				String uFirstName2 = newFName2.next(); 
				
				System.out.println("Add surname: ");
				Scanner newSur2 = new Scanner(System.in); 
				String newSurname2 = newSur2.next(); 
				
				System.out.println("Enter Address: ");
				Scanner newAddress2 = new Scanner(System.in); 
				String a2 = newAddress2.next(); 
				
				System.out.println("Enter Town: ");
				Scanner t2 = new Scanner(System.in); 
				String town2 = t2.next(); 
				
				System.out.println("Enter postcode: ");
				Scanner p2 = new Scanner(System.in); 
				String postCode2 = p2.next(); 
				
				System.out.println("Enter PhoneNo: ");
				Scanner Num2 = new Scanner(System.in); 
				String phoneNum2 = Num2.next(); 
				
				System.out.println("Enter DOB: ");
				Scanner d2 = new Scanner(System.in); 
				String dob2 = d2.next(); 
				
				int borrowAmount2 = 4; 
				System.out.println("Borrow amount set for full memebers at: " + borrowAmount2); 
				
				UserType setGrade2 = UserType.Full; 			
				
				users.add(new User(username2, uFirstName2, newSurname2, a2, town2, postCode2, phoneNum2, dob2, password2, borrowAmount2, setGrade2));
				
				System.out.println("\nFull User has been added\n");
				Catalogue catalogue2 = new Catalogue();
				catalogue2.genInstanceReport();
				// Serialize Array				
				try { 
					//FileOutputStream fos = new FileOutputStream("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserInfo\\info.ser");
					FileOutputStream fos = new FileOutputStream("C:\\OOP - Assessment\\UserInfo\\info.ser");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(users);
					oos.close(); 
					fos.close(); 
					System.out.printf("Serialized ArrayList(Users) data saved in info.ser\n");					
					
				} catch (IOException ioe) { 
					System.out.println("Error! file not found");					
				}
				
				break;
			case "4":
				System.out.println("\nAdd UserName: ");
				Scanner newUserName3 = new Scanner(System.in);
				String username3 = newUserName3.next(); 
				
				System.out.println("Add password: ");
				Scanner newPassword3 = new Scanner(System.in); 
				String password3 = newPassword3.next(); 
				
				Iterator<User> usersPass3 = users.iterator(); 
				while(usersPass3.hasNext()) { 
					User o = usersPass3.next(); 
					if (o.getPassword().contains(password3)) {
						System.out.println("Error. Password already exists");				
					}
				}
				
				System.out.println("Add firstname: ");
				Scanner newFName3 = new Scanner(System.in); 
				String uFirstName3 = newFName3.next(); 
				
				System.out.println("Add surname: ");
				Scanner newSur3 = new Scanner(System.in); 
				String newSurname3 = newSur3.next(); 
				
				System.out.println("Enter Address: ");
				Scanner newAddress3 = new Scanner(System.in); 
				String a3 = newAddress3.next(); 
				
				System.out.println("Enter Town: ");
				Scanner t3 = new Scanner(System.in); 
				String town3 = t3.next(); 
				
				System.out.println("Enter postcode: ");
				Scanner p3 = new Scanner(System.in); 
				String postCode3 = p3.next(); 
				
				System.out.println("Enter PhoneNo: ");
				Scanner Num3 = new Scanner(System.in); 
				String phoneNum3 = Num3.next(); 
				
				System.out.println("Enter DOB: ");
				Scanner d3 = new Scanner(System.in); 
				String dob3 = d3.next(); 
				
				int borrowAmount3 = 0; 
				
				System.out.println("Borrow amount for Casual user: " + borrowAmount3);
				
				UserType setGrade3 = UserType.Casual; 			
				
				users.add(new User(username3, uFirstName3, newSurname3, a3, town3, postCode3, phoneNum3, dob3, password3, borrowAmount3, setGrade3));
				System.out.println("Causal User has been added");
				
				Catalogue catalogue3 = new Catalogue();
				catalogue3.genInstanceReport();
				
				// Serialize Array				
				try { 
					//FileOutputStream fos = new FileOutputStream("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserInfo\\info.ser");
					FileOutputStream fos = new FileOutputStream("C:\\OOP - Assessment\\UserInfo\\info.ser");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(users);
					oos.close(); 
					fos.close(); 
					System.out.printf("Serialized ArrayList(Users) data saved in info.ser\n");						
				} catch (IOException ioe) { 
					System.out.println("Error! file not found");					
				}							
				break;
			case "5": 
				adminMenu(); 
				break; 
			}
			// Users can change their Username within their profile so if a duplicate occurs 
			// it won't effect the system 
			} while(l != "5");
	}
	// Display menu for full members
	public void fullMenu() { 
		Scanner input = new Scanner(System.in);
		String selection;
		do {
			//Display menu		
			System.out.println("************** FULL USER ********************");
			System.out.println("Please select what you would like to do: ");
			System.out.println("1 - Search Library System");
			System.out.println("2 - Edit Profile");
			System.out.println("3 - Info");
			System.out.println("4 - Login History");
			System.out.println("5 - Loan history");
			System.out.println("6 - Reserve Item");
			System.out.println("0 - Exit");
			selection = input.nextLine();
			
			switch (selection) { 
			case "1": 
				// Search item class 
				Catalogue cat = new Catalogue();
				cat.search();
				break;		
			case "2": 
				editProfile();
				break;
			case "3": // Give user info on what they can do within in the app
				System.out.println("You are currently a full user.");
				System.out.println("Full user members can reserve an item before it has become available to loan.");
				System.out.println("In order to reserve an item, go into 'Reserve Item' and see what is available to reserve");
				System.out.println("\n");
				break;
			case "4": // View login history 
				System.out.println("*** View Login history ***");
				Scanner usr = new Scanner(System.in);
				String name;
				
				System.out.println("Enter your Username to view your Login in history: ");
				name = usr.next(); 

				Iterator<User> user = users.iterator();				
				while(user.hasNext()) {
					User u = user.next();						
					try {					
						if (u.getUserName().contains(name)) {
							//File f = new File("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserLogin\\" + name + ".txt");
							File f = new File("C:\\OOP - Assessment\\UserLogin\\" + name + ".txt");
							if (f.exists()) {
								System.out.println("*** Login history ***");
								Scanner reader = new Scanner(f);
								while (reader.hasNextLine()) { 
									String log = reader.nextLine();
									System.out.println(log);										
								}	
								reader.close();
								System.out.println("\n");
							} 
						} 
					} catch (FileNotFoundException e) {
						System.out.println("Error. File not found");
					}					
				} 
				break;
			case "5": // View loan history 
				System.out.println("*** View Loan history ***");
				Scanner usr1 = new Scanner(System.in);
				String usrName;
				Boolean read = false; 	
				
				System.out.println("Enter your Username to view your loans: ");
				usrName = usr1.next(); 
				
				
				Iterator<User> user1 = users.iterator(); 
				Iterator<Stock> item = stock.iterator();
				while(user1.hasNext()) {
					User u = user1.next();
					if (u.getUserName().contains(usrName)) {
						Scanner i = new Scanner(System.in);
						String a;
						
						System.out.println("Enter the Item you'd like to view:");
						a = i.next();
					while (item.hasNext()) {
						Stock s = item.next();
						if (s.getTitle().contains(a)) {	
							try {																
								//File f = new File("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserLoans\\" + u.getUserName() + s.getTitle() + ".txt");
								File f = new File("C:\\OOP - Assessment\\UserLoans\\" + u.getUserName() + s.getTitle() + ".txt");
								if (f.exists()) {
									System.out.println("*** Loan history ***");
									Scanner reader = new Scanner(f);
									while (reader.hasNextLine()) { 
										String log = reader.nextLine();
										System.out.println(log);										
									}		
									System.out.println("Borrow Amount left: " + u.getBorrowAmount() + "\n");
									read = true;
									reader.close();											
								}								
							} catch (FileNotFoundException e) {
								System.out.println("Error. File not found");
							}
						}
					}	
				}
				}
				break;
			case "6": // Reserve stock item
				Catalogue cat1 = new Catalogue();
				cat1.reserveStock();
				break;
			case "0":
				System.out.println("You have logged out");
				// Get logout details
				try { 									
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
					Date date = new Date();
					String textAppend = "\nLogout date: " + formatter.format(date);
					//BufferedWriter writer = new BufferedWriter(new FileWriter("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\LoginCasual.txt", true));										
					BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\OOP - Assessment\\LoginCasual.txt", true));
					writer.write(textAppend);
					writer.close();
				} catch (IOException e) { 
					System.out.println("An error has occured");
					//e.printStackTrace();
				}
				
				// Serialize Array when closing
				try { 
					//FileOutputStream fos = new FileOutputStream("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserInfo\\info.ser");
					FileOutputStream fos = new FileOutputStream("C:\\OOP - Assessment\\UserInfo\\info.ser");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(users);
					oos.close(); 
					fos.close(); 
					System.out.printf("Serialized ArrayList(Users) data saved in info.ser\n");
					// This will save all instances of stock objects. If any loans are changed etc this will load them in upon beginning
					//FileOutputStream stocks = new FileOutputStream("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\stockInfo\\stockInfo.ser");
					FileOutputStream stocks = new FileOutputStream("C:\\OOP - Assessment\\stockInfo\\stockInfo.ser");
					ObjectOutputStream objectStockInfo = new ObjectOutputStream(stocks);
					objectStockInfo.writeObject(stock);
					stocks.close(); 
					objectStockInfo.close();
					
				}catch (IOException ioe) { 
					System.out.println("Error! file not found");
					//ioe.printStackTrace();
				}
				
				System.exit(Integer.parseInt(selection));
				break;
			default: 
				System.out.println("Error. Please enter the correct input");
				break;
			}
		} while (selection != "0");
		//input.close();
	}
	// Display menu for staff members
	public void staffMenu() {  
		Scanner input = new Scanner(System.in);
		String selection;
		do {
			//Display menu		
			System.out.println("************** STAFF USER ********************");
			System.out.println("Please select what you would like to do: ");
			System.out.println("1 - Search Library System");
			System.out.println("2 - Edit Profile");
			System.out.println("3 - Info");
			System.out.println("4 - Login History");
			System.out.println("5 - Loan history");
			System.out.println("6 - Reserve Item");
			System.out.println("0 - Exit");
			selection = input.nextLine();
			
			switch (selection) { 
			case "1": 
				// Search item class 
				Catalogue cat = new Catalogue();
				cat.search();
				break;		
			case "2": 
				editProfile();
				break;
			case "3": // Give user info on what they can do within in the app
				System.out.println("You are currently a Staff user.");
				System.out.println("Staff user(s) members can reserve an item before it has become available to loan.");
				System.out.println("In order to reserve an item, go into 'Reserve Item' and see what is available to reserve");
				System.out.println("\n");
				break;
			case "4": // View login history 
				System.out.println("*** View Login history ***");
				Scanner usr = new Scanner(System.in);
				String name;
				
				System.out.println("Enter your Username to view your Login in history: ");
				name = usr.next(); 

				Iterator<User> user = users.iterator();				
				while(user.hasNext()) {
					User u = user.next();						
					try {					
						if (u.getUserName().contains(name)) {
							//File f = new File("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserLogin\\" + name + ".txt");
							File f = new File("C:\\OOP - Assessment\\UserLogin\\" + name + ".txt");
							if (f.exists()) {
								System.out.println("*** Login history ***");
								Scanner reader = new Scanner(f);
								while (reader.hasNextLine()) { 
									String log = reader.nextLine();
									System.out.println(log);										
								}	
								reader.close();
								System.out.println("\n");
							} 
						} 
					} catch (FileNotFoundException e) {
						System.out.println("Error. File not found");
					}					
				} 
				break;
			case "5": // View loan history 
				System.out.println("*** View Loan history ***");
				Scanner usr1 = new Scanner(System.in);
				String usrName;
				Boolean read = false; 	
				
				System.out.println("Enter your Username to view your loans: ");
				usrName = usr1.next(); 
				
				
				Iterator<User> user1 = users.iterator(); 
				Iterator<Stock> item = stock.iterator();
				while(user1.hasNext()) {
					User u = user1.next();
					if (u.getUserName().contains(usrName)) {
						Scanner i = new Scanner(System.in);
						String a;
						
						System.out.println("Enter the Item you'd like to view:");
						a = i.next();
					while (item.hasNext()) {
						Stock s = item.next();
						if (s.getTitle().contains(a)) {	
							try {					
								//if (u.getUserName().contains(usrName) && s.getLoan() == true) {							
								//File f = new File("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserLoans\\" + u.getUserName() + s.getTitle() + ".txt");
								File f = new File("C:\\OOP - Assessment\\UserLoans\\" + u.getUserName() + s.getTitle() + ".txt");
								if (f.exists()) {
									System.out.println("*** Loan history ***");
									Scanner reader = new Scanner(f);
									while (reader.hasNextLine()) { 
										String log = reader.nextLine();
										System.out.println(log);										
									}		
									System.out.println("Borrow Amount left: " + u.getBorrowAmount() + "\n");
									read = true;
									reader.close();											
								}								
							} catch (FileNotFoundException e) {
								System.out.println("Error. File not found");
							}
						}
					}	
				}
				}
				break;
			case "6": // Reserve stock item
				Catalogue cat1 = new Catalogue();
				cat1.reserveStock();
				break;
			case "0":
				System.out.println("You have logged out");
				// Get logout details
				try { 									
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
					Date date = new Date();
					String textAppend = "\nLogout date: " + formatter.format(date);
					//BufferedWriter writer = new BufferedWriter(new FileWriter("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\LoginCasual.txt", true));										
					BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\OOP - Assessment\\LoginCasual.txt", true));
					writer.write(textAppend);
					writer.close();
				} catch (IOException e) { 
					System.out.println("An error has occured");
					//e.printStackTrace();
				}
				
				// Serialize Array when closing
				try { 
					//FileOutputStream fos = new FileOutputStream("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserInfo\\info.ser");
					FileOutputStream fos = new FileOutputStream("C:\\OOP - Assessment\\UserInfo\\info.ser");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(users);
					oos.close(); 
					fos.close(); 
					System.out.printf("Serialized ArrayList(Users) data saved in info.ser\n");
					// This will save all instances of stock objects. If any loans are changed etc this will load them in upon beginning
					//FileOutputStream stocks = new FileOutputStream("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\stockInfo\\stockInfo.ser");
					FileOutputStream stocks = new FileOutputStream("C:\\OOP - Assessment\\stockInfo\\stockInfo.ser");
					ObjectOutputStream objectStockInfo = new ObjectOutputStream(stocks);
					objectStockInfo.writeObject(stock);
					stocks.close(); 
					objectStockInfo.close();
					
				}catch (IOException ioe) { 
					System.out.println("Error! file not found");
					//ioe.printStackTrace();
				}
				
				System.exit(Integer.parseInt(selection));
				break;
			default: 
				System.out.println("Error. Please enter the correct input");
				break;
			}
		} while (selection != "0");
		//input.close();
	}
	// Display menu for Casual Member
	public void CasualMenu() { 
		System.out.println("************** CASUAL ********************");
		System.out.println("Please select what you would like to do: ");
		System.out.println("1 - Search Library System");
		System.out.println("2 - Edit Profile");
		System.out.println("3 - Exit");
		System.out.println("*NOTE* As a casual Member you aren't able to loan/Reserve items");
		
		Scanner input = new Scanner(System.in);						
		int selection = input.nextInt();
		
		
		do {
			switch (selection) { 
			case 1: 
				// Search item class 
				// and display items relating to search
				Catalogue cat = new Catalogue();
				cat.search();
				break;		
			case 2: 
				editProfile();
				break;
			case 3: 
				System.out.println("You have logged out");
				// Get logout details
				try { 									
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
					Date date = new Date();
					String textAppend = "\nLogout date: " + formatter.format(date);
					//BufferedWriter writer = new BufferedWriter(new FileWriter("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\LoginCasual.txt", true));
					BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\OOP - Assessment\\LoginCasual.txt", true));
					writer.write(textAppend);
					writer.close();
				} catch (IOException e) { 
					System.out.println("An error has occured");
					e.printStackTrace();
				}
				
				// Serialize Array when closing
				try { 
					//FileOutputStream fos = new FileOutputStream("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserInfo\\info.ser");
					FileOutputStream fos = new FileOutputStream("C:\\OOP - Assessment\\UserInfo\\info.ser");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(users);
					oos.close(); 
					fos.close(); 
					System.out.printf("Serialized ArrayList(Users) data saved in info.ser\n");
					// This will save all instances of stock objects. If any loans are changed etc this will load them in upon beginning
					//FileOutputStream stocks = new FileOutputStream("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\stockInfo\\stockInfo.ser");
					FileOutputStream stocks = new FileOutputStream("C:\\OOP - Assessment\\stockInfo\\stockInfo.ser");
					ObjectOutputStream objectStockInfo = new ObjectOutputStream(stocks);
					objectStockInfo.writeObject(stock);
					stocks.close(); 
					objectStockInfo.close();
					System.out.printf("Serialized ArrayList(Stock) data saved in stockinfo.ser\n");
				}catch (IOException ioe) { 
					System.out.println("Error! file not found");
					ioe.printStackTrace();
				}			
				System.exit(selection);
				break;
			default: 
				System.out.println("Error. Please enter the correct input");
				break;
			}
		} while (selection != 3);
		//input.close(); 
	}	
} // End of Glencaldy Class 