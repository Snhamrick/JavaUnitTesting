package test;
import service.AppointmentService;
import service.Contact;
import service.ContactService;
import service.Appointment;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {														//TEST APPOINTMENT SERVICE
	
	Date testDate = new Date(System.currentTimeMillis());							//setting currentTime to be used in tests
	Date testTime = new Date(testDate.getTime() + 10);								//testTime variable in future to be used in appointment creation

	@Test
	void TestAppointmentServiceClass() {											//test service object creation
		AppointmentService testService = new AppointmentService();
		assertTrue(testService.getAppointmentList().equals(new ArrayList<Appointment>()));
	}
	
	@Test
	void TestAddAppointment() {														//test adding an appointment
		AppointmentService testService = new AppointmentService();
		Appointment testAppointment1 = new Appointment("00001", testTime, "testing appointmentservice class");
		Appointment testAppointment2 = new Appointment("00002", testTime, "testing appointmentservice class");
		testService.addAppointment(testAppointment1);
		testService.addAppointment(testAppointment2); 
		assertTrue(testService.getAppointmentList().get(0).equals(testAppointment1));
		assertTrue(testService.getAppointmentList().get(1).equals(testAppointment2));
	}
	
	@Test
	void TestAddDuplicate() {														//test adding a duplicate ID
		AppointmentService testService = new AppointmentService();
		Appointment testAppointment1 = new Appointment("00001", testTime, "testing appointmentservice class");
		testService.addAppointment(testAppointment1);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testService.addAppointment(testAppointment1);
		}); 
	}

	
	@Test	
	void TestUpdateDate() {															//test updating the date
		Date update = new Date(System.currentTimeMillis());
		Date updateDate = new Date(update.getTime() + 10);
		AppointmentService testService = new AppointmentService();
		Appointment testAppointment1 = new Appointment("00001", new Date(System.currentTimeMillis()), "testing appointmentservice class");
		testService.updateAppointmentDate(testAppointment1, updateDate);
		assertTrue(testAppointment1.getApptDate().compareTo(updateDate) == 0);
	}
	
	@Test
	void TestUpdatePastDate() {														//test attempting to update with past date
		Date pastDate = new Date(testDate.getTime() - 10);
		AppointmentService testService = new AppointmentService();
		Appointment testAppointment1 = new Appointment("00001", testTime, "testing appointmentservice class");
		Assertions.assertThrows(IllegalArgumentException.class, () ->  {
		testService.updateAppointmentDate(testAppointment1, pastDate);
		});
	}
	
	
	@Test
	void TestDeleteAppointment() {													//test deleting an appointment
		AppointmentService testService = new AppointmentService();
		Appointment testAppointment1 = new Appointment("00001", testTime, "testing appointmentservice class");
		testService.addAppointment(testAppointment1);
		testService.deleteAppointment("00001");
		assertTrue(testService.getAppointmentList().isEmpty());
	}
	
	@Test
	void TestDeleteNotFound() {														//test delete ID not found
		AppointmentService testService = new AppointmentService();
		Appointment testAppointment1 = new Appointment("00001", testTime, "testing appointmentservice class");
		Appointment testAppointment2 = new Appointment("00002", testTime, "testing appointmentservice class");
		testService.addAppointment(testAppointment1);
		testService.addAppointment(testAppointment2); 
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testService.deleteAppointment("00003");
		});
		}
		
}
