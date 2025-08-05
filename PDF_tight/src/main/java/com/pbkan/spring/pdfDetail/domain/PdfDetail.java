 package com.pbkan.spring.pdfDetail.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.pbkan.spring.member.domain.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="pdf_detail")
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@AllArgsConstructor(access=AccessLevel.PROTECTED)
@Getter
@Builder
public class PdfDetail {

	@Id
	@Column(name="pdf_num")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long pdfNum;
	
	@ManyToOne
	@JoinColumn(name="mem_id")
	private Member member;
	
	@Column(name="pdf_title")
	private String pdfTitle;
	
	@Column(name="ori_filename")
	private String oriFilename;
	
	@Column(name="chn_filename")
	private String chnFilename;
	
	@Column(name="up_time")
	@CreationTimestamp
	private LocalDateTime upTime;
	
	@Lob
	@Column(name="pdf_text", columnDefinition = "text")
	private String pdfText;
}
