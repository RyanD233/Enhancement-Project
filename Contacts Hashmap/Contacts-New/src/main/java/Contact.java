public class Contact {
	private String id;
	private String firstName;
	private String lastName;
	private String number;
	private String address;

	private final int MAX_ID_LENGTH = 10;
	private final int MAX_NAME_LENGTH = 10;
	private final int MAX_NUMBER_LENGTH = 10;
	private final int MAX_ADDRESS_LENGTH = 30;
	
	public Contact(String id, String firstName, String lastName, String number, String address) {
		//Ensures ID length is less than or equal to 10 and not null
		if (id == null || id.length() > MAX_ID_LENGTH) {
			throw new IllegalArgumentException("Invalid ID");
		}
		this.id = id;

		setFirstName(firstName);
		setLastName(lastName);
		setNumber(number);
		setAddress(address);
	}

	// Checks if the string is an integer
	private boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
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
		//Ensures First Name length is less than or equal to 10 and not null
		if (firstName == null || firstName.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		//Ensures Last Name length is less than or equal to 10 and not null
		if (lastName == null || lastName.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		this.lastName = lastName;
	}
	
	public void setNumber(String number) {
		//Ensures number is an integer, its length is equal to 10, and not null
		if (number == null || !isInteger(number) || number.length() != MAX_NUMBER_LENGTH) {
			throw new IllegalArgumentException("Invalid Number");
		}
		this.number = number;
	}
	
	public void setAddress(String address) {
		//Ensures address length is less than or equal to 30 and not null
		if (address == null || address.length() > MAX_ADDRESS_LENGTH) {
			throw new IllegalArgumentException("Invalid Address");
		}
		this.address = address;
	}
}
