package com.sevlow.sdk.tim.api;

import com.sevlow.sdk.tim.bean.*;
import com.sun.istack.internal.NotNull;

import java.util.Date;
import java.util.List;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.api
 * @date 2019-05-27 10:38
 * @Description: 关系链管理
 * API Doc : https://cloud.tencent.com/document/product/269/1642
 */
public interface TIMRelationService {

	/**
	 * 加好友方式
	 */
	public static enum AddType{

		// 单向添加好友
		Add_Type_Single("Add_Type_Single"),
		// 双向添加好友
		Add_Type_Both("Add_Type_Both");

		private String typeInfo;

		private AddType(String typeInfo){
			this.typeInfo = typeInfo;
		}
	}

	/**
	 * 删除好友方式
	 */
	public static enum DeleteType{
		// 单向删除好友
		Delete_Type_Single("Delete_Type_Single"),
		// 双向删除好友
		Delete_Type_Both("Delete_Type_Both");

		private String typeInfo;

		private DeleteType(String typeInfo){
			this.typeInfo = typeInfo;
		}
	}

	/**
	 * 双向好友检查方式
	 */
	public static enum CheckType{

		// 单向检查
		CheckResult_Type_Singal("CheckResult_Type_Singal"),

		// 双向检查
		CheckResult_Type_Both("CheckResult_Type_Both");

		private String typeInfo;

		private CheckType(String typeInfo){
			this.typeInfo = typeInfo;
		}
	}

	/**
	 * 添加好友
	 *
	 * 添加好友，支持批量添加好友。
	 *
	 * API Doc : https://cloud.tencent.com/document/product/269/1643
	 *
	 * @param account      需要添加好友的 <b>Identifier</b>
	 * @param friends      被添加的 <b>Identifier</b> 集合
	 * @param friendSource 好友来源
	 * @param addType      好友添加方式
	 * @return
	 */
	AddFriendResult addFriends(@NotNull String account, @NotNull List<String> friends, @NotNull String friendSource,AddType addType);

	/**
	 * 添加好友(双向)
	 */
	AddFriendResult addFriends(@NotNull String account, @NotNull List<String> friends, @NotNull String friendSource);


	/**
	 * 导入好友
	 *
	 * 支持批量导入单向好友；
	 * 往同一个用户导入好友时建议采用批量导入的方式，避免并发写导致的写冲突。
	 *
	 * API Doc : https://cloud.tencent.com/document/product/269/8301
	 * @param account 需要导入好友的 <b>Identifier</b>
	 * @param friends 被添加的 <b>Identifier</b> 集合
	 * @param friendSource 好友来源
	 * @return
	 */
	ImportFriendsResult importFriends(@NotNull String account, @NotNull List<String> friends, @NotNull String friendSource);

	/**
	 * 删除好友
	 *
	 * 删除好友，支持单向删除好友和双向删除好友。
	 *
	 * API Doc : https://cloud.tencent.com/document/product/269/1644
	 *
	 * @param account       账号 <b>Identifier</b>
	 * @param friends       删除的好友列表 <b>Identifier</b> 集合
	 * @param deleteType    删除方式
	 * @return
	 */
	DeleteFriendsResult deleteFriend(@NotNull String account, @NotNull List<String> friends, DeleteType deleteType);

	/**
	 * 删除好友(双向)
	 *
	 */
	DeleteFriendsResult deleteFriend(@NotNull String account,@NotNull List<String> friends);

	/**
	 * 清空(删除)所有好友
	 *
	 * API Doc : https://cloud.tencent.com/document/product/269/1645
	 *
	 * @param account
	 */
	void emptyFriends(@NotNull String account);

	/**
	 * 校验好友
	 *
	 * 支持批量校验好友关系。
	 *
	 * API Doc : https://cloud.tencent.com/document/product/269/1646
	 *
	 * @param account
	 * @param friends
	 * @param checkType
	 * @return
	 */
	CheckFriendsResult checkFriends(@NotNull String account, @NotNull List<String> friends, CheckType checkType);

	/**
	 * 校验好友(双向)
	 *
	 * @param account
	 * @param friends
	 * @return
	 */
	CheckFriendsResult checkFriends(@NotNull String account,@NotNull List<String> friends);

	/**
	 * 拉取好友
	 *
	 * 分页拉取所有好友。
	 *
	 * API Doc : https://cloud.tencent.com/document/product/269/1647
	 *
	 * @param account               需要拉取该 Identifier 的好友
	 * @param offset                拉取的起始位置
	 * @param rows                  每页需要拉取的好友数量,最大100
	 * @param timestamp             上次拉取的时间戳，为0时表示全量拉取
	 * @param lastStandardSequence  上次拉取标配关系链的 Sequence，仅在只拉取标配关系链字段时有用
	 * @return
	 */
	ListFriendsResult listFriends(@NotNull String account, int offset, int rows, Date timestamp, int lastStandardSequence);

	/**
	 * 屏蔽用户(添加黑名单)
	 *
	 * 添加黑名单，支持批量添加黑名单。
	 *
	 * API Doc : https://cloud.tencent.com/document/product/269/3718
	 *
	 * @param identifier
	 * @param accounts
	 * @return
	 */
	BlockAccountsResult blockAccounts(@NotNull String identifier,@NotNull List<String> accounts);

	/**
	 * 解除屏蔽 (删除黑名单)
	 *
	 * 删除指定黑名单。
	 *
	 * API Doc : https://cloud.tencent.com/document/product/269/3719
	 *
	 * @param identifier
	 * @param blockAccounts
	 * @return
	 */
	UnBlockAccountsResult unblockAccounts(@NotNull String identifier,@NotNull List<String> blockAccounts);

	/**
	 * 拉取黑名单
	 *
	 * 分页拉取所有黑名单。
	 *
	 * API Doc : https://cloud.tencent.com/document/product/269/3722
	 *
	 * @param identifier        需要拉取该 Identifier 的黑名单
	 * @param offset            拉取的起始位置
	 * @param rows              拉去总数
	 * @param lastSequence      上一次拉黑名单时后台返回给客户端的 Seq，初次拉取时为0
	 * @return
	 */
	ListBlockAccountsResult listBlockAccounts(@NotNull String identifier, int offset,int rows,int lastSequence);

}
