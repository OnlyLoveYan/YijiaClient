package com.yijia;


import com.yijia.service.impl.MqttServiceImpl;

public class Main {
    public static void main(String[] args) {
        MqttServiceImpl mqttService = new MqttServiceImpl();
        mqttService.publish("","");
    }
}
