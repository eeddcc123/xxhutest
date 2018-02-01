package com.pdfstudy;



import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;


import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.awt.Rectangle;
import java.io.File;
import java.util.List;


public class ExtractTextByArea1
{
    private ExtractTextByArea1()
    {

    }

    public static void main( String[] args ) throws Exception
    {
    String file = "F:\\project_data\\09_其他项目\\05_智慧认知\\01_明辉材料\\投标响应表-demo - 副本.pdf";
    
    
//    PDFBox BDFBOX = new PDFBox();
    
    File file1 = new File(file);
            PDDocument document = null;
            try
            {
            	
            	
            	
                document = PDDocument.load( file1);

                int pages = document.getNumberOfPages();
                PDFTextStripper stripper = new PDFTextStripper();
                stripper.setSortByPosition(true);
                stripper.setStartPage(1);
                stripper.setEndPage(pages);
                System.out.println(stripper.getText(document));
//                stripper.setSortByPosition( true );
//                Rectangle rect = new Rectangle( 10, 280, 275, 60 );
//                stripper.addRegion( "class1", rect );
//                Rectangle s = new Rectangle();
//                
////                document.getDocumentCatalog().getPages().get(index)
////                List allPages = document.getDocumentCatalog().getAllPages();
////                PDPage firstPage = (PDPage)allPages.get( 0 );
//                PDPage firstPage = document.getDocumentCatalog().getPages().get(0);
//                stripper.extractRegions( firstPage );
//                System.out.println( "Text in the area:" + rect );
//                System.out.println( stripper.getTextForRegion( "class1" ) );

            }catch (Exception e){
            	e.printStackTrace();
            }
            finally
            {
                if( document != null )
                {
                    document.close();
                }
            }
    }

}