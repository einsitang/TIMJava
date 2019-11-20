package com.sevlow.sdk.tim.bean.group;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author pengshiqing
 * @Date: 2019/11/19
 * @Description:
 */
@Data
public class CreateGroupResult implements Serializable {

    private static final long serialVersionUID = 2869190403582320201L;

    @SerializedName("GroupId")
    private String groupId ;
}
