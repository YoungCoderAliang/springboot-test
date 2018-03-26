package allen.config.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServer {
    private static Logger logger = LoggerFactory.getLogger(ContextLog.class);
    
    public static void main(String[] args) {
		SpringApplication.run(ConfigServer.class, args);
		// rabbitmq on mac
		// /usr/local/Cellar/rabbitmq/3.7.3/sbin/rabbitmq-server
    }
    
    @Configuration
    public static class ContextLog implements ApplicationListener<ContextRefreshedEvent> {
	@Override
        public void onApplicationEvent(ContextRefreshedEvent event) {
	    logger.error(event.getApplicationContext().toString());
        }
	
	@Bean
	public ContextLog contextLog() {
	    return new ContextLog();
	}
    }
}
