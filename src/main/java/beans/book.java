package beans;

public class book {
	
	private String bookId;
	private String title;
	private String author;

	private int j;
	
	private float Price;
	private String Picture;
	
//	private int PublisherId;
//	private int CategoryId;
	
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getRelease() {
		return Release;
	}
	public void setRelease(int release) {
		Release = release;
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
	public String getPicture() {
		return Picture;
	}
	public void setPicture(String picture) {
		Picture = picture;
	}
	public book(String bookId, String title, String author, int release, float price, String picture) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		Release = release;
		Price = price;
		Picture = picture;
	}
	


	

}
