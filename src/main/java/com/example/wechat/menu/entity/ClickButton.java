package com.example.wechat.menu.entity;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/5/7 4:14 下午
 */
public class ClickButton extends BaseButton{

    private String type = "click";

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }
}
