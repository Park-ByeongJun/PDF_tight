package com.pbkan.spring.ai.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ai_query")
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@AllArgsConstructor(access=AccessLevel.PROTECTED)
@Getter
@Builder
public class AiQuery {

	@Id
	@Column(name="query_num")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int queryNum;
	
	@Column(name="pdf_num")
	private int pdfNum;
	
	@Column(name="mem_id")
	private String memId;
	
	@Column(name="re_question")
	private String reQuestion;
	
	@Column(name="re_response")
	private String reResponse;
	
	@Column(name="que_time")
	@CreationTimestamp
	private LocalDateTime queTime;
}
