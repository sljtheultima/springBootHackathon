package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class Log {
    public void logSuccess(String statuscode){
        log.info(String.format("Result received Successfully at %s. Status code : %s , ",new Date().toString(),statuscode));
    }

    public void logError(String statuscode ){
        log.error(String.format("Error receiving results at %s.Status code: %s",new Date().toString(), statuscode));
    }
}
