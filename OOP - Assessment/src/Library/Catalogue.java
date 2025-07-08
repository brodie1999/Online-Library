package Library;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
// This class will house all of the main functions for searching, editing, adding etc 
public class Catalogue { 
	
	// Add items to stock
	public void addItems() { 	
		
		// only for Admin users who can add items for users to loan	
		// Check stock ID is a duplicate 
		Scanner in = new Scanner(System.in);
		int s; 		
		
		do { 
			System.out.println("Add new Items here: ");
			System.out.println("1 - Add Book");
			System.out.println("2 - Add Video");
			System.out.println("3 - Add Journal");
			System.out.println("4 - Add disc");
			System.out.println("5 - Exit to menu");		
		
			s = in.nextInt();
						
			switch(s) { 
			case 1: // Add book
				boolean check = false;
				String stockID;
				
				do {
					
					System.out.println("\nAdd StockID: ");
					Scanner id = new Scanner(System.in);			
					stockID = id.next();
					// Check for duplicate within stock
					for (Stock stock : Glencaldy.stock) { 
						if (stock.getID().contains(stockID) && stock.grade() == ItemType.book) { 
							System.out.println("StockID already exists. Try again" );
							check = false;
							break; 
						} else { 
							check = true; 
						}
					}
					
				} while (check != true);	
				
				if (check == true) {
					System.out.println("Add ISBN: ");
					Scanner ISBN = new Scanner(System.in);
					int ISBNNum = ISBN.nextInt();
					
					System.out.println("Add Author: "); 
					Scanner author = new Scanner(System.in); 
					String a = author.nextLine(); 
						
					System.out.println("Add book title: "); 
					Scanner title = new Scanner(System.in); 
					String t = title.nextLine();
						
					System.out.println("Add cost: ");
					Scanner cost = new Scanner(System.in);
					Double c = cost.nextDouble();	
						
					System.out.println("Add subject area: ");
					Scanner SA = new Scanner(System.in); 
					String subjectA = SA.nextLine(); 
						
					System.out.println("Add publisher: "); 
					Scanner pub1 = new Scanner(System.in); 
					String publisher1 = pub1.nextLine();
						
					System.out.println("Add number of Pages: ");
					Scanner pages = new Scanner(System.in); 
					int numPages = pages.nextInt(); 
								
					ItemType grade = ItemType.book;
					System.out.println("Item: " + grade);
						
					Boolean l = false;
					System.out.println("Item Loaned: " + l);
						
					System.out.println("Item has been added\n");
					Glencaldy.stock.add(new Book(stockID, ISBNNum, a, t, c, subjectA, publisher1, numPages, grade, l, null));
				}
				// De-Serialize stock Array
				try {
					//String stockPath = "F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\stockInfo\\stockInfo.ser";
					String stockPath = "C:\\OOP - Assessment\\stockInfo\\stockInfo.ser";
					FileOutputStream f = new FileOutputStream(stockPath);
					ObjectOutputStream soos = new ObjectOutputStream(f);			
					soos.writeObject(Glencaldy.stock);
					
					soos.close();
					f.close();
				} catch (EOFException e) { 
					System.out.println("An error occurred");
				} catch (IOException e) { 
					System.out.println("An error occurred");
				}
				genInstanceReport();
				break;
			case 2: // Add video
				String stock1; 
				Boolean checkD = false;
				System.out.println("\nAdd StockID: ");
				Scanner stockID1 = new Scanner(System.in);
				stock1 = stockID1.next();	
				do {
					
					System.out.println("\nAdd StockID: ");
					Scanner id = new Scanner(System.in);			
					stock1 = id.next();
					// Check for duplicate within stock
					for (Stock stock : Glencaldy.stock) { 
						if (stock.getID().contains(stock1) && stock.grade() == ItemType.video) { 
							System.out.println("StockID already exists. Try again" );
							checkD = false;
							break; 
						} else { 
							checkD = true; 
						}
					}
					
				} while (checkD != true);	
				if (checkD == true) {
					System.out.println("Add run time: ");
					Scanner runTime = new Scanner(System.in);
					int rt = runTime.nextInt();
					
					System.out.println("Add video Format: "); 
					Scanner format = new Scanner(System.in);
					String vf = format.nextLine();
					
					System.out.println("Add film genre: "); 
					Scanner genre = new Scanner(System.in);
					String g = genre.nextLine();
					
					System.out.println("Add film title: "); 
					Scanner t2 = new Scanner(System.in); 
					String title1 = t2.nextLine();
				
					System.out.println("Add cost: \n");
					Scanner cost1 = new Scanner(System.in);
					Double c1 = (cost1.nextDouble());		
					
					System.out.println("Add publisher: "); 
					Scanner pub = new Scanner(System.in);
					String publisher = pub.nextLine();
					
					System.out.println("Add storage type: "); 
					Scanner storage = new Scanner(System.in);
					String store = storage.nextLine(); 
					
					ItemType grade1 = ItemType.video;
					System.out.println("Item: " + grade1);		
					
					Boolean l1 = false;			
					System.out.println("Item loaned: " + l1);
					
					Glencaldy.stock.add(new Video(stock1, rt, vf, g, title1, c1, publisher, store, grade1, l1, null));
					genInstanceReport();
					
					// De-Serialize stock Array
					try {
						//String stockPath = "F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\stockInfo\\stockInfo.ser";
						String stockPath = "C:\\OOP - Assessment\\stockInfo\\stockInfo.ser";
						FileOutputStream f = new FileOutputStream(stockPath);
						ObjectOutputStream soos = new ObjectOutputStream(f);			
						soos.writeObject(Glencaldy.stock);
						
						soos.close();
						f.close();
					} catch (EOFException e) { 
						System.out.println("An error occurred");
					} catch (IOException e) { 
						System.out.println("An error occurred");
					}
				}
				break;
			case 3: // Add Journal
				String stock2;
				Boolean checkDup = false; 
				System.out.println("\nAdd StockID: ");
				Scanner stockID2 = new Scanner(System.in);
				stock2 = stockID2.nextLine();
				
				do {
					
					System.out.println("\nAdd StockID: ");
					Scanner id = new Scanner(System.in);			
					stock2 = id.next();
					// Check for duplicate ID within stock
					for (Stock stock : Glencaldy.stock) { 
						if (stock.getID().contains(stock2) && stock.grade() == ItemType.journals) { 
							System.out.println("StockID already exists. Try again" );
							checkDup = false;
							break; 
						} else { 
							checkDup = true; 
						}
					}
					
				} while (checkDup != true);
				if (checkDup == true) {
					System.out.println("Add ISSN No. : ");
					Scanner ISSN = new Scanner(System.in);
					int Num = ISSN.nextInt();
				
					System.out.println("Add issue number:"); 
					Scanner issue = new Scanner(System.in); 
					int issueNum = issue.nextInt(); 
					
					System.out.println("Add Date of issue: "); 
					Scanner date = new Scanner(System.in); 
					String issueDate = date.nextLine(); 
					
					System.out.println("Add title: "); 
					Scanner t3 = new Scanner(System.in); 
					String title3 = t3.nextLine(); 
					
					System.out.println("Add cost: \n£");
					Scanner cost2 = new Scanner(System.in);
					Double c2 = (cost2.nextDouble());		
					
					System.out.println("Add subject area: ");
					Scanner SA1 = new Scanner(System.in); 
					String subjectA1 = SA1.nextLine();
					
					System.out.println("Add publisher: "); 
					Scanner pub2 = new Scanner(System.in);
					String publisher2 = pub2.nextLine();
					
					System.out.println("Add number of Pages: ");
					Scanner pages1 = new Scanner(System.in); 
					int numPages1 = pages1.nextInt();
					
					ItemType grade2 = ItemType.journals;
					System.out.println("Item: " + grade2);
					
					System.out.println("Item Loaned: ");
					Scanner loaned2 = new Scanner(System.in);
					Boolean l2 = loaned2.nextBoolean();			
						
					Glencaldy.stock.add(new Journal(stock2, Num, issueNum, issueDate, title3, c2, subjectA1, publisher2, numPages1, grade2, l2, null));				
					genInstanceReport();
					// De-Serialize stock Array
					try {
						//String stockPath = "F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\stockInfo\\stockInfo.ser";
						String stockPath = "C:\\OOP - Assessment\\stockInfo\\stockInfo.ser";
						FileOutputStream f = new FileOutputStream(stockPath);
						ObjectOutputStream soos = new ObjectOutputStream(f);			
						soos.writeObject(Glencaldy.stock);
						
						soos.close();
						f.close();
					} catch (EOFException e) { 
						System.out.println("An error occurred");
					} catch (IOException e) { 
						System.out.println("An error occurred");
					}
				}
				break;
			case 4: // Add disc 
				String stock3; 
				Boolean checkID = false; 
				System.out.println("\nAdd StockID: ");
				Scanner stockID3 = new Scanner(System.in);
				stock3 = stockID3.nextLine();	
				
				do {
					
					System.out.println("\nAdd StockID: ");
					Scanner id = new Scanner(System.in);			
					stock3 = id.next();
					// Check for duplicate ID within stock
					for (Stock stock : Glencaldy.stock) { 
						if (stock.getID().contains(stock3) && stock.grade() == ItemType.compactDisc) { 
							System.out.println("StockID already exists. Try again" );
							checkID = false;
							break; 
						} else { 
							checkID = true; 
						}
					}
					
				} while (checkID != true);
				if (checkID == true) {	
					System.out.println("Add run time: ");
					Scanner runTime1 = new Scanner(System.in);
					int rt1 = runTime1.nextInt();
				
					System.out.println("Add CD Type: ");
					Scanner type = new Scanner(System.in);
					String cdType = type.nextLine();
									
					System.out.println("Add Number of tracks: ");
					Scanner tracks = new Scanner(System.in);
					int numTracks = tracks.nextInt();
					
					System.out.println("Add Artist: ");
					Scanner Artist = new Scanner(System.in);
					String a1 = Artist.nextLine();
					
					System.out.println("Add title: "); 
					Scanner title5 = new Scanner(System.in); 
					String t5 = title5.nextLine(); 
					
					System.out.println("Add cost: \n£");
					Scanner cost3 = new Scanner(System.in);
					Double c3 = (cost3.nextDouble());		
					
					System.out.println("Add publisher: "); 
					Scanner pub3 = new Scanner(System.in); 
					String publisher3 = pub3.nextLine(); 
					
					System.out.println("Add storage Type: "); 
					Scanner st = new Scanner(System.in); 
					String storageType = st.nextLine(); 
						
					ItemType grade3 = ItemType.compactDisc;
					System.out.println("Item: " + grade3);
					
					System.out.println("Item Loaned: ");
					Scanner loaned3 = new Scanner(System.in);
					Boolean l3 = loaned3.nextBoolean();			
						
					Glencaldy.stock.add(new Disc(stock3, rt1, cdType, numTracks, a1, t5, c3, publisher3, storageType, grade3, l3, null));
					genInstanceReport();
					
					// De-Serialize stock Array
					try {
						//String stockPath = "F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\stockInfo\\stockInfo.ser";
						String stockPath = "C:\\OOP - Assessment\\stockInfo\\stockInfo.ser";
						FileOutputStream f = new FileOutputStream(stockPath);
						ObjectOutputStream soos = new ObjectOutputStream(f);			
						soos.writeObject(Glencaldy.stock);
						
						soos.close();
						f.close();
					} catch (EOFException e) { 
						System.out.println("An error occurred");
					} catch (IOException e) { 
						System.out.println("An error occurred");
					}
				}
				break;
			case 5: // Exit 
				Glencaldy menu = new Glencaldy();				
				menu.adminMenu();
				break;
			default: 
				System.out.println("Please enter the correct input");
				break;
			}
		} while(s != 5);
		
		//in.close();
	}
 	// Search stock 
	public void search() {			
		//This will ask the user to search for their desired type
		Scanner search = new Scanner(System.in); 	 
		int s;
		do {			
			System.out.println("Search using item type OR the title of the item: \n");
			System.out.println("1 - Search Books");
			System.out.println("2 - Search Videos");
			System.out.println("3 - Search Journal");
			System.out.println("4 - Search Disc");	
			System.out.println("5 - Search using title");
			System.out.println("6 - Return to menu");
			s = search.nextInt();		
			
			switch(s) 
			{ 
			case 1: // Search books
				System.out.println("All available Books: \n");
				Iterator<Stock> it = Glencaldy.stock.iterator();
				while(it.hasNext()) { 
					Stock b = it.next();
					if (b.grade() == ItemType.book && b.getLoan() == false) { 
						System.out.println(b.toString() + "\n");							
					}							
				} 					
				
				break;
			case 2: // Search videos
				System.out.println("All available Videos: \n");
				Iterator<Stock> ite = Glencaldy.stock.iterator();
				while(ite.hasNext()) { 
					Stock v = ite.next();
					if (v.grade() == ItemType.video && v.getLoan() == false) { 
						System.out.println(v.toString() + "\n");						
					}
				}			
				break;
			case 3: // Search Journals
				System.out.println("All available Journals: \n");
				Iterator<Stock> iter = Glencaldy.stock.iterator();
				while(iter.hasNext()) 
				{ 
					Stock j = iter.next();
					if (j.grade() == ItemType.journals && j.getLoan() == false) { 
						System.out.println(j.toString() + "\n");							
					}					
				}		
				break;
			case 4: // Search discs
				System.out.println("All available discs: \n");
				Iterator<Stock> i = Glencaldy.stock.iterator();
				while(i.hasNext()) { 
					Stock d = i.next();
					if (d.grade() == ItemType.compactDisc && d.getLoan() == false) { 
						System.out.println(d.toString() + "\n");						
					}
				}				
				break;
			case 5: 
				boolean checkTitle = false; 				
				Scanner srchTitle = new Scanner(System.in);
				String title; 
				do {
					System.out.println("Search by title: ");
					title = srchTitle.nextLine();
					//title.trim();
					Iterator<Stock> stockTitle = Glencaldy.stock.iterator();
					while(stockTitle.hasNext()) { 
						Stock sTitle = stockTitle.next(); 
						if (sTitle.getTitle().contains(title) && sTitle.getLoan() == false) { 
							System.out.println("\n" + sTitle.toString());
							checkTitle = true;
						} else if (!sTitle.getTitle().contains(title) && !stockTitle.hasNext() && checkTitle == false) { 
							System.out.println("Error Item not found");
						}
					}
					
				} while(checkTitle != true);				
				break;
			case 6:
				
				// De-Serialize stock Array
				try {
					//String stockPath = "F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\stockInfo\\stockInfo.ser";
					String stockPath = "C:\\OOP - Assessment\\stockInfo\\stockInfo.ser";
					FileOutputStream f = new FileOutputStream(stockPath);
					ObjectOutputStream soos = new ObjectOutputStream(f);			
					soos.writeObject(Glencaldy.stock);
					
					soos.close();
					f.close();
				} catch (EOFException e) { 
					System.out.println("An error occurred");
				} catch (IOException e) { 
					System.out.println("An error occurred");
				}
				Scanner a = new Scanner(System.in);
				System.out.println("Enter your username to return to menu");
				String uName = a.next(); 
				Iterator<User> u = Glencaldy.users.iterator();
				while(u.hasNext()) { 
					User us = u.next(); 
					if (us.getUserName().contains(uName) && us.getType() == UserType.Admin) { 
						Glencaldy m = new Glencaldy();
						m.adminMenu();
					} else if (us.getUserName().contains(uName) && us.getType() == UserType.Full) { 
						Glencaldy m1 = new Glencaldy();
						m1.fullMenu();
					} else if (us.getUserName().contains(uName) && us.getType() == UserType.Casual) { 
						Glencaldy m2 = new Glencaldy(); 
						m2.CasualMenu();
					} else if (us.getUserName().contains(uName) && us.getType() == UserType.Staff) { 
						Glencaldy m3 = new Glencaldy();
						m3.staffMenu();
					}
					if (!u.hasNext()) { 
						System.out.println("Error! user not found");
					}
				}
				System.out.println("returned to Menu\n");	
				break;
			default: 
				System.out.println("Please enter the correct input");			
				break;
			}		
		} while(s != 5);
		//search.close();
	} // End of Search class()
	// Loan function for Admin users
	public void loan() {
		Scanner loan = new Scanner(System.in);
		String s;	
		do {
			System.out.println("Please select what you would like to do:  ");
			System.out.println("1 - Loan Item");
			System.out.println("2 - Menu");
			s = loan.next();		// Error NoSuchElementException : Occurs when User presses 2 to go  back to search
			Boolean loaned = false; 		
				
			switch (s) {
			case "1": 		 
				do {
					Scanner item = new Scanner(System.in); 
					System.out.println("Please enter the title of the item the user would like to borrow: ");				
					String title = item.nextLine();
				
					// Search stock for the title the user has entered
					Iterator<Stock> stk = Glencaldy.stock.iterator(); 
					while(stk.hasNext()) {
						Stock st = stk.next();
						if (st.getTitle().contains(title) && st.getLoan() == false) { 						
							Scanner usr = new Scanner(System.in);
							Scanner pwd = new Scanner(System.in);
							
							System.out.println("Please enter the username & password of the user to loan this item: ");
							System.out.println("Enter username: ");
							String userName = usr.nextLine();
							System.out.println("Enter password: ");
							String password = pwd.nextLine(); 						
		
							Iterator<User> u = Glencaldy.users.iterator();
							while(u.hasNext()) { 
								User user = u.next();							
								//File checkFile = new File("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserFines\\" + user.getUserName() + ".txt");
								File checkFile = new File("C:\\OOP - Assessment\\UserFines\\" + user.getUserName() + ".txt");
								if (checkFile.exists()) {				
									System.out.println("Error! You have outstanding fines that have yet to be paid! See Administrator");
									break;
								} else if (!checkFile.exists()) {
									if (user.getUserName().contains(userName) && user.getPassword().contains(password)) {								
										if (user.getBorrowAmount() > 0) {
											user.setBorrowAmount((user.getBorrowAmount() - 1)); 									
											System.out.println(user.getUserName() + " has reserved " + title);
											System.out.println("Borrows left: " + user.getBorrowAmount());
											System.out.println("\n");
											//Set borrow to true
											st.setLoan(true);
											loaned = true;	
											// Serilize stock array
											try {
												//String stockPath = "F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\stockInfo\\stockInfo.ser";
												String stockPath = "C:\\OOP - Assessment\\stockInfo\\stockInfo.ser";
												FileOutputStream f = new FileOutputStream(stockPath);
												ObjectOutputStream soos = new ObjectOutputStream(f);			
												soos.writeObject(Glencaldy.stock);
												
												soos.close();
												f.close();
												
												//FileOutputStream fos = new FileOutputStream("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserInfo\\info.ser");
												FileOutputStream fos = new FileOutputStream("C:\\OOP - Assessment\\UserInfo\\info.ser");
												ObjectOutputStream oos = new ObjectOutputStream(fos);
												oos.writeObject(Glencaldy.users);
												oos.close(); 
												fos.close(); 
											} catch (EOFException e) { 
												//e.printStackTrace();
											} catch (IOException e) { 
												System.out.println("Error! file not found");										
											}										
										} else { 
											System.out.println("Error! unable to reserve this item. Loan limit reached");
											System.out.println("Borrows left: " + user.getBorrowAmount());
										}
										// Write loan to file 
										try {										
											// setup file writer
											//File loanFile = new File("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserLoans\\" + user.getUserName() + st.getTitle() + ".txt");
											File loanFile = new File("C:\\OOP - Assessment\\UserLoans\\" + user.getUserName() + st.getTitle() + ".txt");
											FileWriter writer = new FileWriter(loanFile);									
											if (loanFile.exists()) { 
												//FileWriter writer1 = new FileWriter("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserLoans\\" + user.getUserName() + st.getTitle() + ".txt");
												FileWriter writer1 = new FileWriter("C:\\OOP - Assessment\\UserLoans\\" + user.getUserName() + st.getTitle() + ".txt");
												// Get Current date for when the loan was issued
												DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
												LocalDateTime date = LocalDateTime.now();
												st.setLoanDate(dtf.format(date));									
												// Set userName of the user who loaned it
												st.setUserLoaned(userName);
												
												SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
												Calendar c = Calendar.getInstance(); 
												try { 
													c.setTime(sdf.parse(st.getLoanDate()));
												} catch (ParseException e) { 
													//e.printStackTrace();
												}
												c.add(Calendar.DAY_OF_WEEK, 10);
												String dueDate = sdf.format(c.getTime());
												st.setReturnDate(dueDate);
												writer1.write("Item Loaned: " + title + "\n" + "User: " + userName + "\n" + "Name: " + user.getfName() + "\nDate Loaned: " + st.getLoanDate() + "\nDue date: " + st.getReturnedDate());
												writer1.close();
											} else {										
											// Get Current date for when the loan was issued
											DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
											LocalDateTime date = LocalDateTime.now();
											st.setLoanDate(dtf.format(date));									
											// Set userName of the user who loaned it
											st.setUserLoaned(userName);
											
											SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
											Calendar c = Calendar.getInstance(); 
											try { 
												c.setTime(sdf.parse(st.getLoanDate()));
											} catch (ParseException e) { 
												//e.printStackTrace();
											}
											c.add(Calendar.DAY_OF_WEEK, 10);
											String dueDate = sdf.format(c.getTime());
											st.setReturnDate(dueDate);
											writer.write("Item Loaned: " + title + "\n" + "User: " + userName + "\n" + "Name: " + user.getfName() + "\nDate Loaned: " + st.getLoanDate() + "\nDue date: " + st.getReturnedDate());
											writer.close();
											}
										} catch (IOException e){ 
											//e.printStackTrace();
										}
										
										// Serilize stock array
										try {
											//String stockPath = "F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\stockInfo\\stockInfo.ser";
											String stockPath = "C:\\OOP - Assessment\\stockInfo\\stockInfo.ser";
											FileOutputStream f = new FileOutputStream(stockPath);
											ObjectOutputStream soos = new ObjectOutputStream(f);			
											soos.writeObject(Glencaldy.stock);
											
											soos.close();
											f.close();
											
											//FileOutputStream fos = new FileOutputStream("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserInfo\\info.ser");
											FileOutputStream fos = new FileOutputStream("C:\\OOP - Assessment\\UserInfo\\info.ser");
											ObjectOutputStream oos = new ObjectOutputStream(fos);
											oos.writeObject(Glencaldy.users);
											oos.close(); 
											fos.close(); 
										} catch (EOFException e) { 
											//e.printStackTrace();
										} catch (IOException e) { 
											System.out.println("Error! file not found");										
										}
									
									} else if (!user.getUserName().contains(userName) && !u.hasNext()) { 
										System.out.println("Error Username or password doesn't exist");
									}
									
								} // End of file check if
								
							} // End of user iterator
						}					
					} // End of for (Stock)			
				} while (loaned != true);		
				break;
			case "2": 
				// De-Serialize stock Array
				try {
					//String stockPath = "F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\stockInfo\\stockInfo.ser";
					String stockPath = "C:\\OOP - Assessment\\stockInfo\\stockInfo.ser";
					FileOutputStream f = new FileOutputStream(stockPath);
					ObjectOutputStream soos = new ObjectOutputStream(f);			
					soos.writeObject(Glencaldy.stock);
					
					soos.close();
					f.close();
				} catch (EOFException e) { 
					System.out.println("An error occurred");
				} catch (IOException e) { 
					System.out.println("An error occurred");
				}
				Scanner a = new Scanner(System.in);
				System.out.println("Enter your username to return to menu");
				String uName = a.next(); 
				Iterator<User> u = Glencaldy.users.iterator();
				while(u.hasNext()) { 
					User us = u.next(); 
					if (us.getUserName().contains(uName) && us.getType() == UserType.Admin) { 
						Glencaldy m = new Glencaldy();
						m.adminMenu();
					} else if (us.getUserName().contains(uName) && us.getType() == UserType.Full) { 
						Glencaldy m1 = new Glencaldy();
						m1.fullMenu();
					} else if (us.getUserName().contains(uName) && us.getType() == UserType.Casual) { 
						Glencaldy m2 = new Glencaldy(); 
						m2.CasualMenu();
					} else if (us.getUserName().contains(uName) && us.getType() == UserType.Staff) { 
						Glencaldy m3 = new Glencaldy();
						m3.staffMenu();
					}
					if (!u.hasNext()) { 
						System.out.println("Error! user not found");
					}
				}
				System.out.println("returned to Menu\n");	
				break; 
			default: 
				System.out.println("Enter correct input");
				break;
			} // End of switch		
		} while (s != "2");
	}
	// Update loans that have been returned
	public void updateLoans() { 
		System.out.println("****************** UPDATE LOANS ******************");
		 
		// This is where an Admin or staff user can view and update loans for full users
		Scanner itemReturned = new Scanner(System.in); 		
		
		String title;
	
		System.out.println("Please enter the title of the Item that has been returned: ");
		title = itemReturned.nextLine();

		Iterator<Stock> items = Glencaldy.stock.iterator();
		Iterator<User> Users = Glencaldy.users.iterator();
		while (items.hasNext()) { 
			Stock stock = items.next(); 
			if (stock.getTitle().contains(title)) {
				Scanner a = new Scanner(System.in);
				String uName;		
				System.out.println("\nEnter the Username of the user that has returned an item: ");				
				uName = a .nextLine(); 				
				while(Users.hasNext()) {
					User u = Users.next();
					if (u.getUserName().contains(uName)) { 
					
					try { 
						// Create file reader
						FileReader read = new FileReader("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserLoans\\" + u.getUserName() + stock.getTitle() + ".txt");
						//FileReader read = new FileReader("C:\\OOP - Assessment\\UserLoans\\" + u.getUserName() + stock.getTitle() + ".txt");						
						Scanner reader = new Scanner(read);
						while (reader.hasNextLine()) {
							String data = reader.nextLine();
							System.out.println(data + "\n");
						}
						reader.close();
						read.close();						
					} catch (IOException e){ 
						System.out.println("Error occurred. File not found");						
					}				
										
					System.out.println("Item returned: " + title);
					//Remove loan file
					File file = new File("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserLoans\\" + uName + title + ".txt");
					//File file = new File("C:\\OOP - Assessment\\UserLoans\\" + uName + title + ".txt");
					if (file.delete()) { 
						System.out.println("Original Loan file has been deleted");
					} else { 
						System.out.println("Failed to delete file");
					}
					stock.setLoan(false);
					System.out.println("Stock updating...");
					// Get input 
					Scanner usr = new Scanner(System.in);  
					System.out.println("Enter Username of the loanee to increase their borrow amount: ");
					String userName = usr.next(); 
					// Add to borrowAmount
					if (u.getBorrowAmount() == 4 || u.getBorrowAmount() == 6) {
						System.out.println("Borrow Amount reached");
					} else {
						u.setBorrowAmount((u.getBorrowAmount() + 1));
						System.out.println("Borrow Amount increased");
					} 				
		
					// Serialize stock Array
					try {
						FileOutputStream fos = new FileOutputStream("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\stockInfo\\stockInfo.ser");
						//FileOutputStream fos = new FileOutputStream("C:\\OOP - Assessment\\UserInfo\\info.ser");
						ObjectOutputStream oos = new ObjectOutputStream(fos);
						oos.writeObject(Glencaldy.stock);
						oos.close(); 
						fos.close(); 
						System.out.println("Item is now available to loan");
					} catch (EOFException e) { 
						System.out.println("An Error has Occurred. File Doesn't exist");
					} catch (IOException e) { 
						System.out.println("File not found");
						
					}
												
					// Calculate Date between date loaned and date returned 
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					LocalDate dateLoaned = LocalDate.parse(stock.getLoanDate(), dtf); // Add 10 days from the loan Date
					LocalDate dueDate = LocalDate.parse(stock.getReturnedDate(), dtf); // Return the due date
					LocalDateTime now = LocalDateTime.now();
					LocalDate dateReturned = LocalDate.parse(dtf.format(now), dtf); // Return current date 					
					long daysBetween = ChronoUnit.DAYS.between(dateLoaned, dateReturned);
					 // If daysBetween > 10 - Add fine to userLoans 
					System.out.println("\n ********** Loan Info **********");
					System.out.println("Date Loaned: " + dateLoaned);
					System.out.println("Due Date: " + dueDate);
					System.out.println("Date Returned: " + dateReturned);
					System.out.println("Days between: " + daysBetween);
					
					if (daysBetween > 10) { 
						System.out.println("\n ********** WARNING **********");
						System.out.println("Item has been loaned 10 days or more!");
						System.out.println("A fine has been issued onto the users account");						
						// Create text file for the User to add fine information 
						try {
							BufferedWriter out = new BufferedWriter(new FileWriter("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserFines\\" + u.getUserName() + ".txt"));
							//BufferedWriter out = new BufferedWriter(new FileWriter("\\OOP - Assessment\\UserLoans\\" + u.getUserName() + ".txt"));
							out.write("User: " + stock.getUserLoaned() +"\nReturned item late: " + stock.getTitle() + "\nby: " + (daysBetween - 10) + " Day(s)");
							out.write("\nUsers Fine: £" + 0.50 * (daysBetween - 10));
							
							out.flush();
							out.close();						
							} catch (IOException i) { 
								System.out.println("Error! File not found");
								//i.printStackTrace();
							}
						}						
					} else if (!u.getUserName().contains(uName) && !Users.hasNext()) { 
						System.out.println("Error! User not found");
					}
				} // End of user iterator				
			} 
		} // End of items iterator
	}	
	// Generate instance report
	public void genInstanceReport() { 		
		try {
			// Create file writer
			//FileWriter Itemwrite = new FileWriter("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\GenerationReports\\Itemreport.txt");
			FileWriter Itemwrite = new FileWriter("C:\\OOP - Assessment\\GenerationReports\\Itemreport.txt");
			//FileWriter UserWriter = new FileWriter("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\GenerationReports\\UserReport.txt"); 
			FileWriter UserWriter = new FileWriter("C:\\OOP - Assessment\\GenerationReports\\UserReport.txt");
			// Loop through Stock instances
			for (Stock s: Glencaldy.stock) { 
				Itemwrite.write("Stocks: " + s.toString() + "\n");
			}
			Itemwrite.close();
			// Loop through User Instances 
			for (User u: Glencaldy.users) { 			
				UserWriter.write("Users: " + u.toString() + "\n");
			}	
		UserWriter.close();
		// Write to file 
		} catch (IOException e) { 
			//e.printStackTrace();
			System.out.println("Error. file not found");
		}		
	}
	// Edit stock 
	public void editStock() { 
		// Allow Admin users to edit current stock 
		Scanner o = new Scanner(System.in); 
		String option; 	
		do { 
			
			System.out.println("1 - Edit existing stock");
			System.out.println("2 - Return to menu");
			option = o.next(); 
			
			switch (option) { 
			case "1": // Edit stock
				Scanner e = new Scanner(System.in); 
				System.out.println("Enter the title of the item you'd like to edit: ");
				String title = e.next();
				Iterator<Stock> it = Glencaldy.stock.iterator(); // Search through stock array 
				while(it.hasNext()) { 
					Stock s = it.next(); 
					if (s.getTitle().contains(title) && s.grade() == ItemType.book && s.getLoan() == false) { // Check whether stock item exists
						Scanner edit = new Scanner(System.in);
						
						System.out.println("What would you like to edit:");
						System.out.println("1 - Edit title");
						System.out.println("2 - Edit ISBN");
						System.out.println("3 - Edit Author"); 								
						System.out.println("4 - Edit cost");
						System.out.println("5 - Subject Area");
						System.out.println("6 - Publisher");
						System.out.println("7 - Number of Pages");
					
						String op = edit.next();
						
						switch(op) { 
						case "1":
							Scanner i = new Scanner(System.in);
							System.out.println("Enter New title: ");
							String newTitle = i.nextLine();
							newTitle.trim(); // Stops text being cut off. takes the whole sentence
							s.setTitle(newTitle);
							break;
						case "2":
							Scanner a = new Scanner(System.in);
							System.out.println("Enter New ISBN: ");
							int ISBN = a.nextInt();
							s.setISBN(ISBN);
							break;
						case "3":
							Scanner b = new Scanner(System.in);
							System.out.println("Enter new Author: ");
							String Author = b.nextLine();
							Author.trim();
							s.setAuthor(Author);
							break;
						case "4":
							Scanner c = new Scanner(System.in);
							System.out.println("Enter Cost:");
							Double cost = c.nextDouble(); 
							s.setCost(cost);
							break;
						case "5":
							Scanner d = new Scanner(System.in);
							System.out.println("Enter new Subject Area:");
							String SA = d.nextLine();
							SA.trim();
							s.setSubArea(SA);
							break;	
						case "6":
							Scanner f = new Scanner(System.in);
							System.out.println("Enter new Publisher");
							String pub = f.nextLine();
							pub.trim(); 
							s.setPublisher(pub);														
							break;
						case "7":
							Scanner g = new Scanner(System.in);
							System.out.println("Enter number of pages: ");
							int pages = g.nextInt();
							s.setPages(pages);
							break;					
						default: 
							System.out.println("Enter an option");
							break;
						}
						//Alert user stock has been updated
						System.out.println("Stock has been updated");						
					} else if (s.getTitle().contains(title) && s.grade() == ItemType.journals && s.getLoan() == false) { 
						
						Scanner edit = new Scanner(System.in);
						
						System.out.println("What would you like to edit:");
						System.out.println("1 - Edit title");
						System.out.println("2 - Edit ISSN"); 						 
						System.out.println("3 - Edit Issue Number");
						System.out.println("4 - Edit Date of issue");
						System.out.println("5 - Edit cost");
						System.out.println("6 - Edit Subject area");
						System.out.println("7 - Edit publisher");
						System.out.println("8 - Edit total pages");
					
						String op = edit.next();
						
						switch(op) { 
						case "1":
							Scanner i = new Scanner(System.in);
							System.out.println("Enter New title: ");
							String newTitle = i.nextLine();
							newTitle.trim(); // Stops text being cut off. takes the whole sentence
							s.setTitle(newTitle);
							break;
						case "2":
							Scanner a = new Scanner(System.in);
							System.out.println("Enter New ISSN: ");
							int ISSN = a.nextInt();
							s.setISSN(ISSN);
							break;
						case "3":
							Scanner b = new Scanner(System.in);
							System.out.println("Enter New Issue Number: ");
							int IssueNum = b.nextInt();
							s.setIssueNum(IssueNum);
							break;
						case "4":
							Scanner k = new Scanner(System.in);
							System.out.println("Enter new Date of Issue:");
							String doi = k.nextLine();
							doi.trim();
							s.setDateIssue(doi);
							break;
						case "5":
							Scanner c = new Scanner(System.in);
							System.out.println("Enter Cost:");
							Double cost = c.nextDouble(); 
							s.setCost(cost);
							break;	
						case "6":
							Scanner d = new Scanner(System.in);
							System.out.println("Enter new Subject Area:");
							String SA = d.nextLine();
							SA.trim();
							s.setSubArea(SA);	
							break;
						case "7":
							Scanner f = new Scanner(System.in);
							System.out.println("Enter new Publisher");
							String pub = f.nextLine();
							pub.trim(); 
							s.setPublisher(pub);
							break;
						case "8":
							Scanner g = new Scanner(System.in);
							System.out.println("Enter total pages: ");
							int totalPages = g.nextInt();
							s.setPages(totalPages);
							break;
						default: 
							System.out.println("Enter an option");
							break;
						}
						
					} else if (s.getTitle().contains(title) && s.grade() == ItemType.video  && s.getLoan() == false) { 
						Scanner edit = new Scanner(System.in);
						
						System.out.println("What would you like to edit:");
						System.out.println("1 - Edit title");
						System.out.println("2 - Edit run time");
						System.out.println("3 - Edit video format"); 								
						System.out.println("4 - Edit Genre");
						System.out.println("5 - Edit cost");
						System.out.println("6 - Edit Publisher");
						System.out.println("7 - Edit Storage");
					
						String op = edit.next();
						
						switch(op) { 
						case "1":
							Scanner i = new Scanner(System.in);
							System.out.println("Enter New title: ");
							String newTitle = i.nextLine();
							newTitle.trim(); // Stops text being cut off. takes the whole sentence
							s.setTitle(newTitle);
							break;
						case "2":
							Scanner a = new Scanner(System.in);
							System.out.println("Enter New runtime: ");
							int time = a.nextInt();
							s.setRuntime(time);
							break;
						case "3":
							Scanner b = new Scanner(System.in);
							System.out.println("Enter video Format: ");
							String Author = b.next(); 
							Author.trim();
							s.setAuthor(Author);
							break;
						case "4":
							Scanner c = new Scanner(System.in);
							System.out.println("Enter Genre:");
							String Genre = c.next();
							Genre.trim();
							s.setGenre(Genre);
							break;
						case "5":
							Scanner d = new Scanner(System.in);
							System.out.println("Enter Cost:");
							Double cost = d.nextDouble(); 
							s.setCost(cost);
							break;
						case "6":
							Scanner f = new Scanner(System.in);
							System.out.println("Enter new Publisher");
							String pub = f.next();
							pub.trim();
							s.setPublisher(pub);														
							break;
						case "7":
							Scanner g = new Scanner(System.in);
							System.out.println("Enter Storage Type: ");
							String storageType = g.next();
							storageType.trim();
							s.setStorage(storageType);
							break;					
						default: 
							System.out.println("Enter an option");
							break;
						}
						
						System.out.println("Stock has been updated");
						

					} else if (s.getTitle().contains(title) && s.grade() == ItemType.compactDisc && s.getLoan() == false) { 
						Scanner edit = new Scanner(System.in);
						
						System.out.println("What would you like to edit:");
						System.out.println("1 - Edit title");
						System.out.println("2 - Edit Artist"); 						 
						System.out.println("3 - Edit run time");
						System.out.println("4 - Edit Cost");
						System.out.println("5 - Edit cd type");
						System.out.println("6 - Edit number of Tracks");
						System.out.println("7 - Edit Publisher");
						System.out.println("8 - Edit storage type");						
					
						String op = edit.next();
						
						switch(op) { 
						case "1":
							Scanner i = new Scanner(System.in);
							System.out.println("Enter New title: ");
							String newTitle = i.nextLine();
							newTitle.trim(); // Stops text being cut off. takes the whole sentence
							s.setTitle(newTitle);
							break;
						case "2":
							Scanner h = new Scanner(System.in);
							System.out.println("Enter New Artist: ");
							String Artist = h.nextLine();
							Artist.trim(); // Stops text being cut off. takes the whole sentence
							s.setArtist(Artist);
							break;
						case "3":
							Scanner a = new Scanner(System.in);
							System.out.println("Enter New runtime: ");
							int time = a.nextInt();
							s.setRuntime(time);
							break;
						case "4":
							Scanner c = new Scanner(System.in);
							System.out.println("Enter Cost:");
							Double cost = c.nextDouble(); 
							s.setCost(cost);							
							break;
						case "5":
							Scanner d = new Scanner(System.in);
							System.out.println("Enter new cd type:");
							String cd = d.nextLine();
							cd.trim();
							s.setCDType(cd);	
							break;	
						case "6":
							Scanner j = new Scanner(System.in);
							System.out.println("Enter number of tracks: ");
							int numTracks = j.nextInt();
							s.setNumTrack(numTracks);
							break;
						case "7":
							Scanner f = new Scanner(System.in);
							System.out.println("Enter new Publisher");
							String pub = f.next();
							pub.trim();
							s.setPublisher(pub);
							break;
						case "8":
							Scanner g = new Scanner(System.in);
							System.out.println("Enter Storage Type: ");
							String storageType = g.next();
							storageType.trim();
							s.setStorage(storageType);
							break;
						default: 
							System.out.println("Enter an option");
							break;
						}
					} if(!it.hasNext()) { // Display error
						System.out.println("Error Item doesn't exist");
					}
				}
				break; 
			case "2": // Return to admin menu
				Glencaldy menu = new Glencaldy();
				menu.adminMenu();
				break;
			default:
				System.out.println("Error incorrect input");
				break;
			}
			
		} while (option != "2");
	}
	// Allow users to reserve stock 
	public void reserveStock() { 
		Scanner loan = new Scanner(System.in);
		String s;		
		do {
			System.out.println("Please select what you would like to do:  ");
			System.out.println("1 - Reserve Item");
			System.out.println("2 - Menu");
			s = loan.next();		// Error NoSuchElementException : Occurs when User presses 2 to go  back to search
			Boolean loaned = false; 		
				
			switch (s) {
			case "1": 		 
				do {
					Scanner item = new Scanner(System.in); 
					System.out.println("Please enter the title of the item you'd like to Reserve: ");				
					String title = item.nextLine();
				
					// Search stock for the title the user has entered
					Iterator<Stock> stk = Glencaldy.stock.iterator(); 
					while(stk.hasNext()) {
						Stock st = stk.next();
						if (st.getTitle().contains(title) && st.getLoan() == false) { 						
							Scanner usr = new Scanner(System.in);
							Scanner pwd = new Scanner(System.in);
							
							System.out.println("Please enter your username & password to reserve this item: ");
							System.out.println("Enter username: ");
							String userName = usr.nextLine();
							System.out.println("Enter password: ");
							String password = pwd.nextLine(); 						
		
							Iterator<User> u = Glencaldy.users.iterator();
							while(u.hasNext()) { 
								User user = u.next();							
								//File checkFile = new File("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserFines\\" + user.getUserName() + ".txt");
								File checkFile = new File("C:\\OOP - Assessment\\UserFines\\" + user.getUserName() + ".txt");
								if (checkFile.exists()) {				
									System.out.println("Error! You have outstanding fines that have yet to be paid! See Administrator");																
								} else if (!checkFile.exists()) {
									if (user.getUserName().contains(userName) && user.getPassword().contains(password)) {								
										if (user.getBorrowAmount() > 0) {
											user.setBorrowAmount((user.getBorrowAmount() - 1)); 									
											System.out.println(user.getUserName() + " has reserved " + title);
											System.out.println("Borrows left: " + user.getBorrowAmount());
											//Set borrow to true
											st.setLoan(true);
											loaned = true;	
											// Serilize stock array
											try {
												//String stockPath = "F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\stockInfo\\stockInfo.ser";
												String stockPath = "C:\\OOP - Assessment\\stockInfo\\stockInfo.ser";
												FileOutputStream f = new FileOutputStream(stockPath);
												ObjectOutputStream soos = new ObjectOutputStream(f);			
												soos.writeObject(Glencaldy.stock);
												
												soos.close();
												f.close();
												
												//FileOutputStream fos = new FileOutputStream("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserInfo\\info.ser");
												FileOutputStream fos = new FileOutputStream("C:\\OOP - Assessment\\UserInfo\\info.ser");
												ObjectOutputStream oos = new ObjectOutputStream(fos);
												oos.writeObject(Glencaldy.users);
												oos.close(); 
												fos.close(); 
											} catch (EOFException e) { 
												//e.printStackTrace();
											} catch (IOException e) { 
												System.out.println("Error! file not found");										
											}
											
										} else { 
											System.out.println("Error! unable to reserve this item. Loan limit reached");
											System.out.println("Borrows left: " + user.getBorrowAmount());
										}
										// Write loan to file 
										try {										
											// setup file writer
											//File loanFile = new File("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserLoans\\" + user.getUserName() + st.getTitle() + ".txt");
											File loanFile = new File("C:\\OOP - Assessment\\UserLoans\\" + user.getUserName() + st.getTitle() + ".txt");
											FileWriter writer = new FileWriter(loanFile);									
											if (loanFile.exists()) { 
												//FileWriter writer1 = new FileWriter("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserLoans\\" + user.getUserName() + st.getTitle() + ".txt");
												FileWriter writer1 = new FileWriter("C:\\OOP - Assessment\\UserLoans\\" + user.getUserName() + st.getTitle() + ".txt");
												// Get Current date for when the loan was issued
												DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
												LocalDateTime date = LocalDateTime.now();
												st.setLoanDate(dtf.format(date));									
												// Set userName of the user who loaned it
												st.setUserLoaned(userName);
												
												SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
												Calendar c = Calendar.getInstance(); 
												try { 
													c.setTime(sdf.parse(st.getLoanDate()));
												} catch (ParseException e) { 
													//e.printStackTrace();
												}
												c.add(Calendar.DAY_OF_WEEK, 10);
												String dueDate = sdf.format(c.getTime());
												st.setReturnDate(dueDate);
												writer1.write("Item Loaned: " + title + "\n" + "User: " + userName + "\n" + "Name: " + user.getfName() + "\nDate Loaned: " + st.getLoanDate() + "\nDue date: " + st.getReturnedDate());
												writer1.close();
											} else {										
											// Get Current date for when the loan was issued
											DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
											LocalDateTime date = LocalDateTime.now();
											st.setLoanDate(dtf.format(date));									
											// Set userName of the user who loaned it
											st.setUserLoaned(userName);
											
											SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
											Calendar c = Calendar.getInstance(); 
											try { 
												c.setTime(sdf.parse(st.getLoanDate()));
											} catch (ParseException e) { 
												//e.printStackTrace();
											}
											c.add(Calendar.DAY_OF_WEEK, 10);
											String dueDate = sdf.format(c.getTime());
											st.setReturnDate(dueDate);
											writer.write("Item Loaned: " + title + "\n" + "User: " + userName + "\n" + "Name: " + user.getfName() + "\nDate Loaned: " + st.getLoanDate() + "\nDue date: " + st.getReturnedDate());
											writer.close();
											}
										} catch (IOException e){ 
											//e.printStackTrace();
										}
										
										// Serilize stock array
										try {
											//String stockPath = "F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\stockInfo\\stockInfo.ser";
											String stockPath = "C:\\OOP - Assessment\\stockInfo\\stockInfo.ser";
											FileOutputStream f = new FileOutputStream(stockPath);
											ObjectOutputStream soos = new ObjectOutputStream(f);			
											soos.writeObject(Glencaldy.stock);
											
											soos.close();
											f.close();
											
											//FileOutputStream fos = new FileOutputStream("F:\\College\\HND Software Dev SEM2\\Object Oriented Programming & Design - JB\\OOP - Assessment\\UserInfo\\info.ser");
											FileOutputStream fos = new FileOutputStream("C:\\OOP - Assessment\\UserInfo\\info.ser");
											ObjectOutputStream oos = new ObjectOutputStream(fos);
											oos.writeObject(Glencaldy.users);
											oos.close(); 
											fos.close(); 									
										} catch (IOException e) { 
											System.out.println("Error! file not found");										
										}
									
									} else if ((!user.getUserName().contains(userName) && !user.getPassword().contains(password)) && !u.hasNext()) { 
										System.out.println("Error Username or password doesn't exist");
									}
								} // End of file check if	
							} // End of user iterator
						} 					
					} // End of for (Stock)			
				} while (loaned != true);		
				break;
			case "2": 
				String username; 
				Scanner usr = new Scanner(System.in);
				System.out.println("Enter your Username to return to menu");
				username = usr.nextLine();
				Iterator<User> u2 = Glencaldy.users.iterator();
				while(u2.hasNext()) {
					User u = u2.next();				
					if (u.getUserName().contains(username) && u.getType() == UserType.Full) {
						Glencaldy main = new Glencaldy();
						main.fullMenu();
					}
					if (u.getUserName().contains(username) && u.getType() == UserType.Staff) {
						Glencaldy main = new Glencaldy();
						main.staffMenu();
					}
					if (!u2.hasNext()) { 
						System.out.println("Error! User not found");
					}
				}		
				break; 
			default: 
				System.out.println("Enter correct input");
				break;
			} // End of switch			
		} while (s != "2");
	}
} // End of Catalogue class