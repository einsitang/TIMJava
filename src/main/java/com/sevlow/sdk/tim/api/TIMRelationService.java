package com.sevlow.sdk.tim.api;

import com.sevlow.sdk.tim.bean.*;
import com.sevlow.sdk.tim.bean.account.TIMFriend;
import com.sevlow.sdk.tim.bean.relation.ListFriendsDirectivityResult;
import com.sevlow.sdk.tim.bean.relation.ListFriendsResult;
import com.sevlow.sdk.tim.common.error.TIMException;
import lombok.NonNull;

import java.util.List;

/**
 * @author Element
 *
 * 关系链管理
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

    public static enum BlackCheckType {

        BlackCheckResult_Type_Both("BlackCheckResult_Type_Both"),
        BlackCheckResult_Type_Singal("BlackCheckResult_Type_Singal");

        private String typeInfo;

        private BlackCheckType(String typeInfo) {
            this.typeInfo = typeInfo;
        }

    }

    /**
     * 添加好友
     * <p>
     * 添加好友，支持批量添加好友。
     * </p>
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
     * </p>
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
     * </p>
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
     * </p>
     * API Doc : https://cloud.tencent.com/document/product/269/8301
     *
     * @param identifier 需要导入好友的 <b>Identifier</b>
     * @param friends    被添加的 <b>TIMFriend</b> 集合
     * @return
     */
    ImportFriendsResult importFriends(@NonNull String identifier, @NonNull List<TIMFriend> friends) throws TIMException;

    /**
     * 更新好友
     * <p>
     * 支持批量更新同一用户的多个好友的关系链数据。
     * 更新一个用户多个好友时，建议采用批量方式，避免并发写导致的写冲突。
     * </p>
     * API Doc : https://cloud.tencent.com/document/product/269/12525
     *
     * @param identifier
     * @param friends
     * @param snsItems
     * @return
     * @throws TIMException
     */
    UpdateFriendsResult updateFriends(@NonNull String identifier, @NonNull List<String> friends, List<SnsItem> snsItems) throws TIMException;

    /**
     * 删除好友
     * <p>
     * 删除好友，支持单向删除好友和双向删除好友。
     * </p>
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
     * </p>
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
     *
     * <p>
     * 分页拉取全量好友数据。
     * 不支持资料数据的拉取。
     * 不需要指定请求拉取的字段，默认返回全量的标配好友数据和自定义好友数据。
     * </p>
     * API Doc : https://cloud.tencent.com/document/product/269/1647
     *
     * @param account          指定要拉取好友数据的用户的 UserID
     * @param startIndex       分页的起始位置
     * @param standardSequence 上次拉好友数据时返回的 StandardSequence，如果 StandardSequence 字段的值与后台一致，后台不会返回标配好友数据
     * @param customSequence   上次拉好友数据时返回的 CustomSequence，如果 CustomSequence 字段的值与后台一致，后台不会返回自定义好友数据
     * @return ListFriendsResult
     * @throws TIMException
     */
    ListFriendsResult listFriends(@NonNull String account, @NonNull Integer startIndex, Integer standardSequence, Integer customSequence) throws TIMException;

    /**
     * 拉取好友
     *
     * @param account    指定要拉取好友数据的用户的 UserID
     * @param startIndex 分页的起始位置
     * @return
     * @throws TIMException
     * @see com.sevlow.sdk.tim.api.TIMRelationService#listFriends
     */
    ListFriendsResult listFriends(@NonNull String account, @NonNull Integer startIndex) throws TIMException;

    /**
     * 拉取指定好友
     * <p>
     * 支持拉取指定好友的好友数据和资料数据。
     * 建议每次拉取的好友数不超过100，避免因数据量太大导致回包失败。
     * </p>
     * API Doc : https://cloud.tencent.com/document/product/269/8609
     *
     * @param account           指定要拉取好友数据的用户的 UserID
     * @param friends           好友的 UserID 列表
     * @param profiles          需要拉取的标配资料字段 @link com.sevlow.sdk.tim.bean.profile.TIMProfile
     * @param customProfiles    需要拉取的自定义资料字段 ,无需输入Tag_Profile_Custom_ 自动补充
     * @param snsProfiles       需要拉取的标配好友字段字段 @link com.sevlow.sdk.tim.bean.relation.TIMFriendProfile
     * @param customSnsProfiles 需要拉取的自定义好友字段 ,无需输入 Tag_SNS_Custom_ 自动补充
     * @return ListFriendsDirectivityResult
     * @throws TIMException
     *
     */
    ListFriendsDirectivityResult listFriendsDirectivity(@NonNull String account, @NonNull List<String> friends,
                                                        List<String> profiles, List<String> customProfiles,
                                                        List<String> snsProfiles, List<String> customSnsProfiles) throws TIMException;

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
     * 修改好友备注
     */
    void remarkFriend(@NonNull String identifier, @NonNull String friendId, @NonNull String remark) throws TIMException;


}
