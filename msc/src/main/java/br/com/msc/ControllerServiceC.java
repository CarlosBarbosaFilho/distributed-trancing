package br.com.msc;

import brave.sampler.Sampler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ControllerServiceC {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerServiceC.class);

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
        String response = "This is the integrated logs to msa, msb and msb";
        return response;
    }
}
