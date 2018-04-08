package com.kf.data.service.crawler.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kf.data.mybatis.entity.UserGroup;
import com.kf.data.mybatis.entity.UserGroupExample;
import com.kf.data.mybatis.mapper.UserGroupMapper;
import com.kf.data.service.crawler.UserGroupService;

/**
 * @Title: UserGroupServiceImpl.java
 * @Package com.kf.data.service.crawler.impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: liangyt
 * @date: 2018年4月8日 下午2:32:22
 * @version V1.0
 */
@Service
public class UserGroupServiceImpl implements UserGroupService {

	@Autowired
	UserGroupMapper userGroupMapper;

	@Override
	public List<UserGroup> readUserGroupByUserid(int userid) {
		UserGroupExample example = new UserGroupExample();
		example.or().andCreateIdEqualTo(userid);
		return userGroupMapper.selectByExample(example);
	}

}
