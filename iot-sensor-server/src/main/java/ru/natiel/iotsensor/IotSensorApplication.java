package ru.natiel.iotsensor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.config.EnableIntegration;

@EnableIntegration
@SpringBootApplication
public class IotSensorApplication {

  public static void main(String[] args) {
    SpringApplication.run(IotSensorApplication.class, args);
  }

}
