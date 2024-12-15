package tr.gov.turkiye.sekilapp.sekil;
import tr.gov.turkiye.sekilapp.log.Logger;

import java.lang.Math;

public class Ucgen extends Sekil {

    public Ucgen() {
        super(0, '*');
        this.alan=0;
        this.cevre=0;

    }

    public Ucgen(int kenar,char sembol){
        super(kenar,sembol);
    }

    @Override
    public void ciz(){
        for (int i = 1; i <= kenar; i++) {
            for (int j = 1; j <= i; j++) {
                Logger.logMessage(sembol + " ");
            }
            Logger.logMessage("\n");

        }


    }

    @Override
    public void alan(){
        this.alan = (int)((Math.sqrt(3) / 4) * this.kenar * this.kenar);

    }

    @Override
    public void cevre(){
        this.cevre = 3 * this.kenar;


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