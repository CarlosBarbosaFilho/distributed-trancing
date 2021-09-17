package br.com.msb;

import brave.sampler.Sampler;
import com.sun.jdi.event.ExceptionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping ("/msb")
public class ControllerServiceB {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerServiceB.class);

    @Autowired
    private ServiceClientB serviceClientB;

    @GetMapping
    public ResponseEntity<String> getMsb() throws RestClientException {
        try {
            LOGGER.info("calling microservice msc");
            var response = serviceClientB.response();
            LOGGER.info("finishing call microservice msc");
            return ResponseEntity.ok(response);

        }catch (RestClientException ex){
            ex.getMessage();
        }
        return ResponseEntity.internalServerError().build();
    }

    @Bean
    public Sampler defaultSampler(){
        return Sampler.ALWAYS_SAMPLE;
    }
}
