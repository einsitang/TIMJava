package com.sevlow.sdk.tim.api;

import com.sevlow.sdk.tim.bean.*;
import com.sevlow.sdk.tim.bean.account.TIMFriend;
import com.sevlow.sdk.tim.common.error.TIMException;
import lombok.NonNull;

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
	public static enum AddType {

		// 单向添加好友
		Add_Type_Single("Add_Type_Single"),
		// 双向添加好友
		Add_Type_Both("Add_Type_Both");

		private String typeInfo;

		private AddType(String typeInfo) {
			this.typeInfo = typeInfo;
		}

	}

	/**
	 * 删除好友方式
	 */
	public static enum DeleteType {
		// 单向删除好友
		Delete_Type_Single("Delete_Type_Single"),
		// 双向删除好友
		Delete_Type_Both("Delete_Type_Both");

		private String typeInfo;

		private DeleteType(String typeInfo) {
			this.typeInfo = typeInfo;
		}
	}

	/**
	 * 双向好友检查方式
	 */
	public static enum CheckType {

		// 单向检查
		CheckResult_Type_Singal("CheckResult_Type_Singal"),

		// 双向检查
		CheckResult_Type_Both("CheckResult_Type_Both");

		private String typeInfo;

		private CheckType(String typeInfo) {
			this.typeInfo = typeInfo;
		}
	}

	public static enum BlackCheckType{

		BlackCheckResult_Type_Both("BlackCheckResult_Type_Both"),
		BlackCheckResult_Type_Singal("BlackCheckResult_Type_Singal");

		private String typeInfo;

		private BlackCheckType(String typeInfo){
			this.typeInfo = typeInfo;
		}

	}

	/**
	 * 添加好友
	 * <p>
	 * 添加好友，支持批量添加好友。
	 * <p>
	 * API Doc : https://cloud.tencent.com/document/product/269/1643
	 *
	 * @param identifier   需要添加好友的 <b>Identifier</b>
	 * @param friends      被添加的 <b>Identifier</b> 集合
	 * @param friendSource 好友来源,自动补全AddSource_Type_XXX,所以仅输入"XXX"即可
	 * @param addType      好友添加方式,为 <b>null</b> 则双向添加好友( Add_Type_Both )
	 * @return
	 * @throws TIMException
	 */
	AddFriendsResult addFriends(@NonNull String identifier, @NonNull List<String> friends, @NonNull String friendSource, AddType addType) throws TIMException;

	/**
	 * 添加好友(双向添加好友)
	 *
	 * <p>
	 * 添加好友，支持批量添加好友。
	 * <p>
	 * API Doc : https://cloud.tencent.com/document/product/269/1643
	 *
	 * @param identifier   需要添加好友的 <b>Identifier</b>
	 * @param friends      被添加的 <b>Identifier</b> 集合
	 * @param friendSource 好友来源,自动补全AddSource_Type_XXX,所以仅输入"XXX"即可
	 * @return
	 * @throws TIMException
	 */
	AddFriendsResult addFriends(@NonNull String identifier, @NonNull List<String> friends, @NonNull String friendSource) throws TIMException;


	/**
	 * 导入好友
	 * <p>
	 * 支持批量导入单向好友；
	 * 往同一个用户导入好友时建议采用批量导入的方式，避免并发写导致的写冲突。
	 * <p>
	 * API Doc : https://cloud.tencent.com/document/product/269/8301
	 *
	 * @param identifier   需要导入好友的 <b>Identifier</b>
	 * @param friends      被添加的 <b>Identifier</b> 集合
	 * @param friendSource 好友来源,自动补全AddSource_Type_XXX,所以仅输入"XXX"即可
	 * @return
	 */
	ImportFriendsResult importFriends(@NonNull String identifier, @NonNull List<String> friends, @NonNull String friendSource) throws TIMException;

	/**
	 * 导入好友
	 * <p>
	 * 支持批量导入单向好友；
	 * 往同一个用户导入好友时建议采用批量导入的方式，避免并发写导致的写冲突。
	 * <p>
	 * API Doc : https://cloud.tencent.com/document/product/269/8301
	 *
	 * @param identifier   需要导入好友的 <b>Identifier</b>
	 * @param friends      被添加的 <b>TIMFriend</b> 集合
	 * @return
	 */
	ImportFriendsResult importFriends(@NonNull String identifier, @NonNull List<TIMFriend> friends) throws TIMException;

	/**
	 * 更新好友
	 *
	 * 支持批量更新同一用户的多个好友的关系链数据。
	 * 更新一个用户多个好友时，建议采用批量方式，避免并发写导致的写冲突。
	 *
	 * API Doc : https://cloud.tencent.com/document/product/269/12525
	 *
	 * @param identifier
	 * @param friends
	 * @param snsItems
	 * @return
	 * @throws TIMException
	 */
	UpdateFriendsResult updateFriends(@NonNull String identifier,@NonNull List<String> friends, List<SnsItem> snsItems) throws TIMException;
	/**
	 * 删除好友
	 * <p>
	 * 删除好友，支持单向删除好友和双向删除好友。
	 * <p>
	 * API Doc : https://cloud.tencent.com/document/product/269/1644
	 *
	 * @param identifier 账号 <b>Identifier</b>
	 * @param friends    删除的好友列表 <b>Identifier</b> 集合
	 * @param deleteType 删除方式,为 <b>null</b> 则双向删除( Delete_Type_Both )
	 * @return
	 */
	DeleteFriendsResult deleteFriend(@NonNull String identifier, @NonNull List<String> friends, DeleteType deleteType) throws TIMException;

	/**
	 * 删除好友(双向)
	 * <p>
	 * 删除好友，支持单向删除好友和双向删除好友。
	 * <p>
	 * API Doc : https://cloud.tencent.com/document/product/269/1644
	 *
	 * @param identifier 账号 <b>Identifier</b>
	 * @param friends    删除的好友列表 <b>Identifier</b> 集合
	 * @return
	 */
	DeleteFriendsResult deleteFriend(@NonNull String identifier, @NonNull List<String> friends) throws TIMException;

	/**
	 * 清空(删除)所有好友
	 * <p>
	 * API Doc : https://cloud.tencent.com/document/product/269/1645
	 *
	 * @param identifier
	 */
	void emptyFriends(@NonNull String identifier) throws TIMException;

	/**
	 * 校验好友
	 * <p>
	 * 支持批量校验好友关系。
	 * <p>
	 * API Doc : https://cloud.tencent.com/document/product/269/1646
	 *
	 * @param identifier
	 * @param friends
	 * @param checkType
	 * @return
	 */
	CheckFriendsResult checkFriends(@NonNull String identifier, @NonNull List<String> friends, CheckType checkType) throws TIMException;

	/**
	 * 校验好友(双向)
	 *
	 * @param identifier
	 * @param friends
	 * @return
	 */
	CheckFriendsResult checkFriends(@NonNull String identifier, @NonNull List<String> friends) throws TIMException;

	/**
	 * 拉取好友
	 * <p>
	 * 分页拉取所有好友。
	 * <p>
	 * API Doc : https://cloud.tencent.com/document/product/269/1647
	 *
	 * @param identifier           需要拉取该 Identifier 的好友
	 * @param offset               拉取的起始位置
	 * @param rows                 每页需要拉取的好友数量,最大100
	 * @param timestamp            上次拉取的时间戳，为0时表示全量拉取
	 * @param lastStandardSequence 上次拉取标配关系链的 Sequence，仅在只拉取标配关系链字段时有用
	 * @return
	 */
	ListFriendsResult listFriends(@NonNull String identifier, Integer offset, Integer rows, Integer timestamp, Integer lastStandardSequence) throws TIMException;

	ListFriendsByAccountsResult listFriendsByAccounts(@NonNull String identifier, @NonNull List<String> accounts) throws TIMException;

	/**
	 * 屏蔽用户(添加黑名单)
	 * <p>
	 * 添加黑名单，支持批量添加黑名单。
	 * <p>
	 * API Doc : https://cloud.tencent.com/document/product/269/3718
	 *
	 * @param identifier
	 * @param accounts
	 * @return
	 */
	AddBlockAccountsResult addBlockAccounts(@NonNull String identifier, @NonNull List<String> accounts) throws TIMException;

	/**
	 * 解除屏蔽 (删除黑名单)
	 * <p>
	 * 删除指定黑名单。
	 * <p>
	 * API Doc : https://cloud.tencent.com/document/product/269/3719
	 *
	 * @param identifier
	 * @param blockAccounts
	 * @return
	 */
	RemoveBlockAccountsResult removeblockAccounts(@NonNull String identifier, @NonNull List<String> blockAccounts) throws TIMException;

	/**
	 * 拉取黑名单
	 * <p>
	 * 分页拉取所有黑名单。
	 * <p>
	 * API Doc : https://cloud.tencent.com/document/product/269/3722
	 *
	 * @param identifier   需要拉取该 Identifier 的黑名单
	 * @param offset       拉取的起始位置
	 * @param rows         拉去总数
	 * @param lastSequence 上一次拉黑名单时后台返回给客户端的 Seq，初次拉取时为0
	 * @return
	 */
	ListBlockAccountsResult listBlockAccounts(@NonNull String identifier, Integer offset, Integer rows, Integer lastSequence) throws TIMException;

	/**
	 * 校验黑名单
	 * <p>
	 * 支持批量校验黑名单。
	 * <p>
	 * API Doc : https://cloud.tencent.com/document/product/269/3725
	 *
	 * @param identifier
	 * @param accounts
	 * @param checkType
	 * @return
	 */
	CheckBlockAccountsResult checkBlockAccounts(@NonNull String identifier, @NonNull List<String> accounts, BlackCheckType checkType) throws TIMException;

	/**
	 * 添加分组
	 * <p>
	 * 添加分组，支持批量添加分组，并将指定好友加入到新增分组中。
	 * <p>
	 * API Doc : https://cloud.tencent.com/document/product/269/10107
	 *
	 * @param identifier
	 * @param groupNames
	 * @param friends
	 * @return
	 */
	AddGroupsResult addGroups(@NonNull String identifier, @NonNull List<String> groupNames, List<String> friends) throws TIMException;

	/**
	 * 删除分组
	 * <p>
	 * 删除指定分组。
	 * <p>
	 * API Doc : https://cloud.tencent.com/document/product/269/10108
	 *
	 * @param identifier
	 * @param groupNames
	 * @return
	 */
	DeleteGroupsResult deleteGroups(@NonNull String identifier, @NonNull List<String> groupNames) throws TIMException;


	/**
	 *  修改好友备注
	 */
	void remarkFriend(@NonNull String identifier,@NonNull String friendId,@NonNull String remark) throws TIMException;




}
