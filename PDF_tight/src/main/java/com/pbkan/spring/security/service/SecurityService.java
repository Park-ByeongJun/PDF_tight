package com.pbkan.spring.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pbkan.spring.member.domain.Member;
import com.pbkan.spring.member.domain.MemberDto;
import com.pbkan.spring.member.repository.MemberRepository;
import com.pbkan.spring.security.vo.SecurityUser;

@Service
public class SecurityService implements UserDetailsService{

	private final MemberRepository memberRepository;
	
	@Autowired
	public SecurityService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Member member = memberRepository.findBymemId(username);
		
		if(member != null) {
			MemberDto dto = new MemberDto().toDto(member);
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority(member.getRoleMem()));
			dto.setAuthorities(authorities);
			
			return new SecurityUser(dto);
		}else {
			throw new UsernameNotFoundException(username);
		}
	}
}
