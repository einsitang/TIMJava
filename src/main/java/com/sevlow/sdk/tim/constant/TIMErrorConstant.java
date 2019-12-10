package com.sevlow.sdk.tim.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 腾讯 云通讯 错误码对照表
 *
 * @author element
 */
public class TIMErrorConstant {

    public final static Map<Integer, String> ERROR_INFO_MAP = new HashMap<>();

    static {

        ERROR_INFO_MAP.put(-1, "Unknow");

        ERROR_INFO_MAP.put(30001, "请求参数错误，请根据错误描述检查请求参数");
        ERROR_INFO_MAP.put(30002, "SDKAppID 不匹配");
        ERROR_INFO_MAP.put(30003, "请求的用户帐号不存在");
        ERROR_INFO_MAP.put(30004, "请求需要 App 管理员权限");
        ERROR_INFO_MAP.put(30005, "关系链字段中包含敏感词");
        ERROR_INFO_MAP.put(30006, "服务器内部错误，请重试");
        ERROR_INFO_MAP.put(30007, "网络超时，请稍后重试");
        ERROR_INFO_MAP.put(30008, "并发写导致写冲突，建议使用批量方式");
        ERROR_INFO_MAP.put(30009, "后台禁止该用户发起加好友请求");
        ERROR_INFO_MAP.put(30010, "自己的好友数已达系统上限");
        ERROR_INFO_MAP.put(30011, "分组已达系统上限");
        ERROR_INFO_MAP.put(30012, "未决数已达系统上限");
        ERROR_INFO_MAP.put(30014, "对方的好友数已达系统上限");
        ERROR_INFO_MAP.put(30015, "请求添加好友时，对方在自己的黑名单中，不允许加好友");
        ERROR_INFO_MAP.put(30016, "请求添加好友时，对方的加好友验证方式是不允许任何人添加自己为好友");
        ERROR_INFO_MAP.put(30525, "请求添加好友时，自己在对方的黑名单中，不允许加好友");
        ERROR_INFO_MAP.put(30539, "A 请求加 B 为好友，B 的加好友验证方式被设置为“AllowType_Type_NeedConfirm”，这时 A 与 B 之间只能形成未决关系，这个返回码用于标识加未决成功，以便与加好友成功的返回码区分开，调用方可以捕捉该错误给用户一个合理的提示");
        ERROR_INFO_MAP.put(30540, "添加好友请求被安全策略打击，请勿频繁发起添加好友请求");

        ERROR_INFO_MAP.put(40001, "请求参数错误，请根据错误描述检查请求参数");
        ERROR_INFO_MAP.put(40003, "请求的用户帐号不存在");
        ERROR_INFO_MAP.put(40004, "请求需要 App 管理员权限");
        ERROR_INFO_MAP.put(40005, "资料字段中包含敏感词");
        ERROR_INFO_MAP.put(40006, "服务器内部错误，请稍后重试");
        ERROR_INFO_MAP.put(40007, "没有资料字段的读权限");
        ERROR_INFO_MAP.put(40008, "没有资料字段的写权限");
        ERROR_INFO_MAP.put(40009, "资料字段的 Tag 不存在");
        ERROR_INFO_MAP.put(40601, "资料字段的 Value 长度超过500字节");
        ERROR_INFO_MAP.put(40605, "标配资料字段的 Value错误");
        ERROR_INFO_MAP.put(40610, "资料字段的 Value 类型不匹配");

        ERROR_INFO_MAP.put(50001, "请求的用户帐号不存在。");
        ERROR_INFO_MAP.put(50002, "请求参数错误，请根据错误描述检查请求是否正确。");
        ERROR_INFO_MAP.put(50003, "请求需要 App 管理员权限。");
        ERROR_INFO_MAP.put(50004, "服务端内部错误，请重试。");
        ERROR_INFO_MAP.put(50005, "网络超时，请稍后重试。");

        ERROR_INFO_MAP.put(60008, "服务请求超时或 HTTP 请求格式错误，请检查并重试。");
        ERROR_INFO_MAP.put(70020, "SDKAppID 未找到，请在云通信 IM 控制台确认应用信息。");
        ERROR_INFO_MAP.put(70052, "UserSig 已经失效，请重新生成，再次尝试。");
        ERROR_INFO_MAP.put(70107, "请求的用户帐号不存在。");
        ERROR_INFO_MAP.put(70169, "服务端内部超时，请重试");
        ERROR_INFO_MAP.put(70398, "创建帐号数量超过免费体验版数量限制，请升级为专业版");
        ERROR_INFO_MAP.put(70402, "参数非法，请检查必填字段是否填充，或者字段的填充是否满足协议要求");
        ERROR_INFO_MAP.put(70403, "请求需要 App 管理员权限");
        ERROR_INFO_MAP.put(70500, "服务器内部错误，请重试");

        ERROR_INFO_MAP.put(90001, "JSON 格式解析失败，请检查请求包是否符合 JSON 规范。或者 To_Account 是空数组");
        ERROR_INFO_MAP.put(90003, "JSON 格式请求包中 To_Account 不符合消息格式描述，请检查 To_Account 类型是否为 String");
        ERROR_INFO_MAP.put(90005, "JSON 格式请求包体中缺少 MsgRandom 字段或者 MsgRandom 字段不是 Integer 类型");
        ERROR_INFO_MAP.put(90006, "JSON 格式请求包体中缺少 MsgTimeStamp 字段或者 MsgTimeStamp 字段不是 Integer 类型");
        ERROR_INFO_MAP.put(90007, "JSON 格式请求包体中 MsgBody 类型不是 Array 类型，请将其修改为 Array 类型");
        ERROR_INFO_MAP.put(90008, "JSON 格式请求包体中缺少 From_Account 字段，或者From_Account 不存在");
        ERROR_INFO_MAP.put(90009, "请求需要 App 管理员权限");
        ERROR_INFO_MAP.put(90010, "JSON 格式请求包不符合消息格式描述，请参考 TIMMsgElement 对象 的定义。");
        ERROR_INFO_MAP.put(90011, "批量发消息目标帐号超过500，请减少 To_Account 中目标帐号数量");
        ERROR_INFO_MAP.put(90012, "To_Account 没有注册或不存在，请确认 To_Account 是否导入即时通信 IM 或者是否拼写错误。");
        ERROR_INFO_MAP.put(90026, "消息离线存储时间错误（最多不能超过7天）。");
        ERROR_INFO_MAP.put(90992, "后端服务超时，请重试");
        ERROR_INFO_MAP.put(90994, "服务内部错误，请重试");
        ERROR_INFO_MAP.put(90995, "服务内部错误，请重试");
        ERROR_INFO_MAP.put(91000, "服务内部错误，请重试");

    }

    public static String getErrorInfo(Integer i) {
        return ERROR_INFO_MAP.get(i);
    }

}
