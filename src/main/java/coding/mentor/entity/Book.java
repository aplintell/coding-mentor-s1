package coding.mentor.entity;

public class Book {
	private long id;
	private String name;
	private long categoryId;
	private int stock;
	private String description;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(long id, String name, long categoryId, int stock, String description) {
		super();
		this.id = id;
		this.name = name;
		this.categoryId = categoryId;
		this.stock = stock;
		this.description = description;
	}

	public Book(String name, long categoryId, int stock, String description) {
		super();
		this.name = name;
		this.categoryId = categoryId;
		this.stock = stock;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	@Override
//	public boolean equals(Object obj) {
//		Book other = (Book) obj;
//		return other.getId() == this.id;
//	}
//
//	@Override
//	public final int hashCode() {
//		int result = 17;
//		result = 31 * result + this.id;
//		return result;
//	}

}
