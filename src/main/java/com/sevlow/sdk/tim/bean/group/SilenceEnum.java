package com.sevlow.sdk.tim.bean.group;

import lombok.Getter;

/**
 * @author pengshiqing
 * @Date: 2019/11/19
 * @Description:
 */
@Getter
public enum SilenceEnum {

    QUIET(1),
    NOTICE(0)
    ;
    private Integer type ;

    SilenceEnum(Integer type) {
        this.type = type;
    }
}
