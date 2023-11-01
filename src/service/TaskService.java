package service;
import java.util.*;


public class TaskService {
	
	private ArrayList<Task> taskList;						//array list to store list of tasks
	
	public TaskService() {									//constructor
		taskList = new ArrayList<Task>();						//create new task list
	}
	
	public ArrayList<Task> getTaskList() {				//function to return task list
		return taskList;
	}

	public void addTask(Task addTask) {											//function to add task to task list
		for (int i = 0; i < taskList.size(); ++i) {									//for all of the tasks already in the list
			if (addTask.getTaskID() == taskList.get(i).getTaskID()) {					//if the taskID to be added matches one from the list
				throw new IllegalArgumentException("Duplicate ID");							//throw duplicate exception
			}
		}
		taskList.add(addTask);														//add task to task list
	}
	
	public void deleteTask(String deleteID) {									//function to delete task from task list
		for (int i = 0; i < taskList.size(); ++i) {									//for all of the tasks in task list
			if (deleteID == taskList.get(i).getTaskID()) {								//if the deleteID matches a task from the list
				taskList.remove(i);															//remove that task
			}
			
			else if (i == taskList.size() - 1) {										//else if the end of the list is reached without a match
				throw new IllegalArgumentException("Unable to find task ID");				//throw exception that task was not found
			}
		}
	}
	
	public void updateName(String updateID, String updatName) {						//function to update Name
		for (int i = 0; i < taskList.size(); ++i) {										//for all of the tasks in the task list
			if (updateID == taskList.get(i).getTaskID()) {									//if the ID to be updated matches an ID from the list
				taskList.get(i).setTaskName(updatName);											//update the name of that task
			}
			else if (i == taskList.size() - 1) {											//else if the end of the list is reached
				throw new IllegalArgumentException("Unable to find task to update");			//throw exception
			}
		}
	}
	
	public void updateDescription(String updateID, String updateDescription) {		//function to update Description
		for (int i = 0; i < taskList.size(); ++i) {										//for all of the tasks in the task list
			if (updateID == taskList.get(i).getTaskID()) {									//if the updateID matches an ID from the list
				taskList.get(i).setTaskDescription(updateDescription);							//update the description of that task
			}
			else if (i == taskList.size() - 1) {											//else if the end of the list is reached
				throw new IllegalArgumentException("Unable to update Description");				//throw exception
			}
			
			}
		}
	}
