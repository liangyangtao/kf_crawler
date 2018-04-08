package com.kf.data.service.crawler;

import java.util.List;

import com.kf.data.mybatis.entity.UserFriend;

/**
 * @Title: UserFriendService.java
 * @Package com.kf.data.service.crawler
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: liangyt
 * @date: 2018年4月4日 下午4:24:51
 * @version V1.0
 */
public interface UserFriendService {

	public List<UserFriend> readFriendByUserid(int userId);
	
	public List<UserFriend> readFriendByUseridAndGourpId(int userId,int groupId);
	
	
}
