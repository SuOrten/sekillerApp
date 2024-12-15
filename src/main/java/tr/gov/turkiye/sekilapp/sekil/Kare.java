package tr.gov.turkiye.sekilapp.sekil;

import tr.gov.turkiye.sekilapp.log.Logger;



public class Kare extends Sekil {

    public Kare() {
        super(0, '*');
        this.cevre=0;
        this.alan=0;

    }

    public Kare(int kenar,char sembol){

        super(kenar,sembol);
    }

    @Override
    public void ciz(){
        for (int i = 0; i < kenar; i++) {
            for (int j = 0; j < kenar; j++) {
                Logger.logMessage(sembol + " ");
            }
            Logger.logMessage("\n");

        }
    }

    @Override
    public void alan(){
        this.alan = this.kenar * this.kenar;

    }

    @Override
    public void cevre(){
        this.cevre = 4 * this.kenar;

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