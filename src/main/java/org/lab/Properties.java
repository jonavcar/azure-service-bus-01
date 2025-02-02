package org.lab;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;

public class Properties {

  private final String connectionString;
  private final String queueName;

  public Properties() {
    java.util.Properties props = new java.util.Properties();

    try (InputStream input = getClass().getResourceAsStream("/application.properties")) {
      if (input == null) {
        throw new IllegalStateException("No se encontró 'application.properties' en el classpath");
      }
      props.load(input);
    } catch (IOException e) {
      throw new UncheckedIOException("Error al cargar 'application.properties'", e);
    }
    this.connectionString = props.getProperty("servicebus.connectionString");
    this.queueName = props.getProperty("servicebus.queueName");
  }

  public String getConnectionString() {
    return connectionString;
  }

  public String getQueueName() {
    return queueName;
  }
}