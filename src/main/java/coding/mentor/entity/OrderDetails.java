package coding.mentor.entity;

public class OrderDetails {

	private long orderId;
	private long bookId;

	public OrderDetails() {
		// TODO Auto-generated constructor stub
	}

	public OrderDetails(long orderId, long bookId) {
		super();
		this.orderId = orderId;
		this.bookId = bookId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

}
