package _2;

import java.io.IOException;
import java.time.LocalDate;

public class Main2 {

    public static void main(String[] args) throws IOException {
        MexaricPdf2 mexaricPdf2 = new MexaricPdf2();
        
        Entity2 entity2 = new Entity2();

        entity2.setOrdenDay("");
        entity2.setOrdenMonth("");
        entity2.setTableSubHesab("");
        entity2.setTableAnalitikUcotSifr("");
        entity2.setTableMebleq("");
        entity2.setTableMeqsedTeyinatSift("");
        entity2.setVerilsinFullName("");
        entity2.setEsas("");
        entity2.setMeblegYaziIle("");
        entity2.setElave("");
        entity2.setRehber("");
        entity2.setBasBoyukMuhasib("");
        entity2.setAldimYaziIle("");
        entity2.setTarix(LocalDate.now());
        entity2.setImza("");
        entity2.setUzre("");
        entity2.setXezinedatTehvil("");
        
        mexaricPdf2.createMexaricPdf(entity2);
    }
}
