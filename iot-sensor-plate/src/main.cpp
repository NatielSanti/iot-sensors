#include <WiFi.h>
#include <PubSubClient.h>

const char* ssid = "MGTS_GPON_9EE2";
const char* password = "moscow80";

const char* mqtt_server = "192.168.1.11";

WiFiClient espClient;
PubSubClient client(espClient);

void setup() {

  Serial.begin(115200);
  delay(2000);
  Serial.println("Starting...");

  WiFi.begin(ssid, password);

  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.println("Connecting to WiFi...");
  }

  Serial.println("WiFi connected");
  Serial.println(WiFi.localIP());

  client.setServer(mqtt_server, 1883);
}

void reconnectMQTT() {

  while (!client.connected()) {

    Serial.println("Connecting to MQTT...");

    if (client.connect("esp32-client")) {

      Serial.println("MQTT connected");

    } else {

      Serial.print("MQTT failed, rc=");
      Serial.println(client.state());

      delay(2000);
    }
  }
}

void loop() {

  if (!client.connected()) {
    reconnectMQTT();
  }

  client.loop();

  String payload =
    "{\"deviceId\":\"esp32-1\",\"temperature\":25.4}";

  bool result =
    client.publish("sensors/temperature", payload.c_str());

  if (result) {
    Serial.println("Message published");
    Serial.println(payload);
  } else {
    Serial.println("Publish failed");
  }

  delay(5000);
}
