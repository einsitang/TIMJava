package com.sevlow.sdk.tim.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.constant
 * @date 2019-05-27 15:52
 * @Description:
 *
 * 腾讯 云通讯 错误码对照表
 */
public class TIMErrorConstant {

	public final static Map<Integer,String> ERROR_INFO_MAP = new HashMap<>();

	static{

		ERROR_INFO_MAP.put(-1,"Unknow");

		ERROR_INFO_MAP.put(40005,"资料字段中包含敏感词");
		ERROR_INFO_MAP.put(40006,"设置资料时服务器内部错误，请稍后重试");
		ERROR_INFO_MAP.put(40601,"资料字段的 Value 长度超过500字节");
		ERROR_INFO_MAP.put(60008,"服务请求超时或 HTTP 请求格式错误，请检查并重试。");
		ERROR_INFO_MAP.put(70020,"SDKAppID 未找到，请在云通信 IM 控制台确认应用信息。");
		ERROR_INFO_MAP.put(70052,"UserSig 已经失效，请重新生成，再次尝试。");
		ERROR_INFO_MAP.put(70107,"请求的用户帐号不存在。");
		ERROR_INFO_MAP.put(70169,"服务端内部超时，请重试");
		ERROR_INFO_MAP.put(70398,"创建帐号数量超过免费体验版数量限制，请升级为专业版");
		ERROR_INFO_MAP.put(70402,"参数非法，请检查必填字段是否填充，或者字段的填充是否满足协议要求");
		ERROR_INFO_MAP.put(70403,"请求需要 App 管理员权限");
		ERROR_INFO_MAP.put(70500,"服务器内部错误，请重试");
		ERROR_INFO_MAP.put(90001,"JSON 格式解析失败，请检查请求包是否符合 JSON 规范。或者 To_Account 是空数组");
		ERROR_INFO_MAP.put(90003,"JSON 格式请求包中 To_Account 不符合消息格式描述，请检查 To_Account 类型是否为 String");
		ERROR_INFO_MAP.put(90009,"请求需要 App 管理员权限");
		ERROR_INFO_MAP.put(90011,"批量发消息目标帐号超过500，请减少 To_Account 中目标帐号数量");
		ERROR_INFO_MAP.put(90992,"后端服务超时，请重试");
		ERROR_INFO_MAP.put(90994,"服务内部错误，请重试");
		ERROR_INFO_MAP.put(90995,"服务内部错误，请重试");
		ERROR_INFO_MAP.put(91000,"服务内部错误，请重试");

	}

	public static String getErrorInfo(Integer i){
		return ERROR_INFO_MAP.get(i);
	}

}
