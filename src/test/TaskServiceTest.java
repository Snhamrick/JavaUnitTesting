package test;
import java.util.*;
import service.Task;
import service.TaskService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskServiceTest {

	@Test
	void testTaskServiceClass() {
		TaskService testService = new TaskService();
		assertTrue(testService.getTaskList().equals(new ArrayList<Task>()));
	}
	
	@Test
	void testAddTask() {
		TaskService testService = new TaskService();
		Task testTask = new Task("001", "Clean Kitchen", "Counters, stove, fridge, pantry, floor");
		testService.addTask(testTask);
		assertTrue(testService.getTaskList().get(0).equals(testTask));
	}
	
	@Test
	void testAddDuplicate() {
		TaskService testService = new TaskService();
		Task testTask = new Task("001", "Clean Kitchen", "Counters, stove, fridge, pantry, floor");
		Task testTask2 = new Task("001", "Wash Clothes", "Whites, Colors");
		testService.addTask(testTask);
		Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			testService.addTask(testTask2);
		});
	}
	
	@Test
	void testDeleteTask() {
		TaskService testService = new TaskService();
		Task testTask = new Task("001", "Clean Kitchen", "Counters, stove, fridge, pantry, floor");
		testService.addTask(testTask);
		testService.deleteTask("001");
		assertTrue(testService.getTaskList().equals(new ArrayList<Task>()));
	}
	
	@Test
	void testDeleteTaskNotFound() {
		TaskService testService = new TaskService();
		Task testTask = new Task("001", "Clean Kitchen", "Counters, stove, fridge, pantry, floor");
		testService.addTask(testTask);	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testService.deleteTask("000");
		});
	}
	
	@Test
	void testUpdateName() {
		TaskService testService = new TaskService();
		Task testTask = new Task("001", "Clean Kitchen", "Counters, stove, fridge, pantry, floor");
		testService.addTask(testTask);	
		testService.updateName("001", "Wash Kitchen");
		assertTrue(testService.getTaskList().get(0).getTaskName().equals("Wash Kitchen"));
	}
	
	@Test
	void testUpdateNameNotFound() {
		TaskService testService = new TaskService();
		Task testTask = new Task("001", "Clean Kitchen", "Counters, stove, fridge, pantry, floor");
		testService.addTask(testTask);	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testService.updateName("000", "Wash Kitchen"); 
		});
	}
		
	@Test
	void testUpdateDescription() {
		TaskService testService = new TaskService();
		Task testTask = new Task("001", "Clean Kitchen", "Counters, stove, fridge, pantry, floor");
		testService.addTask(testTask);	
		testService.updateDescription("001", "Wash Kitchen");
		assertTrue(testService.getTaskList().get(0).getTaskDescription().equals("Wash Kitchen"));
	}
	
	@Test
	void testUpdateDescriptionNotFound() {
		TaskService testService = new TaskService();
		Task testTask = new Task("001", "Clean Kitchen", "Counters, stove, fridge, pantry, floor");
		testService.addTask(testTask);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testService.updateDescription("000", "Wash Kitchen"); 
		});
	}
	

}
