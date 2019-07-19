package com.sevlow.sdk.tim.bean.chat;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * @author pengshiqing
 * @Date: 2019/7/19
 * @Description:
 */
@Data
public class MsgCustomContent {

    @SerializedName("Data")
    private String data ;

    @SerializedName("desc")
    private String Desc ;

    @SerializedName("ext")
    private String Ext ;

    @SerializedName("sound")
    private String Sound ;
}
