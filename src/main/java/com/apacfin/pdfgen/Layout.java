package com.apacfin.pdfgen;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Layout {

    Margin margin;

    private Layout() {}
 
    private static class LayoutHolder{
        public static final Layout instance = new Layout();
    } 

    public static Layout getInstance(){
        return  LayoutHolder.instance;
    }
    
}
