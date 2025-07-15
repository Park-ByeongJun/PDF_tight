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
	private String pdf_text;
	private LocalDateTime up_time;
	
	public PdfDetail toEntity() {
		return PdfDetail.builder()
				//.pdfNum(pdf_num)
				.memId(mem_id)
				.pdfTitle(pdf_title)
				.oriFilename(ori_filename)
				.chnFilename(chn_filename)
				.pdfText(pdf_text)
				.upTime(up_time)
				.build();
	}
	
	public PdfDetailDto toDto(PdfDetail pdfDetail) {
		return PdfDetailDto.builder()
				.pdf_num(pdfDetail.getPdfNum())
				.mem_id(pdfDetail.getMemId())
				.pdf_title(pdfDetail.getPdfTitle())
				.ori_filename(pdfDetail.getOriFilename())
				.chn_filename(pdfDetail.getChnFilename())
				.pdf_text(pdfDetail.getPdfText())
				.up_time(pdfDetail.getUpTime())
				.build();
	}
}
