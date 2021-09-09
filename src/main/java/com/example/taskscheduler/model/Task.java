package com.example.taskscheduler.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Builder
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long taskId;
    @Column
    private String userId;
    @Column
    private String name;
    @Column
    private Timestamp time;
    @Column
    private boolean remindOnSunday;
    @Column
    private boolean remindOnMonday;
    @Column
    private boolean remindOnTuesday;
    @Column
    private boolean remindOnWednesday;
    @Column
    private boolean remindOnThursday;
    @Column
    private boolean remindOnFriday;
    @Column
    private boolean remindOnSaturday;
}
