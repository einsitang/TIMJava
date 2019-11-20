package com.sevlow.sdk.tim.bean.group;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pengshiqing
 * @Date: 2019/11/19
 * @Description:
 */
@Data
public class TIMTextElem {

    @SerializedName("MsgType")
    private String msgType ;

    @SerializedName("MsgContent")
    private Map<String,String> msgContent = new HashMap<>(1);

    public TIMTextElem(String message) {
        this.msgType = "TIMTextElem";
        msgContent.put("Text",message);
    }
}
