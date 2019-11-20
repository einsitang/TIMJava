package com.sevlow.sdk.tim.bean.group;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author pengshiqing
 * @Date: 2019/11/19
 * @Description:
 */
@Data
public class ShuttedMemberResult implements Serializable {
    
    private static final long serialVersionUID = 6292088611087946322L;

    @SerializedName("GroupId")
    private String GroupId ;

    @SerializedName("ShuttedUinList")
    private List<ShuttedUin> shuttedUinList ;


    @Data
    private class ShuttedUin{

        @SerializedName("Member_Account")
        private String memberAccount ;

        @SerializedName("ShuttedUntil")
        private Integer shuttedUntil ;
    }
}
