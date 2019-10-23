package com.sevlow.sdk.tim.bean.chat;

import lombok.Getter;

/**
 * @author pengshiqing
 * @Date: 2019/7/26
 * @Description:
 */

@Getter
public enum ChatMsgEnum {

    /**
     *  消息同步发送
     */
    SYNC(1),
    
    /**
     *  消息不同步
     */
    NO_SYNC(2)

    ;

    private Integer type ;

    ChatMsgEnum(Integer type){
        this.type = type ;
    }
}
