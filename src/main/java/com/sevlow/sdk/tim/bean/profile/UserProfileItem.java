package com.sevlow.sdk.tim.bean.profile;

import com.google.gson.annotations.SerializedName;
import com.sevlow.sdk.tim.bean.ResultStruct;
import com.sevlow.sdk.tim.bean.SnsItem;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;
import java.util.List;

/**
 * @author element
 */
@Data
public class UserProfileItem extends ResultStruct implements Serializable {
    private static final long serialVersionUID = -6019144745649301532L;

    private static final String CUSTOM_PROFILE_PREFIX = "Tag_Profile_Custom_";

    @SerializedName("To_Account")
    private String toAccount;

    @SerializedName("ProfileItem")
    private List<SnsItem> profileItems;

    public Object getProfile(@NonNull String key){
        if(profileItems == null || profileItems.isEmpty()){
            return null;
        }

        return profileItems.stream()
                .filter((item)->key.equals(item.getTag()))
                .findFirst()
                .orElse(null);
    }

    public Object getCustom(@NonNull String key){
        if(profileItems == null || profileItems.isEmpty()){
            return null;
        }

        String completeKey = CUSTOM_PROFILE_PREFIX.concat(key);
        return profileItems.stream()
                .filter((item)->completeKey.equals(item.getTag()))
                .findFirst()
                .orElse(null);
    }
}
