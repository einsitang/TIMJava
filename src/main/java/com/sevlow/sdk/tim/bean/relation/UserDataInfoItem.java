package com.sevlow.sdk.tim.bean.relation;

import com.google.gson.annotations.SerializedName;
import com.sevlow.sdk.tim.bean.ResultStruct;
import com.sevlow.sdk.tim.bean.SnsItem;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author element
 */
@Data
public class UserDataInfoItem extends ResultStruct implements Serializable {

    private static final long serialVersionUID = 5720197350739860347L;

    @SerializedName("To_Account")
    private String account;

    @SerializedName("SnsProfileItem")
    private List<SnsItem> snsProfileItems;
}
