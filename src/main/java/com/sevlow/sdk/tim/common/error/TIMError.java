package com.sevlow.sdk.tim.common.error;

import com.google.gson.annotations.SerializedName;
import com.sevlow.sdk.tim.constant.TIMErrorConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * TIM 错误值
 *
 * @author element
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TIMError implements Serializable {

    private static final long serialVersionUID = -906834256793589790L;

    @SerializedName("ErrorCode")
    private int errorCode = 0;

    @SerializedName("ErrorInfo")
    private String errorInfo = "";

    @SerializedName("ActionStatus")
    private String actionStatus = "OK";

    @SerializedName("ErrorDisplay")
    private String errorDisplay = "";

    public TIMError(int errorCode, String errorInfo) {
        this.errorCode = errorCode;
        this.errorInfo = errorInfo;
    }

    @Override
    public String toString() {
        return "错误: ErrorCode=" + this.errorCode +
                ", ErrorInfo=" + this.errorInfo +
                ", ErrorDisplay=" + this.errorDisplay +
                ", ActionStatus=" + this.actionStatus +
                "\n" +
                "Description=" + TIMErrorConstant.getErrorInfo(this.errorCode);
    }

}
