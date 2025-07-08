package Library;

public class Video extends Stock {
	// Video class extends from stock and will store Video values 

	private static final long serialVersionUID = 1L;
	private ItemType grade = ItemType.video;
	// Create Constructor for Video 
	public Video(String id, int time, String videoFormat, String genre, String title, Double cost, String publisher, String storage, ItemType grade, boolean loaned, String userLoaned) { 
		super(id, time, videoFormat, genre, title, cost, publisher, storage, grade, loaned, userLoaned);
	}
}
