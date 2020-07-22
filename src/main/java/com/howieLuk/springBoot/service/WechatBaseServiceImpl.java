package com.howieLuk.springBoot.service;

import com.howieLuk.springBoot.security.Encory;
import com.howieLuk.springBoot.security.EncoryFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service("WechatBaseService")
public class WechatBaseServiceImpl implements WechatBaseService {

    @Override
    public boolean checkSignature(String signature, String timeStamp, String nonce, String token) {
        String [] strings = {token, timeStamp, nonce};
        //字典排序
        Arrays.sort(strings);
        StringBuilder sb = new StringBuilder();
        for (String str: strings) {
            sb.append(str);
        }
        //进行sha1加密
        Encory sha1 = EncoryFactory.getEncory("SHA1");
        String secret = sha1.encode(sb.toString());
        return secret.equals(signature.toUpperCase());
    }
}
