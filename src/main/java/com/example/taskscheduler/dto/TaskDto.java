package com.example.taskscheduler.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Builder
public class TaskDto {
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Timestamp time;
    /* In order of -> Sunday, Monday .... Saturday */
    private List<Boolean> daysToRemind;

    public void setDaysToRemind(List<Boolean> daysToRemind) {
        if(daysToRemind.size() != 7) {
            throw new AssertionError("The number of days MUST be equal to 7");
        }
        this.daysToRemind = daysToRemind;
    }
}
