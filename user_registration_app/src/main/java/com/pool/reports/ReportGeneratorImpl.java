package com.pool.reports;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
@Service
public class ReportGeneratorImpl implements ReportGenerator {

	public void preparePdf(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=shiav.pdf");
		try {
			ServletOutputStream stream=response.getOutputStream();
			Document documentMaster=PdfUtill.documentInstance();
			PdfWriter.getInstance(documentMaster, stream);
			documentMaster.open();
			String imagePath=PdfUtill.getImage("/images/fb.png");
			Image image=PdfUtill.createImage(imagePath, Element.ALIGN_RIGHT, 0, 0,100,100,10,50);
			
			documentMaster.add(image);
			Font fontHeadder=PdfUtill.createFont(FontFactory.COURIER_BOLD, 16, BaseColor.BLACK);
			Chunk chunk=new Chunk("Hello World", fontHeadder);
			documentMaster.add(chunk);
			Paragraph paragraph=new Paragraph("Facebook Image ");
			documentMaster.add(paragraph);
		
			documentMaster.close();
			stream.flush();
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	
	}

}
