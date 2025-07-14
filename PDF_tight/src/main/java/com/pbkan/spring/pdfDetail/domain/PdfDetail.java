 package com.pbkan.spring.pdfDetail.domain;

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
	
	@Column(name="mem_id")
	private String memId;
	
	@Column(name="pdf_title")
	private String pdfTitle;
	
	@Column(name="ori_filename")
	private String oriFilename;
	
	@Column(name="chn_filename")
	private String chnFilename;
	
	@Column(name="up_time")
	@CreationTimestamp
	private LocalDateTime upTime;
	
	@Column(name="pdf_text")
	private String pdfText;
}
