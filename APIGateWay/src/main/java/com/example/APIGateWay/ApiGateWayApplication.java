package com.example.APIGateWay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGateWayApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("reserve", r->r.path("/reserve/**")
						.uri("http://localhost:8099/"))
				.route("buy", r->r.path("/buy/**")
						.uri("http://localhost:8098/")).build();
	}

}
