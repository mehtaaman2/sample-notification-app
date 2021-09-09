package com.example.taskscheduler.util;

import com.example.taskscheduler.dto.TaskDto;
import com.example.taskscheduler.model.Task;

import java.util.Arrays;

public class TransformationUtil {

    public static Task transform(TaskDto taskDto, String user) {
        int i = 0;
        return Task.builder()
                .userId(user)
                .name(taskDto.getName())
                .time(taskDto.getTime())
                .remindOnSunday(taskDto.getDaysToRemind().get(i++))
                .remindOnMonday(taskDto.getDaysToRemind().get(i++))
                .remindOnTuesday(taskDto.getDaysToRemind().get(i++))
                .remindOnWednesday(taskDto.getDaysToRemind().get(i++))
                .remindOnThursday(taskDto.getDaysToRemind().get(i++))
                .remindOnFriday(taskDto.getDaysToRemind().get(i++))
                .remindOnSaturday(taskDto.getDaysToRemind().get(i++))
                .build();
    }

    public static TaskDto transform(Task task) {
        return TaskDto.builder()
                .name(task.getName())
                .time(task.getTime())
                .daysToRemind(Arrays.asList(task.isRemindOnSunday(),
                        task.isRemindOnMonday(),
                        task.isRemindOnTuesday(),
                        task.isRemindOnWednesday(),
                        task.isRemindOnThursday(),
                        task.isRemindOnFriday(),
                        task.isRemindOnSunday()
                        )
                ).build();
    }
}
