public class Contact {
	private String id;
	private String firstName;
	private String lastName;
	private String number;
	private String address;
	
	public Contact(String id, String firstName, String lastName, String number, String address) {
		//Ensures ID length is less than or equal to 10 and not null
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		//Ensures First Name length is less than or equal to 10 and not null
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		//Ensures Last Name length is less than or equal to 10 and not null
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		//Ensures number length is equal to 10 and not null
		if (number == null || number.length() != 10) {
			throw new IllegalArgumentException("Invalid Number");
		}
		//Ensures address length is less than or equal to 30 and not null
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		this.address = address;
	}
	
	public String getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getNumber() {
		return number;
	}
	public String getAddress() {
		return address;
	}
	
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		this.lastName = lastName;
	}
	
	public void setNumber(String number) {
		if (number == null || number.length() != 10) {
			throw new IllegalArgumentException("Invalid Number");
		}
		this.number = number;
	}
	
	public void setAddress(String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		this.address = address;
	}
}
