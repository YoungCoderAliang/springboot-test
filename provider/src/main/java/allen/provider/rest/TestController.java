package allen.provider.rest;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public String test() {
	logger.error("here");
	try {
	    Thread.sleep(50);
        } catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
        }
	return sdf.format(new Date()) + " " + port + " " + testStr;
    }
}
