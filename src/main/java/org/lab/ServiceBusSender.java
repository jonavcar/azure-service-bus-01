package org.lab;

import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusSenderClient;

public class ServiceBusSender {

  private final String connectionString;
  private final String queueName;

  public ServiceBusSender(String connectionString, String queueName) {
    this.connectionString = connectionString;
    this.queueName = queueName;
  }

  public void sendMessage(String messageBody) {
    ServiceBusClientBuilder builder = new ServiceBusClientBuilder()
        .connectionString(this.connectionString);

    ServiceBusSenderClient senderClient = builder
        .sender()
        .topicName(this.queueName)
        .buildClient();

    try {
      ServiceBusMessage message = new ServiceBusMessage(messageBody);
      senderClient.sendMessage(message);
      System.out.println("Mensaje enviado a " + this.queueName);
    } finally {
      senderClient.close();
    }

  }

}
