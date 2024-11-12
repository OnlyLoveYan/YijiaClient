package com.yijia.service;

public interface MqttService {

    public void publish(String topic, String message);
}
