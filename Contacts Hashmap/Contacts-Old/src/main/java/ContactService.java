import java.util.ArrayList;
public class ContactService {
	
	ArrayList<Contact> contactList = new ArrayList<Contact>();
	
	//Method for adding contacts to the contactList
	public Boolean addContact(Contact contact) {
		boolean didAdd = false;
		//Adds the contact if there are not contacts in contactList
		if (contactList.size() == 0) {
			contactList.add(contact);
			didAdd = true;
		}
		else {
			//Adds the new contact if the list does not contain a contact with the same ID
			for (Contact c: contactList) {
				if (contact.getId().equalsIgnoreCase(c.getId())){
					return didAdd;
				}
			}
			contactList.add(contact);
			didAdd = true;
		}
		return didAdd;
	}
	
	//Deletes a contact from the list if it contains the given ID
	public void deleteContact(String id) {
		for (Contact c: contactList) {
			if (id.equalsIgnoreCase(c.getId())){
				contactList.remove(c);
			}
		}
	}
	
	//Changes the first name of the contact with the given ID
	public void changeFirstName(String id, String firstName) {
		for (Contact c: contactList) {
			if (id.equalsIgnoreCase(c.getId())){
				c.setFirstName(firstName);
			}
		}
	}
	
	//Changes the last name of the contact with the given ID
	public void changeLastName(String id, String lastName) {
		for (Contact c: contactList) {
			if (id.equalsIgnoreCase(c.getId())){
				c.setLastName(lastName);
			}
		}
	}
	
	//Changes the number of the contact with the given ID
	public void changeNumber(String id, String number) {
		for (Contact c: contactList) {
			if (id.equalsIgnoreCase(c.getId())){
				c.setNumber(number);
			}
		}
	}
	
	//Changes the address of the contact with the given ID
	public void changeAddress(String id, String address) {
		for (Contact c: contactList) {
			if (id.equalsIgnoreCase(c.getId())){
				c.setAddress(address);
			}
		}
	}
}
