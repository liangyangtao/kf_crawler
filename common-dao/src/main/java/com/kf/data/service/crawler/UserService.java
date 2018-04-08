package com.kf.data.service.crawler;

import com.kf.data.mybatis.entity.User;

/**
 * @Title: UserService.java
 * @Package com.kf.data.service.crawler
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: liangyt
 * @date: 2018年4月4日 上午10:19:34
 * @version V1.0
 */
public interface UserService {

	/**
	 * @param ssoId
	 * @return
	 */
	User findBySso(String ssoId);

	User findById(int userId);

}
