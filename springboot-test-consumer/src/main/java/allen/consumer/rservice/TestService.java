package allen.consumer.rservice;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "feign-provider")
public interface TestService {

    @GetMapping(value="test")
    String test();
}
