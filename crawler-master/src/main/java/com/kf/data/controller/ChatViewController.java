package com.kf.data.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kf.data.entity.view.UserFriendView;
import com.kf.data.entity.view.UserGroupView;
import com.kf.data.entity.view.UserView;
import com.kf.data.mybatis.entity.User;
import com.kf.data.mybatis.entity.UserFriend;
import com.kf.data.mybatis.entity.UserGroup;
import com.kf.data.service.crawler.UserFriendService;
import com.kf.data.service.crawler.UserGroupService;
import com.kf.data.service.crawler.UserService;

/**
 * @Title: ChatViewController.java
 * @Package com.kf.data.controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: liangyt
 * @date: 2018年4月8日 下午1:49:35
 * @version V1.0
 */
@Controller
@RequestMapping("/chat")
public class ChatViewController extends CommonController {

	@Autowired
	UserService userService;

	@Autowired
	UserFriendService userFriendService;

	@Autowired
	UserGroupService userGroupService;

	@RequestMapping(value = "/viewInit", method = { RequestMethod.GET, RequestMethod.POST })
	public void viewInit(ModelMap modelMap, String ssoId, HttpServletResponse response) {
		try {

			Map<String, Object> datamap = new HashMap<>();
			/***
			 * 用户
			 */
			User user = userService.findBySso(ssoId);
			if (user == null) {
				return;
			}
			UserView userView = new UserView();
			userView.setAvatar(user.getAvatar());
			userView.setId(user.getId() + "");
			userView.setSign(user.getSign());
			userView.setStatus("online");
			userView.setUsername(user.getSsoId());
			datamap.put("mine", userView);
			/****
			 * 好友分组
			 */
			List<UserGroup> groups = userGroupService.readUserGroupByUserid(user.getId());
			UserGroup defaultUserGroup = new UserGroup();
			defaultUserGroup.setAvatar("");
			defaultUserGroup.setGroupName("我的好友");
			defaultUserGroup.setGroupStatus(0);
			defaultUserGroup.setId(0);
			groups.add(defaultUserGroup);
			List<UserFriendView> userfriendViews = new ArrayList<>();

			List<UserGroupView> userGroupViews = new ArrayList<>();

			for (UserGroup userGroup : groups) {
				UserGroupView userGroupView = new UserGroupView();
				userGroupView.setAvatar(userGroup.getAvatar());
				userGroupView.setGroupname(userGroup.getGroupName());
				userGroupView.setId(userGroup.getId() + "");
				userGroupViews.add(userGroupView);
				UserFriendView userFriendView = new UserFriendView();
				List<UserFriend> userFriends = userFriendService.readFriendByUseridAndGourpId(user.getId(),
						userGroup.getId());
				userFriendView.setGroupname(userGroup.getGroupName());
				userFriendView.setId(userGroup.getId() + "");
				List<UserView> list = new ArrayList<>();
				for (UserFriend userFriend : userFriends) {
					Integer friendId = userFriend.getFriendId();
					User friend = userService.findById(friendId);
					UserView viewFriend = new UserView();
					viewFriend.setAvatar(friend.getAvatar());
					viewFriend.setId(friend.getId() + "");
					viewFriend.setSign("");
					if (friend.getUserStatus().equals(2)) {
						viewFriend.setStatus("online");
					}
					viewFriend.setUsername(friend.getSsoId());
					list.add(viewFriend);
				}
				userFriendView.setList(list);
				userfriendViews.add(userFriendView);
			}

			/****
			 * 组下的朋友
			 */

			datamap.put("friend", userfriendViews);
			datamap.put("group", userGroupViews);
			Map<String, Object> result = new HashMap<>();
			result.put("code", "0");
			result.put("msg", "");
			result.put("data", datamap);
			responseJson(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
}
