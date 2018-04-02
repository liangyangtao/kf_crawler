package com.kf.data.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;

/**
 * @Title: ChatController.java
 * @Package com.kf.data.controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: liangyt
 * @date: 2018年3月29日 下午5:24:31
 * @version V1.0
 */
@Controller
public class ChatController extends CommonController {

	private SimpMessagingTemplate template;

	@MessageMapping("/user/{userId}")
	public void userMessage(String message, @DestinationVariable String userId,
			StompHeaderAccessor headerAccessor) {
//		SysUser user = (SysUser) headerAccessor.getUser();
//		String sessionId = headerAccessor.getSessionId();
		String dest = "/topic/" + userId + "/" + "greetings";
		this.template.convertAndSendToUser(userId, dest, message);
	}

	@MessageMapping("/room/{roomId}")
	public void roomMessage(String message, @DestinationVariable String roomId) {
		String dest = "/topic/" + roomId + "/" + "greetings";
		this.template.convertAndSendToUser(roomId,dest, message);
	}

}
