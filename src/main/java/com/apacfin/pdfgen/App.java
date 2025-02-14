package com.apacfin.pdfgen;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.vandeseer.easytable.TableDrawer;
import org.vandeseer.easytable.structure.Row;
import org.vandeseer.easytable.structure.Table;
import org.vandeseer.easytable.structure.Table.TableBuilder;
import org.vandeseer.easytable.structure.cell.TextCell;

public class App {

    static final float MARGIN = 50F;

    static final float LEADING = 1.5f * 12;
    static final float IMAGEWIDTH = 60F;
    static final float IMAGEHEIGHT = 60F;
    static final float FOOTERHEIGHT = 150F;

    float startX;

    float startY;

    float marginX;

    float marginY;

    float endY;

    boolean header;

    boolean footer;
    
    public static void main(String[] args) throws Exception {
        App app = new App();
        

        app.setMarginX(App.MARGIN);
        app.setMarginY(App.MARGIN);
        
    
        PDDocument doc = app.getPDDocument();
        PDPage page = app.getPDPage();
        doc.addPage(page);
        
        float width = app.getMaxWritableWidth(page);
        float height = app.getMaxWritableHeight(page);

        app.setHeader(true,height);
        app.setFooter(true);

        app.setStartX(app.getMarginX());
        //app.setStartY(app.getMaxWritableHeight(page));
        
        System.out.println("Page Height :" + height);
        System.out.println("Page Width :" + width);
        System.out.println("Y Position:"+app.getStartY());
        PDPageContentStream contentStream = app.generateNewPDContentStream(doc, page);
        
        

        String text = "தமிழ்நாடு (Tamil Nadu) என்பது இந்தியாவின், தென் முனையில் அமைந்துள்ள மாநிலங்களில் ஒன்றாகும். தமிழகம் என்றும் பரவலாக அழைக்கப்படும் இம்மாநிலமானது, பரப்பளவில் இந்தியாவின் பத்தாவது பெரிய மாநிலமாக மற்றும் மக்கள்தொகை அடிப்படையில் இந்தியாவின் ஆறாவது பெரிய மாநிலமாகத் திகழ்கிறது. உலகின் பழம்பெரும் மொழிகளில் ஒன்றான தமிழ் மொழி பேசும் தமிழர் வாழும் பகுதியே தமிழ்நாடு என வழங்கப்படுகிறது. இதன் தலைநகரமாக சென்னை உள்ளது.";
        float margin = 50;

        app.generateText(contentStream, doc, app.loadFont("tamil",doc), text, app.getStartX(), app.getStartY(), width, margin, App.LEADING, "LEFT", 10);
         
        String text2 = "हम डाटा संग्रह टूल्स, जैसे की कुकीज के माध्यम से आपकी जानकारी एकत्र करते हैं ताकि आपको बेहतर और व्यक्तिगत अनुभव प्रदान कर सकें और लक्षित विज्ञापन पेश कर सकें। अगर आप साइन-अप करते हैं, तो हम आपका ईमेल पता, फोन नंबर और अन्य विवरण पूरी तरह सुरक्षित तरीके से स्टोर करते हैं। आप कुकीज नीति पृष्ठ से अपनी कुकीज हटा सकते है और रजिस्टर्ड यूजर अपने प्रोफाइल पेज से अपना व्यक्तिगत डाटा हटा या एक्सपोर्ट कर सकते हैं। हमारी Cookies Policy, Privacy Policy और Terms & Conditions के बारे में पढ़ें और अपनी सहमति देने के लिए Agree पर क्लिक करें।";
        app.generateText(contentStream, doc, app.loadFont("hindi",doc), text2, app.getStartX(), app.getStartY(), width, margin, App.LEADING, "LEFT", 10);

        String text3 = "ಕೇಂದ್ರ ಸರ್ಕಾರಿ ನೌಕರರ ವೇತನ ಮತ್ತು ಪಿಂಚಣಿದಾರರ ಪಿಂಚಣಿಗೆ ತಿದ್ದುಪಡಿಗಳನ್ನು ಪ್ರಸ್ತಾಪಿಸುವ 8ನೇ ವೇತನ ಆಯೋಗಕ್ಕೆ ಕೇಂದ್ರ ಸಚಿವ ಸಂಪುಟ ಅನುಮೋದನೆ ನೀಡಿದೆ. ಇದು ಮುಂದಿನ ವರ್ಷ ಜಾರಿಗೆ ಬರಲಿದೆ ಎಂದು ಹೇಳಲಾಗುತ್ತಿದೆ. 8ನೇ ವೇತನ ಆಯೋಗದ ಅಡಿಯಲ್ಲಿ ಕೇಂದ್ರ ಸರ್ಕಾರಿ ನೌಕರರು ಮತ್ತು ಪಿಂಚಣಿದಾರರಿಗೆ ಹಂತ 1 ರಿಂದ ಹಂತ 10 ರವರೆಗಿನ ವೇತನ ಹೆಚ್ಚಳ ಮತ್ತು ಪಿಂಚಣಿ ಹೆಚ್ಚಳ ಎಷ್ಟು ಎನ್ನುವ ಲೆಕ್ಕಾಚಾರವನ್ನು ಇಲ್ಲಿ ಕಾಣಬಹುದು.ಕನ್ನಡ ಭಾಷೆಯಲ್ಲಿ ಇತ್ತೀಚಿನ ಕರ್ನಾಟಕ, ದೇಶ, ವಿದೇಶ, ಮನರಂಜನೆ, ಶಿಕ್ಷಣ, ಉದ್ಯೋಗ, ಆರೋಗ್ಯ, ಜೀವನಶೈಲಿ, ಆಧ್ಯಾತ್ಮ,  ಕ್ರೀಡೆ, ಕ್ರೈಂ, ವೈರಲ್, ವ್ಯಾಪಾರ, ತಂತ್ರಜ್ಞಾನ ಸುದ್ದಿಗಳನ್ನು ಓದಲು ಈಗಲೇ ನಮ್ಮ ಜೀ ಕನ್ನಡ ನ್ಯೂಸ್ ಮೊಬೈಲ್ ಅಪ್ಲಿಕೇಶನ್ ಡೌನ್ಲೋಡ್ ಮಾಡಿ";
        app.generateText(contentStream, doc, app.loadFont("kannada",doc), text3, app.getStartX(), app.getStartY(), width, margin, App.LEADING, "LEFT", 10);

        String text4 = "మన టాలీవుడ్ లో లవ్ పెయిర్స్ పేరు చెప్పగానే చప్పున గుర్తుకు వచ్చే జంట కృష్ణ (Krishna)- విజయనిర్మల (Vijayanirmala) అనే చెప్పాలి... ప్రస్తుతం వారిద్దరూ మన మధ్య లేకపోయినా, తెలుగు జనం మదిలో మాత్రం సుస్థిరస్థానం సంపాదించారు. మేడ్ ఫర్ ఈచ్ అదర్ అన్న మాటకు నిలువెత్తు నిదర్శనంగా నిలచిన ఈ జంట ఇద్దరూ సినిమా రంగంలో రికార్డులు సృష్టించిన వారే కావడం విశేషం! తెలుగునాట అత్యధిక చిత్రాలలో నటించిన హీరోగా కృష్ణ సాగితే, ప్రపంచంలోనే ఎక్కువ సినిమాలు తీసిన లేడీ డైరెక్టర్ గా విజయనిర్మల గిన్నిస్ బుక్ లోనూ చోటు సంపాదించారు. అందువల్లే తెలుగు జనం కృష్ణ-విజయనిర్మల జంటను ఎన్నటికీ మరచిపోలేరు. అంతేనా! వీరిద్దరి ఆన్ స్క్రీన్ కెమిస్ట్రీ కూడా ఓ రికార్డ్ - కృష్ణ, విజయనిర్మల జంటగా 40కి పైగా చిత్రాలు వెలుగు చూశాయి... టాలీవుడ్ లో అన్ని చిత్రాలలో నటించిన జోడీ మరొకటి కానరాదు";
        app.generateText(contentStream, doc, app.loadFont("telugu",doc), text4, app.getStartX(), app.getStartY(), width, margin, App.LEADING, "LEFT", 10);
        String[][] loanDetails = {
            {"கடன் வகை\nType of Loan", "Secured Business Loan"},
            {"நோக்கம்\nPurpose of Loan", "Business Expansion (Purchase of plant & machinery)"},
            {"அனுமதிக்கப்பட்ட கடன் தொகை \n Loan Amount Sanctioned", "Rs.1000.0/-"},
            {"பதவிக்காலம் (மாதங்கள்)\n Tenure(Months)", "360"},
            {"பதவிக்காலம் (மாதங்கள்)\n Tenure(Months)", "360"},
            {"வட்டி வகை\n Interest Type", "ஃபிக்சட்\nFixed"},
            {"வட்டி வீதம்\n Rate of Interest", "24.00% p.a"},
            {"மாதாந்த தவணை (இஎம்ஐ) \n Monthly Instalment (EMI)", "10000"},
            {"கடன் வகை\nType of Loan", "Secured Business Loan"},
            {"நோக்கம்\nPurpose of Loan", "Business Expansion (Purchase of plant & machinery)"},
            {"அனுமதிக்கப்பட்ட கடன் தொகை \n Loan Amount Sanctioned", "Rs.1000.0/-"},
            {"பதவிக்காலம் (மாதங்கள்)\n Tenure(Months)", "360"},
            {"பதவிக்காலம் (மாதங்கள்)\n Tenure(Months)", "360"},
            {"வட்டி வகை\n Interest Type", "ஃபிக்சட்\nFixed"},
            {"வட்டி வீதம்\n Rate of Interest", "24.00% p.a"},
            {"மாதாந்த தவணை (இஎம்ஐ) \n Monthly Instalment (EMI)", "10000"},
            {"கடன் வகை\nType of Loan", "Secured Business Loan"},
            {"நோக்கம்\nPurpose of Loan", "Business Expansion (Purchase of plant & machinery)"},
            {"அனுமதிக்கப்பட்ட கடன் தொகை \n Loan Amount Sanctioned", "Rs.1000.0/-"},
            {"பதவிக்காலம் (மாதங்கள்)\n Tenure(Months)", "360"},
            {"பதவிக்காலம் (மாதங்கள்)\n Tenure(Months)", "360"},
            {"வட்டி வகை\n Interest Type", "ஃபிக்சட்\nFixed"},
            {"வட்டி வீதம்\n Rate of Interest", "24.00% p.a"},
            {"மாதாந்த தவணை (இஎம்ஐ) \n Monthly Instalment (EMI)", "10000"}
        };

        TableBuilder myTable = Table.builder().fontSize(10).borderWidth(1f).addColumnsOfWidth(200, 200).width(width).padding(5);

        for (String[] detail : loanDetails) {
            myTable.addRow(Row.builder()
                        .add(TextCell.builder().text(detail[0]).font(app.loadFont("tamil", doc)).build())
                        .add(TextCell.builder().text(detail[1]).font(app.loadFont("tamil", doc)).build())
                        .build()).build();
        }
        
        TableDrawer tableDrawer = TableDrawer.builder()
                        .contentStream(contentStream)
                        .startX(app.getStartX())
                        .startY(app.getStartY())
                        .table(myTable.build())
                        .endY(app.getEndY())
                        .build();
        tableDrawer.draw(()-> doc,() -> app.getPDPage() ,margin); /**/
        contentStream.close();
        app.generateHeader(doc,page);
        app.generateFooter(doc, page);
        doc.save("C:\\Users\\APAC_NIKHIL.APACGP5846\\Downloads\\test1.pdf");
        System.out.println("Hello World!");
    }

