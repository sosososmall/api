package com.pokerstar.api.infrastructure.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedisPropertiesUtil implements Serializable {
    private static final long serialVersionUID = 3709386936236816505L;

    private String host;

    private int port;

    private int timeout;

    private String password;

    private int database;
}
