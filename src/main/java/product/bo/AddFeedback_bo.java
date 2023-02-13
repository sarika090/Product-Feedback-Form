package product.bo;

public class AddFeedback_bo {
    
	private int id;
	private String name;
	private String email;
	private String phone;
	private String comment;
	private String rating;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	
	
	@Override
	public String toString() {
		return "AddFeedback_bo [name=" + name + ", email=" + email + ", phone=" + phone + ", comment="
				+ comment + ", rating=" + rating + "]";
	}
	
	public AddFeedback_bo(String name, String email, String phone, String comment, String rating) {
		super();

		this.name = name;
		this.email = email;
		this.phone = phone;
		this.comment = comment;
		this.rating = rating;
	}
	public AddFeedback_bo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
