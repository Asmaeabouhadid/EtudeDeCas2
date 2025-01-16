package com.example.car;

import com.example.car.entities.Car;
import com.example.car.repositories.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@SpringBootApplication
public class CarApplication {

    private static final Logger logger = Logger.getLogger(CarApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(CarApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(5000);
        requestFactory.setReadTimeout(5000);

        return new RestTemplate(requestFactory);
    }

    @Bean
    CommandLineRunner initData(CarRepository carRepository) {
        return args -> {
            logger.info("Initializing Car data...");
            carRepository.save(new Car("Range Rover", "14 R 5288", 5L));
            carRepository.save(new Car("Porche", "34 T 6732", 6L));
            carRepository.save(new Car("lamborgini", "44 R 6712", 7L));
            logger.info("Car data initialized successfully.");
        };
    }
}