import java.io.IOException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws IOException {
        MexaricPdf mexaricPdf = new MexaricPdf();
        
        Entity entity = new Entity();

        entity.setOrdenDay("");
        entity.setOrdenMonth("");
        entity.setTableSubHesab("");
        entity.setTableAnalitikUcotSifr("");
        entity.setTableMebleq("");
        entity.setTableMeqsedTeyinatSift("");
        entity.setVerilsinFullName("");
        entity.setEsas("");
        entity.setMeblegYaziIle("");
        entity.setElave("");
        entity.setRehber("");
        entity.setBasBoyukMuhasib("");
        entity.setAldimYaziIle("");
        entity.setTarix(LocalDate.now());
        entity.setImza("");
        entity.setUzre("");
        entity.setXezinedatTehvil("");
        
        mexaricPdf.createMexaric(entity);
    }
}
