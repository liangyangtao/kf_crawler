//package com.kf.data.config;
//
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.messaging.simp.config.ChannelRegistration;
//import org.springframework.messaging.simp.config.MessageBrokerRegistry;
//import org.springframework.web.socket.CloseStatus;
//import org.springframework.web.socket.WebSocketHandler;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
//import org.springframework.web.socket.config.annotation.EnableWebSocket;
//import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
//import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
//import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;
//import org.springframework.web.socket.handler.WebSocketHandlerDecorator;
//import org.springframework.web.socket.handler.WebSocketHandlerDecoratorFactory;
//
///****
// * 
// * @Title: WebSocketConfig.java
// * @Package com.kf.data.configuration
// * @Description: stomp 初始化
// * @author liangyt
// * @date 2018年2月1日 下午2:37:45
// * @version V1.0
// */
//@SpringBootApplication
//@EnableWebSocket
//@EnableWebSocketMessageBroker
//public class WebSocketConfiguration extends AbstractWebSocketMessageBrokerConfigurer {
//
//	@Override
//	public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
//		stompEndpointRegistry.addEndpoint("/app").setAllowedOrigins("*").addInterceptors().withSockJS();
//	}
//
//	@Override
//	public void configureMessageBroker(MessageBrokerRegistry registry) {
//		registry.setApplicationDestinationPrefixes("/app");
//		registry.enableSimpleBroker("/topic", "/user");
//		registry.setUserDestinationPrefix("/user/");
//		// registry.enableStompBrokerRelay("/topic").setRelayHost("127.0.0.1").setRelayPort(61613)
//		// .setSystemHeartbeatReceiveInterval(2000).setSystemHeartbeatSendInterval(2000);
//
//	}
//
//	@Override
//	public void configureClientOutboundChannel(ChannelRegistration registration) {
//		registration.taskExecutor().corePoolSize(4).maxPoolSize(8);
//	}
//
////	@Override
////	public void configureWebSocketTransport(final WebSocketTransportRegistration registration) {
////		registration.addDecoratorFactory(new WebSocketHandlerDecoratorFactory() {
////			@Override
////			public WebSocketHandler decorate(final WebSocketHandler handler) {
////				return new WebSocketHandlerDecorator(handler) {
////					@Override
////					public void afterConnectionEstablished(final WebSocketSession session) throws Exception {
////						String username = session.getPrincipal().getName();
////						
////						super.afterConnectionEstablished(session);
////					}
////
////					@Override
////					public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus)
////							throws Exception {
////						String username = session.getPrincipal().getName();
////						
////						super.afterConnectionClosed(session, closeStatus);
////					}
////				};
////			}
////		});
////		super.configureWebSocketTransport(registration);
////	}
//
//}