package com.yijia.config;

import com.yijia.callback.PushCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;


public class MqttConfig {

    public static MqttClient mqttClient;

    static {
        mqttClient();
    }

    public static void mqttClient() {
        String broker = "tcp://121.37.216.129:1883";
        String clientId = "mqtt-client";
        MemoryPersistence persistence = new MemoryPersistence();

        try {
            mqttClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setUserName("emqx_test");
            connOpts.setPassword("emqx_test_password".toCharArray());
            // 保留会话
            connOpts.setCleanSession(true);
            mqttClient.setCallback(new PushCallback());
            mqttClient.connect(connOpts);


            //TODO
            //设置成安卓版版号或者id
            mqttClient.subscribe("testtopic");
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }
    }
}
