package com.pokerstar.api.infrastructure.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringUtil {

    private static Logger Log = LoggerFactory.getLogger(StringUtil.class);

    private static ObjectMapper mapper = new ObjectMapper();

    public static String object2Json(Object source) {
        try {
            return mapper.writeValueAsString(source);
        } catch (Exception ex) {
            Log.error("object 2 json error:", ex);
            return null;
        }
    }

    public static <T> T json2Object(String json, Class<T> target) {
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructType(Class.forName(target.getName())));
        } catch (Exception ex) {
            Log.error("json 2 entity error:source=" + json, ex);
        }

        return null;
    }

    public static <T> List<T> json2Lst(String json, Class<T> target) {
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, Class.forName(target.getName())));
        } catch (Exception ex) {
            Log.error("json 2 list entity error:source=" + json, ex);
        }

        return null;
    }

    public static String map2KeyValStr(Map<String, Object> source) {
        StringBuffer sb = new StringBuffer(256);

        for (Map.Entry<String, Object> item : source.entrySet()) {
            try {
                if (StringUtils.isNotBlank(item.getValue().toString())) {
                    sb.append(item.getKey()).append("=").append(item.getValue()).append("&");
                } else {
                    continue;
                }
            } catch (Exception ex) {
                continue;
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static Map<String, Object> json2Map(String source) {
        if (StringUtils.isBlank(source)) {
            return new HashMap<>(0);
        }

        try {
            return mapper.readValue(source, new TypeReference<Map<String, Object>>() {
            });
        } catch (Exception ex) {
            Log.error("json 2 map error:source = " + source, ex);
            return new HashMap<>(0);
        }
    }

    public static Map<String, Object> queryString2Map(String source) {
        if (StringUtils.isBlank(source)) {
            return new HashMap<>(0);
        }

        String[] params = source.split("&");
        String[] tmp;
        Map<String, Object> result = new HashMap<>(params.length);
        for (String item : params) {
            if (StringUtils.isNotBlank(item)) {
                tmp = item.split("=");
                result.put(tmp[0], tmp[1]);
            }
        }

        return result;
    }
}