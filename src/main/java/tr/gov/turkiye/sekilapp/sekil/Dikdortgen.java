package tr.gov.turkiye.sekilapp.sekil;

import tr.gov.turkiye.sekilapp.log.Logger;

public class Dikdortgen extends Sekil {

    public Dikdortgen() {
        super(0,'*');
        this.alan=0;
        this.cevre=0;

    }

    public Dikdortgen(int kenar,char sembol){
        super(kenar,sembol);
    }

    @Override
    public void ciz(){
        for (int i = 0; i < kenar; i++) {
            for (int j = 0; j < kenar*2; j++) {
                Logger.logMessage(sembol + " ");
            }
            Logger.logMessage("\n");

        }
    }

    @Override
    public void alan(){
        this.alan= (2*this.kenar)*this.kenar;
    }

    @Override
    public void cevre(){
        this.cevre= 2*(this.kenar+(2*this.kenar));
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


