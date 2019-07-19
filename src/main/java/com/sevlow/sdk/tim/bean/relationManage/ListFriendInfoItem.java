package com.sevlow.sdk.tim.bean.relationManage;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author pengshiqing
 * @Date: 2019/6/4
 * @Description:
 */

@Data
public class ListFriendInfoItem  implements Serializable {


    private static final long serialVersionUID = 1341687065395870529L;


    @SerializedName("Info_Account")
    private String infoAccount ;

    @SerializedName("SnsProfileItem")
    private List<SnsProfileItem> snsProfileItem ;




    @Data
    private class SnsProfileItem implements Serializable {

        private static final long serialVersionUID = 4088549752680756130L;

        @SerializedName("Tag")
        private String tag;

        @SerializedName("Value")
        private Object value;

    }
}
