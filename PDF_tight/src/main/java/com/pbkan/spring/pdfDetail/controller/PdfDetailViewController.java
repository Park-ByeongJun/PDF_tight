package com.pbkan.spring.pdfDetail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pbkan.spring.pdfDetail.domain.PdfDetailDto;
import com.pbkan.spring.pdfDetail.service.PdfFileService;

@Controller
public class PdfDetailViewController {

	private final PdfFileService pdfFileService;
	
	@Autowired
	public PdfDetailViewController(PdfFileService pdfFileService) {
		this.pdfFileService = pdfFileService;
	}
	
	@GetMapping("/pdfDetail")
	public String pdfDetail() {
		return "pdfDetail/pdfDetail";
	}
	
	
	@GetMapping("/myPdfList")
	public String myPdfList(Model model) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		List<PdfDetailDto> resultList = pdfFileService.selectPdfDetailList(username);
		model.addAttribute("resultList",resultList);
		
		return "member/myPdfList";
	}
}
