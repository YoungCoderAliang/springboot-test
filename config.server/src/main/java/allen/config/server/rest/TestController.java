package allen.config.server.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
//    @Value("${trade.deep.zb}")
    private String zbdeep;
    @RequestMapping(value="hello", method = RequestMethod.GET)
    public String hello() {
	return "heel";
    }
}
