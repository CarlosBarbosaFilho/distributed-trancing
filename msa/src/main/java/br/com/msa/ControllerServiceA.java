package br.com.msa;

import brave.sampler.Sampler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

@RestController
@RequestMapping("/msa")
public class ControllerServiceA {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerServiceA.class);

    @Autowired
    private ServiceClientA serviceClientA;

    @GetMapping
    public ResponseEntity<String> getMsb() throws RestClientException {
        try {
            LOGGER.info("calling microservice msb");
            var response = serviceClientA.response();
            LOGGER.info("finishing call microservice msb");
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
