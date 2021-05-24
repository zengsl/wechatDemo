package com.example.wechat.core.service;

import cn.hutool.http.HttpRequest;
import com.example.wechat.base.constants.WechatConfig;
import com.example.wechat.base.utils.JacksonUtils;
import com.example.wechat.core.entity.AccessToken;
import org.apache.commons.collections4.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/5/7 4:55 下午
 */
@Service
public class CoreServiceImpl implements CoreService {

    Logger logger = LoggerFactory.getLogger(getClass());


    private static AccessToken accessToken;

    @Override
    public String getAccessToken() {

        if (accessToken == null || accessToken.isExpired()) {
            getToken();
        }

        return accessToken.getToken();
    }


    private void getToken() {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
        url = String.format(url, WechatConfig.APP_ID, WechatConfig.SECRET);
        String result = HttpRequest.get(url).execute().body();
        logger.info("result={}", result);

        Map<String,Object> tokenMap =  JacksonUtils.json2HashMap(result);
        String token = MapUtils.getString(tokenMap, "access_token");
        long expiresIn = MapUtils.getLong(tokenMap, "expires_in");
        accessToken = new AccessToken();
        accessToken.setToken(token);
        accessToken.setExpiresTime(System.currentTimeMillis() + expiresIn);

    }
}
