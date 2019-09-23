package sample.background;

public class Buch extends Medium {
    String zAutor;
    String zISBN;

    public Buch(int pCode, double pPreis, int pJahr, String pRegal, String pTitel, String pAutor, String pISBN){
        super(pCode,pPreis,pJahr,pRegal,pTitel);
        zAutor = pAutor;
        zISBN = pISBN;
    }

    public void gibAllesAufKonsoleAus() {
        System.out.println("[ Buch ] Titel: " + zTitel + " | Code:" + zCode + " | Preis: " + zPreis + "Euro | Regal: " + zRegal + " | Jahr: " + zJahr + " | Autor: " + zAutor + " | ISBN: "  + zISBN);
    }

    public String gibAutor(){
        return zAutor;
    }

    public String gibISBN(){
        return zISBN;
    }
}
