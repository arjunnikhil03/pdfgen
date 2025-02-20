package com.apacfin.pdfgen;

import org.apache.pdfbox.pdmodel.PDDocument;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Document {

    private Page page;

    private Document() {}
 
    private static class DocumentHolder{
        public static final Document instance = new Document();
    } 

    public static Document getInstance(){
        return  DocumentHolder.instance;
    }

    public PDDocument generatePDFDocument(){
        return new PDDocument();
    }

}