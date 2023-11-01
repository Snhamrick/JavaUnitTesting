package test;
import java.util.ArrayList;

import service.Contact;
import service.ContactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;



class ContactServiceTest {
	
	@Test
	void testContactServiceClass() {																				//test class creation
		ContactService testService = new ContactService();
		assertTrue(testService.getContactList().equals(new ArrayList<Contact>()));
	}
	
	@Test
	void testContactServiceAdd() {																					//test adding contact to list
		ContactService testService = new ContactService();
		Contact testContact = new Contact("25826", "Steve", "Hamilton", "3048729999", "178 Don Knotts Blvd");
		testService.addContact(testContact);
		assertTrue(testService.getContactList().get(0).equals(testContact));
		
	}
	
	@Test
	void testContactServiceAddDuplicate() {																			//test adding duplicate to contact list
		ContactService testService = new ContactService();
		Contact testContact = new Contact("25826", "Steve", "Hamilton", "3048729999", "178 Don Knotts Blvd");
		testService.addContact(testContact);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testService.addContact(testContact);
		}); }
	
	@Test
	void testContactServiceDeleteFound() {																			//test deleting a contact from list
		ContactService testService = new ContactService();
		Contact testContact = new Contact("25826", "Steve", "Hamilton", "3048729999", "178 Don Knotts Blvd");
		testService.addContact(testContact);
		testService.deleteContact("25826");
		assertTrue(testService.getContactList().isEmpty());
	}
	
	@Test
	void testContactServiceDeleteNotFound() {																		//test delete if not found
		ContactService testService = new ContactService();
		Contact testContact = new Contact("25826", "Steve", "Hamilton", "3048729999", "178 Don Knotts Blvd");
		testService.addContact(testContact);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testService.deleteContact("00000");
		}); 
	}
	
	@Test
	void testFirstNameUpdate() {																					//test updated first name
		ContactService testService = new ContactService();
		Contact testContact = new Contact("25826", "Steve", "Hamilton", "3048729999", "178 Don Knotts Blvd");
		testService.addContact(testContact);
		testService.updateFirstName("25826", "Ralph");
		assertTrue(testContact.getFirstName().equals("Ralph"));
	}
	
	@Test
	void testLastNameUpdate() {																						//test update last name
		ContactService testService = new ContactService();
		Contact testContact = new Contact("25826", "Steve", "Hamilton", "3048729999", "178 Don Knotts Blvd");
		testService.addContact(testContact);
		testService.updateLastName("25826", "Weasley");
		assertTrue(testContact.getLastName().equals("Weasley"));
	}
	
	@Test
	void testPhoneUpdate() {																						//test updated phone number
		ContactService testService = new ContactService();
		Contact testContact = new Contact("25826", "Steve", "Hamilton", "3048729999", "178 Don Knotts Blvd");
		testService.addContact(testContact);
		testService.updatePhone("25826", "3048729888");
		assertTrue(testContact.getPhone().equals("3048729888"));
	}
	
	@Test
	void testAddressUpdate() {																						//test updated address
		ContactService testService = new ContactService();
		Contact testContact = new Contact("25826", "Steve", "Hamilton", "3048729999", "178 Don Knotts Blvd");
		testService.addContact(testContact);
		testService.updateAddress("25826", "130 Windsor Drive");
		assertTrue(testContact.getAddress().equals("130 Windsor Drive"));
	}
	
	@Test
	void testAddressUpdateNotFound() {																						//test updated address not found
		ContactService testService = new ContactService();
		Contact testContact = new Contact("25826", "Steve", "Hamilton", "3048729999", "178 Don Knotts Blvd");
		testService.addContact(testContact);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testService.updateAddress("00000", "130 Windsor Drive");
		}); 
	}
	
	@Test
	void testPhoneUpdateNotFound() {																						//test updated phone number not found
		ContactService testService = new ContactService();
		Contact testContact = new Contact("25826", "Steve", "Hamilton", "3048729999", "178 Don Knotts Blvd");
		testService.addContact(testContact);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testService.updatePhone("00000", "3048728888");
		});
	}
	
	@Test
	void testLastNameUpdateNotFound() {																						//test update last name not found
		ContactService testService = new ContactService();
		Contact testContact = new Contact("25826", "Steve", "Hamilton", "3048729999", "178 Don Knotts Blvd");
		testService.addContact(testContact);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testService.updateLastName("00000", "Williams");
		});
	}
	
	@Test
	void testFirstNameUpdateNotFound() {																					//test updated first name not found
		ContactService testService = new ContactService();
		Contact testContact = new Contact("25826", "Steve", "Hamilton", "3048729999", "178 Don Knotts Blvd");
		testService.addContact(testContact);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testService.updateFirstName("00000", "Marcus");
		});
	}
	
	

}
