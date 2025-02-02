package org.lab;

public class Main {

  public static void main(String[] args) {
    Properties properties = new Properties();
    String connectionString = properties.getConnectionString();
    String queueName = properties.getQueueName();

    ServiceBusSender sender = new ServiceBusSender(connectionString, queueName);

    String message = "837463337911:ACTIVE";

    sender.sendMessage(message);

    System.exit(0);

  }

}