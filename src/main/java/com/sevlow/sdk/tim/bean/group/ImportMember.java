package com.sevlow.sdk.tim.bean.group;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author pengshiqing
 * @Date: 2019/11/19
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImportMember implements Serializable {

    private static final long serialVersionUID = -7697775807568780852L;


    @SerializedName("Member_Account")
    private String Member_Account ;

    @SerializedName("Role")
    private Role role ;

    @SerializedName("JoinTime")
    private Date joinTime ;

    @SerializedName("UnreadMsgNum")
    private Integer unreadMsgNum ;

    public enum Role{
        Admin,
        Member
    }

    public ImportMember(String member_Account) {
        Member_Account = member_Account;
    }

    public ImportMember(String member_Account, Role role) {
        Member_Account = member_Account;
        this.role = role;
    }
}
