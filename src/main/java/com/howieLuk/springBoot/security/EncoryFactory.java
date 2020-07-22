package com.howieLuk.springBoot.security;

import java.util.HashMap;
import java.util.Map;

public class EncoryFactory {
    private static Map<String, Encory> map = new HashMap<>();

    static {
        map.put("SHA1", new SHA1());
    }

    public static Encory getEncory(String encory) {
        return map.get(encory);
    }
}
