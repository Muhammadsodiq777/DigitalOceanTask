package uz.digitalocean.com;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DigitalOceanTaskApplication {

    @Autowired
    private Flyway flyway;

    public static void main(String[] args) {
        SpringApplication.run(DigitalOceanTaskApplication.class, args);
        System.out.println("Started!!!");
    }

    public void run(String... args) throws Exception {
        flyway.migrate();
    }

}
