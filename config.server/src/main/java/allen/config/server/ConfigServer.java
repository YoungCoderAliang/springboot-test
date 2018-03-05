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
	// http://localhost:8888/feign-provider/prod ， 
	// /spring.application.name/spring.cloud.config.profile
	// 应用名/分支
    }
}
