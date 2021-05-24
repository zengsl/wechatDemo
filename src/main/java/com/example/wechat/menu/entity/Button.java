package com.example.wechat.menu.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/5/7 4:10 下午
 */
public class Button {

    List<BaseButton> button = new ArrayList<>(16);

    public List<BaseButton> getButton() {
        return button;
    }

    public void setButton(List<BaseButton> button) {
        this.button = button;
    }
}
