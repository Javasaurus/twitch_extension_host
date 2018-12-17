package be.javasaurus.twitchextensionhost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@ComponentScan(basePackages = {"be.javasaurus.twitchextensionhost"})
@EnableAutoConfiguration
@CrossOrigin(allowCredentials="false")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}