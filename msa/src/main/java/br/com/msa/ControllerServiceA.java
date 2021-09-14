package br.com.msa;

import brave.sampler.Sampler;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ControllerServiceA {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerServiceA.class);
    private static final String MSB = "http://localhost:8081/msb";
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

    @GetMapping("/msa")
    public String call1(){
        LOGGER.info("Calling microservice A");
        String url = MSB;
        String response = (String)
                restTemplate.exchange(url, HttpMethod.GET, null, String.class).getBody();
        LOGGER.info("Response received to msb is " + response);
        return response;
    }
}
