package com.kf.data.service.crawler.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kf.data.mybatis.entity.User;
import com.kf.data.mybatis.entity.UserExample;
import com.kf.data.mybatis.mapper.UserMapper;
import com.kf.data.service.crawler.UserService;

/**
 * @Title: UserServiceImpl.java
 * @Package com.kf.data.service.crawler.impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: liangyt
 * @date: 2018年4月4日 上午10:30:02
 * @version V1.0
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;

	@Override
	public User findBySso(String ssoId) {
		UserExample example = new UserExample();
		example.or().andSsoIdEqualTo(ssoId);
		List<User> users = userMapper.selectByExample(example);
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

	@Override
	public User findById(int userId) {
		UserExample example = new UserExample();
		example.or().andIdEqualTo(userId);
		List<User> users = userMapper.selectByExample(example);
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

}
