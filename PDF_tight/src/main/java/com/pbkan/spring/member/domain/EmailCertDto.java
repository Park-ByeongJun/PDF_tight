package com.pbkan.spring.member.domain;

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
public class EmailCertDto {

	private String email;
	private String cer_code;
	private LocalDateTime code_time;
	private String pass_yn;
	private int attemp_count;
	
	public EmailCert toEntity() {
		return EmailCert.builder()
				.email(email)
				.cerCode(cer_code)
				.codeTime(code_time)
				.passYn(pass_yn)
				.attempCount(attemp_count)
				.build();
	}
	
	public EmailCertDto toDto(EmailCert emailCert) {
		return EmailCertDto.builder()
				.email(emailCert.getEmail())
				.cer_code(emailCert.getCerCode())
				.code_time(emailCert.getCodeTime())
				.pass_yn(emailCert.getPassYn())
				.attemp_count(emailCert.getAttempCount())
				.build();
	}
}
