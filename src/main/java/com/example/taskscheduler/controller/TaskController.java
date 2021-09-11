package com.example.taskscheduler.controller;

import com.example.taskscheduler.dto.TaskDto;
import com.example.taskscheduler.model.Task;
import com.example.taskscheduler.repository.TaskRepository;
import com.example.taskscheduler.service.NotificationService;
import com.example.taskscheduler.util.TransformationUtil;
import com.google.firebase.messaging.FirebaseMessagingException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/api/users/{userId}/tasks")
@AllArgsConstructor
public class TaskController {

    private TaskRepository repository;
    private NotificationService notificationService;

    @PostMapping
    public String addTask(@PathVariable("userId") String userId, @RequestBody TaskDto task) throws FirebaseMessagingException {
        Task savedTask = repository.save(TransformationUtil.transform(task, userId));
        notificationService.sendNotification(savedTask);
        return "Task saved successfully!";
    }

    @GetMapping
    public List<TaskDto> getAllTasks(@PathVariable("userId") String userId) {
        return repository.findByUserId(userId).stream().map(task -> TransformationUtil.transform(task)).collect(Collectors.toList());
    }

}
