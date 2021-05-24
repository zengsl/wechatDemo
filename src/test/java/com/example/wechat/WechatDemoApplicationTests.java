package com.example.wechat;

import com.example.wechat.menu.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class WechatDemoApplicationTests {

    @Resource
    MenuService menuService;



    @Test
    void testMenuBuild() {
        menuService.build();
    }
}
