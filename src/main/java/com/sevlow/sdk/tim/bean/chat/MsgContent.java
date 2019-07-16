package com.sevlow.sdk.tim.bean.chat;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author pengshiqing
 * @Date: 2019/7/16
 * @Description:
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MsgContent implements Serializable {

    private static final long serialVersionUID = 8874434318533463826L;

    @SerializedName("Text")
    private String text ;
}
