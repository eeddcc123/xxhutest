package com.pdfstudy;



import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;


import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.awt.Rectangle;
import java.io.File;
import java.util.List;


public class ExtractTextByArea
{
    private ExtractTextByArea()
    {

    }

    public static void main( String[] args ) throws Exception
    {
    String file = "F:\\project_data\\09_其他项目\\05_智慧认知\\01_明辉材料\\投标响应表-demo - 副本.pdf";
    File file1 = new File(file);
            PDDocument document = null;
            try
            {
            	
            	
            	
                document = PDDocument.load( file1);
                if( document.isEncrypted() )
                {
//                    try
//                    {
//                    	
//                    	
//                    	
////                        document.decrypt( "" );
//                    }
//                    catch( InvalidPasswordException e )
//                    {
//                        System.err.println( "Error: Document is encrypted with a password." );
//                        System.exit( 1 );
//                    }
                }
                
//                PDFT
                
                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition( true );
                Rectangle rect = new Rectangle( 10, 280, 275, 60 );
                stripper.addRegion( "class1", rect );
                Rectangle s = new Rectangle();
                
//                document.getDocumentCatalog().getPages().get(index)
//                List allPages = document.getDocumentCatalog().getAllPages();
//                PDPage firstPage = (PDPage)allPages.get( 0 );
                PDPage firstPage = document.getDocumentCatalog().getPages().get(0);
                stripper.extractRegions( firstPage );
                System.out.println( "Text in the area:" + rect );
                System.out.println( stripper.getTextForRegion( "class1" ) );

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