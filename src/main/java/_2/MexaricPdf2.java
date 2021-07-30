package _2;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

import javax.swing.text.StyleConstants;
import java.io.IOException;

public class MexaricPdf2 {

    public void createMexaric(Entity2 entity2) throws IOException {

        //generate olunan PDF 'root' folderde yaranacaq
        String pdfPath = "mexaric_2.pdf";

        PdfWriter pdfWriter = new PdfWriter(pdfPath);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);

        //orientation to landscape
        pdfDocument.setDefaultPageSize(PageSize.A4.rotate());
        pdfDocument.addNewPage();

        PdfPage page = pdfDocument.getPage(1);
        Rectangle pageRect = new Rectangle(page.getTrimBox());
        pageRect.applyMargins(30,30,30,30,false);
        new PdfCanvas(page).setStrokeColor(Color.BLACK).setLineWidth(0.8f).rectangle(pageRect).stroke();

        PdfFont normalFont = PdfFontFactory.createFont("fonts/arial.ttf", "Identity-H", true);

        Document document = new Document(pdfDocument);
//        document.setTopMargin(0);
//        document.setLeftMargin(0);
//        document.setBottomMargin(30);

        document.setFont(normalFont);
        document.setFontSize(8.5f);

        /*****************************************  TABLE - 1  *****************************************/

        Table table1 = new Table(new float[]{350f});
        table1.addCell(new Cell().add("Bioloji  Təbabət  Klinikası").setTextAlignment(TextAlignment.CENTER));

        /*****************************************  TABLE - 2  *****************************************/

        Table table2 = new Table(new float[]{350f}).setMarginTop(10f).setMarginBottom(20f);
        table2.addCell(cell("KASSA MƏDAXİL ORDENİNİN KÜTÜYÜ №", false, "center", false));

        /*****************************************  TABLE - 3  *****************************************/

        Table table3 = new Table(new float[]{70f, 70f, 70f, 70f});

        table3.addCell(cell("Seria", false, "", false));
        table3.addCell(cell("BTKM", true, "", false));
        table3.addCell(cell("nomre", false, "", false));
        table3.addCell(cell("BTKM", true, "", false));


        /*******************************************  E N D  *******************************************/

        document.add(table1);
        document.add(table2);
        document.add(table3);

        document.close();
        pdfDocument.close();
        pdfWriter.close();
        System.out.println("PDF created");
    }

    private Cell cell(String value, boolean bottomBorder, String align, boolean bold) {
        Cell cell = new Cell();
        cell.add(value);
        cell.setBorder(Border.NO_BORDER);

        if (bold) {
            cell.setBold();
        }

        if (bottomBorder) {
            cell.setBorderBottom(new SolidBorder(0));
            cell.setTextAlignment(TextAlignment.CENTER);
        }

        if (align.equalsIgnoreCase("right")) {
            cell.setTextAlignment(TextAlignment.RIGHT);
        } else if (align.equalsIgnoreCase("center")) {
            cell.setTextAlignment(TextAlignment.CENTER);
        }
        return cell;
    }

}
