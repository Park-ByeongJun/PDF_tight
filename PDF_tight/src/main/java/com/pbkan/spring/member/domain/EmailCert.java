package com.pbkan.spring.member.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@AllArgsConstructor(access=AccessLevel.PROTECTED)
@Getter
@Builder
public class EmailCert {

	@Id
	@Column(name="email")
	private String email;
	
	@Column(name="cer_code")
	private String cerCode;
	
	@Column(name="code_time")
	@CreationTimestamp
	private LocalDateTime codeTime;
	
	@Column(name="pass_yn")
	private String passYn;
	
	@Column(name="attemp_count")
	private int attempCount;
}
