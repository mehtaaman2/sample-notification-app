package com.example.taskscheduler.service;

import com.example.taskscheduler.model.Task;
import com.example.taskscheduler.model.User;
import com.example.taskscheduler.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.messaging.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class NotificationService {

    private UserRepository userRepository;

    public void sendNotification(Task task) throws FirebaseMessagingException {
        BatchResponse response = FirebaseMessaging.getInstance()
                .sendMulticast(MulticastMessage.builder()
                        .addAllTokens(getRelevantTokensForTheUser(task.getUserId()))
                        .setNotification(Notification.builder()
                                .setTitle(task.getName())
                                .build())
                        .putData("timeOffset", task.getTime().toLocalDateTime()
                                .format(DateTimeFormatter.ISO_TIME))
                        .build());
        try {
            log.info("Response for sent notification for task {} is {}", task,
                    new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(response));
        } catch (JsonProcessingException e) {
            log.error("Some error" , e);
        }
    }
   /*TODO: Fetch the group based on the message,
      fetch all the recipients of that group and collect those tokens */
    private Collection<String> getRelevantTokensForTheUser(String userId) {
        List<String> tokens =  userRepository.findAll()
                .stream()
                .map(User::getToken)
                .collect(Collectors.toList());
        log.info("Got tokens {} for given userid {}", tokens, userId);
        return tokens;
    }
}
