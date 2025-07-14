package com.pbkan.spring.pdfDetail.domain;

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
public class PdfDetailDto {

	private long pdf_num;
	private String mem_id;
	private String pdf_title;
	private String ori_filename;
	private String chn_filename;
	private LocalDateTime up_time;
	private String pdf_text;
	
	public PdfDetail toEntity() {
		return PdfDetail.builder()
				.pdfNum(pdf_num)
				.memId(mem_id)
				.pdfTitle(pdf_title)
				.oriFilename(ori_filename)
				.chnFilename(chn_filename)
				.upTime(up_time)
				.pdfText(pdf_text)
				.build();
	}
	
	public PdfDetailDto toDto(PdfDetail pdfDetail) {
		return PdfDetailDto.builder()
				.pdf_num(pdfDetail.getPdfNum())
				.mem_id(pdfDetail.getMemId())
				.pdf_title(pdfDetail.getPdfTitle())
				.ori_filename(pdfDetail.getOriFilename())
				.chn_filename(pdfDetail.getChnFilename())
				.up_time(pdfDetail.getUpTime())
				.pdf_text(pdfDetail.getPdfText())
				.build();
	}
}
