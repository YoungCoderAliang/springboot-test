package allen.provider.rest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class TestController {
	private static Logger logger = LoggerFactory.getLogger(TestController.class);
	private static SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
	@Value("${server.port}")
	private String port;
	@Value("${test.a}")
	private String testStr;

	// http://localhost:2221/test

	@RequestMapping(value = "test", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "fallback")
	public String test() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(TestController.class.getResourceAsStream("flag")));
			if (br.readLine().equals("a")) {
				br.close();
				return sdf.format(new Date()) + " " + port + " " + testStr;
			} else {
				br.close();
				throw new RuntimeException();
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		throw new RuntimeException();
		// return sdf.format(new Date()) + " " + port + " " + testStr;
	}

	public String fallback() {
		logger.error("fallback");
		return "fallback";
	}
}
