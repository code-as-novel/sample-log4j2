package com.example.logger.health.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.logger.health.dto.HealthDto;

import jakarta.annotation.PostConstruct;

@Controller
@RequestMapping("/health")
public class HealthController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(HealthController.class);

    @GetMapping
    public ResponseEntity<HealthDto> getHealth(){
        long start = System.currentTimeMillis();

        for(int i=0; i<1000000; i++){
            LOGGER.info("this number is : " + i);
        }

        long end = System.currentTimeMillis();

        LOGGER.info("total time : " + (end-start));

        return ResponseEntity.ok(new HealthDto("UP"));
    }

    @PostConstruct
    public void printLogger() {
        LOGGER.info("##################### Logger : " + LOGGER.getClass().getName());
    }

}
