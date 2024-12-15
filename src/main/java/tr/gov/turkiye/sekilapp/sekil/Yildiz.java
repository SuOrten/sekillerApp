package tr.gov.turkiye.sekilapp.sekil;

import tr.gov.turkiye.sekilapp.log.Logger;

public class Yildiz extends Sekil{

    public Yildiz() {
        super(0,'*');
        this.alan=0;
        this.cevre=0;

    }
    public Yildiz(int kenar,char sembol) {
        super(kenar,sembol);
    }

    @Override
    public void ciz() {
        for (int i = 0; i < kenar; i++) {
            for (int j = 0; j < kenar; j++) {
                // Çapraz çizgi (köşegen) veya ortadaki yatay çizgi için kontrol
                if (i == j || i + j == kenar - 1 || i == kenar / 2) {
                    Logger.logMessage(sembol + " ");
                } else {
                    Logger.logMessage("  "); // Boşluk
                }
            }
            Logger.logMessage("\n");
        }


    }

    @Override
    public void alan(){
        this.alan= (float)this.kenar*6;
    }

    @Override
    public void cevre(){
        this.cevre=this.kenar*6;
    }
    @Override
    public void setAlantoZero(){
        this.alan=0;
    }
    @Override
    public void setCevretoZero(){
        this.cevre=0;

    }
    @Override
    public void printAlan(){
        Logger.logNumber(this.alan);
    }

    @Override
    public void printCevre(){
        Logger.logNumber(this.cevre);
    }

    public String getType() {
        return this.type;
    }

    public void printType() {
        Logger.logMessage(this.type);
    }
}