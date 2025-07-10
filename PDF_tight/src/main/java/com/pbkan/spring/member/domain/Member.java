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
@Table(name="member")
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@AllArgsConstructor(access=AccessLevel.PROTECTED)
@Getter
@Builder
public class Member {

	@Id
	@Column(name="mem_id")
	private String memId;
	
	@Column(name="mem_pw")
	private String memPw;
	
	@Column(name="mem_name")
	private String memName;
	
	@Column(name="mem_date")
	@CreationTimestamp
	private LocalDateTime memDate;
	
	@Column(name="mem_email")
	private String memEmail;
	
	@Column(name="role_mem")
	private String roleMem;
	
	@Column(name="mem_yn")
	private String memYn;
}
