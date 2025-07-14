package com.pbkan.spring.pdfDetail.service;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pbkan.spring.pdfDetail.repository.PdfDetailRepository;

@Service
public class PdfFileService {

	private String fileDir = "C:\\PDF_tight\\upload\\";
	
	private final PdfDetailRepository pdfDetailRepository;
	
	@Autowired
	public PdfFileService(PdfDetailRepository pdfDetailRepository) {
		this.pdfDetailRepository = pdfDetailRepository;
	}
	
	public String upload(MultipartFile file) {
		
		String chnFileName = null;
		
		try {
			String oriFileName = file.getOriginalFilename();
			String fileExt
				= oriFileName.substring(oriFileName.lastIndexOf("."),oriFileName.length());
			UUID uuid = UUID.randomUUID();
			String uniqueName = uuid.toString().replaceAll("-","");
			chnFileName = uniqueName+fileExt;
			File saveFile = new File(fileDir+chnFileName);
			if(!saveFile.exists()) {
				saveFile.mkdirs();
			}
			file.transferTo(saveFile);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return chnFileName;
	}
}