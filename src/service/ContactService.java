package service;

import java.util.*;

public class ContactService {
	
	private ArrayList<Contact> contactList;							//Private arrayList of contacts
		
	
	public ContactService() {										//Constructor
		contactList = new ArrayList<Contact>();							//Set contact list equal to new empty array list
			
	}
	
	public ArrayList<Contact> getContactList() {					//function to return contact list
		return contactList;
	}
	
	public void addContact(Contact t_contact) {											//function to add contact to contact list
		for (int i = 0; i < contactList.size(); i++) {										//FOR each contact in the contact list
			if (contactList.get(i).getContactId() == t_contact.getContactId()) {				//IF the contact to be added has the same ID as contact in the list
				throw new IllegalArgumentException("Duplicate ID");									//THROW Exception Duplicate
			}
		}
		contactList.add(t_contact);															//Add the contact to the list
	}
	
	public void deleteContact(String contactId) {										//function to delete contact from contact list
		for (int i = 0; i < contactList.size(); i++) {										//FOR all of the contacts in the contact list
			if (contactList.get(i).getContactId() == contactId) {								//IF the contact ID matches the ID to be deleted
				contactList.remove(i);																//remove the contact from the list
			}
			else if (i == contactList.size() - 1) {												//else if the end of the list is reached without finding the contact
				throw new IllegalArgumentException("Contact not found");							//THROW exception not found
			}
		}
	}
	
	public void updateFirstName(String contactId, String firstName) {				//function to update first name of contact
		for (int i = 0; i < contactList.size(); i++) {									//FOR each contact in the contact list
			if (contactId == contactList.get(i).getContactId()) {							//IF contact ID matches ID to be updated
				contactList.get(i).setFirstName(firstName);										//set first name to new desired name
			}
			else if (i == contactList.size() - 1) {												//else if the end of the list is reached without finding the contact
				throw new IllegalArgumentException("Contact not found");							//THROW exception not found
			}
		}
	}
	
	
	public void updateLastName(String contactId, String lastName) {					//function to update last name of contact
		for (int i = 0; i < contactList.size(); i++) {									//FOR each contact in the contact list
			if (contactId == contactList.get(i).getContactId()) {							//IF the contact ID matches the ID to be updated
				contactList.get(i).setLastName(lastName);										//set last name to new desired name
			}
			else if (i == contactList.size() - 1) {												//else if the end of the list is reached without finding the contact
				throw new IllegalArgumentException("Contact not found");							//THROW exception not found
			}
		}
	}
	
	public void updatePhone(String contactId, String phone) {						//function to update phone number
		for (int i = 0; i < contactList.size(); i++) {									//FOR each contact in the contact list
			if (contactId == contactList.get(i).getContactId()) {							//IF the contact ID matches the ID to be updated
				contactList.get(i).setPhone(phone);												//set phone number to new desired number
			}
			else if (i == contactList.size() - 1) {												//else if the end of the list is reached without finding the contact
				throw new IllegalArgumentException("Contact not found");							//THROW exception not found
			}
		}
	}
	
	public void updateAddress(String contactId, String address) {					//function to update address
		for (int i = 0; i < contactList.size(); i++) {									//FOR each contact in the contact list
			if (contactId == contactList.get(i).getContactId()) {							//IF the contact ID matches the ID to be updated
				contactList.get(i).setAddress(address);											//set the address to new desired address
			}
			else if (i == contactList.size() - 1) {												//else if the end of the list is reached without finding the contact
				throw new IllegalArgumentException("Contact not found");							//THROW exception not found
			}
		}
	}
	
	
	
}
