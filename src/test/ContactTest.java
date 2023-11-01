package test;
import service.Contact;



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {
	
	@Test
	void testContactClass() {																							//test class creation
		Contact testContact = new Contact("25826", "Steve", "Hamilton", "3048729999", "178 Don Knotts Blvd");
		assertTrue(testContact.getContactId().equals("25826"));
		assertTrue(testContact.getFirstName().equals("Steve"));
		assertTrue(testContact.getLastName().equals("Hamilton"));
		assertTrue(testContact.getPhone().equals("3048729999"));
		assertTrue(testContact.getAddress().equals("178 Don Knotts Blvd"));
		
	}
	
	@Test
	void testContactIdLength() {																						//test ID too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {	
			new Contact("2582600000000", "Steve", "Hamilton", "3048729999", "178 Don Knotts Blvd");
		}); }
	
	@Test
	void testContactIdNull() {																							//test NULL ID
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Steve", "Hamilton", "3048729999", "178 Don Knotts Blvd");
		}); }
		

	@Test
	void testFirstNameLength() {																						//test first name too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("25826", "Steveeeeeeeeee", "Hamilton", "3048729999", "178 Don Knotts Blvd");
		}); }
	

	@Test
	void testFirstNameNull() {																							//test NULL first name
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("25826", null, "Hamilton", "3048729999", "178 Don Knotts Blvd");
		}); }
	
	@Test
	void testLastNameLength() {																							//test last name too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("25826", "Steve", "Hamiltonnnnnnnnn", "3048729999", "178 Don Knotts Blvd");
		}); }
	
	@Test
	void testLastNameNull() {																							//test NULL last name
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("25826", "Steve", null, "3048729999", "178 Don Knotts Blvd");
		}); }
	
	@Test
	void testPhoneShort() {																								//test phone number too short
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("25826", "Steve", "Hamilton", "30487299", "178 Don Knotts Blvd");
		}); }
	
	@Test
	void testPhoneLong() {																								//test phone number too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("25826", "Steve", "Hamilton", "30487299999999", "178 Don Knotts Blvd");
		}); }
	
	@Test
	void testPhoneNull() {																								//test NULL phone number
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("25826", "Steve", "Hamilton", null, "178 Don Knotts Blvd");
		}); }
	
	@Test
	void testAddressLength() {																							//test address too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("25826", "Steve", "Hamilton", "3048729999", "178 Don Knotts Blvd000000000000");
		}); }
	
	@Test
	void testAddressNull() {																							//test NULL address
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("25826", "Steve", "Hamilton", "3048729999", null);
		}); }
}
	

	
	
	
