package com.yijia.service.impl;

import com.yijia.config.MqttConfig;
import com.yijia.service.MqttService;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;


public class MqttServiceImpl implements MqttService {

    @Override
    public void publish(String topic, String message) {
        MqttMessage mqttMessage = new MqttMessage(message.getBytes());
        mqttMessage.setQos(1);
        try {
            MqttConfig.mqttClient.publish(topic,mqttMessage);
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }
    }
}
