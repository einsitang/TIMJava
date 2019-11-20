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
public class GroupMemberInfo implements Serializable {

    private static final long serialVersionUID = -7860881397655972971L;

    /**
     *  要操作的群组（必填）
     */
    @SerializedName("GroupId")
    private String GroupId ;

    /**
     * 要操作的群成员（必填）
     */
    @SerializedName("Member_Account")
    private String memberAccount ;

    /**
     * 设置角色
     */
    @SerializedName("Role")
    private Role role ;

    /**
     * 群名片（选填）
     */
    @SerializedName("NameCard")
    private String nameCard ;

    /**
     * AcceptAndNotify、Discard或者AcceptNotNotify，消息屏蔽类型
     */
    @SerializedName("MsgFlag")
    private MsgFlag msgFlag ;

    /**
     * 指定群成员的禁言时间，单位为秒
     */
    @SerializedName("ShutUpTime")
    private Integer shutUpTime ;



    public enum MsgFlag{
        AcceptAndNotify,
        Discard,
        AcceptNotNotify
    }

    public enum Role{
        Admin,
        Member
    }
}
