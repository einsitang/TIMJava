package com.sevlow.sdk.tim.bean.group;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pengshiqing
 * @Date: 2019/11/19
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupInfo {

    /**
     * 群主的 UserId（选填）
     */
    @SerializedName("Owner_Account")
    private String ownerAccount ;

    /**
     * 群id 选填
     */
    @SerializedName("GroupId")
    private String groupId ;

    /**
     * 群组类型：Private/Public/ChatRoom/AVChatRoom/BChatRoom（必填）
     */
    @SerializedName("Type")
    private Type type ;

    /**
     *  最大群成员数量（选填）
     */
    @SerializedName("MaxMemberNum")
    private Integer maxMemberNum ;

    /**
     * 群名称（必填）
     */
    @SerializedName("Name")
    private String name ;

    /**
     * 群简介（选填）
     */
    @SerializedName("Introduction")
    private String introduction ;

    /**
     * 群公告（选填）
     */
    @SerializedName("Notification")
    private String notification ;

    /**
     * 群头像 URL（选填）
     */
    @SerializedName("FaceUrl")
    private String faceUrl ;

    /**
     * 申请加群处理方式（选填）
     */
    @SerializedName("ApplyJoinOption")
    private ApplyJoinOption applyJoinOption ;


    /**
     *  设置全员禁言（选填）:"On"开启，"Off"关闭
     */
    @SerializedName("ShutUpAllMember")
    private ShutUpAllMember shutUpAllMember ;


    public enum Type {
        Public,
        Private,
        ChatRoom,
        AVChatRoom,
        BChatRoom
    }

    public enum ApplyJoinOption{
        FreeAccess,
        NeedPermission,
        DisableApply,
    }

    public enum ShutUpAllMember {
        On,
        Off
    }

}
