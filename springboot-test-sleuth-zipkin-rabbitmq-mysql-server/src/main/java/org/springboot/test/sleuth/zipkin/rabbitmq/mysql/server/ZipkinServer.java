package org.springboot.test.sleuth.zipkin.rabbitmq.mysql.server;

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
	// rabbitmq on mac
	// /usr/local/Cellar/rabbitmq/3.7.3/sbin/rabbitmq-server
    }
}
