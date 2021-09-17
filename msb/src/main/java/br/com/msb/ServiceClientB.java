package br.com.msb;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient (name = "${feign.name}", url = "${feign.url}")
public interface ServiceClientB {

    @RequestMapping (method = RequestMethod.GET)
    String response();
}
