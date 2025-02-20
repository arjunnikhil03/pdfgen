package com.apacfin.pdfgen;

public class Test {


    public static void main(String[] args) {
        Document doc = Document.getInstance();
        Page page = Page.getInstance();
        doc.setPage(page);
        Layout layout = Layout.getInstance();
        page.setLayout(layout);      
    }
    
}
