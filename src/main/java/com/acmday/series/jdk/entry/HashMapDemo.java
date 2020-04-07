package com.acmday.series.jdk.entry;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author acmday
 * @date 2020/3/27.
 */
public class HashMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>(1);
        for (int i=0; i<100; ++i) {
            map.put("nub["+i+"]", i);
        }
    }
}
