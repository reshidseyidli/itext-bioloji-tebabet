import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

import java.io.IOException;

public class MexaricPdf {

    public void createMexaric(Entity entity) throws IOException {

        //generate olunan PDF 'root' folderde yaranacaq
        String pdfPath = "mexaric.pdf";

        PdfWriter pdfWriter = new PdfWriter(pdfPath);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(PageSize.A4);

        Document document = new Document(pdfDocument);
        document.setTopMargin(10);
        document.setBottomMargin(0);

        PdfFont normalFont = PdfFontFactory.createFont("fonts/arial.ttf", "Identity-H", true);
        document.setFont(normalFont);
        document.setFontSize(9f);

        /*****************************************  TABLE - 1  *****************************************/

        Table table1 = new Table(new float[]{200f, 360f});

        table1.addCell(cell("BİOLOJİ  TƏBABƏT  KLİNİKASI", true, "center", true));
        table1.addCell(cell("Forma N - KO-2", false, "right", true));

        /*****************************************  TABLE - 2  *****************************************/

        Table table2 = new Table(new float[]{200f, 360f});

        table2.addCell(cell("(müəssisənin, təşkilatın adı)", false, "center", false).setFontSize(7f));
        table2.addCell(cell("", false, "", false).setFontSize(7f));

        /*****************************************  TABLE - 3  *****************************************/

        Table table3 = new Table(new float[]{180f, 50f, 350f});

        table3.addCell(cell("KASSA  MƏXARİC  ORDERİ     №", false, "", true));
        table3.addCell(cell("MX0001", false, "", true));
        table3.addCell(cell("", false, "", true));

        /*****************************************  TABLE - 4  *****************************************/

        Table table4 = new Table(new float[]{15f, 25f, 40f, 80f, 400f});

        table4.addCell(cell("<", false, "", false).setFontSize(7f));
        table4.addCell(cell(entity.getOrdenDay(), true, "", false).setFontSize(7f));
        table4.addCell(cell(">", false, "", false).setFontSize(7f));
        table4.addCell(cell(entity.getOrdenMonth(), true, "", false).setFontSize(7f));
        table4.addCell(cell("2021-ci il", false, "", false));

        /*****************************************  TABLE - 5  *****************************************/

        Table table5 = new Table(new float[]{50f, 130f, 130f, 110f, 140f});

        Cell cell5_11 = new Cell();
        cell5_11.setBorderLeft(new SolidBorder(1));
        cell5_11.setBorderTop(new SolidBorder(1));

        Cell cell5_12 = new Cell();
        cell5_12.setBorderTop(new SolidBorder(1));
        cell5_12.add("Müxabirləşən hesab, subhesab");
        cell5_12.setTextAlignment(TextAlignment.CENTER);

        Cell cell5_13 = new Cell();
        cell5_13.setBorderTop(new SolidBorder(1));
        cell5_13.add("Analitik uçotun şifri");
        cell5_13.setTextAlignment(TextAlignment.CENTER);


        Cell cell5_14 = new Cell();
        cell5_14.setBorderTop(new SolidBorder(1));
        cell5_14.add("Məbləğ");
        cell5_14.setTextAlignment(TextAlignment.CENTER);

        Cell cell5_15 = new Cell();
        cell5_15.setBorderTop(new SolidBorder(1));
        cell5_15.setBorderRight(new SolidBorder(1));
        cell5_15.add("Məqsədli təyinatın şifri");
        cell5_15.setTextAlignment(TextAlignment.CENTER);

        table5.addCell(cell5_11);
        table5.addCell(cell5_12);
        table5.addCell(cell5_13);
        table5.addCell(cell5_14);
        table5.addCell(cell5_15);

        //-------------------------------------------------

        Cell cell5_21 = new Cell().setHeight(18f);
        cell5_21.setBorderLeft(new SolidBorder(1));
        cell5_21.setBorderBottom(new SolidBorder(1));

        Cell cell5_22 = new Cell();
        cell5_22.setBorderBottom(new SolidBorder(1));
        cell5_22.add(entity.getTableSubHesab());

        Cell cell5_23 = new Cell();
        cell5_23.setBorderBottom(new SolidBorder(1));
        cell5_23.add(entity.getTableAnalitikUcotSifr());

        Cell cell5_24 = new Cell();
        cell5_24.setBorderBottom(new SolidBorder(1));
        cell5_24.add(entity.getTableMebleq());

        Cell cell5_25 = new Cell();
        cell5_25.setBorderBottom(new SolidBorder(1));
        cell5_25.setBorderRight(new SolidBorder(1));
        cell5_25.add(entity.getTableMeqsedTeyinatSift());

        table5.addCell(cell5_21);
        table5.addCell(cell5_22);
        table5.addCell(cell5_23);
        table5.addCell(cell5_24);
        table5.addCell(cell5_25);

        /*****************************************  TABLE - 6  *****************************************/

        Table table6 = new Table(new float[]{60f, 500f});

        table6.addCell(cell("Verilsin", false, "", true));
        table6.addCell(cell(entity.getVerilsinFullName(), true, "", false));

        /*****************************************  TABLE - 7  *****************************************/

        Table table7 = new Table(new float[]{60f, 500f});

        table7.addCell(cell("", false, "", false).setFontSize(7f));
        table7.addCell(cell("(soyadı, adı, atasının adı)", false, "center", false).setFontSize(7f));

        /*****************************************  TABLE - 8  *****************************************/

        Table table8 = new Table(new float[]{40f, 520f});

        table8.addCell(cell("Əsas", false, "", true));
        table8.addCell(cell(entity.getEsas(), true, "", false));

        /*****************************************  TABLE - 9  *****************************************/

        Table table9 = new Table(new float[]{90f, 470f});

        table9.addCell(cell("Məbləğ (yazı ilə)", false, "", true));
        table9.addCell(cell(entity.getMeblegYaziIle(), true, "", false));

        /*****************************************  TABLE - 10  *****************************************/

        Table table10 = new Table(new float[]{50f, 510f});

        table10.addCell(cell("Əlavə", false, "", false));
        table10.addCell(cell(entity.getElave(), true, "", false));

        /*****************************************  TABLE - 11  *****************************************/

        Table table11 = new Table(new float[]{45f, 205f, 150f, 160f});

        table11.addCell(cell("Rəhbər:", false, "", true).setItalic());
        table11.addCell(cell(entity.getRehber(), true, "", false));

        table11.addCell(cell("Baş (böyük) mühasib:", false, "right", true).setItalic());
        table11.addCell(cell(entity.getBasBoyukMuhasib(), true, "", false));

        /*****************************************  TABLE - 12  *****************************************/

        Table table12 = new Table(new float[]{110f, 450f});

        table12.addCell(cell(" Aldım   ( yazı  ilə )", false, "", true));
        table12.addCell(cell(entity.getAldimYaziIle(), true, "", false));

        /*****************************************  TABLE - 13  *****************************************/

        Table table13 = new Table(new float[]{40f, 140f, 100f, 100f, 180});

        table13.addCell(cell("Tarix:", false, "", true));
        table13.addCell(cell(entity.getTarix().toString(), true, "", false));

        table13.addCell(cell("İmza:", false, "right", true));
        table13.addCell(cell(entity.getImza(), true, "", false));

        table13.addCell(cell("", false, "", false));

        /*****************************************  TABLE - 14  *****************************************/

        Table table14 = new Table(new float[]{40f, 520f});

        table14.addCell(cell("Üzrə", false, "", true));
        table14.addCell(cell(entity.getUzre(), true, "", false));

        /*****************************************  TABLE - 15  *****************************************/

        Table table15 = new Table(new float[]{40f, 520f});

        table15.addCell(cell("", false, "", false).setFontSize(7f));
        table15.addCell(cell("(Şəxsiyyəti müəyyən edən sənədin adı, seriyası, nömrəsi, verildiyi yer və tarix)", false, "center", false).setFontSize(7f));

        /*****************************************  TABLE - 16  *****************************************/

        Table table16 = new Table(new float[]{120f, 190f, 250f});

        table16.addCell(cell("Xəzinadar təhvil verdi:", false, "", false));
        table16.addCell(cell(entity.getXezinedatTehvil(), true, "", false));
        table16.addCell(cell("", false, "", false));

        /*****************************************  TABLE - 17/1  *****************************************/

        Table table17_1 = new Table(new float[]{420f, 140f});

        table17_1.addCell(cell("", false, "", false));
        table17_1.addCell(cell("Vərəq 01", false, "", false));

        /*****************************************  TABLE - 17/2  *****************************************/

        Table table17_2 = new Table(new float[]{420f, 140f});

        table17_2.addCell(cell("", false, "", false));
        table17_2.addCell(cell("Vərəq 02", false, "", false));


        /*******************************************  E N D  *******************************************/

        document.add(table1);
        document.add(table2);
        document.add(new Paragraph("\n").setFontSize(0.3f));
        document.add(table3);
        document.add(table4);
        document.add(new Paragraph("\n").setFontSize(0.3f));
        document.add(table5);
        document.add(new Paragraph("\n").setFontSize(0.3f));
        document.add(table6);
        document.add(table7);
        document.add(table8);
        document.add(new Paragraph("\n").setFontSize(0.3f));
        document.add(table9);
        document.add(new Paragraph("\n").setFontSize(0.3f));
        document.add(table10);
        document.add(new Paragraph("\n").setFontSize(0.3f));
        document.add(table11);
        document.add(new Paragraph("\n").setFontSize(0.3f));
        document.add(table12);
        document.add(new Paragraph("\n").setFontSize(0.3f));
        document.add(table13);
        document.add(new Paragraph("\n").setFontSize(0.3f));
        document.add(table14);
        document.add(table15);
        document.add(table16);
        document.add(table17_1);

        document.add(new Paragraph("\n").setFontSize(30f));

        document.add(table1);
        document.add(table2);
        document.add(new Paragraph("\n").setFontSize(0.3f));
        document.add(table3);
        document.add(table4);
        document.add(new Paragraph("\n").setFontSize(0.3f));
        document.add(table5);
        document.add(new Paragraph("\n").setFontSize(0.3f));
        document.add(table6);
        document.add(table7);
        document.add(table8);
        document.add(new Paragraph("\n").setFontSize(0.3f));
        document.add(table9);
        document.add(new Paragraph("\n").setFontSize(0.3f));
        document.add(table10);
        document.add(new Paragraph("\n").setFontSize(0.3f));
        document.add(table11);
        document.add(new Paragraph("\n").setFontSize(0.3f));
        document.add(table12);
        document.add(new Paragraph("\n").setFontSize(0.3f));
        document.add(table13);
        document.add(new Paragraph("\n").setFontSize(0.3f));
        document.add(table14);
        document.add(table15);
        document.add(table16);
        document.add(table17_2);

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
