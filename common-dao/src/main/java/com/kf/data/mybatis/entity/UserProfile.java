package com.kf.data.mybatis.entity;

public class UserProfile {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column im_user_profile.id
	 * @mbggenerated  Wed Apr 04 16:23:42 CST 2018
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column im_user_profile.type
	 * @mbggenerated  Wed Apr 04 16:23:42 CST 2018
	 */
	private String type;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column im_user_profile.user_id
	 * @mbggenerated  Wed Apr 04 16:23:42 CST 2018
	 */
	private Integer userId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column im_user_profile.id
	 * @return  the value of im_user_profile.id
	 * @mbggenerated  Wed Apr 04 16:23:42 CST 2018
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column im_user_profile.id
	 * @param id  the value for im_user_profile.id
	 * @mbggenerated  Wed Apr 04 16:23:42 CST 2018
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column im_user_profile.type
	 * @return  the value of im_user_profile.type
	 * @mbggenerated  Wed Apr 04 16:23:42 CST 2018
	 */
	public String getType() {
		return type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column im_user_profile.type
	 * @param type  the value for im_user_profile.type
	 * @mbggenerated  Wed Apr 04 16:23:42 CST 2018
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column im_user_profile.user_id
	 * @return  the value of im_user_profile.user_id
	 * @mbggenerated  Wed Apr 04 16:23:42 CST 2018
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column im_user_profile.user_id
	 * @param userId  the value for im_user_profile.user_id
	 * @mbggenerated  Wed Apr 04 16:23:42 CST 2018
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}