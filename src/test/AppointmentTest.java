package test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import service.Appointment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppointmentTest {
	Date currentTime = new Date(System.currentTimeMillis());														//currentTime

	@Test
	void TestAppointmentClass() {																					//test appointment class creation
		Date testTime = new Date(currentTime.getTime() + 10);		
		Appointment testAppointment = new Appointment("00001", testTime, "testing appointment class");
		
		assertTrue(testAppointment.getApptID().equals("00001"));
		assertTrue(testAppointment.getApptDate().compareTo(testTime) == 0);
		assertTrue(testAppointment.getApptDescription().equals("testing appointment class"));
	}
	
	@Test
	void TestAppointmentIDLength() {																				//test ID length too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("000000000001", currentTime, "testing appointment class");
		});
	}
		
	
	@Test
	void TestAppointmentIDNull() {																					//test ID null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, currentTime, "testing appointment class");
		});
		
	}
	
	@Test
	void TestAppointmentPastDate() {																				//test using a past date
		Date pastDate = new Date(currentTime.getTime() - 10);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment ("00001", pastDate, "testing appointment class");
		});
	}
	
	@Test
	void TestAppointmentFutureDate() {																				//test using a future date
		Date futureDate = new Date(currentTime.getTime() + 10);
		Appointment testAppointment = new Appointment("00001", futureDate, "testing appointment class");
		assertTrue(testAppointment.getApptDate().compareTo(futureDate) == 0);
	}

	@Test
	void TestAppointmentDateNull() {																				//test date null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("00001", null, "testing appointment class");
		});
	}
	
	@Test
	void TestAppointmentDescriptionLength() {																		//test description length too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("00001", new Date(2022, 12, 25), "testing appointment classssssssssssssssssssssssssss");
		});
	}
	
	@Test
	void TestAppointmentDescriptionNull() {																			//test description null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("00001", new Date(2022, 12, 25), null);
		});
	}
	

}
