package tr.gov.turkiye.sekilapp.sekil;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import tr.gov.turkiye.sekilapp.log.Logger;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME, // JSON'daki "type" alanını kullan
        include = JsonTypeInfo.As.PROPERTY, // "type" özelliği olarak ekle
        property = "type" // JSON'daki özellik adı "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Kare.class, name = "Kare"),
        @JsonSubTypes.Type(value = Ucgen.class, name = "Ucgen"),
        @JsonSubTypes.Type(value = Daire.class, name = "Daire"),
        @JsonSubTypes.Type(value = Dikdortgen.class, name = "Dikdortgen"),
        @JsonSubTypes.Type(value = Yildiz.class, name = "Yildiz")
})

abstract public class Sekil {
    protected char sembol;
    protected int kenar;
    protected String type;

    protected float alan;

    protected float cevre;

    public Sekil(int kenar,char sembol){

        this.kenar=kenar;
        this.sembol=sembol;
        this.alan=0;
        this.cevre=0;
        this.type = this.getClass().getSimpleName();
    }

    public abstract void ciz();

    public abstract void alan();

    public abstract void cevre();

    public abstract void setAlantoZero();

    public abstract void setCevretoZero();

    public abstract void printAlan();


    public abstract void printCevre();

    public float getAlan(){
        return this.alan;
    }

    public float getCevre(){
        return this.cevre;
    }

    public int getKenar(){
        return this.kenar;
    }

    public char getSembol(){
        return this.sembol;
    }

    public String getType() {
        return this.type;
    }

    public void printType() {
        Logger.logMessage(this.type);
    }
}