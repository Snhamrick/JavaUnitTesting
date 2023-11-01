package test;
import service.Task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {

	@Test
	void testTaskClass() {
		Task testTask = new Task("001", "Clean Kitchen", "Counters, strove, fridge, pantry, floor");
		assertTrue(testTask.getTaskID().equals("001"));
		assertTrue(testTask.getTaskName().equals("Clean Kitchen"));
		assertTrue(testTask.getTaskDescription().equals("Counters, strove, fridge, pantry, floor"));	
	}
	
	@Test
	void testTaskIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			new Task("000000000001", "Clean Kitchen", "Counters, strove, fridge, pantry, floor");
		}); }
	
	@Test
	void testTaskIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Clean Kitchen", "Counters, stove, fridge, pantry, floor");
		});
	}
	
	@Test
	void testTaskNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("001", "Clean Kitchennnnnnnnn", "Counters, stove, fridge, pantry, floor");
		});
	}
	
	@Test
	void testTaskNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("001", null, "Counters, stove, fridge, pantry, floor");
		});
	}
	@Test
	void testTaskDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("001", "Clean Kitchen", "Counters, stove, fridge, pantry, floor, cabinets, hhh");
		});
	}
	@Test
	void testTaskDescriptionNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("001", "Clean Kitchen", null);
		});
	}
	}
