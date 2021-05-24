package com.example.wechat.menu;

import com.example.wechat.core.service.CoreService;
import com.example.wechat.menu.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/5/7 5:47 下午
 */
@SpringBootTest
public class MenuServiceTest {
    @Resource
    MenuService menuService;

    @Test
    void testBuildMenu() {
        menuService.build();
    }
}
