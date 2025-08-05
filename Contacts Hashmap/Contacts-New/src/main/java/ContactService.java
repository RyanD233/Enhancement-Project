import java.util.HashMap;
public class ContactService {
	
	HashMap<String, Contact> contactList = new HashMap<String, Contact>();
	
	//Method for adding contacts to the contactList
	public Boolean addContact(Contact contact) {
		boolean didAdd = false;
		//Adds the contact if its id is not in the list already
		if (!contactList.containsKey(contact.getId())) {
			contactList.put(contact.getId(), contact);
			didAdd = true;
		}
		return didAdd;
	}
	
	//Deletes a contact from the list if it contains the given ID
	public void deleteContact(String id) {
		contactList.remove(id);
	}
	
	//Changes the first name of the contact with the given ID
	public void changeFirstName(String id, String firstName) {
		contactList.get(id).setFirstName(firstName);
	}
	
	//Changes the last name of the contact with the given ID
	public void changeLastName(String id, String lastName) {
		contactList.get(id).setLastName(lastName);
	}
	
	//Changes the number of the contact with the given ID
	public void changeNumber(String id, String number) {
		contactList.get(id).setNumber(number);
	}
	
	//Changes the address of the contact with the given ID
	public void changeAddress(String id, String address) {
		contactList.get(id).setAddress(address);
	}
}
