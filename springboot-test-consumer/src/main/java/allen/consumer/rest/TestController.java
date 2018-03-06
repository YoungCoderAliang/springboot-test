package allen.consumer.rest;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import allen.consumer.rservice.TestService;

@RestController
public class TestController {
	@Resource
	private TestService testService;

	@RequestMapping(value = "t", method = RequestMethod.GET)
	public String t() {
		return testService.test();
	}
}