    private float getStartX(){
        return this.startX;
    }

    private void setStartX(float x){
        this.startX = x;
    }

    private void setHeader(boolean header,float pageWritableHeight){
        this.header = header;
        this.setStartX(MARGIN);
        if(header){
            this.setStartY(pageWritableHeight - (IMAGEHEIGHT/2 + LEADING));
        }else{
            this.setStartY(MARGIN);
        }
    }

    private boolean getHeader(){
        return this.header;
    }

    private void setFooter(boolean footer){
        this.footer = footer;
        if(footer){
            this.setEndY(FOOTERHEIGHT);
        }else{
            this.setEndY(this.getMarginY());
        }
    }

    private boolean getFooter(){
        return this.footer;
    }

    private void setEndY(float y){
        this.endY = y;
    }

    private float getEndY(){
        return this.endY;
    }

    private void setStartY(float y){
        this.startY = y;
    }

    private float getStartY(){
        return this.startY;
    }

    private void setMarginX(float x){
        this.marginX = x;
    }

    private float getMarginX(){
        return this.marginX;
    }

    private void setMarginY(float y){
        this.marginY = y;
    }

    private float getMarginY(){
        return this.marginY;
    }
    
    private PDDocument getPDDocument() {
        return new PDDocument();
    }

    private PDPage getPDPage() {
        return new PDPage(PDRectangle.A4);
    }

