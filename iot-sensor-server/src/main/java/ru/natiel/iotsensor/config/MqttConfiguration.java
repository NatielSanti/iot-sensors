//package ru.natiel.iotsensor.config;
//
//import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.integration.annotation.ServiceActivator;
//import org.springframework.integration.channel.DirectChannel;
//import org.springframework.integration.endpoint.MessageProducerSupport;
//import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
//import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
//import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.MessageHandler;
//
//@Configuration
//public class MqttConfiguration {
//
//  private static final String BROKER_URL = "tcp://mosquitto:1883";
//  private static final String CLIENT_ID = "iot-sensor-server-client";
//  private static final String TOPIC = "sensors/temperature";
//
//  @Bean
//  public MqttPahoClientFactory mqttClientFactory() {
//    DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
//    MqttConnectOptions options = new MqttConnectOptions();
//
//    options.setServerURIs(new String[]{BROKER_URL});
//    // Если брокер требует авторизацию:
//    // options.setUserName("username");
//    // options.setPassword("password".toCharArray());
//    options.setCleanSession(true);
//
//    factory.setConnectionOptions(options);
//    return factory;
//  }
//
//  @Bean
//  public MessageChannel mqttInputChannel() {
//    return new DirectChannel();
//  }
//
//  @Bean
//  public MqttPahoMessageDrivenChannelAdapter mqttInbound(
//      MqttPahoClientFactory mqttClientFactory) {
//
//    // Укажите топики для подписки (можно несколько)
//    String[] topics = {TOPIC};
//
//    MqttPahoMessageDrivenChannelAdapter adapter =
//        new MqttPahoMessageDrivenChannelAdapter(
//            CLIENT_ID,           // уникальный ID клиента
//            mqttClientFactory,
//            topics                        // топики для подписки
//        );
//
//    adapter.setCompletionTimeout(5000);
//    adapter.setQos(1);                    // 0, 1 или 2
//    adapter.setOutputChannel(mqttInputChannel());
//
//    return adapter;
//  }
//}
