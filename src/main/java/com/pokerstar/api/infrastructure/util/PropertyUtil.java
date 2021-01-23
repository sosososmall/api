package com.pokerstar.api.infrastructure.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {
    private static Logger Log = LoggerFactory.getLogger(PropertyUtil.class);

    public static final String APPLICATION_PROPERTIES = "application.properties";

    public static String getPropValByName(String propertyFileName, String key){
        try {
            Resource resource = new ClassPathResource(propertyFileName);
            Properties props = PropertiesLoaderUtils.loadProperties(resource);
            return props.getProperty(key);
        }catch (IOException ex){
            Log.error(ex.getMessage());
        }
        return null;
    }
}
