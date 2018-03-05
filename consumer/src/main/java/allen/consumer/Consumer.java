package allen.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Hello world!
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableDiscoveryClient
@EnableFeignClients 
@EnableEurekaClient
public class Consumer {
    public static void main(String[] args) {
	SpringApplication.run(Consumer.class, args);
    }
    
//    @Bean
//    public IRule myRule() {
//	// 向容器注入IRule，来改变ribbon默认使用的负载均衡策略
//	return new WeightedResponseTimeRule();
////	return new RandomRule();
//    }
}
