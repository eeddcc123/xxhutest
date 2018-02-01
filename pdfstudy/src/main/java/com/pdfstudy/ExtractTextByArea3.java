package com.pdfstudy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ExtractTextByArea3 {

public static void main(String[] args) throws IOException {
File file = new File("F:\\project_data\\09_其他项目\\05_智慧认知\\01_明辉材料\\投标响应表-demo - 副本.pdf");
PDDocument doc=PDDocument.load(file);
int pagenumber=doc.getNumberOfPages();
System.out.print("pages"+pagenumber);
FileOutputStream fos=new FileOutputStream("F:\\project_data\\09_其他项目\\05_智慧认知\\01_明辉材料\\投标响应表-demo1.doc");
Writer writer=new OutputStreamWriter(fos,"UTF-8");
PDFTextStripper stripper=new PDFTextStripper();
stripper.setSortByPosition(true);//排序
stripper.setStartPage(3);//设置转换的开始页
stripper.setEndPage(7);//设置转换的结束页
stripper.writeText(doc,writer);
writer.close();
doc.close();
}
}