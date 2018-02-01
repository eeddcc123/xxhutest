package com.pdfstudy2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.html.simpleparser.HTMLWorker;
import com.lowagie.text.html.simpleparser.StyleSheet;
import com.lowagie.text.rtf.RtfWriter2;

public class Html2Doc {
	/**
	 * 读取html文件到word
	 * @param filepath html文件的路径
	 * @param type 1 本地网页
	 *             2 在线网页
	 *             3 在线网页 需要解析css js
	 * @return
	 * @throws Exception
	 */
	public boolean writeWordFile(String filepath, int type) throws Exception {
		boolean flag = false;
		ByteArrayInputStream bais = null;
		FileOutputStream fos = null;
		String path = "D:/";  //根据实际情况写路径
		try {
			if (!"".equals(path)) {
				File fileDir = new File(path);
				if (fileDir.exists()) {
					String content = "";
					if(type == 1){
						content = readFile(filepath);
					}else if(type == 2){
						content = readFile2(filepath);
					}
					byte b[] = content.getBytes();
					bais = new ByteArrayInputStream(b);
					POIFSFileSystem poifs = new POIFSFileSystem();
					DirectoryEntry directory = poifs.getRoot();
					DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);
					fos = new FileOutputStream(path + "test.doc");
					poifs.writeFilesystem(fos);
					bais.close();
					fos.close();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fos != null) fos.close();
			if(bais != null) bais.close();
		}
		return flag;
	}

	/**
	 * 读取html文件到字符串
	 * @param filename
	 * @return
	 * @throws Exception
	 */
	public String readFile(String filename) throws Exception {
		StringBuffer buffer = new StringBuffer("");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filename));
			buffer = new StringBuffer();
			while (br.ready())
				buffer.append((char) br.read());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(br!=null) br.close();
		}
		return buffer.toString();
	}

	public String readFile2(String fileUrl) throws Exception {
		String result = "";
//		String htmlSource = _cmsUtil.getHtmlResourceByUrl(fileUrl,"UTF-8");
//		result = htmlSource;  //该方法是在线获取链接的html内容
		return result;
	}

	public static void main(String[] args) throws Exception {
		new Html2Doc().writeWordFile("D:\\HTMLPDF\\a1.html",1);
	}
}
