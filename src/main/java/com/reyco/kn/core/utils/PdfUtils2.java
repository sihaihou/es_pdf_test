package com.reyco.kn.core.utils;

import java.io.OutputStream;

import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.itextpdf.text.pdf.BaseFont;
/** 
 * @author  reyco
 * @date    2022.03.25
 * @version v1.0.1 
 */
public class PdfUtils2 {
	
	public static void htmlToPdf(String htmlString,OutputStream os) {
        ITextRenderer renderer = new ITextRenderer();
		ITextFontResolver font = renderer.getFontResolver();
        try {
			font.addFont("C:/WINDOWS/Fonts/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
			//添加中文识别，这里是设置的宋体，Linux下要换成对应的字体
	        renderer.setDocumentFromString(htmlString);
			renderer.layout();
			renderer.createPDF(os);
			renderer.finishPDF();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
