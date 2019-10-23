package com.sevlow.sdk.tim.bean.profile;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author element
 */
@Data
public class TIMProfile implements Serializable {

    private static final long serialVersionUID = -5970285192843170414L;

    @SerializedName("Tag_Profile_IM_Nick")
    private String nick;

    @SerializedName("Tag_Profile_IM_Gender")
    private GenderEnum gender;

    @SerializedName("Tag_Profile_IM_BirthDay")
    private String birthday;

    @SerializedName("Tag_Profile_IM_Location")
    private String location;

    @SerializedName("Tag_Profile_IM_SelfSignature")
    private String selfSignature;

    @SerializedName("Tag_Profile_IM_AllowType")
    private AllowTypeEnum allowType;

    @SerializedName("Tag_Profile_IM_Language")
    private String language;

    @SerializedName("Tag_Profile_IM_Image")
    private String image;

    @SerializedName("Tag_Profile_IM_MsgSettings")
    private Integer msgSettings;

    @SerializedName("Tag_Profile_IM_AdminForbidType")
    private AdminForbidTypeEnum  adminForbidType;

    @SerializedName("Tag_Profile_IM_Level")
    private Integer level;

    @SerializedName("Tag_Profile_IM_Role")
    private Integer role;


}
