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
public class MemberAccount implements Serializable {
    
    private static final long serialVersionUID = -6127906010511506336L;

    @SerializedName("Member_Account")
    private String memberAccount ;

    public MemberAccount(String memberAccount) {
        this.memberAccount = memberAccount;
    }
}
