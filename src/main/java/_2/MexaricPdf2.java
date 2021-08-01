package _2;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

import java.io.IOException;

public class MexaricPdf2 {

    public void createMexaricPdf(Entity2 entity2) throws IOException {
        String pdfPath = "mexaric_2.pdf";
        PdfWriter pdfWriter = new PdfWriter(pdfPath);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);

        pdfDocument.setDefaultPageSize(PageSize.A4.rotate());
        pdfDocument.addNewPage();

        PdfFont normalFont = PdfFontFactory.createFont("fonts/arial.ttf", "Identity-H", true);

        Document document = new Document(pdfDocument);
        document.setFont(normalFont);

        Table table = new Table(new float[]{420f, 420f});
        table.setBorderBottom(new SolidBorder(Color.BLACK, 2f));

        /*****************************************  TABLE - GENERAL  *****************************************/

        Cell cellHeading = new Cell();
        String headingTxtBioloji = "Bioloji  Təbabət  Klinikası";
        cellHeading.setTextAlignment(TextAlignment.CENTER);
        cellHeading.add(headingTxtBioloji);

        Cell cellGeneral = new Cell();
        cellGeneral.setTextAlignment(TextAlignment.CENTER);

        String strSeria = "\nSeria  BTKM  nömrə  M0374\n";
        String strTarix = "\n<<_____>>_____________2021 ci il.\n";
        String strKimden = "\nKimden_____________________________________________";

        Cell cellPulOdeyen = new Cell();
        cellPulOdeyen.setFontSize(8f);
        String strPulOdeyenin = "(pul odəyənin vəzifəsi, soyadı, adı, atasının adı)";
        cellPulOdeyen.add(strPulOdeyenin);

        Cell cellAltXett = new Cell();
        cellAltXett.add("___________________________________________");
        cellAltXett.setMarginTop(10f);

        Cell cellShexTesEden = new Cell();
        cellShexTesEden.setFontSize(8f);
        String shexTesEd = "(şəxsiyyətini təsdiq edən sənəd, seriyası, nömrəsi, ünvanı)";
        cellShexTesEden.add(shexTesEd);

        String strNeUcun = "Nə üçün_____________________________________________";

        Cell cellMeqseq = new Cell();
        cellMeqseq.setFontSize(8f);
        String meqsed = "(məqsədi aydın yazmaq)";
        cellMeqseq.add(meqsed);

        String strMebleq = "\nMəbləğ_____________________________________________";

        Cell cellReqem = new Cell();
        cellReqem.setFontSize(8f);
        String strReqem = "(rəqəm və yazı ilə tam aydın göstərmək)";
        cellReqem.add(strReqem);

        Cell cellManQep = new Cell();
        String strMaqQep = "______________________________________.man______qəp";
        cellManQep.add(strMaqQep);


        cellGeneral.add(strSeria);
        cellGeneral.add(strTarix);
        cellGeneral.add(strKimden);
        cellGeneral.add(cellPulOdeyen);
        cellGeneral.add(cellAltXett);
        cellGeneral.add(cellShexTesEden);
        cellGeneral.add(strNeUcun);
        cellGeneral.add(cellMeqseq);
        cellGeneral.add(cellAltXett);
        cellGeneral.add(strMebleq);
        cellGeneral.add(cellReqem);

        cellGeneral.add(cellManQep);


        //----------------------------------------------------------------------------------------------//

        /*****************************************  TABLE - LEFT  *****************************************/

        Table tableLeft = new Table(new float[]{420f});
        tableLeft.addCell(cellHeading);

        ////////////////////////
        tableLeft.startNewRow();
        ////////////////////////

        Cell cell_2_Left = new Cell();
        String cell_2_LeftTxt = "KASSA  MəDAXİL  ORDENİNİN  KÜTÜYÜ  №";
        cell_2_Left.setTextAlignment(TextAlignment.CENTER);
        cell_2_Left.setBorderBottom(new SolidBorder(Color.WHITE, 1f));
        cell_2_Left.add(cell_2_LeftTxt);
        cell_2_Left.setMarginTop(10f);

        tableLeft.addCell(cell_2_Left);

        ////////////////////////
        tableLeft.startNewRow();
        ////////////////////////

        /*****************************************  TABLE - RIGHT  *****************************************/

        Table tableRight = new Table(new float[]{420f});
        tableRight.addCell(cellHeading);

        /////////////////////////
        tableRight.startNewRow();
        /////////////////////////

        Cell cell_2_Right = new Cell();
        String cell_2_RightTxt = "KASSA  MəDAXİL  ORDENİ  №";
        cell_2_Right.setTextAlignment(TextAlignment.CENTER);
        cell_2_Right.setBorderBottom(new SolidBorder(Color.WHITE, 1f));
        cell_2_Right.add(cell_2_RightTxt);
        cell_2_Right.setMarginTop(10f);

        tableRight.addCell(cell_2_Right);

        /*************************************************************************************************/

        tableLeft.addCell(cellGeneral);
        tableRight.addCell(cellGeneral);

        /*************************************************************************************************/

        table.addCell(tableLeft);
        table.addCell(tableRight);

        document.add(table);

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
