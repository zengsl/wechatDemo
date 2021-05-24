package com.example.wechat.menu.entity;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/5/7 4:14 下午
 */
public class ViewButton extends BaseButton {
    private String type = "view";

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }
}
