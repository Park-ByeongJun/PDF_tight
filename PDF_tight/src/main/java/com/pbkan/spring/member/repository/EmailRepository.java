package com.pbkan.spring.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pbkan.spring.member.domain.EmailCert;

public interface EmailRepository extends JpaRepository<EmailCert, String>{

}
