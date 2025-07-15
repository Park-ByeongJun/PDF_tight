package com.pbkan.spring.pdfDetail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PdfDetailViewController {

	@GetMapping("/pdfDetail")
	public String pdfDetail() {
		return "pdfDetail/pdfDetail";
	}
}
