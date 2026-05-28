package ru.natiel.iotsensor.service;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import java.util.concurrent.atomic.AtomicReference;
import org.springframework.stereotype.Service;

@Service
public class TemperatureService {

  private final AtomicReference<Double> latestTemperature =
      new AtomicReference<>(0.0);

  public TemperatureService(MeterRegistry registry) {

    Gauge.builder(
        "esp32_temperature",
        latestTemperature,
        AtomicReference::get
    ).register(registry);
  }

  public void updateTemperature(double temp) {
    latestTemperature.set(temp);
  }
}
