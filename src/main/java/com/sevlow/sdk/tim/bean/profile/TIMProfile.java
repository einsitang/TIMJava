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

    public static final String TAG_PROFILE_IM_NICK = "Tag_Profile_IM_Nick";
    public static final String TAG_PROFILE_IM_GENDER = "Tag_Profile_IM_Gender";
    public static final String TAG_PROFILE_IM_BIRTHDAY = "Tag_Profile_IM_BirthDay";
    public static final String TAG_PROFILE_IM_LOCATION = "Tag_Profile_IM_Location";
    public static final String TAG_PROFILE_IM_SELFSIGNATURE = "Tag_Profile_IM_SelfSignature";
    public static final String TAG_PROFILE_IM_ALLOWTYPE = "Tag_Profile_IM_AllowType";
    public static final String TAG_PROFILE_IM_LANGUAGE = "Tag_Profile_IM_Language";
    public static final String TAG_PROFILE_IM_IMAGE = "Tag_Profile_IM_Image";
    public static final String TAG_PROFILE_IM_MSGSETTINGS = "Tag_Profile_IM_MsgSettings";
    public static final String TAG_PROFILE_IM_ADMINFORBIDTYPE = "Tag_Profile_IM_AdminForbidType";
    public static final String TAG_PROFILE_IM_LEVEL = "Tag_Profile_IM_Level";
    public static final String TAG_PROFILE_IM_ROLE = "Tag_Profile_IM_Role";

    @SerializedName(TAG_PROFILE_IM_NICK)
    private String nick;

    @SerializedName(TAG_PROFILE_IM_GENDER)
    private GenderEnum gender;

    @SerializedName(TAG_PROFILE_IM_BIRTHDAY)
    private String birthday;

    @SerializedName(TAG_PROFILE_IM_LOCATION)
    private String location;

    @SerializedName(TAG_PROFILE_IM_SELFSIGNATURE)
    private String selfSignature;

    @SerializedName(TAG_PROFILE_IM_ALLOWTYPE)
    private AllowTypeEnum allowType;

    @SerializedName(TAG_PROFILE_IM_LANGUAGE)
    private String language;

    @SerializedName(TAG_PROFILE_IM_IMAGE)
    private String image;

    @SerializedName(TAG_PROFILE_IM_MSGSETTINGS)
    private Integer msgSettings;

    @SerializedName(TAG_PROFILE_IM_ADMINFORBIDTYPE)
    private AdminForbidTypeEnum adminForbidType;

    @SerializedName(TAG_PROFILE_IM_LEVEL)
    private Integer level;

    @SerializedName(TAG_PROFILE_IM_ROLE)
    private Integer role;


}
