package com.sevlow.sdk.tim.bean.relation;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 指向性拉取好友结果
 *
 * @author element
 */
@Data
public class ListFriendsDirectivityResult implements Serializable {

    private static final long serialVersionUID = -2636511198234645476L;

    @SerializedName("InfoItem")
    private List<UserDataInfoItem> infoItems;

}
