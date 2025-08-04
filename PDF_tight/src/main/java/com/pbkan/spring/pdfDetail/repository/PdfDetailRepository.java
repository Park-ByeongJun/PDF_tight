package com.pbkan.spring.pdfDetail.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.pbkan.spring.pdfDetail.domain.PdfDetail;


public interface PdfDetailRepository extends JpaRepository<PdfDetail, Long>{

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO pdf_detail (mem_id, pdf_title, ori_filename, chn_filename, up_time, pdf_text) " +
                   "VALUES (:memId, :pdfTitle, :oriFilename, :chnFilename, now(), :pdfText)", nativeQuery = true)
    void insertPdfDetail(@Param("memId") String memId,
                         @Param("pdfTitle") String pdfTitle,
                         @Param("oriFilename") String oriFilename,
                         @Param("chnFilename") String chnFilename,
                         @Param("pdfText") String pdfText);
    
    @Query("SELECT a FROM PdfDetail a WHERE a.memId = :memId")
    List<PdfDetail> findByMemId(@Param("memId") String memId);
}