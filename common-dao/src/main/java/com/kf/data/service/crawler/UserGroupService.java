package com.kf.data.service.crawler;

import java.util.List;

import com.kf.data.mybatis.entity.UserGroup;

/**  
 * @Title:  UserGroupService.java   
 * @Package com.kf.data.service.crawler   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: liangyt    
 * @date:   2018年4月8日 下午2:27:28   
 * @version V1.0 
 */
public interface UserGroupService {
	
	public List<UserGroup> readUserGroupByUserid(int userid);

}
