package com.project.app.winningapp.service;

import org.springframework.stereotype.Service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

@Service
public class PushNotificationService {

    public void sendPushNotification(String title, String body, String deviceToken) throws FirebaseMessagingException {
//    	Builder builder = new Builder();
    	
    	
        Message message = Message.builder()
//                .setNotification(new Notification(title, body))
                .setNotification(Notification.builder().setTitle(title).setBody(body).build())
                .setToken(deviceToken)
                .build();

        FirebaseMessaging.getInstance().send(message);
    }
}
