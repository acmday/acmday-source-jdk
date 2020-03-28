package com.acmday.series.jdk.entry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author acmday
 * @date 2020/3/27.
 */
public class CurrentHashMapDemo {;
    public static void main(String[] args) {
        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("one", 1);
    }
}