    private float getMaxWritableWidth(PDPage page){
        return page.getMediaBox().getWidth() - 2 * this.getMarginX();
    }

    private float getMaxWritableHeight(PDPage page){
        System.out.println("Actual Page Height:"+page.getMediaBox().getHeight());
        System.out.println("Margin on Y-AXIS:"+this.getMarginY());
        System.out.println(page.getMediaBox().getHeight() - this.getMarginY());
        return page.getMediaBox().getHeight() - this.getMarginY();
    }

    private void generateFooter(PDDocument document, PDPage page) throws IOException{
        if(this.getFooter()){
            float y = this.getEndY();
            PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
            contentStream.setStrokingColor(Color.BLACK);
            contentStream.setLineWidth(1);
            contentStream.moveTo(this.getMarginX(), y);
            contentStream.lineTo(this.getMaxWritableWidth(page)+MARGIN,y);
            contentStream.stroke();
            this.generateText(contentStream, document, 
                            this.loadFont("english", document), 
                            "APAC FINANCIAL SERVICES", 
                            MARGIN, 
                            y - LEADING, 
                            this.getMaxWritableWidth(page)- MARGIN, 
                            this.getMarginX(), 
                            LEADING, 
                            "CENTER", 
                            15);
            contentStream.close();
        }
    }


