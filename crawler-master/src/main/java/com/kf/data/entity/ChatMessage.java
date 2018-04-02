package com.kf.data.entity;

/**
 * @Title: ChatMessage.java
 * @Package com.kf.data.entity
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: liangyt
 * @date: 2018年4月2日 下午4:11:47
 * @version V1.0
 */
public class ChatMessage {
	private String username;

	private String nickname;

	private String avatar;

	private String content;

	private String sendTime;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname
	 *            the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * @return the avatar
	 */
	public String getAvatar() {
		return avatar;
	}

	/**
	 * @param avatar
	 *            the avatar to set
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the sendTime
	 */
	public String getSendTime() {
		return sendTime;
	}

	/**
	 * @param sendTime
	 *            the sendTime to set
	 */
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

}
