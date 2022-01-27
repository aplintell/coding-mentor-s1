package coding.mentor.entity;

import java.util.Date;

public class Order {

	private long id;
	private long studentId;
	private Date submitDate;

	public Order() {
		super();
	}

	public Order(long id, long studentId, Date submitDate) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.submitDate = submitDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

}
