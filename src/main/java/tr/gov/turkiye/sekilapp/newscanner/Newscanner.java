package tr.gov.turkiye.sekilapp.newscanner;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import tr.gov.turkiye.sekilapp.log.Logger;

import java.io.IOError;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Newscanner {

    protected int x;
    protected int kenar;
    protected char sembol;

    public int getx() {
        return this.x;
    }

    public int getKenar() {
        return this.kenar;
    }

    public char getSembol() {
        return this.sembol;
    }

    public void setx() {
        Logger.logMessage("Bu bir konsol uygulamasidir. Lutfen asagidaki komut numaralarindan birini giriniz.\n");
        Logger.logMessage("Program calistigini kontrol etmek icin : 1\n");
        Logger.logMessage("Ekrana 3x3 kare cizdirmek icin : 2\n");
        Logger.logMessage("Ekrana parametreli kare cizdirmek icin : 3\n");
        Logger.logMessage("Ucgen cizdirmek icin : 4\n");
        Logger.logMessage("dikdortgen cizdirmek icin : 5\n");
        Logger.logMessage("yildiz cizdirmek icin : 6\n");
        Logger.logMessage("daire cizdirmek icin : 7\n");
        Logger.logMessage("Uygulamayi kapatmak icin : 8\n");
        Logger.logMessage("Şekiller ile toplama yapmak için : 9\n");
        Logger.logMessage("Listenin içindeki şekilleri dosyaya koymak için : 10\n");
        Logger.logMessage("Şekilleri sıfırlamak için : 11\n");
        Logger.logMessage("Json ya da metin dosyası okutmak için : 12\n");
        Logger.logMessage("Listeyi görmek için : 13\n");
        Logger.logMessage("Listeyi sıfırlamak için : 14\n");

        try {



        String kararregex = "([1-9]|1[0-4])";

        Scanner input = new Scanner(System.in);
        int temp= input.nextInt();

        if (String.valueOf(temp).matches(kararregex)){
            this.x =temp;

        } else {
            throw new IllegalArgumentException(" Sadece 1 ve 14 arasındaki sayılar girilebilir.");
        }

        }catch (InputMismatchException e){
            Logger.logMessage("Lütfen tamsayı giriniz.\n");
            e.getStackTrace();
        }
    }

    public void setKenar() {
        Scanner input = new Scanner(System.in);
        Logger.logMessage("Kenar uzunlugu gir\n");
        this.kenar = input.nextInt();
    }

    public void setSembol() {
        Scanner input = new Scanner(System.in);
        String sembolregex = "[0-9a-zA-Z_$!^+]";
        Logger.logMessage("sembol giriniz\n");
        char temp = input.next().charAt(0);

        if (String.valueOf(temp).matches(sembolregex)) {
            this.sembol = temp;
        } else {
            throw new IllegalArgumentException("Yanlış sembol seçimi.");
        }



    }
}
