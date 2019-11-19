package com.sevlow.sdk.tim.api.impl;

import com.sevlow.sdk.tim.api.TIMGroupService;
import com.sevlow.sdk.tim.api.TIMRelationService;
import com.sevlow.sdk.tim.api.TIMService;
import com.sevlow.sdk.tim.api.test.TestModule;
import com.sevlow.sdk.tim.bean.*;
import com.sevlow.sdk.tim.bean.group.*;
import com.sevlow.sdk.tim.bean.profile.AdminForbidTypeEnum;
import com.sevlow.sdk.tim.bean.profile.AllowTypeEnum;
import com.sevlow.sdk.tim.bean.profile.GenderEnum;
import com.sevlow.sdk.tim.bean.profile.TIMProfile;
import com.sevlow.sdk.tim.common.error.TIMException;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.util.*;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.api.impl
 * @date 2019-05-27 23:39
 * @Description:
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
		AllGroupResult allGroup = groupService.pageGroup(0,10,GroupInfo.Type.Public);
		Assert.assertNotNull(allGroup);
	}


	@Test
	public void testCreateGroup() throws TIMException {
		GroupInfo groupInfo = new GroupInfo();
		groupInfo.setGroupId("11231");
		groupInfo.setType(GroupInfo.Type.Public);
		groupInfo.setApplyJoinOption(GroupInfo.ApplyJoinOption.FreeAccess);
		groupInfo.setName("147");
		System.out.println(groupInfo.toString());
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
		System.out.println(groupInfo.toString());
		groupService.updateGroup(groupInfo);
	}


	@Test
	public void testJoinGroup() throws TIMException {
		List<String> list = Arrays.asList("74940051523371008","74897564679274496");
		AddGroupResult addGroupResult = groupService.addGroupMember("11231",list, SilenceEnum.QUIET);
		System.out.println("11111");
	}


	@Test
	public void testDeleteGroupMember() throws TIMException {
		List<String> list = Arrays.asList("74897564679274496","74897564679274496");
		groupService.deleteGroupMember("11231",list, SilenceEnum.QUIET,null);

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
		groupService.forbidSendMsg("11231",Arrays.asList("74940051523371008"),100);
	}


	@Test
	public void testGetShuttedMember() throws TIMException {
		ShuttedMember member = groupService.getShuttedMember("11231");
		Assert.assertNotNull(member);
	}


	@Test
	public void testSendGroupMsg() throws TIMException {
		groupService.sendGroupMsg("11231","74940051523371008",true,"你好");
	}


	@Test
	public void testSendGroupSystemNotification() throws TIMException {
		groupService.sendGroupSystemNotification("11231",null,"你好");
	}


	@Test
	public void testImportGroupMember() throws TIMException {
		List<ImportMember> members = new ArrayList<>();
		ImportMember member1 = new ImportMember("74897564679274496");
		ImportMember member2 = new ImportMember("74940051523371008");
		members.add(member1);
		members.add(member2);
		AddGroupResult result = groupService.importGroupMember("11231", members);
		Assert.assertNotNull(result);
	}
}