    @SuppressWarnings("ConvertToTryWithResources")
    private void generateHeader(PDDocument document,PDPage page) throws  IOException{
        if(this.getHeader()){
            float width = 60F;
            float height = 60F;
            float x = (page.getMediaBox().getWidth() - width)/2;
            System.err.println("Image X:"+x+" Image Y:"+(this.getMaxWritableHeight(page)- (height/2)));
            InputStream imagePath = App.class.getResourceAsStream("/apaclogo.jpg");
            PDImageXObject image = PDImageXObject.createFromByteArray(document,org.apache.pdfbox.io.IOUtils.toByteArray(imagePath),"logo.jpg");
            PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true);
            contentStream.drawImage(image,x,this.getMaxWritableHeight(page) - (height/2),width,height);
            contentStream.close();
        }
    }

    private PDType0Font getFont(String fontUrl, PDDocument doc) throws IOException {
        InputStream fontSteam = App.class.getResourceAsStream(fontUrl);
        return PDType0Font.load(doc, fontSteam, true);
    }

    private PDFont loadFont(String language, PDDocument doc) throws IOException {
        PDFont font = null;
        switch (language) {
            case "tamil":
                font = this.getFont("/Tiro_Tamil/TiroTamil-Regular.ttf", doc);
                break;
            case "telugu":
                font = this.getFont("/Tiro_Telugu/TiroTelugu-Regular.ttf", doc);
                break;
            case "hindi":
                font = this.getFont("/Tiro_Devanagari_Hindi/TiroDevanagariHindi-Regular.ttf", doc);
                break;
            case "kannada":
                font = this.getFont("/Tiro_Kannada/TiroKannada-Regular.ttf", doc);
                break;
            default:
                font = new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN);
        }
        return font;
    }

    private PDPageContentStream generateNewPDContentStream(PDDocument document,
            PDPage page) throws IOException {
        PDPageContentStream  contentStream =  new PDPageContentStream(document, page);
        return contentStream;
    }

    private void generateText(PDPageContentStream contentStream, PDDocument doc, PDFont font, String text, float startX,
            float startY, float width, float margin, float leading, String alignment, int fontSize) throws IOException {

        float currentY = startY;
        List<String> splitText = this.splitTextIntoLines(text,width, font,fontSize);
        
        for (String linetext : splitText) {
            if (currentY - leading < margin) {
                contentStream.close();
                PDPage newPage = this.getPDPage();
                doc.addPage(newPage);
                contentStream = this.generateNewPDContentStream(doc, newPage);
                currentY = this.getStartY();
            }
            contentStream.setFont(font, fontSize);
            this.generateAlignedText(contentStream, font, linetext, startX, currentY, width, alignment,fontSize);
            currentY -= leading;
        }
        this.setStartY(currentY);
    }

    public List<String> splitTextIntoLines(String text, float maxWidth,PDFont font, int fontSize) throws IOException {
        List<String> words = Stream.of(text.split(" "))
                                   .collect(Collectors.toList());
        List<String> lines = new ArrayList<>();
        StringBuilder line = new StringBuilder();

        for (String word : words) {
            float lineWidth = font.getStringWidth(line.toString()) / 1000 * fontSize;
            float wordWidth = font.getStringWidth(word.toString()) / 1000 * fontSize;
            if (lineWidth + wordWidth + 1 > maxWidth) {
                lines.add(line.toString());
                line = new StringBuilder();
            }
            if (line.length() > 0) {
                line.append(" ");
            }
            line.append(word);
        }
        if (line.length() > 0) {
            lines.add(line.toString());
        }

        return lines;
    }

    private void generateAlignedText(PDPageContentStream contentStream,
            PDFont font,
            String text,
            float startX, float y,
            float width, String alignMent,int fontSize) throws IOException {
            float textWidth = font.getStringWidth(text) / 1000 * 12;
            float adjustedX = startX;

        switch (alignMent) {
            case "CENTER":
                adjustedX = startX + (width - textWidth) / 2;
                break;
            case "RIGHT":
                adjustedX = startX + width - textWidth;
                break;
            case "LEFT":
            default:
                adjustedX = startX;
                break;
        }
        contentStream.setFont(font, fontSize);
        contentStream.beginText();
        contentStream.newLineAtOffset(adjustedX, y);
        contentStream.showText(text);
        contentStream.endText();
    }
}
