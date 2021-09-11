package com.example.taskscheduler.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String deviceId;
    @Column
    private String deviceName;
    @Column(length = 1000)
    private String token;
}
