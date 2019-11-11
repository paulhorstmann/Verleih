package sample.background;

public class Kunde {
    protected int zKundennummer;
    protected String zName;
    protected String zAdresse;
    protected double zOffenerBetrag;

    public Kunde(String pName,int pKundennummer, String pAdresse){
        zName = pName;
        zKundennummer = pKundennummer;
        zAdresse = pAdresse;
    }

    public void alleKundenRechnungenBegleichen(){
        zOffenerBetrag = 0;
    }

    public void neueRechnungAnschreiben(double pBetrag){
        zOffenerBetrag = zOffenerBetrag + pBetrag;
    }

    public void RechnungBegleichen(double pBetrag){
        zOffenerBetrag = zOffenerBetrag - pBetrag;
    }

    public void setzeAdresse(String pAdresse){
        zAdresse = pAdresse;
    }

    public void setzeName(String pName){
        zName = pName;
    }

    public void setzeOffenerBetrag(double pBetrag){
        zOffenerBetrag = pBetrag;
    }

    public void setzeKundennummer(int pKundennummer){
        zKundennummer = pKundennummer;
    }

    public String gibAdresse(){
        return zAdresse;
    }

    public int gibKundennummer(){return zKundennummer;}

    public String gibName(){
        return zName;
    }

    public String gibErinnerungsschreiben(){
        return "Sehr geehrter Frau/Herr " + zName + ", sie haben noch einen Betrag von " + zOffenerBetrag + " Euro zu begleichen";
    }

    public double gibOffenerBetrag(){
        return zOffenerBetrag;
    }
}
