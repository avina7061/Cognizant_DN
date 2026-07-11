import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EdgeGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(EdgeGatewayApplication.class, args);
    }

    @GetMapping("/fallback")
    public String fallback() {
        return "The service is currently unavailable. Please try again later.";
    }
}