package com.voyage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class VoyageGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(VoyageGatewayApplication.class, args);
    }

}
