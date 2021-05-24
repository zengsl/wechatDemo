package com.example.wechat.menu.service;

import cn.hutool.http.HttpRequest;
import com.example.wechat.base.utils.JacksonUtils;
import com.example.wechat.core.service.CoreService;
import com.example.wechat.menu.entity.Button;
import com.example.wechat.menu.entity.ViewButton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/5/7 4:39 下午
 */
@Service
public class MenuServiceImpl implements MenuService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private CoreService coreService;

    @Override
    public void build() {
        Button button = new Button();

        ViewButton viewButton = new ViewButton();
        viewButton.setName("项目申报");
        viewButton.setUrl("http://ynkjt.viphk.ngrok.org/egrantweb/wechat/index");
        button.getButton().add(viewButton);

        /*ClickButton clickButton = new ClickButton();
        clickButton.setName("点击");
        clickButton.setKey("zClick");

        ViewButton viewButton = new ViewButton();
        viewButton.setName("查看");
        viewButton.setUrl("http://gc.hnkjt.egrant.cn:18080/egrantweb/");

        SubButton subButton = new SubButton();
        subButton.setName("按钮组");
        subButton.getSubButton().add(clickButton);
        subButton.getSubButton().add(viewButton);

        button.getButton().add(clickButton);
        button.getButton().add(viewButton);
        button.getButton().add(subButton);*/

        String buttonJson = JacksonUtils.jsonObjectSerializer(button, true);
        logger.info("buttonStr:{}", buttonJson);

        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s";
        String accessToken = coreService.getAccessToken();
        url = String.format(url, accessToken);
        String result = HttpRequest.post(url).body(buttonJson).execute().body();
        logger.info("result={}", result);

    }
}
