package ru.natiel.iotsensor.config;

import org.eclipse.paho.client.mqttv3.*;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class SimpleMqttSubscriber implements MqttCallback {

  private static final String BROKER_URL = "tcp://mosquitto:1883";
  private static final String CLIENT_ID = "iot-sensor-server-client";
  private static final String TOPIC = "sensors/temperature";

  private MqttClient client;

  @PostConstruct
  public void connect() throws Exception {
    client = new MqttClient(BROKER_URL, CLIENT_ID);
    MqttConnectOptions options = new MqttConnectOptions();
    options.setCleanSession(true);

    client.connect(options);
    client.setCallback(this);
    client.subscribe(TOPIC, 1);
    System.out.println("Connected: " + client.isConnected());
  }

  @Override
  public void messageArrived(String topic, MqttMessage message) {
    String payload = new String(message.getPayload());
    System.out.println("Топик: " + topic + ", Сообщение: " + payload);
  }

  @Override
  public void connectionLost(Throwable cause) {
    System.err.println("Соединение потеряно: " + cause.getMessage());
  }

  @Override
  public void deliveryComplete(IMqttDeliveryToken token) {
  }

  @PreDestroy
  public void disconnect() throws Exception {
    if (client != null && client.isConnected()) {
      client.disconnect();
      client.close();
    }
  }
}
