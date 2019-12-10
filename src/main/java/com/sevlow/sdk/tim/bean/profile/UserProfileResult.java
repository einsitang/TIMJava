package com.sevlow.sdk.tim.bean.profile;

import com.google.gson.annotations.SerializedName;
import com.sevlow.sdk.tim.bean.ResultStruct;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author element
 */
@Data
public class UserProfileResult extends ResultStruct implements Serializable {

    private static final long serialVersionUID = -2616197016212501604L;

    @SerializedName("UserProfileItem")
    private List<UserProfileItem> userProfileItems;

    @SerializedName("Fail_Account")
    private List<String> failAccounts;

    @SerializedName("ActionStatus")
    private String actionStatus;

}
