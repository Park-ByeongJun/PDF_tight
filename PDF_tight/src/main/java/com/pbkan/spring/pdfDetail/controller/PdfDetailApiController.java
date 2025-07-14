package com.pbkan.spring.pdfDetail.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.pbkan.spring.pdfDetail.domain.PdfDetailDto;
import com.pbkan.spring.pdfDetail.service.PdfFileService;

@Controller
public class PdfDetailApiController {

	private final PdfFileService pdfFileService;
	
	@Autowired
	public PdfDetailApiController(PdfFileService pdfFileService) {
		this.pdfFileService = pdfFileService;
	}
	
	@ResponseBody
	@PostMapping("/uploadPdf")
	public Map<String,String> uploadPdf(PdfDetailDto dto, @RequestParam("file") MultipartFile file){
		Map<String,String> resultMap = new HashMap<String,String>();
		resultMap.put("res_code", "404");
		resultMap.put("res_msg", "PDF 등록중 오류가 발생했습니다.");
		
		String chnFileName = pdfFileService.upload(file);
		if(chnFileName != null) {
			dto.setMem_id(dto.getMem_id());
			dto.setOri_filename(file.getOriginalFilename());
			dto.setChn_filename(chnFileName);
			resultMap.put("res_code", "200");
			resultMap.put("res_msg", "파일 업로드 성공했습니다.");
		}else {
			resultMap.put("res_msg", "파일 업로드 실패했습니다.");
		}
		return resultMap;
	}
}
