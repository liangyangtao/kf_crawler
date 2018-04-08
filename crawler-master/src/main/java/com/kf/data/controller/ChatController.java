package com.kf.data.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Title: ChatController.java
 * @Package com.kf.data.controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: liangyt
 * @date: 2018年3月29日 下午5:24:31
 * @version V1.0
 */
@Controller
@RequestMapping("/chat")
public class ChatController extends CommonController {

	private SimpMessagingTemplate template;

	@MessageMapping("/userChat/{userId}")
	public void userChatMessage(String message, @DestinationVariable String userId,
			StompHeaderAccessor headerAccessor) {
//		SysUser user = (SysUser) headerAccessor.getUser();
//		String sessionId = headerAccessor.getSessionId();
		
		String dest = "/userChat/" + userId + "/greetings";
		this.template.convertAndSendToUser(userId, dest, message);
	}

	@MessageMapping("/roomChat/{roomId}")
	public void roomChatMessage(String message, @DestinationVariable String roomId) {
		String dest = "/topic/" + roomId + "/greetings";
		this.template.convertAndSendToUser(roomId,dest, message);
	}

}
