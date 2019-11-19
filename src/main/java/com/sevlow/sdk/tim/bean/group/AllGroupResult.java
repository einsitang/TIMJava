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
public class AllGroupResult implements Serializable {

    private static final long serialVersionUID = 5330395292714348875L;

    @SerializedName("TotalCount")
    private Integer totalCount ;

    @SerializedName("Next")
    private Long next ;

    @SerializedName("GroupIdList")
    private List<GroupId> groupIdList ;

    @Data
    private class GroupId{

        @SerializedName("GroupId")
        private String groupId ;
    }
}
