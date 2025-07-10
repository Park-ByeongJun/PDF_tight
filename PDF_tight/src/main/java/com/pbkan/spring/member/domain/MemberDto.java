package com.pbkan.spring.member.domain;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

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
public class MemberDto {

	private String mem_id;
	private String mem_pw;
	private String mem_name;
	private LocalDateTime mem_date;
	private String mem_email;
	private String role_mem;
	private String mem_yn;
	
	private List<GrantedAuthority> authorities;
	
	public Member toEntity() {
		return Member.builder()
				.memId(mem_id)
				.memPw(mem_pw)
				.memName(mem_name)
				.memDate(mem_date)
				.memEmail(mem_email)
				.roleMem(role_mem)
				.memYn(mem_yn)
				.build();
	}
	
	public MemberDto toDto(Member member) {
		return MemberDto.builder()
				.mem_id(member.getMemId())
				.mem_pw(member.getMemPw())
				.mem_name(member.getMemName())
				.mem_date(member.getMemDate())
				.mem_email(member.getMemEmail())
				.role_mem(member.getRoleMem())
				.mem_yn(member.getMemYn())
				.build();
	}
}
