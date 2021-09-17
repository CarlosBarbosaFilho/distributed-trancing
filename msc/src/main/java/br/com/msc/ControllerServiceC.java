package br.com.msc;

import brave.sampler.Sampler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping ("/msb")
public class ControllerServiceC {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerServiceC.class);

    @Bean
    public Sampler defaultSampler(){
        return Sampler.ALWAYS_SAMPLE;
    }

    @GetMapping
    public String call1(){
        LOGGER.info("Returned call to microservice C");
        String response = "This is the integrated logs to msa, msb and msb with sleuth";
        return response;
    }
}
