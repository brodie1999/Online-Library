package Library;

public class Journal extends Stock{
	// Journal class extends from stock and will store Journal values 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ItemType grade = ItemType.journals;
	// Create Constructor for Journal
	public Journal(String stockID, int ISSN, int issueNum, String dateIssue ,String title, Double cost, String subjectArea, String publisher, int pages, ItemType grade ,Boolean loaned, String userLoan) { 
		super(stockID, ISSN, issueNum, dateIssue, title, cost, subjectArea, publisher, pages, grade, loaned, userLoan);
	}
}
