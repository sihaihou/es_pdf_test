package com.reyco.kn.core.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class FreemarkerUtils {
	/**
	 * 
	 * @param map        		对象数据集
	 * @param out        		输出流
	 * @param name				模板文件名称
	 * @throws IOException
	 * @throws TemplateException
	 */
	public static void exportWord(Map<String, Object> map, OutputStream out, String name)
			throws IOException, TemplateException {
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
		cfg.setClassForTemplateLoading(FreemarkerUtils.class, "/ftl");
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		cfg.setLogTemplateExceptions(false);
		cfg.setWrapUncheckedExceptions(true);
		Template tmpl = cfg.getTemplate(name);
		Writer writer = new OutputStreamWriter(out, "utf-8");
		tmpl.process(map, writer);
		writer.flush();
		writer.close();
	}
	/**
	 * 
	 * @param map        		对象数据集
	 * @param name				模板文件名称
	 * @throws IOException
	 * @throws TemplateException
	 */
	public static String createWord(Map<String, Object> map, String templateName)
			throws IOException, TemplateException {
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
		cfg.setClassForTemplateLoading(FreemarkerUtils.class, "/ftl");
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		cfg.setLogTemplateExceptions(false);
		cfg.setWrapUncheckedExceptions(true);
		Template tmpl = cfg.getTemplate(templateName);
		File outFile = File.createTempFile(new Date().getTime()+(templateName.split("\\.")[0]),".tmp");
		Writer writer = new OutputStreamWriter(new FileOutputStream(outFile), "utf-8");
		tmpl.process(map, writer);
		writer.flush();
		writer.close();
		return outFile.getPath();
	}
	public static String getTemplate(String template, Map<String, Object> map) throws IOException, TemplateException {
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
		String templatePath = FreemarkerUtils.class.getResource("/").getPath() + "/ftl";
		cfg.setDirectoryForTemplateLoading(new File(templatePath));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		cfg.setLogTemplateExceptions(false);
		cfg.setWrapUncheckedExceptions(true);
		Template temp = cfg.getTemplate(template);
		StringWriter stringWriter = new StringWriter();
		temp.process(map, stringWriter);
		return stringWriter.toString();
	}
}
