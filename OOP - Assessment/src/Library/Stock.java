package Library;

import java.io.Serializable;
import java.util.Date;

public class Stock implements Serializable  {
	// Create Items to be displayed by the Catalogue 	
	// Also allow Admin users to edit stock within the system
	
	private static final long serialVersionUID = 1L;
	
	private int ISBN; 
	private int ISSN;
	private int issueNum;
	private int runTime; 
	private Double cost; 
	private int numTracks; 
	private int fee = -1;
	private int pages;
	
	private String stockID;
	private String format; 
	private String dateIssue;
	private String subjectArea;
	private String Author; 
	private String title; 
	private String genre; 
	private String storage; 
	private String artist;
	private String cdType; 
	private String publisher;
	private String userLoaned;
	
	private boolean loan;  
	private boolean loaned;	 
	
	private String loanDate;
	private String loanReturned;
	
	private ItemType grade; 		
	 
	// Regular Stock Contructor 
	public Stock(String stockID, String title, Double cost, ItemType grade, boolean loan) { 
		this.stockID = stockID; 
		this.title = title; 
		this.cost = cost; 
		this.grade = grade;
		this.loan = loan;	
	}	
	// Journal Constructor 
	public Stock(String stockID, int ISSN, int issueNum, String dateIssue ,String title, Double cost, String subjectArea, String publisher, int pages, ItemType grade ,Boolean loaned, String userLoaned) { 
		this.stockID = stockID; 
		this.ISSN = ISSN; 
		this.issueNum = issueNum;
		this.dateIssue = dateIssue;
		this.title = title; 
		this.cost = cost; 
		this.subjectArea = subjectArea; 
		this.publisher = publisher; 
		this.pages = pages;
		this.grade = grade; 
		this.loaned = loaned;
		this.userLoaned = userLoaned; 
	}
	
	// Book Contructor
	public Stock (String stockID, int ISBN, String Author, String title, Double cost, String subjectArea, String publisher, int pages, ItemType grade, boolean loaned, String userLoaned) { 
		this.stockID = stockID; 
		this.ISBN = ISBN;
		this.Author = Author; 
		this.title = title; 
		this.cost = cost; 
		this.subjectArea = subjectArea; 
		this.publisher = publisher; 
		this.pages = pages; 
		this.grade = grade; 
		this.loan = loaned; 
		this.userLoaned = userLoaned;
	}
	
	// video Contructor
	public Stock (String stockID, int time, String format, String genre, String title, Double cost, String publisher, String storage, ItemType grade, boolean loaned, String userLoaned) { 
		this.stockID = stockID; 
		this.runTime = time;
		this.format = format; 
		this.genre = genre; 
		this.title = title; 
		this.cost = cost; 
		this.publisher = publisher; 
		this.storage = storage; 
		this.grade = grade; 
		this.loan = loaned; 
		this.userLoaned = userLoaned;
	}
	
	// disc constructor
	public Stock(String stockID, int runTime, String cdType, int numTracks, String Artist, String title, Double cost, String publisher, String storage, ItemType grade, boolean loaned, String userLoaned) { 
		this.stockID = stockID; 
		this.runTime = runTime; 
		this.cdType = cdType; 
		this.numTracks = numTracks; 
		this.artist = Artist; 
		this.title = title; 
		this.cost = cost; 
		this.publisher = publisher; 
		this.storage = storage; 
		this.grade = grade; 
		this.loan = loaned; 
		this.userLoaned = userLoaned;
	}
	
	// Getters and setters for Book, Journal, video and Compact disc
	// These are in place in order for admin staff to edit existing stock items
	public String getID() { 
		return stockID; 
	}
	
	public void setID(String stockID) { 
		this.stockID = stockID; 
	}
	
	public String getTitle() { 
		return title; 
	}
		
	public void setTitle(String title) { 
		this.title = title; 
	}
	
	public int getISBN() { 
		return ISBN;
	}
	
	public void setISBN(int ISBN) { 
		this.ISBN = ISBN; 
	}
	
	public String getAuthor() { 
		return Author;
	}
	
	public void setAuthor(String Author) { 
		this.Author = Author;
	}
	
	public String getPublisher() { 
		return publisher; 
	}
	
	public void setPublisher(String pub) { 
		this.publisher = pub; 
	}
	
	public String getSubjectArea() { 
		return subjectArea;
	}
	
	public void setSubArea(String SA) { 
		this.subjectArea = SA;
	}
	
	public int getPages() { 
		return pages; 
	}
	
	public void setPages(int pages) { 
		this.pages = pages; 
	}
	
	public int getTime() { 
		return runTime; 
	}
	
	public void setRuntime(int runTime) { 
		this.runTime = runTime; 
	}

	public String getFormat() { 
		return format;
	}
	
	public void setFormat(String f) { 
		this.format = f; 
	}
	
	public int getISSN() { 
		return ISSN;
	}
	
	public void setISSN(int i) { 
		this.ISSN = i; 
	}

	public int getNumTracks() { 
		return numTracks; 
	}
	
	public void setNumTrack(int numTracks) { 
		this.numTracks = numTracks;
	}

	public int getIssueNum() { 
		return issueNum; 
	}
	
	public void setIssueNum(int issue) { 
		this.issueNum = issue; 
	}

	public String getDateIssue() {
		return dateIssue;
	}
	
	public void setDateIssue(String dateIssue) { 
		this.dateIssue = dateIssue; 
	}

	public String getGenre() { 
		return genre;
	}
	
	public void setGenre(String genre) { 
		this.genre = genre;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public void setArtist(String Artist) { 
		this.artist = Artist; 
	}
	
	public String getCDType() {
		return cdType;
	}
	
	public void setCDType(String type) { 
		this.cdType = type;
	}
	
	public String getStorage() {
		return storage; 
	}
	
	public void setStorage(String storage) { 
		this.storage = storage; 
	}
	
	public Double getCost() { 
		return cost; 
	}
	
	public void setCost(Double cost) { 
		this.cost = cost; 
	}
	
	public boolean getLoan() { 
		return loan;
	}
	
	public void setLoan(boolean loan) { 
		this.loan = loan; 
	}
	
	public ItemType grade() { 
		return grade; 
	}	
	
	public int getFee() { 
		return fee;
	}
	
	public String getUserLoaned() { 
		return userLoaned; 
	}
	
	public void setUserLoaned(String userLoaned) { 
		this.userLoaned = userLoaned;
	}
	
	public String getLoanDate() { 
		return loanDate;
	}
	
	public void setLoanDate(String loanDate) { 
		this.loanDate = loanDate;
	}
	
	public String getReturnedDate() { 
		return loanReturned;
	}
	
	public void setReturnDate(String returnDate) { 
		this.loanReturned = returnDate;
	}
	
	@Override
	public String toString() { 
		return "StockID: " + stockID + "\n" + "title: " + title +"\n" + "Cost: £" + cost + "\n" + "Loaned: " + loan + "\nItem type: " + grade + "\n";
	}	
}