package allen.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.client.ConfigClientProperties;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class Provider {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Provider.class, args);
		ConfigClientProperties p = (ConfigClientProperties) context.getBean(ConfigClientProperties.class);
		System.out.println(p.toString());
	}
}
