package com.example.wechat.menu.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/5/7 4:31 下午
 */
public class SubButton extends BaseButton {

    @JsonProperty("sub_button")
    private List<BaseButton> subButton = new ArrayList<>(16);

    public List<BaseButton> getSubButton() {
        return subButton;
    }

    public void setSubButton(List<BaseButton> subButton) {
        this.subButton = subButton;
    }
}
