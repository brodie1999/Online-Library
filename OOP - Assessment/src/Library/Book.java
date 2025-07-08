package Library;

public class Book extends Stock {
	// Book class extends from stock and will store book values 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ItemType grade = ItemType.video;
	//Contructor for book
	public Book(String id, int ISBN, String author, String title, Double cost, String area, String publisher, int pages, ItemType grade, boolean loaned, String userLoaned) { 
		super(id, ISBN, author, title, cost, area, publisher, pages, grade, loaned, userLoaned);
	}
}
