package com.pbkan.spring.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pbkan.spring.member.domain.Member;
import com.pbkan.spring.member.domain.MemberDto;
import com.pbkan.spring.member.repository.MemberRepository;

@Service
public class MemberService {
	
	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
		this.memberRepository = memberRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public int createMember(MemberDto dto) {
		int result = -1;
		try {
			dto.setMem_pw(passwordEncoder.encode(dto.getMem_pw()));
			Member member = dto.toEntity();
			memberRepository.save(member);
			result = 1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
