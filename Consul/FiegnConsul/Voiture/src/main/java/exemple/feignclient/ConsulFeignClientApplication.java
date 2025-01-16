package exemple.feignclient;

import exemple.feignclient.entities.Voiture;
import exemple.feignclient.repository.VoitureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
@EnableFeignClients
public class ConsulFeignClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsulFeignClientApplication.class, args);
    }

}