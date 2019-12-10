package com.sevlow.sdk.tim.bean.profile;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;


/**
 * @author element
 */
@Data
public class ProfileItem implements Serializable {

    private static final long serialVersionUID = 6918323613244902742L;

    @SerializedName("Tag")
    private String tag;

    @SerializedName("Value")
    private Object value;
}
