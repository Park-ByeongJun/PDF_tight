package com.pbkan.spring.pdfDetail.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pbkan.spring.member.domain.Member;
import com.pbkan.spring.member.repository.MemberRepository;
import com.pbkan.spring.pdfDetail.domain.PdfDetail;
import com.pbkan.spring.pdfDetail.domain.PdfDetailDto;
import com.pbkan.spring.pdfDetail.repository.PdfDetailRepository;
import com.pbkan.spring.pdfDetail.util.PdfTextExtractor;

@Service
public class PdfFileService {

	private String fileDir = "C:\\PDF_tight\\upload\\";
	
	private final PdfDetailRepository pdfDetailRepository;
	private final MemberRepository memberRepository;
	
	@Autowired
	public PdfFileService(PdfDetailRepository pdfDetailRepository, MemberRepository memberRepository) {
		this.pdfDetailRepository = pdfDetailRepository;
		this.memberRepository = memberRepository;
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
			bringText = bringText.replaceAll("[\\x00-\\x08\\x0B\\x0C\\x0E-\\x1F]", "");
			
			PdfDetailDto dto = new PdfDetailDto();
			String title = bringText.length() > 10 ? bringText.substring(0,10) : bringText;
			dto.setMem_id(memId);
			dto.setOri_filename(oriFileName);
			dto.setChn_filename(chnFileName);
			dto.setPdf_title(title);
			dto.setPdf_text(bringText);
			
			Member member = memberRepository.findBymemId(memId);
			
			PdfDetail pdfDetail = dto.toEntity(member);

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
	
	public List<PdfDetailDto> selectPdfDetailList(String memId){
		List<PdfDetail> pdfList = pdfDetailRepository.findByMemId(memId);
		List<PdfDetailDto> pdfDetailList = new ArrayList<PdfDetailDto>();
		
		for (PdfDetail a : pdfList) {
			PdfDetailDto dto = PdfDetailDto.builder().pdf_num(a.getPdfNum()).pdf_title(a.getPdfTitle())
								.ori_filename(a.getOriFilename()).chn_filename(a.getChnFilename())
								.up_time(a.getUpTime()).pdf_text(a.getPdfText()).build();
								
			pdfDetailList.add(dto);
		}
		return pdfDetailList;
	}
}