package service;
import java.util.*;

public class AppointmentService {

	public ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();		//ArrayList to store appointments
	
	
	public ArrayList<Appointment> getAppointmentList() {								//function to return ArrayList of appointments
		return appointmentList;
	}
	
	public void addAppointment(Appointment appointment) {								//function to add appointments to list 
		for (int i = 0; i < appointmentList.size(); ++i) {
			String temp = appointmentList.get(i).getApptID();
			if (temp == appointment.getApptID()) {
				throw new IllegalArgumentException("Duplicate ID");
			}
		}
		appointmentList.add(appointment);
	}
	
	public void deleteAppointment(String deleteID) {									//function to delete appointment
		for (int i = 0; i < appointmentList.size(); ++i) {
			if (deleteID == appointmentList.get(i).getApptID()) {
				appointmentList.remove(i);
			}
			else if (i == appointmentList.size() - 1) {
				throw new IllegalArgumentException("ID not found");
			}
		}
	}
	
	public void updateAppointmentDate(Appointment updateAppt, Date updateDate) {		//function to update appointment date
		updateAppt.setDate(updateDate);	
	}
	
}
