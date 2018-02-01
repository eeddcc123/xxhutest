package com.pdfstudy2;

import java.io.FileInputStream;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableCell;
import org.apache.poi.hwpf.usermodel.TableIterator;
import org.apache.poi.hwpf.usermodel.TableRow;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class WordTableRead {

	public  static void main(String[] args){  
        try {  
        	
        	String ss = "1234我们经";
        	//1234
        	char[] chars = ss.toCharArray();
        	String returnStr = "";
            for (int i = 0; i < chars.length; i++) {
              returnStr += "\\u" + Integer.toString(chars[i], 16);
              //f052
              if("f052".equals(Integer.toString(chars[i], 16))){
            	  System.out.println("我是空格呀");
              }
            }
            System.out.println(returnStr);
        	
            String[] s=new String[2000];  
            FileInputStream in=new FileInputStream("F:\\project_data\\09_其他项目\\05_智慧认知\\01_明辉材料\\7、2017年合肥市公安局信息中心小型机存储服务器等设备运维服务本地化服务情况一览表.doc");  
            POIFSFileSystem pfs=new POIFSFileSystem(in);  
            HWPFDocument hwpf=new HWPFDocument(pfs);  
            Range range =hwpf.getRange();  
            TableIterator it=new TableIterator(range);  
            int index=0;  
            while(it.hasNext()){  
                Table tb=(Table)it.next();  
                for(int i=0;i<tb.numRows();i++){  
                    //System.out.println("Numrows :"+tb.numRows());  
                    TableRow tr=tb.getRow(i);  
                    System.out.println("数据分析第【"+i+"】行");
                    for(int j=0;j<tr.numCells();j++){  
                        //System.out.println("numCells :"+tr.numCells());  
//                      System.out.println("j   :"+j);  
                        TableCell td=tr.getCell(j);  
                        if(td.numParagraphs()>1){
                        	System.out.println(1111111111);
                        }
                        for(int k=0;k<td.numParagraphs();k++){  
                            //System.out.println("numParagraphs :"+td.numParagraphs());  
                            Paragraph para=td.getParagraph(k);  
                            System.out.println(para.text());
                             s[index]=para.text().trim();  
                             index++;  
                        }  
                        
                        
                        
                    }  
                }  
            }  
//          System.out.println(s.toString());  
            for(int i=0;i<s.length;i++){  
//                System.out.println(s[i]);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  

}
