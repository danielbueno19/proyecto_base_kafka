# Proyecto Inicial Apache Kafka con Spring Boot

Este proyecto demuestra la implementación básica de Apache Kafka con Spring Boot, incluyendo un productor y un consumidor de mensajes.

## 📋 Descripción

Proyecto multi-módulo Maven que implementa:
- **Kafka Productor**: Aplicación que envía mensajes a un topic de Kafka
- **Kafka Consumidor**: Aplicación que escucha y procesa mensajes del topic

## 🏗️ Arquitectura del Proyecto

```
proyecto_ini_kafka/
├── kafka_productor/          # Módulo productor de mensajes
├── kafka_consumidor/         # Módulo consumidor de mensajes
└── pom.xml                   # POM padre del proyecto
```

## 🛠️ Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.5.7**
- **Spring Kafka**
- **Maven** (Multi-módulo)
- **Apache Kafka**

## 📦 Módulos

### Kafka Productor
- **Puerto**: Default (8080)
- **Función**: Envía mensajes al topic `topic-test-1`
- **Mensaje**: "Hola desde kafka spring"

### Kafka Consumidor
- **Puerto**: 8090
- **Función**: Escucha mensajes del topic `topic-test-1`
- **Grupo**: `grupo-test-1`

## 🚀 Requisitos Previos

1. **Java 17** o superior
2. **Maven 3.6+**
3. **Apache Kafka** ejecutándose en `localhost:9092`

## ⚙️ Configuración de Kafka

Antes de ejecutar las aplicaciones, asegúrate de tener Kafka ejecutándose:

```bash
# Iniciar KRaft
.\bin\windows\kafka-server-start.bat .\config\server.properties
```

## 🏃‍♂️ Ejecución

### Opción 1: Ejecutar desde el directorio raíz

```bash
# Compilar todo el proyecto
mvn clean install

# Ejecutar el consumidor (en una terminal)
cd kafka_consumidor
mvn spring-boot:run

# Ejecutar el productor (en otra terminal)
cd kafka_productor
mvn spring-boot:run
```

### Opción 2: Ejecutar módulos individualmente

```bash
# Consumidor
cd kafka_consumidor
./mvnw spring-boot:run

# Productor
cd kafka_productor
./mvnw spring-boot:run
```

## 📝 Funcionamiento

1. **Inicia el consumidor** primero para que esté escuchando el topic
2. **Inicia el productor** que automáticamente enviará un mensaje al iniciar
3. **Verifica los logs** del consumidor para ver el mensaje recibido

### Logs esperados en el consumidor:
```
INFO - Mensaje recibido: Hola desde kafka spring
```

## 🔧 Configuración

### Productor (`kafka_productor/src/main/resources/application.yaml`)
```yaml
spring:
  application:
    name: kafka_productor
  kafka:
    bootstrap-servers: localhost:9092
```

### Consumidor (`kafka_consumidor/src/main/resources/application.yaml`)
```yaml
server:
  port: 8090
spring:
  application:
    name: kafka_consumidor
  kafka:
    bootstrap-servers: localhost:9092
```

## 📁 Estructura de Código

### Productor
- `KafkaProductorApplication.java`: Clase principal que envía mensajes
- `KafkaProductorConfig.java`: Configuración del productor
- `KafkaTopicConfig.java`: Configuración del topic

### Consumidor
- `KafkaConsumidorApplication.java`: Clase principal del consumidor
- `KafkaConsumerListener.java`: Listener que procesa mensajes
- `KafkaConsumidorConfig.java`: Configuración del consumidor

## 🧪 Testing

Ejecutar tests:
```bash
mvn test
```

## 🤝 Contribución

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/nueva-funcionalidad`)
3. Commit tus cambios (`git commit -am 'Agrega nueva funcionalidad'`)
4. Push a la rama (`git push origin feature/nueva-funcionalidad`)
5. Abre un Pull Request

