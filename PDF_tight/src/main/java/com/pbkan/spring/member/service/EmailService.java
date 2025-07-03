package com.pbkan.spring.member.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.pbkan.spring.member.domain.EmailCert;
import com.pbkan.spring.member.repository.EmailRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;

@Service
public class EmailService {

	private final EmailRepository emailRepository;
	private final JavaMailSender javaMailSender;
	
	@Autowired
	public EmailService(EmailRepository emailRepository, JavaMailSender javaMailSender) {
		this.emailRepository = emailRepository;
		this.javaMailSender = javaMailSender;
	}
	
	@Transactional
	public Map<String,String> sendCertCode(String email1, String code){
		
		Map<String,String> result = new HashMap<>();
		
		
		
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, false ,"UTF-8");
			
			helper.setTo(email1);
			helper.setSubject("이메일 인증코드");
			helper.setText("<strong>"+ code + "</strong>" ,true);
			javaMailSender.send(message);
			
			EmailCert cert = EmailCert.builder()
			        .email(email1)
			        .cerCode(code)
			        .codeTime(LocalDateTime.now())
			        .passYn("N")
			        .attempCount(0)
			        .build();
			    emailRepository.save(cert);
			
			    result.put("res_code", "200");
			    result.put("res_msg", "인증 이메일이 전송되었습니다.");
			    
		} catch(MessagingException e) {
			e.printStackTrace();
			result.put("res_code", "500");
			result.put("res_msg", "이메일 전송에 실패했습니다.");
		}
		return result;
	}
}
