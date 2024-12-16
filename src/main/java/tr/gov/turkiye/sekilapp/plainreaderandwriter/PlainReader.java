package tr.gov.turkiye.sekilapp.plainreaderandwriter;

import tr.gov.turkiye.sekilapp.log.Logger;
import tr.gov.turkiye.sekilapp.sekil.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PlainReader {

    public static void dosyadanOkuyupListeyeObjeKoyma(String filepath, ArrayList<Sekil> sekiller) {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",\\s*");
                String sekilTur = parts[0];
                int kenar = Integer.parseInt(parts[1]);
                char sembol = parts[2].charAt(0);

                Sekil sekil = null;
                switch (sekilTur) {
                    case "Kare":
                        sekil = new Kare(kenar, sembol);
                        break;
                    case "Ucgen":
                        sekil = new Ucgen(kenar, sembol);
                        break;
                    case "Dikdortgen":
                        sekil = new Dikdortgen(kenar, sembol);
                        break;
                    case "Yildiz":
                        sekil = new Yildiz(kenar, sembol);
                        break;
                    case "Daire":
                        sekil = new Daire(kenar, sembol);
                        break;
                    default:
                        Logger.logMessage("Bilinmeyen şekil türü: " + sekilTur);
                        continue;
                }

                if (sekil != null) {
                    sekiller.add(sekil);
                }
            }

            Logger.logMessage("Şekiller başarıyla dosyadan okundu ve listeye eklendi. \n");

        } catch (IOException e) {
            Logger.logMessage("Dosya okuma sırasında bir hata oluştu:\n " + e.getMessage());
        }
    }


}
