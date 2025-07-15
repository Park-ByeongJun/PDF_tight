package com.pbkan.spring.pdfDetail.service;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pbkan.spring.pdfDetail.domain.PdfDetail;
import com.pbkan.spring.pdfDetail.domain.PdfDetailDto;
import com.pbkan.spring.pdfDetail.repository.PdfDetailRepository;
import com.pbkan.spring.pdfDetail.util.PdfTextExtractor;

@Service
public class PdfFileService {

	private String fileDir = "C:\\PDF_tight\\upload\\";
	
	private final PdfDetailRepository pdfDetailRepository;
	
	@Autowired
	public PdfFileService(PdfDetailRepository pdfDetailRepository) {
		this.pdfDetailRepository = pdfDetailRepository;
	}
	
	public File upload(MultipartFile file) {
		
		File saveFile = null;
		
		try {
			
			if(file == null || file.isEmpty()) {
				System.out.println("파일 미존재");
				return null;
			}
			
			String oriFileName = file.getOriginalFilename();
			String fileExt
				= oriFileName.substring(oriFileName.lastIndexOf("."),oriFileName.length());
			UUID uuid = UUID.randomUUID();
			String uniqueName = uuid.toString().replaceAll("-","");
			String chnFileName = uniqueName+fileExt;
			saveFile = new File(fileDir+chnFileName);
			if(!saveFile.getParentFile().exists()) {
				saveFile.getParentFile().mkdirs();
			}
			file.transferTo(saveFile);
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return saveFile;
	}
	
	public void bringText(File saveFile, String memId, String oriFileName) {
		try {
			String chnFileName = saveFile.getName();
			String bringText = PdfTextExtractor.extractText(saveFile);

			PdfDetailDto dto = new PdfDetailDto();
			String title = bringText.length() > 10 ? bringText.substring(0,10) : bringText;
			dto.setMem_id(memId);
			dto.setOri_filename(oriFileName);
			dto.setChn_filename(chnFileName);
			dto.setPdf_title(title);
			dto.setPdf_text(bringText);
			
			PdfDetail pdfDetail = dto.toEntity();

			pdfDetailRepository.insertPdfDetail(
					memId,
					title,
					oriFileName,
					chnFileName,
					bringText
					);
				
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}