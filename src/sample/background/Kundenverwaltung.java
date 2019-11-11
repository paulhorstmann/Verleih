package sample.background;

public class Kundenverwaltung {
    private Kunde [] zKundenliste;
    private int zKundenanzahl;

    public Kundenverwaltung() {
        zKundenliste = new Kunde [10000];
        zKundenanzahl = 0;
    }

    public void KundendatenAusgeben(){
        if(zKundenanzahl==0){
            System.out.println("Keine Kunden vorhanden");
            return;
        }
        System.out.println();
        System.out.printf("%-7s %-20s %-25s %-30s %n", "Nummer", " Name", " Adresse", "Rechnungsbetrag");
        Kunde lKunde = new Kunde("",0,"");
        for(int i = 0; i<zKundenanzahl; i++){
            lKunde = zKundenliste[i];
            System.out.format("%-8s %-20s %-25s %-29s %n",
                    String.valueOf(i), lKunde.gibName(), lKunde.gibAdresse() , String.valueOf(lKunde.gibOffenerBetrag()));
        }
        System.out.println();
    }

    public boolean alleRechnungenBegleichen(String pName){
        if(istKundeVorhanden(pName))return false;
        zKundenliste[sucheKunden(pName)].alleKundenRechnungenBegleichen();
        return true;
    }

    public String gibErinnerungsschreiben(String pName){
        System.out.println();
        if(istKundeVorhanden(pName))return "Error #404 | Kunde nicht vorhanden";
        return zKundenliste[sucheKunden(pName)].gibErinnerungsschreiben();
    }

    public int gibKundenanzahl(){
        return zKundenanzahl;
    }

    public boolean KundenLoeschen(String pName){
        if(istKundeVorhanden(pName))return false;
        for(int i = sucheKunden(pName); i<zKundenanzahl; i++)zKundenliste [i] = zKundenliste[i+1];
        zKundenanzahl--;
        System.out.println();
        System.out.println(pName + " wurde gelöscht");
        return true;
    }

    public boolean neuenKundenAnlegen(String pName, String pAdresse ,int pKundennummer){
        Kunde lKunde = new Kunde(pName, pKundennummer , pAdresse);
        zKundenliste [zKundenanzahl] = lKunde;
        zKundenanzahl++;System.out.println();
        System.out.println(pName + " wurde angelegt");
        return true;
    }

    public boolean RechnungAnschreiben(String pName, double pBetrag){
        if(istKundeVorhanden(pName))return false;
        zKundenliste[sucheKunden(pName)].neueRechnungAnschreiben(pBetrag);
        System.out.println();
        System.out.println(pName + " wurde einen Betrag " + pBetrag + " abgebucht");
        return true;
    }

    public boolean RechnungBegleichen(String pName, double pBetrag){
        if(istKundeVorhanden(pName))return false;
        zKundenliste[sucheKunden(pName)].RechnungBegleichen(pBetrag);
        System.out.println();
        System.out.println(pName + " wurde einen Betrag " + pBetrag + " gutgeschrieben");
        return true;
    }

    public int sucheKunden(String pName){
        for(int i = 0; i<zKundenanzahl; i++)
            if(zKundenliste[i].gibName().equals(pName))
                return i;
        return -1;
    }

    private boolean istKundeVorhanden(String pName){
        for(int i = 0; i<zKundenanzahl; i++)
            if(zKundenliste[i].gibName().equals(pName))
                return false;
        return true;
    }
}