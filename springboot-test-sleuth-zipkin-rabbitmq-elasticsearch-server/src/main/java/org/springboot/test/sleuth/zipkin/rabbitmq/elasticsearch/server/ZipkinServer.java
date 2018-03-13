package org.springboot.test.sleuth.zipkin.rabbitmq.elasticsearch.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

/**
 * Hello world!
 *
 */
@EnableZipkinStreamServer
@SpringBootApplication
public class ZipkinServer {
    public static void main(String[] args) {
	SpringApplication.run(ZipkinServer.class, args);
    }
}
