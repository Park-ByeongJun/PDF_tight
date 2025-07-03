package com.pbkan.spring.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pbkan.spring.member.domain.MemberDto;
import com.pbkan.spring.member.service.EmailService;
import com.pbkan.spring.member.service.MemberService;

@Controller
public class MemberApiController {

	private final EmailService emailService;
	private final MemberService memberService;
	
	@Autowired
	public MemberApiController(EmailService emailService, MemberService memberService) {
		this.emailService = emailService;
		this.memberService = memberService;
	}
	
	// 이메일 인증코드 발송
	@ResponseBody
	@PostMapping("/CertEmailSend")
	public Map<String, String> certEmailSend(@RequestBody Map<String,String> request){
		String email = request.get("email");
		
		if(email == null || email.isBlank()) {
			return Map.of("res_code", "400", "res_msg", "이메일이 누락되었습니다.");
		}
		
		String code = String.valueOf((int)(Math.random() * 900000) + 100000 );

		return emailService.sendCertCode(email, code);
	}
	
	@PostMapping("/join")
	@ResponseBody
	public Map<String, String> joinMember(@RequestBody MemberDto dto){
		Map<String,String> resultMap = new HashMap<String,String>();
		resultMap.put("res_code", "404");
		resultMap.put("res_msg", "회원가입 중 오류가 발생했습니다.");
		
		if(memberService.createMember(dto) > 0 ) {
			resultMap.put("res_code", "200");
			resultMap.put("res_msg", "성공적으로 회원가입되었습니다.");
		};
		return resultMap;
	}
}
