package Library;

public class Disc extends Stock{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ItemType grade = ItemType.compactDisc; // Set grade to compactDisc
	// Disc contructor 
	public Disc(String stockID, int runTime, String cdType, int numTracks, String Artist, String title, Double cost, String publisher, String storageType, ItemType grade, boolean loan, String userLoaned) { 
		super(stockID, runTime, cdType, numTracks, Artist, title, cost, publisher, storageType, grade, loan, userLoaned); 
	}
}
