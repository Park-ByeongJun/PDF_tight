package com.pbkan.spring.ai.domain;

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
public class AiQueryDto {

	private int query_num;
	private int pdf_num;
	private String mem_id;
	private String re_question;
	private String re_response;
	private LocalDateTime que_time;
	
	public AiQuery toEntity() {
		return AiQuery.builder()
				.queryNum(query_num)
				.pdfNum(pdf_num)
				.memId(mem_id)
				.reQuestion(re_question)
				.reResponse(re_response)
				.queTime(que_time)
				.build();
	}
	
	public AiQueryDto toDto(AiQuery aiQuery) {
		return AiQueryDto.builder()
				.query_num(aiQuery.getQueryNum())
				.pdf_num(aiQuery.getPdfNum())
				.mem_id(aiQuery.getMemId())
				.re_question(aiQuery.getReQuestion())
				.re_response(aiQuery.getReResponse())
				.que_time(aiQuery.getQueTime())
				.build();
	}
}
