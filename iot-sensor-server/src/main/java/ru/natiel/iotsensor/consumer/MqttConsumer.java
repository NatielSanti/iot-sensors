//package ru.natiel.iotsensor.consumer;
//
//import org.springframework.integration.annotation.ServiceActivator;
//import org.springframework.messaging.Message;
//import org.springframework.stereotype.Service;
//import ru.natiel.iotsensor.service.TemperatureService;
//import tools.jackson.databind.JsonNode;
//import tools.jackson.databind.ObjectMapper;
//
//@Service
//public class MqttConsumer {
//
//  private final ObjectMapper mapper = new ObjectMapper();
//
//  private final TemperatureService service;
//
//  public MqttConsumer(TemperatureService service) {
//    System.out.println("MQTT CONSUMER CREATED");
//    this.service = service;
//  }
//
//  @ServiceActivator(inputChannel = "mqttInputChannel")
//  public void receive(Message<String> message) throws Exception {
//
//    String payload = message.getPayload();
//    System.out.println("Temperature1: " + payload);
//
//    JsonNode json = mapper.readTree(payload);
//
//    double temp = json.get("temperature").asDouble();
//    System.out.println("Temperature2: " + payload);
//
//    service.updateTemperature(temp);
//
//    System.out.println("Temperature: " + temp);
//  }
//}
