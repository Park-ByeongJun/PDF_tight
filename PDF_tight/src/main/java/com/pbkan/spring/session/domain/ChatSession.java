package com.pbkan.spring.session.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.pbkan.spring.member.domain.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="chat_session")
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@AllArgsConstructor(access=AccessLevel.PROTECTED)
@Getter
@Builder
public class ChatSession {

	@Id
	@Column(name="session_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sessionId;
	
	@ManyToOne
	@JoinColumn(name="mem_id")
	private Member member;
	
	@Column(name="session_time")
	@CreationTimestamp
	private LocalDateTime sessionTime;
}
