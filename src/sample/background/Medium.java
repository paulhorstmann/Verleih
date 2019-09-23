package sample.background;

public class Medium {
    int zCode;
    double zPreis;
    int zJahr;
    String zRegal;
    String zTitel;

    public Medium(int pCode, double pPreis, int pJahr, String pRegal, String pTitel){
        zCode = pCode;
        zPreis = pPreis;
        zJahr = pJahr;
        zRegal = pRegal;
        zTitel = pTitel;
    }

    public void gibAllesAufDerKonsoleAus(){
        System.out.println("[ Medium ] Titel: " + zTitel + " | Code:" + zCode + " | Preis: " + zPreis + "Euro | Regal: " + zRegal + " | Jahr: " + zJahr);
    }

    public void setzeCode(int pCode){
        zCode = pCode;
    }

    public void setzePreis(double pPreis){
        zPreis = pPreis;
    }

    public void setzeJahr(int pJahr){
        zJahr = pJahr;
    }

    public void setzeRegal(String pRegal){
        zRegal = pRegal;
    }

    public void setzeTitle(String pTitel){
        zTitel = pTitel;
    }

    public int gibCode(){
        return zCode;
    }

    public double gibPreis(){
        return zPreis;
    }

    public int gibJahr(){
        return zJahr;
    }

    public String gibRegal(){
        return zRegal;
    }

    public String gibTitel(){
        return zTitel;
    }
}
