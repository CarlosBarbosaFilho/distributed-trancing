package br.com.msb;

import brave.sampler.Sampler;
import com.sun.jdi.event.ExceptionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ControllerServiceB {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerServiceB.class);
    private static final String MSC = "http://localhost:8082/msb";
    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Sampler defaultSampler(){
        return Sampler.ALWAYS_SAMPLE;
    }

    @GetMapping ("/msb")
    public String call1(){
        LOGGER.info("Calling microservice C");
        String url = MSC;
        try {
            Thread.sleep(1000);
        }catch (Exception ex){
            System.out.println("throws exception to test");
        }
        String response = (String)
                restTemplate.exchange(url, HttpMethod.GET, null, String.class).getBody();
        LOGGER.info("Response received to msc is " + response);
        return response;
    }
}
