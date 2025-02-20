package com.apacfin.pdfgen;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Margin {

    float upperX;

    float lowerX;

    float lowerY;

    float upperY;


}
