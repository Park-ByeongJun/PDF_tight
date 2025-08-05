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
public class ChatSessionDto {

	private int session_id;
	private String mem_id;
	private LocalDateTime session_time;
	
	public ChatSession toEntity() {
		return ChatSession.builder()
		.sessionId(session_id)
		.memId(mem_id)
		.sessionTime(session_time)
		.build();
	}
	
	public ChatSessionDto toDto(ChatSession chatSession) {
		return ChatSessionDto.builder()
				.session_id(chatSession.getSessionId())
				.mem_id(chatSession.getMemId())
				.session_time(chatSession.getSessionTime())
				.build();
	}
}
