package com.example.demo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("apiinfo")
@Getter @Setter
public class ApiProperties {


    private String host_name;
    private String host_value;
    private String key_name;
    private String key_value;
    private String url;


}
