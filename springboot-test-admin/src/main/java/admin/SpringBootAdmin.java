package admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class SpringBootAdmin {
    public static void main(String[] args) {
	SpringApplication.run(SpringBootAdmin.class, args);
    }
}
