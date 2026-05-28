//package ru.natiel.iotsensor.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.integration.annotation.ServiceActivator;
//import org.springframework.integration.channel.DirectChannel;
//import org.springframework.integration.dsl.IntegrationFlow;
//import org.springframework.integration.dsl.StandardIntegrationFlow;
//import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
//import org.springframework.integration.handler.LoggingHandler;
//import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
//import org.springframework.messaging.MessageChannel;
//
//@Configuration
//public class MqttIntegrationConfiguration {
//
//  @Bean
//  public MessageChannel inputChannel() {
//    return new DirectChannel();
//  }
//
//  @Bean
//  public MqttPahoMessageDrivenChannelAdapter mqttInbound() {
//    MqttPahoMessageDrivenChannelAdapter adapter =
//        new MqttPahoMessageDrivenChannelAdapter("tcp://localhost:1883", "mqttClient",
//            "test/topic");
//    adapter.setCompletionTimeout(5000);
//    adapter.setConverter(new DefaultPahoMessageConverter());
//    adapter.setQos(1);
//    adapter.setOutputChannel(inputChannel());
//    return adapter;
//  }
//
//  @Bean
//  public StandardIntegrationFlow mqttInboundFlow() {
//    return IntegrationFlows.from(mqttInbound())
//        .handle("myService", "process")
//        .get();
//  }
//
//  @Bean
//  @ServiceActivator(inputChannel = "inputChannel")
//  public LoggingHandler loggingHandler() {
//    LoggingHandler loggingHandler = new LoggingHandler("INFO");
//    loggingHandler.setLoggerName("com.example.myapp.integration");
//    return loggingHandler;
//  }
//}
//
