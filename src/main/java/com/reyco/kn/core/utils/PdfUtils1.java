package com.reyco.kn.core.utils;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;

/**
 * @author reyco
 * @date 2022.03.22
 * @version v1.0.1
 */
@Component
public class PdfUtils1 {
	
	private static volatile boolean license = false;
	static {
		// 凭证 不然切换后有水印
		InputStream is;
		try {
			is = new ClassPathResource("/license.xml").getInputStream();
			License aposeLic = new License();
			aposeLic.setLicense(is);
			license = true;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * docx转pdf
	 * @param docxPath
	 * @param os
	 * @throws Exception
	 */
	public void wordToPdf(String docxPath,OutputStream os) throws Exception {
		try {
			if(!license) {
				throw new RuntimeException("License验证不通过...");
			}
			// 要转换的word文件
			Document doc = new Document(docxPath);
			doc.save(os, SaveFormat.PDF);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * html转pdf
	 * @param docxPath
	 * @param os
	 * @throws Exception
	 */
	public void htmlToPdf(String htmlStr,OutputStream os) throws Exception {
		InputStream is = null;
		try {
			if(!license) {
				throw new RuntimeException("License验证不通过...");
			}
			is = new BufferedInputStream(new ByteArrayInputStream(htmlStr.getBytes()));
			// 要转换的word文件
			Document doc = new Document(is);
			doc.save(os, SaveFormat.PDF);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
