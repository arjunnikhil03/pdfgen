package com.apacfin.pdfgen;

import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Page {

    private Layout layout;

    private Page() {}
 
    private static class PageHolder{
        public static final Page instance = new Page();
    } 

    public static Page getInstance(){
        return  PageHolder.instance;
    }

    public PDPage generatePDFPage(PDRectangle pdRectangle){
        return new PDPage(pdRectangle);
    }
    
}
