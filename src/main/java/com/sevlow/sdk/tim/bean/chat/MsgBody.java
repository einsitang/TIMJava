package com.sevlow.sdk.tim.bean.chat;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author pengshiqing
 * @Date: 2019/7/16
 * @Description:
 */
@Data
public class MsgBody implements Serializable {
    
    private static final long serialVersionUID = -3683204615133585051L;

    @SerializedName("MsgType")
    private String msgType ;

    @SerializedName("MsgContent")
    private Object msgContent ;


}
