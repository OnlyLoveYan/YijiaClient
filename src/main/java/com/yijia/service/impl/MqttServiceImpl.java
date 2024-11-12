package com.yijia.service.impl;

import com.yijia.service.MqttService;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MqttServiceImpl implements MqttService {

    @Autowired
    private MqttClient mqttClient;
    @Override
    public void publish(String topic, String message) {
        MqttMessage mqttMessage = new MqttMessage(message.getBytes());
        mqttMessage.setQos(1);
        try {
            mqttClient.publish(topic,mqttMessage);
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }
    }
}
