package service;


public class Task {

	private String taskId;					//variable for taskID
	private String taskName;					//variable for name
	private String taskDescription;				//variable for description
	
	/*Constructor*/
	public Task(String taskID, String name, String description) {
		
		setTaskID(taskID);											//call function to set taskID
		setTaskName(name);											//call function to set taskName
		setTaskDescription(description);							//call function to set taskDescription
	}
	
	
	private void setTaskID(String taskNum) {						//private function to set taskID
		if (taskNum == null || taskNum.length() > 10) {					//can not be null or greater than 10
			throw new IllegalArgumentException("Invalid TaskID");			//throw exception
		}
		this.taskId = taskNum;											//set taskID
	}
	
	public void setTaskName(String name) {						//function to set task name 
		if (name == null || name.length() > 20) {					//can not be null or greater than 20
			throw new IllegalArgumentException("Invalid taskName");		//throw exception
		}
		this.taskName = name;										//set task name
		
	}
	
	public void setTaskDescription(String description) {			//function to set task description
		if (description == null || description.length() > 50) {			//can not be null or greater than 50
			throw new IllegalArgumentException("Invalid taskDescription");		//throw exception
		}
		this.taskDescription = description;								//set description
	}
	
	public String getTaskID() {										//function to return ID
		return taskId;
	}
	
	public String getTaskName() {									//function to return name
		return taskName;	
	}
	
	public String getTaskDescription() {							//function to return deactiption
		return taskDescription;
	}
	
}
