package com.example.wechat.core.controller;

import cn.hutool.crypto.SecureUtil;
import com.example.wechat.base.constants.WechatConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/5/7 12:22 下午
 */
@Controller
@RequestMapping("/wechat")
public class WechatController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("handle")
    public void handle(HttpServletRequest request, HttpServletResponse response) {

        String method = request.getMethod();
        if ("GET".equals(method)) {
            String signature = request.getParameter("signature");
            String timestamp = request.getParameter("timestamp");
            String nonce = request.getParameter("nonce");
            String echostr = request.getParameter("echostr");

            String[] str = new String[]{WechatConfig.TOKEN, timestamp, nonce};
            Arrays.sort(str);
            StringBuilder buffer = new StringBuilder();
            for (String s : str) {
                buffer.append(s);
            }


            logger.info(" signature={},timestamp={},nonce={},echostr={}", signature, timestamp, nonce, echostr);
            String expectSignature = SecureUtil.sha1(buffer.toString());
            if (signature.equals(expectSignature)) {
                try (PrintWriter out = response.getWriter()) {
                    out.write(echostr);
                } catch (IOException e) {
                    logger.error("接入回写失败", e);
                }

            }
        } else {
            // 处理消息

            logger.info("处理消息");
        }

    }
}
