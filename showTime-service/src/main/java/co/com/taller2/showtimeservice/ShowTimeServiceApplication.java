package co.com.taller2.showtimeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ShowTimeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShowTimeServiceApplication.class, args);
    }

}
