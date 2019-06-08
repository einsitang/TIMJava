package com.sevlow.sdk.tim.bean.relation;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author pengshiqing
 * @Date: 2019/6/3
 * @Description: 关系链管理-删除所有
 */
@Data
public class DeleteAllResult implements Serializable {

    private static final long serialVersionUID = 8924765103859833374L;


    @SerializedName("ActionStatus")
    private String actionStatus ;

    @SerializedName("ErrorCode")
    private Integer errorCode ;

    @SerializedName("ErrorInfo")
    private String errorInfo ;

    @SerializedName("ErrorDisplay")
    private String errorDisplay ;


}
