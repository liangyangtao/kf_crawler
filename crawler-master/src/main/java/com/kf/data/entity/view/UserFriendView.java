package com.kf.data.entity.view;

import java.util.List;

/**
 * @Title: UserFriendView.java
 * @Package com.kf.data.entity.view
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: liangyt
 * @date: 2018年4月8日 下午2:49:32
 * @version V1.0
 */
public class UserFriendView {

	private String groupname;
	private String id;
	private List<UserView> list;

	/**
	 * @return the groupname
	 */
	public String getGroupname() {
		return groupname;
	}

	/**
	 * @param groupname
	 *            the groupname to set
	 */
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the list
	 */
	public List<UserView> getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(List<UserView> list) {
		this.list = list;
	}

}
