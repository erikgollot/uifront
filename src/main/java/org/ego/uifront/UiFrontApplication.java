package org.ego.uifront;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

@SpringBootApplication
@EnableDiscoveryClient
@EnableWebSocketMessageBroker
public class UiFrontApplication {

    public static void main(String[] args) {
        SpringApplication.run(UiFrontApplication.class, args);
    }
}
