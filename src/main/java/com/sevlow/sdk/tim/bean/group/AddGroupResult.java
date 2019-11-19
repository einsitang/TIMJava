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
public class AddGroupResult implements Serializable {

    private static final long serialVersionUID = 7535394555315687317L;


    @SerializedName("MemberList")
    private List<MemberAccount> memberList ;


    @Data
    private class MemberAccount{

        @SerializedName("Member_Account")
        private String memberAccount ;

        @SerializedName("Result")
        private Integer result ;
    }


}
