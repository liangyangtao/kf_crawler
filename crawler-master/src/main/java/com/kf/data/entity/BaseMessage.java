package com.kf.data.entity;

import java.util.Date;

/****
 * 
 * @Title: BaseMessage.java
 * @Package com.kf.data.entity
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: liangyt
 * @date: 2018年4月2日 下午4:13:55
 * @version V1.0
 */
public class BaseMessage {

	// 消息类型
	private String type;

	// 消息内容
	private String content;

	// 发送者
	private String sender;

	// 接受者 类型
	private String toType;

	// 接受者
	private String receiver;

	// 发送时间
	private Date date;

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
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
	 * @return the sender
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * @param sender
	 *            the sender to set
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}

	/**
	 * @return the toType
	 */
	public String getToType() {
		return toType;
	}

	/**
	 * @param toType
	 *            the toType to set
	 */
	public void setToType(String toType) {
		this.toType = toType;
	}

	/**
	 * @return the receiver
	 */
	public String getReceiver() {
		return receiver;
	}

	/**
	 * @param receiver
	 *            the receiver to set
	 */
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

}
