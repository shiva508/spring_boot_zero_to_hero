package com.pool.reports;

import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;

public class PdfUtill {
	public static Font createFont(String fontname, float fontSize, BaseColor fontColor) {
		return FontFactory.getFont(fontname, fontSize, fontColor);
	}

	public static Document documentInstance() {
		return new Document();
	}
	public static Image createImage(String IMAGE_PATH,int ALIGNMENT,int INDENT_LEFT,int INDENT_RIGHT,int HEIGHT,int WIDTH,int X_AXIS,int Y_AXIS ) {
		Image image = null;
		try {
			image = Image.getInstance(IMAGE_PATH);
			image.setAlignment(ALIGNMENT);
			/*image.setIndentationLeft(INDENT_LEFT);
			image.setIndentationRight(INDENT_RIGHT);
			image.scaleAbsolute(WIDTH, HEIGHT);
			image.setAbsolutePosition(X_AXIS, Y_AXIS);*/
		} catch (BadElementException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	public static String getImage(String IMAGE_PATH) {
		return PdfUtill.class.getClassLoader().getResource(IMAGE_PATH).getPath();
	}
	
	public static Paragraph createParagraph(String TEXT) {
		return null;
	}
}
