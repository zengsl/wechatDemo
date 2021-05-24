package com.example.wechat.core;

import com.example.wechat.core.service.CoreService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/5/7 5:23 下午
 */
@SpringBootTest
public class CoreServiceTest {

    @Resource
    CoreService coreService;

    @Test
    void testGetAccessToken() {
        coreService.getAccessToken();
    }
}
