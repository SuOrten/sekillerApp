package tr.gov.turkiye.sekilapp.main;

import tr.gov.turkiye.sekilapp.jasonreaderandwriter.JasonReader;
import tr.gov.turkiye.sekilapp.jasonreaderandwriter.JasonWriter;
import tr.gov.turkiye.sekilapp.log.Logger;
import tr.gov.turkiye.sekilapp.manager.PropertiesReader;
import tr.gov.turkiye.sekilapp.sekil.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static tr.gov.turkiye.sekilapp.NewScanner.Newscanner.Option;

public class Main {
    public static void main(String[] args) {

        ArrayList<Sekil> sekiller = new ArrayList<Sekil>();

        do {

            Scanner input = new Scanner(System.in );
            int x = Option();


            if (x == 1) {

                Logger.logMessage("*-*-*-*-*-* \n");

            } else if (x == 2) {

                Sekil sekil = new Kare(3, '*');
                sekil.ciz();
                alanVeCevreHesaplamaVeBastirma(sekil);
                sekiller.add(sekil);

            } else if (x == 3) {

                Logger.logMessage("Kenar uzunlugu gir\n");
                int kenar = input.nextInt();
                Logger.logMessage("sembol gir\n");
                char sembol = input.next().charAt(0);
                Sekil sekil = new Kare(kenar, sembol);
                sekil.ciz();
                alanVeCevreHesaplamaVeBastirma(sekil);
                sekiller.add(sekil);

            } else if (x == 4) {

                Logger.logMessage("Kenar uzunlugu gir\n");
                int kenar = input.nextInt();
                Logger.logMessage("sembol gir\n");
                char sembol = input.next().charAt(0);
                Sekil sekil = new Ucgen(kenar, sembol);
                sekil.ciz();
                alanVeCevreHesaplamaVeBastirma(sekil);
                sekiller.add(sekil);

            } else if (x == 5) {

                Logger.logMessage("Kenar uzunlugu gir\n");
                int kenar = input.nextInt();
                Logger.logMessage("sembol gir\n");
                char sembol = input.next().charAt(0);
                Sekil sekil = new Dikdortgen(kenar, sembol);
                sekil.ciz();
                alanVeCevreHesaplamaVeBastirma(sekil);
                sekiller.add(sekil);

            } else if (x == 6) {

                Logger.logMessage("Kenar uzunlugu gir\n");
                int kenar = input.nextInt();
                Logger.logMessage("sembol gir\n");
                char sembol = input.next().charAt(0);
                Sekil sekil = new Yildiz(kenar, sembol);
                sekil.ciz();
                alanVeCevreHesaplamaVeBastirma(sekil);
                sekiller.add(sekil);

            } else if (x == 7) {

                Logger.logMessage("Kenar uzunlugu gir\n");
                int kenar = input.nextInt();
                Logger.logMessage("sembol gir\n");
                char sembol = input.next().charAt(0);
                Sekil sekil = new Daire(kenar, sembol);
                sekil.ciz();
                alanVeCevreHesaplamaVeBastirma(sekil);
                sekiller.add(sekil);

            } else if (x == 8) {

                System.exit(0);

            } else if (x==9) {

                int alanlarToplam=0;
                int cevrelerToplam=0;
                for (Sekil sekil:sekiller
                ) {
                    sekil.setAlantoZero();
                    sekil.setCevretoZero();
                    sekil.cevre();
                    sekil.alan();
                    alanlarToplam +=sekil.getAlan();
                    cevrelerToplam +=sekil.getCevre();
                }
                Logger.logMessage("Çevreler toplamı: ");
                Logger.logNumber(cevrelerToplam);
                Logger.logMessage("\n");
                Logger.logMessage("Alanlar toplamı: ");
                Logger.logNumber(alanlarToplam);
                Logger.logMessage("\n");

            } else if (x==10) {
                PropertiesReader propertiesReader = new PropertiesReader();
                String format = propertiesReader.getProperty("data.format");
                String filepath= propertiesReader.getProperty("data.filepath");

                if (format.equals("json")){
                    Logger.logMessage("Veri Json formatında yazılacak :\n");
                    JasonWriter.Writer(filepath,sekiller);
                } else if (format.equals("plain")) {
                    dosyadanOkuyupListeyeObjeKoyma(sekiller);
                } else {
                    Logger.logMessage("Bu bilinmeyen bir formattır.\n");
                }


            } else if (x==11) {

                for (Sekil sekil:sekiller
                ) {

                    sekil.setCevretoZero();
                    sekil.setAlantoZero();
                }

            } else if (x==12) {
                PropertiesReader propertiesReader = new PropertiesReader();
                String format = propertiesReader.getProperty("data.format");
                String filepath= propertiesReader.getProperty("data.filepath");

                if (format.equals("json")){
                    Logger.logMessage("Veri Json formatında okunacak :\n");
                    JasonReader.Reader(filepath,sekiller);
                } else if (format.equals("plain")) {
                    listedenOkuyupDosyayaYaz(sekiller);
                } else {
                    Logger.logMessage("Bu bilinmeyen bir formattır.\n");
                }


            }else if (x==13) {
                for (Sekil sekil:sekiller
                ) {
                    Logger.logMessage(sekil.getClass().getName()+", "+sekil.getKenar());
                    Logger.logMessage("\n");

                }
            }else if (x==14) {
                for (Sekil sekil:sekiller
                ) {

                    sekil.setCevretoZero();
                    sekil.setAlantoZero();
                }
                sekiller.clear();
            }
        }while (true);
    }

    private static void listedenOkuyupDosyayaYaz(List<Sekil> sekiller) {
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

    private static void dosyadanOkuyupListeyeObjeKoyma(ArrayList<Sekil> sekiller) {
        try (BufferedReader br = new BufferedReader(new FileReader("output.txt"))) {
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

    private static void alanVeCevreHesaplamaVeBastirma(Sekil sekil) {
        Logger.logMessage("Alan değeri\n");
        sekil.setAlantoZero();
        sekil.alan();
        sekil.printAlan();
        Logger.logMessage("\ncevre değeri\n");
        sekil.setCevretoZero();
        sekil.cevre();
        sekil.printCevre();
        Logger.logMessage("\n");


    }


}



