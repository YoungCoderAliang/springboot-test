package allen.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServer {
    public static void main(String[] args) {
		SpringApplication.run(ConfigServer.class, args);
		// rabbitmq on mac
		// /usr/local/Cellar/rabbitmq/3.7.3/sbin/rabbitmq-server
    }
}
