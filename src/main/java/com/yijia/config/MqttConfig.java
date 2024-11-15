package com.yijia.config;

import com.yijia.callback.PushCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttConfig {

    @Bean
    public MqttClient mqttClient() {
        String broker = "tcp://121.37.216.129:1883";
        String clientId = "mqtt-client1";
        MemoryPersistence persistence = new MemoryPersistence();

        try {
            MqttClient mqttClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setUserName("emqx_test");
            connOpts.setPassword("emqx_test_password".toCharArray());
            // 保留会话
            connOpts.setCleanSession(true);
            mqttClient.setCallback(new PushCallback());
            mqttClient.connect(connOpts);


            //TODO
            //设置成安卓版版号或者id
            mqttClient.subscribe("test");
            return mqttClient;
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }
    }
    //    //implementation 'org.springframework.boot:spring-boot-starter-web:3.1.6'
    //    //implementation 'org.projectlombok:lombok:1.18.22'
}
