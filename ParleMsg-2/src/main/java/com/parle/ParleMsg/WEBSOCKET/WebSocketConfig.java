package com.parle.ParleMsg.WEBSOCKET;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;


@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer{
	
	private final static String CHAT_ENDPOINT = "/chat";

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
	registry.addHandler(getChatWebSocketHandler(), CHAT_ENDPOINT)
	.setAllowedOriginPatterns("*");
	}
	
	
	@Bean 
	public ChatWebSocketHandler getChatWebSocketHandler() {
		return new ChatWebSocketHandler();
	}
	

}
