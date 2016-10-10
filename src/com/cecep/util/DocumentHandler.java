package com.cecep.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import com.cecep.model.DtUser;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class DocumentHandler {

	private static Configuration configuration = null;

	static {

		configuration = new Configuration();

		configuration.setDefaultEncoding("utf-8");

	}

	public static void createDoc(Map<String, Object> dataMap,String path, DtUser currUser) {

		// 设置模本装置方法和路径,FreeMarker支持多种模板装载方法。可以重servlet，classpath，数据库装载，

		// 这里我们的模板是放在com.havenliu.document.template包下面
		configuration.setClassForTemplateLoading(DocumentHandler.class,"/excel");

		Template t = null;

		try {

			// statistics.ftl为要装载的模板

			t = configuration.getTemplate(path);

			t.setEncoding("utf-8");

		} catch (IOException e) {

			e.printStackTrace();

		}

		// 输出文档路径及名称
		String filePath = DocumentHandler.class.getResource("/")+"excel/"+currUser.getUserLname()+"_work.doc";
		filePath = filePath.substring(6);
		File outFile = new File(filePath);

		Writer out = null;

		try {

			out = new BufferedWriter(new OutputStreamWriter(

			new FileOutputStream(outFile), "utf-8"));

		} catch (Exception e1) {

			e1.printStackTrace();

		}

		try {

			t.process(dataMap, out);

		} catch (TemplateException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}finally{
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
