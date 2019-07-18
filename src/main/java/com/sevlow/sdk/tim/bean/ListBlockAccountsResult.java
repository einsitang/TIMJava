package com.sevlow.sdk.tim.bean;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.bean
 * @date 2019-05-27 19:40
 * @Description: TODO
 */

@Data
public class ListBlockAccountsResult implements Serializable {
    private static final long serialVersionUID = 8014241940291761266L;

    @SerializedName("BlackListItem")
    private List<BlackListItemDetail> blackListItems ;

    @SerializedName("StartIndex")
    private Integer startIndex ;

    @SerializedName("CurruentSequence")
    private Integer curruentSequence ;



    @Data
    private class BlackListItemDetail implements Serializable {

        private static final long serialVersionUID = -2470013868300393921L;

        @SerializedName("To_Account")
        private String toAccount ;

        @SerializedName("AddBlackTimeStamp")
        private Integer addBlackTimeStamp ;


    }
}
