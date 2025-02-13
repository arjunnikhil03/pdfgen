package com.apacfin.pdfgen;

import java.io.IOException;
import java.io.InputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

/**
 * Hello world!
 *
 */
public class App 
{
    MutablePair<Float, Float> pointer = new MutablePair<Float, Float>(0.0f,0.0f);
    

    public static void main( String[] args ) throws Exception
    {
        App app = new App();
        PDDocument pdDocument = app.getPDDocument();
        PDPage page = app.getPDPage();

        System.out.println("Page Height :"+page.getMediaBox().getHeight());
        System.out.println("Page Width :"+page.getMediaBox().getWidth());
        
        app.setStartingPointOfPage(page);

        System.out.println("Pointer starting point:"+app.pointer.toString());

        pdDocument.addPage(page);
        PDPageContentStream contentStream = new PDPageContentStream(pdDocument, page);
        contentStream.moveTo(100, 100);
        contentStream.lineTo(page.getMediaBox().getWidth(), page.getMediaBox().getHeight());
        contentStream.stroke();
        contentStream.close();
        pdDocument.save("C:\\Users\\APAC_NIKHIL.APACGP5846\\Downloads\\test1.pdf");   
        System.out.println( "Hello World!" );
    }

    private PDDocument getPDDocument(){
        return new PDDocument();
    }

    private PDPage getPDPage(){
        return new PDPage(PDRectangle.A4);
    }

    private void generateFooter(){
        
    }
    
    private void generateHeader(){

    }

    private PDType0Font getFont(String fontUrl,PDDocument doc) throws IOException {
        InputStream fontSteam = App.class.getResourceAsStream(fontUrl);
        return PDType0Font.load(doc, fontSteam,true);
    }

    private PDFont loadFont(String language,PDDocument pdDocument) throws IOException{
        PDFont font = null;
        switch(language){
            case "tamil":
                font = this.getFont("/Tiro_Tamil/TiroTamil-Regular.ttf",pdDocument);
            break;
            case "telugu":
                font = this.getFont("/Tiro_Telugu/TiroTelugu-Regular.ttf",pdDocument);
            break;
            case "hindi":
                font = this.getFont("/Tiro_Devanagari_Hindi/TiroDevanagariHindi-Regular.ttf",pdDocument);
            break;
            case "kannada":
                font = this.getFont("/Tiro_Kannada/TiroKannada-Regular.ttf",pdDocument);
            break;
            default:
                font = new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN);
        }
        return font;
    }

    private void setStartingPointOfPage(PDPage page){
        this.pointer.setLeft(0.0f);
        this.pointer.setRight(page.getMediaBox().getUpperRightY());
    }

    private void generateText(){
        
    }
}
