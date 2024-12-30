# Spring Cloud Gateway Setup with Eureka Discovery Server 🛠️


## 🌐 What is Spring Cloud Gateway?

Spring Cloud Gateway is a **flexible**, **feature-rich API Gateway solution** designed specifically for **microservices architectures**. Built with **Spring 5**, **Spring Boot 2**, and **Project Reactor**, it facilitates seamless **routing**, **load balancing**, and **security** for your microservices. Its **reactive**, **non-blocking** design ensures **high performance** and **scalability**, making it an ideal choice for **cloud-native applications**.

 - Spring Cloud Gateway serves as a more efficient and scalable replacement for **Zuul**, offering enhanced features for managing and routing requests within microservices environments. ⚡🔒🔄

---

## ✨ Key Features
- **🔄 Dynamic Routing**: Spring Cloud Gateway routes requests to backend services based on predefined configurations, supporting flexible routing strategies.
- **🔒 Security**: Seamless integration with **Spring Security** for robust authentication, authorization, and security filters.
- **📊 Monitoring and Logging**: Built-in support for metrics, logging, and tracing, offering full visibility into request processing and performance.
- **⚡ Performance**: Utilizes **non-blocking I/O** for better scalability and lower latency.
- **🛠️ Custom Filters**: Supports defining custom pre and post filters to manipulate requests and responses dynamically.
- **🔗 Integration with Spring Cloud**: Works with other Spring Cloud components like **Eureka** for service discovery, **Config Server** for centralized configuration, and **Hystrix** for fault tolerance.
- **🔄 Load Balancing**: Leverages **Spring Cloud LoadBalancer** for distributing requests across service instances, ensuring better performance and fault tolerance.
- **📜 Route Predicate**: Allows routing based on request parameters like path, headers, etc.
- **💡 Easy to Use**: Integrates seamlessly with **Spring Boot**, offering simple configuration for microservices applications.

---

## ⚙️ How It Works
1. **🚪 Request Routing**: Spring Cloud Gateway intercepts incoming HTTP requests and routes them to the correct backend service using the configured routes.
2. **🔎 Service Discovery**: Integrates with **Eureka** to dynamically discover backend services, enabling routing to available instances.
3. **💨 Load Balancing**: Works with **Spring Cloud LoadBalancer** to distribute requests across service instances for better load handling.
4. **📜 Filters**: Pre and post filters manipulate requests before routing and responses after routing, allowing flexible request processing.
5. **⚡ Non-blocking Architecture**: Built on reactive programming principles, Spring Cloud Gateway processes requests asynchronously, providing better scalability and performance.

---

## 💡 Spring Cloud Gateway Setup in Spring Boot

1. **Add dependencies in `pom.xml`:**
   ```xml
   <dependency>
       <groupId>org.springframework.cloud</groupId>
       <artifactId>spring-cloud-starter-gateway</artifactId>
   </dependency>
   <dependency>
       <groupId>org.springframework.cloud</groupId>
       <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
   </dependency>
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-webflux</artifactId>
   </dependency>
   ```

2. **Create the Spring Boot main class:**
   ```java
   import org.springframework.boot.SpringApplication;
   import org.springframework.boot.autoconfigure.SpringBootApplication;

   @SpringBootApplication
   public class GatewayServerApplication {
       public static void main(String[] args) {
           SpringApplication.run(GatewayServerApplication.class, args);
       }
   }
   ```

3. **Configure `application.properties`:**
   ```properties
   # Gateway service name
   spring.application.name=spring-cloud-gateway

   # Server port
   server.port=8765

   # Eureka configuration
   eureka.client.service-url.defaultZone=http://localhost:8762/eureka/
   eureka.client.fetch-registry=true
   eureka.client.register-with-eureka=true

   # Configure reactive web application type
   spring.main.web-application-type=reactive
   ```

4. **Configure Gateway Routes:**
   Add routes for services dynamically or statically.

   - **Dynamic Routing with Eureka:**
     The gateway automatically discovers services from Eureka:
     ```properties
     spring.cloud.gateway.discovery.locator.enabled=true
     spring.cloud.gateway.discovery.locator.lower-case-service-id=true
     ```

   - **Static Routes (Optional):**
     Define specific routes in `application.properties`:
     ```properties
     spring.cloud.gateway.routes[0].id=admission-service
     spring.cloud.gateway.routes[0].uri=lb://ADMISSION-SERVICE
     spring.cloud.gateway.routes[0].predicates[0]=Path=/admission/**
     spring.cloud.gateway.routes[0].filters[0]=StripPrefix=1
     ```

5. **Run the Gateway Application:**
   Once the configuration is complete, start the Gateway application. It will register with Eureka and dynamically route requests to registered services.

---

## **🎨 Microservices Architecture Overview**

- **🌐 Eureka Discovery Server** acts as the service registry for all microservices.
- **🌐 Spring Cloud Gateway** serves as the entry point, routing client requests to microservices based on the service ID in Eureka.

---

### **Dynamic Routing with Eureka**

When you enable `spring.cloud.gateway.discovery.locator.enabled=true`, the Gateway automatically discovers and routes requests to services registered in Eureka.

For example:
- If a service is registered in Eureka with the name `ADMISSION-SERVICE`, you can access it through:
  ```
  http://localhost:8765/admission-service/endpoint
  ```

### **📊 Comparison: Zuul vs. Spring Cloud Gateway**
| **Feature**               | **Zuul**                          | **Spring Cloud Gateway**             |
|---------------------------|------------------------------------|---------------------------------------|
| Programming Model         | Servlet (Blocking)                | Reactive (Non-Blocking)              |
| Performance               | Moderate                         | High                                 |
| Built-in Filters          | Limited                          | Extensive                            |
| Service Discovery         | Yes                              | Yes (Built-in with Eureka)           |
| Scalability               | Moderate                         | High (Reactive Model)                |
| Load Balancing            | Ribbon                           | Built-in                             |

---

This setup provides a **modern**, **scalable**, and **efficient** API Gateway solution using Spring Cloud Gateway with Eureka for microservices architectures.

