package service;


public class Contact {
	
	private String contactId;														//variable for ID
	private String firstName;														//variable for first name
	private String lastName;														//variable for last name
	private String phone;															//variable for phone number
	private String address;															//variable for address
	
	/*Constructor*/
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {				
		
		setContactId(contactId);			//call function to set ID
		setFirstName(firstName);			//call function to set first name
		setLastName(lastName);				//call function to set last name
		setPhone(phone);					//call function to set phone number
		setAddress(address);				//call function to set address
	}
	
	public void setFirstName(String firstName) {							//function to set first name									
		if (firstName == null || firstName.length()>10) {						//IF first name is null or greater than 10 characters
			throw new IllegalArgumentException("Invalid firstName");				//THROW Exception
		}
		this.firstName = firstName;												//set first name
	}
	
	public void setLastName(String lastName) {								//function to set last name
		if (lastName == null || lastName.length()>10) {							//IF last name is null or greater than 10 characters
			throw new IllegalArgumentException("Invalid lastName");					//THROW Exception
		}		
		this.lastName = lastName;												//set last name
	}
	
	public void setPhone(String phone) {									//function to set phone number
		if (phone == null || phone.length() != 10) {							//IF number is null or not equal to 10 characters in length
			throw new IllegalArgumentException("Invalid phone");					//THROW Exception
		}
		this.phone = phone;														//set phone number
	}
	
	public void setAddress(String address) {								//function to set address
		if (address == null || address.length()>30) {							//IF address is null or greater than 30 characters
			throw new IllegalArgumentException("Invalid address");					//THROW Exception
		}
		this.address = address;													//set address
	}
	
	private void setContactId(String contactId) {							//PRIVATE function to set ID						
		if (contactId == null || contactId.length()>10) {						//IF ID is null or greater than 10 characters
			throw new IllegalArgumentException("Invalid contactId");				//THROW Exception
		}
		this.contactId = contactId;												//set ID
			
	}


public String getContactId() {												//function to return ID
	return contactId;
}

public String getFirstName() {												//function to return first name
	return firstName;
}

public String getLastName() {												//function to return last name
	return lastName;
}

public String getPhone() {													//function to return phone number
	return phone;
}

public String getAddress() {												//function to return address
	return address;
}

}
