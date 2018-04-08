package com.kf.data.service.crawler.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kf.data.mybatis.entity.UserFriend;
import com.kf.data.mybatis.entity.UserFriendExample;
import com.kf.data.mybatis.mapper.UserFriendMapper;
import com.kf.data.service.crawler.UserFriendService;

/**
 * @Title: UserFriendServiceImpl.java
 * @Package com.kf.data.service.crawler.impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: liangyt
 * @date: 2018年4月8日 下午2:12:16
 * @version V1.0
 */
@Service
public class UserFriendServiceImpl implements UserFriendService {

	@Autowired
	UserFriendMapper userFriendMapper;

	@Override
	public List<UserFriend> readFriendByUserid(int userId) {
		return readFriendByUseridAndGourpId(userId, 0);
	}

	@Override
	public List<UserFriend> readFriendByUseridAndGourpId(int userId, int groupId) {
		UserFriendExample example = new UserFriendExample();
		example.or().andUserIdEqualTo(userId).andGroupIdEqualTo(groupId);
		return userFriendMapper.selectByExample(example);
	}

}
