package com.sevlow.sdk.tim.bean.relationManage;

import com.google.gson.annotations.SerializedName;
import com.sevlow.sdk.tim.bean.SnsItem;
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
    private List<SnsItem> snsProfileItems ;

    
}
