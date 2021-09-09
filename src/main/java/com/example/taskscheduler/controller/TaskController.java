package com.example.taskscheduler.controller;

import com.example.taskscheduler.dto.TaskDto;
import com.example.taskscheduler.model.Task;
import com.example.taskscheduler.repository.TaskRepository;
import com.example.taskscheduler.util.TransformationUtil;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/api/users/{userId}/tasks")
@AllArgsConstructor
public class TaskController {

    private TaskRepository repository;

    @PostMapping
    public String addTask(@PathVariable("userId") String userId, @RequestBody TaskDto task) {
        repository.save(TransformationUtil.transform(task, userId));
        return "Task saved successfully!";
    }

    @GetMapping
    public List<TaskDto> getAllTasks(@PathVariable("userId") String userId) {
        return repository.findByUserId(userId).stream().map(task -> TransformationUtil.transform(task)).collect(Collectors.toList());
    }

}
