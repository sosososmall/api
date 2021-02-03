package com.pokerstar.api.infrastructure.util;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HttpServletUtil {

    public static Map<String, Object> body2Map(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>(16);
        Map<String, String[]> requestParams = request.getParameterMap();
        Iterator<Map.Entry<String, String[]>> iterator = requestParams.entrySet().iterator();
        Map.Entry<String, String[]> item;
        String[] values;
        while (iterator.hasNext()) {
            item = iterator.next();
            values = item.getValue();
            if (values == null) {
                result.put(item.getKey(), "");
            } else if (values.length == 1) {
                result.put(item.getKey(), values[0]);
            } else {
                result.put(item.getKey(), values);
            }
        }

        return result;
    }
}
