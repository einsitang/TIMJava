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

    /**
     *  自定义消息数据。 不作为 APNs 的 payload 字段下发，故从 payload 中无法获取 Data 字段。
     */
    @SerializedName("Data")
    private String data ;

    /**
     *  自定义消息描述信息；当接收方为 iOS 或 Android 后台在线时，做离线推送文本展示。
     */
    @SerializedName("Desc")
    private String desc ;

    /**
     *  扩展字段；当接收方为 iOS 系统且应用处在后台时，此字段作为 APNs 请求包 Payloads 中的 ext 键值下发
     */
    @SerializedName("Ext")
    private String ext ;

    /**
     *  自定义 APNs 推送铃音。
     */
    @SerializedName("Sound")
    private String sound ;
}
