package tr.gov.turkiye.sekilapp.plainreaderandwriter;

import tr.gov.turkiye.sekilapp.log.Logger;
import tr.gov.turkiye.sekilapp.sekil.Sekil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ListedenOkuyupDosyayaYaz {
    public static void listedenOkuyupDosyayaYaz(List<Sekil> sekiller) {
        try {
            File file = new File("output.txt");
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                for (Sekil sekil : sekiller) {
                    sekil.cevre();
                    sekil.alan();
                    bw.write(sekil.getClass().getSimpleName() + "," + sekil.getKenar() + "," + sekil.getSembol() + "," + sekil.getCevre() + "," + sekil.getAlan());
                    bw.newLine();
                }
            }
            Logger.logMessage("Şekiller dosyaya başarıyla yazıldı.\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
