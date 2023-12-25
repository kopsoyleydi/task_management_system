package com.example.taskmanagementsystem;

import com.example.taskmanagementsystem.dto.response.TaskDto;
import com.example.taskmanagementsystem.mapper.TaskMapper;
import com.example.taskmanagementsystem.models.Task;
import com.example.taskmanagementsystem.models.enums.TaskPriority;
import com.example.taskmanagementsystem.models.enums.TaskStatus;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TaskManagementSystemApplicationTests {

	@Test
	void contextLoads() {
	}

	private final TaskMapper taskMapper = Mappers.getMapper(TaskMapper.class);

	@Test
	public void testToDto() {
		Task task = new Task();
		task.setId(1L);
		task.setTitle("Test Task");
		task.setDescription("Task Description");
		task.setStatus(TaskStatus.TODO);
		task.setPriority(TaskPriority.HIGH);

		TaskDto taskDto = taskMapper.toDto(task);

		assertEquals(task.getId(), taskDto.getId());
		assertEquals(task.getTitle(), taskDto.getTitle());
		assertEquals(task.getDescription(), taskDto.getDescription());
		assertEquals(task.getStatus(), taskDto.getStatus());
		assertEquals(task.getPriority(), taskDto.getPriority());
	}


	@Test
	public void testToModel() {
		TaskDto taskDto = new TaskDto();
		taskDto.setId(1L);
		taskDto.setTitle("Test Task");
		taskDto.setDescription("Task Description");
		taskDto.setStatus(TaskStatus.TODO);
		taskDto.setPriority(TaskPriority.HIGH);


		Task task = taskMapper.toModel(taskDto);


		assertEquals(taskDto.getId(), task.getId());
		assertEquals(taskDto.getTitle(), task.getTitle());
		assertEquals(taskDto.getDescription(), task.getDescription());
		assertEquals(taskDto.getStatus(), task.getStatus());
		assertEquals(taskDto.getPriority(), task.getPriority());
	}

	@Test
	public void testToDtoList() {
		// Given
		Task task1 = new Task();
		task1.setId(1L);
		task1.setTitle("Task 1");
		task1.setDescription("Description 1");
		task1.setStatus(TaskStatus.TODO);
		task1.setPriority(TaskPriority.HIGH);

		Task task2 = new Task();
		task2.setId(2L);
		task2.setTitle("Task 2");
		task2.setDescription("Description 2");
		task2.setStatus(TaskStatus.IN_PROCESS);
		task2.setPriority(TaskPriority.MEDIUM);

		List<Task> taskList = Arrays.asList(task1, task2);

		List<TaskDto> taskDtoList = taskMapper.toDtoList(taskList);

		assertEquals(taskList.size(), taskDtoList.size());
	}


	@Test
	public void testToModelList() {

		TaskDto taskDto1 = new TaskDto();
		taskDto1.setId(1L);
		taskDto1.setTitle("TaskDto 1");
		taskDto1.setDescription("DescriptionDto 1");
		taskDto1.setStatus(TaskStatus.TODO);
		taskDto1.setPriority(TaskPriority.HIGH);

		TaskDto taskDto2 = new TaskDto();
		taskDto2.setId(2L);
		taskDto2.setTitle("TaskDto 2");
		taskDto2.setDescription("DescriptionDto 2");
		taskDto2.setStatus(TaskStatus.IN_PROCESS);
		taskDto2.setPriority(TaskPriority.MEDIUM);

		List<TaskDto> taskDtoList = Arrays.asList(taskDto1, taskDto2);


		List<Task> taskList = taskMapper.toModelList(taskDtoList);


		assertEquals(taskDtoList.size(), taskList.size());
	}


}
