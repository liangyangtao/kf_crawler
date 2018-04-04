package com.kf.data.service.crawler;

import java.util.List;

import com.kf.data.mybatis.entity.UserProfile;

/**
 * @Title: UserProfileService.java
 * @Package com.kf.data.service.crawler
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: liangyt
 * @date: 2018年4月4日 上午10:35:53
 * @version V1.0
 */
public interface UserProfileService {

	/**
	 * @param id
	 * @return
	 */
	public List<UserProfile> findByUserid(Integer userid);

}
