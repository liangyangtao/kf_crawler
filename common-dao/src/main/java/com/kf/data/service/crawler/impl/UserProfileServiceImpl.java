package com.kf.data.service.crawler.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kf.data.mybatis.entity.UserProfile;
import com.kf.data.mybatis.entity.UserProfileExample;
import com.kf.data.mybatis.mapper.UserProfileMapper;
import com.kf.data.service.crawler.UserProfileService;

/**
 * @Title: UserProfileServiceImpl.java
 * @Package com.kf.data.service.crawler.impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: liangyt
 * @date: 2018年4月4日 上午10:48:27
 * @version V1.0
 */
@Service
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	UserProfileMapper userProfileMapper;

	@Override
	public List<UserProfile> findByUserid(Integer userId) {
		UserProfileExample example = new UserProfileExample();
		example.or().andUserIdEqualTo(userId);
		return userProfileMapper.selectByExample(example);
	}

}
