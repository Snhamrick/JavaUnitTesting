package service;
import java.util.*;


public class Appointment {
	
	private String appointmentID;														//private string to store ID
	public Date appointmentDate;														//Date to store appointment date
	public String appointmentDescription;												//string to store description
	
	
	public Appointment(String apptID, Date apptDate, String apptDescription) {			//constructor
		setApptID(apptID);
		setDate(apptDate);
		setApptDescription(apptDescription);
	}
	
	private void setApptID(String apptID) {												//private function to set appointment ID
		if (apptID == null || apptID.length()>10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		this.appointmentID = apptID;
	}
	
	public void setDate(Date date) {													//public function to set date
		if (date == null || date.before(new Date(System.currentTimeMillis()))) {
			throw new IllegalArgumentException("Invalid Date");
		}
		this.appointmentDate = date;
	}
	
	public void setApptDescription(String description) {								//public function to set description
		if (description == null || description.length()>50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		this.appointmentDescription = description;
	}
	
	public String getApptID() {															//function to return ID
		return appointmentID;
	}
	
	public Date getApptDate() {															//function to return Date
		return appointmentDate;
	}
	
	public String getApptDescription() {												//function to return description
		return appointmentDescription;
	}

}
