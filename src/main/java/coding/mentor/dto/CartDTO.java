package coding.mentor.dto;

import java.util.List;

import coding.mentor.entity.Book;

public class CartDTO {

	private List<Book> books;

	public CartDTO(List<Book> books) {
		super();
		this.books = books;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
