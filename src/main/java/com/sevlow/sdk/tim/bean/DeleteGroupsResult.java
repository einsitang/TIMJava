package com.sevlow.sdk.tim.bean;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.bean
 * @date 2019-05-27 23:05
 * @Description: TODO
 */
@Data
public class DeleteGroupsResult {

    @SerializedName("CurrentSequence")
    private Integer currentSequence ;
}
