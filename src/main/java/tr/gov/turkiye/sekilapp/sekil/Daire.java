package tr.gov.turkiye.sekilapp.sekil;

import tr.gov.turkiye.sekilapp.log.Logger;
public class Daire extends Sekil {
    public Daire() {
        super(0,'*');
        this.cevre=0;
        this.alan=0;

    }

    public Daire(int kenar,char sembol) {
        super(kenar,sembol);
    }

    @Override
    public void ciz() {
        for (int i = 0; i <= kenar * 2; i++) {
            for (int j = 0; j <= kenar * 2; j++) {
                double distance = Math.sqrt((i - kenar) * (i - kenar) + (j - kenar) * (j - kenar));
                if (distance <= kenar) {
                    Logger.logMessage(sembol + " ");
                } else {
                    Logger.logMessage("  ");
                }
            }
            Logger.logMessage("\n");
        }
    }

    @Override
    public void alan(){
        this.alan= this.kenar*this.kenar*3;
    }

    @Override
    public void cevre(){
        this.cevre= 2*this.kenar*3;
    }

    public void setAlantoZero(){
        this.alan=0;
    }

    public void setCevretoZero(){
        this.cevre=0;

    }

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
