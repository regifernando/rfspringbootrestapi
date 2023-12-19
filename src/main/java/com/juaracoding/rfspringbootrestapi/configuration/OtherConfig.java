package com.juaracoding.rfspringbootrestapi.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:otherconfig.properties")
public class OtherConfig {
    private static String flagLogging;
    public static String getFlagLogging() {
        return flagLogging;
    }
    @Value("${flag.logging}")
    private void setFlagLogging(String flagLogging) {
        OtherConfig.flagLogging = flagLogging;
    }
}