package com.howieLuk.springBoot.controller;

import com.howieLuk.springBoot.service.WechatBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/wechat")
public class WechatBaseController {

    @Autowired
    WechatBaseService wechatBaseService;

    /**
     * 接入wechat伺服器，成为开发者
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/check")
    @ResponseBody
    public String checkSignature(HttpServletRequest request) {
        //检验需要的三个参数
        String signature = request.getParameter("signature");
        String timeStamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        //要接入开发的公众号的token
        String token = "";
        if (wechatBaseService.checkSignature(signature, timeStamp, nonce, token)) {
            return echostr;
        }
        return null;
    }

}
