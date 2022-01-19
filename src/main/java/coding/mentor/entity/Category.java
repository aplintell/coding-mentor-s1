package coding.mentor.entity;

public class Category {
	private long id;
	private String name;
	private boolean show;

	public Category() {
		super();
	}

	public Category(long id, String name, boolean show) {
		super();
		this.id = id;
		this.name = name;
		this.show = show;
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

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

}
