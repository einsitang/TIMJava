package com.sevlow.sdk.tim.bean.relation;

import com.google.gson.annotations.SerializedName;
import com.sevlow.sdk.tim.bean.SnsItem;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 好友对象都包含一个 To_Account 字段和一个 ValueItem 数组
 * @author element
 */
@Data
public class UserDataItem implements Serializable {

    private static final long serialVersionUID = -5954814814829812163L;

    @SerializedName("To_Account")
    private String account;

    @SerializedName("ValueItem")
    private List<SnsItem> valueItems;
}
