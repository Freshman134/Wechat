package com.howieLuk.springBoot.service;

public interface WechatBaseService {
    boolean checkSignature(String signature, String timeStamp, String nonce, String token);
}
