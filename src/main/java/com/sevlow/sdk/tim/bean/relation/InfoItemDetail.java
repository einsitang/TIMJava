package com.sevlow.sdk.tim.bean.relation;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author pengshiqing
 * @Date: 2019/6/3
 * @Description:
 */

@Data
public class InfoItemDetail  implements Serializable {

    private static final long serialVersionUID = -6532938731305216895L;

    @SerializedName("To_Account")
    private String toAccount ;

    @SerializedName("Relation")
    private String relation ;

    @SerializedName("ResultCode")
    private Integer resultCode ;

    @SerializedName("ResultInfo")
    private String resultInfo ;
}
