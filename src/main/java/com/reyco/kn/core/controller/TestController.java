package com.reyco.kn.core.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reyco.kn.core.domain.Quotation;
import com.reyco.kn.core.utils.FreemarkerUtils;
import com.reyco.kn.core.utils.PdfUtils;
import com.reyco.kn.core.utils.PdfUtils1;
import com.reyco.kn.core.utils.PdfUtils2;

import freemarker.template.TemplateException;

/**
 * @author reyco
 * @date 2022.03.14
 * @version v1.0.1
 */
@RestController
@RequestMapping("test")
public class TestController {

	@Autowired
	private PdfUtils1 pdfUtils;

	@GetMapping("showPdf")
	public void showPDF(HttpServletResponse response, HttpServletRequest request)
			throws IOException, TemplateException {
		try {
			FileInputStream is = new FileInputStream(new java.io.File("C:\\Users\\reyco\\Desktop\\quotation.pdf"));
			setContentTypeForPdf(response);
			IOUtils.write(IOUtils.toByteArray(is), response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@GetMapping("createShowPdf")
	public void createShowPDF(HttpServletResponse response, HttpServletRequest request)
			throws IOException, TemplateException {
		try {
			Map<String, Object> data = getData();
			setContentTypeForPdf(response);
			data.put("img1", "iVBORw0KGgoAAAANSUhEUgAAABwAAAAdCAIAAAA2M5tmAAADnElEQVRIDZ2Ve2/aWBDF8Ru/sAlgp0k2u/+sVv3+n2al7TZV1Tx42BiDsY2N+zOgWxqISmMk63LvnTNnZs6MpaZpOhc/XF7neVVVnY6kqaqua4qinFqrp1tv7YBY1/XLeJIuV5IkOZbleb2uYWi6pioKO8LwN0C32+1ylT09vyyXq23TgCLLsm1Zf9zejIaDbtcQoNLl4XNzs6m+fnuM53G2zstywwOu2e0OrvrXYcB7j/smU3hhlq3XZA0zTVOhxjsMhl7PBbDabNZFMZnOsmzNG+6cOraNmzOgHGerbLni4Z0pqnLl+33fI8B6uy2KclNVODBN03VdXdXG01m6XM6iiLrd392S5degmGVZ9u3x6WU8heY+OcBThtAYlWX56fOXJElQjGNbYRiEoyFem+cmSRak2/d6FO0nUIoLwX//+5QkKdEJreU5/EpRB/ZRVbJABVlZlEEwDIYDguPadBpZpvkDFESu/f/5YbFIsRGILdZOLSTLMIyP//xdFEU8T8bTaZqm48nENLuGrvu+h9oWaYr/Ayhh4vfx6TmaJy3izx1BBpHRw5ev1EeSJWTUhqkqD2WZFyUJ7XseJZrIM/7yO4DmeU6mKSIqEWGKBW6gNotikiDLku95H65DNECkKISoa3cLW1mSCLeq6hYUXnGywIYWFEDHC8zyTiF2onhO6bvG0HVsjhRFRnbUZ6//g6TwFsdz0vEqaoFyuuCmrul3tzeWadmO5ToO1P66v+fmVd9XOZ4vEuoI7VPjszvwgk4HqRrGh+ug/ctYaZowGHGfXLfhU27io4XOQpxukuIoisui0Nqn7SKv17MsE/HvL6ukdpVlZ+tzCrff2YkvJV2oQlVVMjsc5MFo0HPdAygJRVl1fSnNY0+kDjbUDVU0zZbM4oYLMoOhrurLS3QMKtYwWy6zHXTbNLJEuxzNV3HvtxaUyqCrdP3AlExTr7aa730Aogt6PRfx7zFk6md2TaT7XswOHKk+jSsQ2mbwPJdm2DMXBxcuCLPv+8PBFQNBmEBZYibSzrp2UJk4++WCrA36/p93t3xIjjm14ifBN9chmmA0M9V/icUFIPjGMKQxtC3zVUkOHz6ahOE2mc0Y+PQC8n4LmkK3o8/3iBq1nyK2LoVCadN2dEcRoAzF3bdyN/x3sxVq0GFIoxzHoS9RukP4Z33/ABXHuKHHgGYSkhN+Oym3OnFtm5n3KlhhKBZnQMXZuxfn+b8bbm/4HU/8JNwW6adaAAAAAElFTkSuQmCC");
			pdfUtils.wordToPdf(FreemarkerUtils.createWord(data, "quotation.ftl"), response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@GetMapping("exportPdf")
	public void wordToPdf(HttpServletResponse response, HttpServletRequest request) {
		Map<String, Object> data = getData();
		try {
			setHeaderForPdfExport(response, request);
			pdfUtils.wordToPdf(FreemarkerUtils.createWord(data, "quotation.ftl"), response.getOutputStream());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@GetMapping("exportWord")
	public void exportWord(HttpServletResponse response, HttpServletRequest request) {
		Map<String, Object> data = getData();
		try {
			setHeaderForWordExport(response, request);
			FreemarkerUtils.exportWord(data, response.getOutputStream(), "quotation.ftl");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping("convertDocxToPdf")
	public void convertDocxToPdf(HttpServletResponse response, HttpServletRequest request) {
		Map<String, Object> data = getData();
		try {
			setHeaderForPdfExport(response, request);
			PdfUtils.convertDocxToPdf(FreemarkerUtils.createWord(data, "quotation.ftl"), response);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@GetMapping("showHtmlTopdf")
	public void htmlTopdf(HttpServletResponse response, HttpServletRequest request) {
		setContentTypeForPdf(response);
		InputStream is = null;
		try {
			File file = new File("C:\\Users\\reyco\\Desktop\\123.html");
			is = new BufferedInputStream(new FileInputStream(file));
			byte[] b = new byte[(int)file.length()];
			is.read(b);
			//pdfUtils.htmlToPdf(new String(b), response.getOutputStream());
			PdfUtils2.htmlToPdf(new String(b), response.getOutputStream());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void setHeaderForPdfExport(HttpServletResponse response, HttpServletRequest request) {
		try {
			String userAgent = request.getHeader("User-Agent");
			if (userAgent.toUpperCase().indexOf("CHROME") > 0) {
				response.setHeader("Content-Disposition","attachment;filename=" + new String(("quotation.pdf").getBytes("UTF-8"), "iso-8859-1"));
			} else if (request.getHeader("User-Agent").toUpperCase().indexOf("LIKE GECKO") > 0) {
				response.setHeader("Content-Disposition","attachment;filename=" + new String(("quotation.pdf").getBytes("GBK"), "iso-8859-1"));
			} else {
				response.setHeader("Content-Disposition","attachment;filename=" + new String(("quotation.pdf").getBytes("UTF-8"), "iso-8859-1"));
			}
			setContentTypeForPdf(response);
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param response
	 * @param request
	 */
	private void setHeaderForWordExport(HttpServletResponse response, HttpServletRequest request) {
		try {
			String userAgent = request.getHeader("User-Agent");
			if (userAgent.toUpperCase().indexOf("CHROME") > 0) {
				response.setHeader("Content-Disposition","attachment;filename=" + new String(("quotation.docx").getBytes("UTF-8"), "iso-8859-1"));
			} else if (request.getHeader("User-Agent").toUpperCase().indexOf("LIKE GECKO") > 0) {
				response.setHeader("Content-Disposition","attachment;filename=" + new String(("quotation.docx").getBytes("GBK"), "iso-8859-1"));
			} else {
				response.setHeader("Content-Disposition","attachment;filename=" + new String(("quotation.docx").getBytes("UTF-8"), "iso-8859-1"));
			}
			setContentTypeForDocx(response);
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param response
	 */
	private void setContentTypeForDocx(HttpServletResponse response) {
		response.setHeader("content-Type", "application/docx");
	}
	private void setContentTypeForPdf(HttpServletResponse response) {
		response.setHeader("content-Type", "application/pdf");
	}
	private Map<String, Object> getData() {
		Map<String, Object> data = new HashMap();
		Quotation quotation = new Quotation();
		quotation.setDate("2022-03-21");
		quotation.setCustomerName("zs");
		quotation.setModeDetail("111-Mode");
		quotation.setCustomerRequirements("客户要求");
		quotation.setSalesTeamMember("ls");
		quotation.setCellNumber("1830720021");
		quotation.setEmailAddress("reyco@163.com");
		quotation.setSalesPerson("ww-saler");
		quotation.setCompanyName("reyco-company");
		quotation.setQuoteExpiry("2022-03-28");
		quotation.setQuoteNumber("JT147258369");
		quotation.setReference("reyco-reference");
		quotation.setGstNumber("reyco-gst-147258");
		List<Quotation.Product> products = new ArrayList<>();
		Quotation.Product product1 = new Quotation.Product();
		product1.setName("商品1");
		product1.setQuantity(1);
		product1.setUnitPrice(new BigDecimal("80000"));
		product1.setDiscount(BigDecimal.ZERO);
		product1.setAmount(new BigDecimal("80000"));
		Quotation.Product product2 = new Quotation.Product();
		product2.setName("商品2");
		product2.setQuantity(2);
		product2.setUnitPrice(new BigDecimal("2500"));
		product2.setDiscount(BigDecimal.ZERO);
		product2.setAmount(new BigDecimal("5000"));
		Quotation.Product product3 = new Quotation.Product();
		product3.setName("商品3");
		product3.setQuantity(5);
		product3.setUnitPrice(new BigDecimal("1000"));
		product3.setDiscount(BigDecimal.ZERO);
		product3.setAmount(new BigDecimal("5000"));
		Quotation.Product product4 = new Quotation.Product();
		product4.setName("商品4");
		product4.setQuantity(5);
		product4.setUnitPrice(new BigDecimal("1000"));
		product4.setDiscount(BigDecimal.ZERO);
		product4.setAmount(new BigDecimal("5000"));
		Quotation.Product product5 = new Quotation.Product();
		product5.setName("商品5");
		product5.setQuantity(5);
		product5.setUnitPrice(new BigDecimal("1000"));
		product5.setDiscount(BigDecimal.ZERO);
		product5.setAmount(new BigDecimal("5000"));
		Quotation.Product product6 = new Quotation.Product();
		product6.setName("商品6");
		product6.setQuantity(5);
		product6.setUnitPrice(new BigDecimal("1000"));
		product6.setDiscount(BigDecimal.ZERO);
		product6.setAmount(new BigDecimal("5000"));
		Quotation.Product product7 = new Quotation.Product();
		product7.setName("商品7");
		product7.setQuantity(5);
		product7.setUnitPrice(new BigDecimal("1000"));
		product7.setDiscount(BigDecimal.ZERO);
		product7.setAmount(new BigDecimal("5000"));
		Quotation.Product product8 = new Quotation.Product();
		product8.setName("商品8");
		product8.setQuantity(5);
		product8.setUnitPrice(new BigDecimal("1000"));
		product8.setDiscount(BigDecimal.ZERO);
		product8.setAmount(new BigDecimal("5000"));
		Quotation.Product product9 = new Quotation.Product();
		product9.setName("商品9");
		product9.setQuantity(5);
		product9.setUnitPrice(new BigDecimal("1000"));
		product9.setDiscount(BigDecimal.ZERO);
		product9.setAmount(new BigDecimal("5000"));
		Quotation.Product product10 = new Quotation.Product();
		product10.setName("商品10");
		product10.setQuantity(5);
		product10.setUnitPrice(new BigDecimal("1000"));
		product10.setDiscount(BigDecimal.ZERO);
		product10.setAmount(new BigDecimal("5000"));
		products.add(product1);
		products.add(product2);
		products.add(product3);
		products.add(product4);
		products.add(product5);
		products.add(product6);
		products.add(product7);
		products.add(product8);
		products.add(product9);
		products.add(product10);
		quotation.setProducts(products);
		quotation.setProductAmount(new BigDecimal("125000"));
		quotation.setGstAmount(new BigDecimal("18750"));
		quotation.setTotalAmount(new BigDecimal("143750"));
		data.put("quotation", quotation);
		return data;
	}
}
