//package ru.natiel.iotsensor.config;
//
//import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.integration.channel.DirectChannel;
//import org.springframework.integration.core.MessageProducer;
//import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
//import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
//import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
//import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
//import org.springframework.messaging.MessageChannel;
//
//@Configuration
//public class MqttConfig {
//
//  @Bean
//  public MqttPahoClientFactory mqttClientFactory() {
//    DefaultMqttPahoClientFactory factory =
//        new DefaultMqttPahoClientFactory();
//
//    MqttConnectOptions options =
//        new MqttConnectOptions();
//
//    options.setServerURIs(
//        new String[]{"tcp://mosquitto:1883"}
//    );
//
//    options.setAutomaticReconnect(true);
//
//    factory.setConnectionOptions(options);
//
//    return factory;
//  }
//
//  @Bean
//  public MessageChannel mqttInputChannel() {
//    return new DirectChannel();
//  }
//
//  @Bean
//  public MqttPahoMessageDrivenChannelAdapter inbound(
//      MqttPahoClientFactory factory
//  ) {
//    System.out.println("MQTT ADAPTER CREATED");
//    MqttPahoMessageDrivenChannelAdapter adapter =
//        new MqttPahoMessageDrivenChannelAdapter(
//            "iot-sensor-server-client",
//            factory,
//            "sensors/temperature"
//        );
//
//    adapter.setOutputChannel(mqttInputChannel());
//    adapter.setConverter(new DefaultPahoMessageConverter());
//    adapter.setCompletionTimeout(5000);
//    adapter.setErrorChannel(new DirectChannel());
//    adapter.setAutoStartup(true);
//    return adapter;
//  }
//}