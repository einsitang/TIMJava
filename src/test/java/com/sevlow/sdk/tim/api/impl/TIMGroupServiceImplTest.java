package com.sevlow.sdk.tim.api.impl;

import com.sevlow.sdk.tim.api.TIMGroupService;
import com.sevlow.sdk.tim.api.TIMService;
import com.sevlow.sdk.tim.api.test.TestModule;
import com.sevlow.sdk.tim.bean.chat.MsgCustomContent;
import com.sevlow.sdk.tim.bean.group.*;
import com.sevlow.sdk.tim.common.error.TIMException;
import com.sevlow.sdk.tim.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.util.*;

/**
 * 群组服务测试用例
 *
 * @author element
 */
@Slf4j
@Guice(modules = {TestModule.class})
public class TIMGroupServiceImplTest {

    @Inject
    private TIMService timService;

    private TIMGroupService groupService;

    @BeforeTest
    public void before() {
        this.groupService = timService.getGroupService();
    }


    @Test
    public void testGetAllGroup() throws TIMException {
        AllGroupResult allGroup = groupService.getAllGroup(GroupInfo.Type.Public);
        Assert.assertNotNull(allGroup);
    }

    @Test
    public void testPageAllGroup() throws TIMException {
        AllGroupResult allGroup = groupService.pageGroup(0, 10, GroupInfo.Type.Public);
        Assert.assertNotNull(allGroup);
    }


    @Test
    public void testCreateGroup() throws TIMException {
        GroupInfo groupInfo = new GroupInfo();
        groupInfo.setGroupId("119384433261281280");
        groupInfo.setType(GroupInfo.Type.Public);
        groupInfo.setApplyJoinOption(GroupInfo.ApplyJoinOption.FreeAccess);
        groupInfo.setName("147");
        log.debug(groupInfo.toString());
        CreateGroupResult group = groupService.createGroup(groupInfo);
        Assert.assertNotNull(group);
    }

    @Test
    public void testUpdateGroup() throws TIMException {
        GroupInfo groupInfo = new GroupInfo();
        groupInfo.setGroupId("@TGS#3XWYJA6FQ");
        groupInfo.setType(GroupInfo.Type.Public);
        groupInfo.setApplyJoinOption(GroupInfo.ApplyJoinOption.FreeAccess);
        groupInfo.setName("147");
        log.debug(groupInfo.toString());
        groupService.updateGroup(groupInfo);
    }


    @Test
    public void testJoinGroup() throws TIMException {
        List<String> list = Arrays.asList("69887072709640192", "74897564679274496");
        AddGroupResult addGroupResult = groupService.addGroupMember("119384433261281280", list, SilenceEnum.QUIET);
        Assert.assertTrue(addGroupResult.getMemberList().size() > 0);
    }


    @Test
    public void testDeleteGroupMember() throws TIMException {
        List<String> list = Arrays.asList("74897564679274496", "74897564679274496");
        groupService.deleteGroupMember("11231", list, SilenceEnum.QUIET, null);

    }


    @Test
    public void testModifyGroupMemberInfo() throws TIMException {
        GroupMemberInfo info = new GroupMemberInfo();
        info.setGroupId("@TGS#3XWYJA6FQ");
        info.setMemberAccount("74940051523371008");
        info.setRole(GroupMemberInfo.Role.Admin);
        info.setNameCard("你好");
        info.setMsgFlag(GroupMemberInfo.MsgFlag.AcceptNotNotify);
        groupService.modifyGroupMemberInfo(info);

    }


    @Test
    public void testDestroyGroup() throws TIMException {
        groupService.destroyGroup("@TGS#3XWYJA6FQ");
    }

    @Test
    public void testForbidSendMsg() throws TIMException {
        groupService.forbidSendMsg("11231", Arrays.asList("74940051523371008"), 100);
    }


    @Test
    public void testGetShuttedMember() throws TIMException {
        ShuttedMemberResult member = groupService.getShuttedMember("11231");
        Assert.assertNotNull(member);
    }


    @Test
    public void testSendGroupMsg() throws TIMException {
        groupService.sendGroupMsg("119384433261281280", null, true, "你好11");
    }


    @Test
    public void testSendGroupSystemNotification() throws TIMException {
        groupService.sendGroupSystemNotification("119384433261281280", null, "你好111");
    }

    @Test
    public void testSentGroupCustomMsg() throws TIMException {
        Map map = new HashMap();
        map.put("action", "9");
        map.put("type", "8");
        map.put("name", "你好");

        MsgCustomContent msg = new MsgCustomContent();
        msg.setSound("dingdong.aiff");
        msg.setExt("您有一条系统消息");
        msg.setDesc("您有一条系统消息");

        msg.setData(JsonUtils.toJson(map));
        groupService.sentGroupCustomMsg("119384433261281280", null, null, msg);
    }


    @Test
    public void testImportGroupMember() throws TIMException {
        // 117954688241893376   72779248246456320  69887072709640192  17612021831
        List<ImportMember> members = new ArrayList<>();
        ImportMember member1 = new ImportMember("72356624357916672");
        ImportMember member2 = new ImportMember("69887072709640192");
        ImportMember member3 = new ImportMember("17612021831");
        members.add(member1);
        members.add(member2);
        members.add(member3);
        AddGroupResult result = groupService.importGroupMember("117954688241893376", members);
        Assert.assertNotNull(result);
    }
}
