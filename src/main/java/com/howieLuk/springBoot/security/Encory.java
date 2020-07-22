package com.howieLuk.springBoot.security;

public interface Encory {
    /**
     * 加密message
     * @param message 明文
     * @return 密文
     */
    String encode(String message);
}
