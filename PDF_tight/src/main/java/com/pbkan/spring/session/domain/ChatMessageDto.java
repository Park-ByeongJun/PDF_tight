package com.pbkan.spring.session.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ChatMessageDto {

	private int message_id;
	private int session_id;
	private String role;
	private String content;
	private LocalDateTime message_time;
	
	public ChatMessage toEntity() {
		return ChatMessage.builder()
				.messageId(message_id)
				.sessionId(session_id)
				.role(role)
				.content(content)
				.messageTime(message_time)
				.build();
	}
	
	public ChatMessageDto toDto(ChatMessage chatMessage) {
		return ChatMessageDto.builder()
				.message_id(chatMessage.getMessageId())
				.session_id(chatMessage.getSessionId())
				.role(chatMessage.getRole())
				.content(chatMessage.getContent())
				.message_time(chatMessage.getMessageTime())
				.build();
	}
}
