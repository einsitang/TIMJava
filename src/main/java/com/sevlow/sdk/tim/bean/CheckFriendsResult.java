package com.sevlow.sdk.tim.bean;

import com.google.gson.annotations.SerializedName;
import com.sevlow.sdk.tim.bean.relationManage.InfoItemDetail;
import lombok.Data;

import java.util.List;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.bean
 * @date 2019-05-27 19:40
 * @Description: TODO
 */
@Data
public class CheckFriendsResult {

    @SerializedName("InfoItem")
    private List<InfoItemDetail> infoItem ;

    @SerializedName("Fail_Account")
    private String[] failAccount ;


}
