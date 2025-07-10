package com.pbkan.spring.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pbkan.spring.member.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String>{

	Member findBymemId(String mem_id);
}
