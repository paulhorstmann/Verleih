package sample.background;

public class Mediothek {
    int zAusleihanzahl;
    int zKundenanzahl;
    int zMedienanzahl;
    Kunde[] zKunden;
    Leihbeziehung[] zAusleihe;
    Medium[] zMedien;

    public Mediothek(){
        zKunden = new Kunde[1000];
        zAusleihe = new Leihbeziehung[1000];
        zMedien = new Medium[1000];
    }

    public void feugeSchauspielerHinzu(String pName, int pMedienNr){

    }

    public void gibAlleAusleihenAus(){

    }

    public void gibAlleKundenAus(){

    }

    public void gibAlleMedienAus(){

    }

    public void gibKundenAus(int pKundennummer){

    }

    public void gibMedienAus(int pJahr3, int pJahr2){

    }

    public boolean loescheKunde(int pKundennummer){
        return true;

    }

    public boolean loescheMedium(int pCode){
        return true;

    }

    public boolean nimmBuchAuf(int pCode, double pPreis, int pJahr, String pRegal, String pTitel, String pAutor, String pISBN){
        return true;

    }

    public boolean nimmFilmAuf(int pCode, double pPreis, int pJahr, String pRegal, String pTitel ,int pLeange,String pGenre){
        return true;

    }

    public boolean nimmKundenAuf(String pName, String pAdresse){
        return true;

    }

    public boolean verliehen(int pKundennummer, int pMediencode){
        return true;

    }

    public boolean werLeiht(int pMediencode){
        return true;

    }

    public boolean zahleEin(int pKundennummer, int pMediencode){
        return true;

    }

    public boolean zurückgeben(){
        return true;
    }
}