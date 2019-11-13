package sample.background;

import java.io.*;
import java.util.GregorianCalendar;
import static sample.basic.contrans.*;

public class Mediothek {
    private int zAusleihanzahl;
    private int zKundenanzahl;
    private int zMedienanzahl;
    private Kunde[] zKunden;
    private Leihbeziehung[] zAusleihe;
    private Medium[] zMedien;

//    TODO Fuege Funktionen hinzu:
//    - Ausleihmethoden auf schnelligkeit prüfen
//
//    - CSV Datei übernahme
//    - Sql Ausgabe
//    - Konsolen User Interface


    public Mediothek(){
        zKunden = new Kunde[1000];
        zAusleihe = new Leihbeziehung[1000];
        zMedien = new Medium[1000];
    }

    public void feugeSchauspielerHinzu(String pName, int pMedienNr){
        Medium lMedium = zMedien[sucheMedium(pMedienNr)];
        if(lMedium != null && lMedium instanceof Film) {
            Film lFilm = (Film) lMedium;
            lFilm.ergaenzeSchauspieler(pName);
            zMedien[sucheMedium(pMedienNr)] = lFilm;
            System.out.println("\nSchauspieler: " + pName + "wurde dem Film " + lMedium.gibTitel());
        }
        System.out.println("\n{Error} Der Schauspieler: " +pName + "konnte nicht zu dem Medium mit der Nummer: " + pMedienNr + "hinzugefuegt werden");
    }

    public void gibAllesAus(){
        gibAlleAusleihenAus();
        gibAlleKundenAus();
        gibAlleMedienAus();
    }

    public void gibAlleAusleihenAus(){

        System.out.println();
        System.out.printf("%-2s %-5s %-3s %-20s %-3s %-20s %-3s %-10s %-3s %-12s %-2s %n", "| ", "Index" ," | " , "Kundenname", " | " , "Mediumtitel", " | " , "Leihgebühr", " | " , "Ausleihdatum" , " |");
        lineBreak(93);
        Leihbeziehung lLeihbeziehung = null;
        for(int i = 0; i<zAusleihanzahl; i++){
            lLeihbeziehung = zAusleihe[i];
            System.out.format("%-2s %-5s %-3s %-20s %-3s %-20s %-3s %-10s %-3s %-12s %-2s %n",
                    "| ", i ," | ", lLeihbeziehung.gibKunde().gibName() , " | " ,  lLeihbeziehung.gibMedium().gibTitel() , " | " , lLeihbeziehung.gibAktulleLeihgebuehr() , " | " , lLeihbeziehung.gibAusleihdatum() , " |");
        }
        if(zAusleihanzahl == 0) System.out.println("Es wird nichts ausgeliehen");
        System.out.println();

    }

    public void gibAktulleLeihgebuehrAus(){
        System.out.println(zAusleihe[0].gibAktulleLeihgebuehr());
    }

    public void gibAlleKundenAus(){
        System.out.println();
        System.out.printf("%-2s %-5s %-3s %-12s %-3s %-20s %-3s %-20s %-3s %-15s %-2s %n", "| ", "Index" ," | " , "Kundennummer", " | " , "Name", " | " , "Adresse", " | " , "Rechnungsbetrag" , " |");
        lineBreak(98);
        Kunde lKunde = null;
        for(int i = 0; i<zKundenanzahl; i++){
            lKunde = zKunden[i];
            System.out.format("%-2s %-5s %-3s %-12s %-3s %-20s %-3s %-20s %-3s %-15s %-2s %n",
                    "| ", i ," | ", lKunde.gibKundennummer() , " | " ,  lKunde.gibName() , " | " , lKunde.gibAdresse() , " | " , lKunde.gibOffenerBetrag(), " |");
        }
        if(zKundenanzahl == 0) System.out.println("Es gibt noch keine Kunden");
        System.out.println();
    }

    public void gibAlleMedienAus(){
        System.out.println();
        System.out.printf("%-2s %-5s %-3s %-6s %-3s %-5s %-3s %-20s %-3s %-5s %-3s %-6s %-3s %-4s %-3s %-10s %-3s %-6s %-3s %-15s %-3s %-17s %-2s  %n", "| " , "Index" , " | ",  "Medium" , " | ",  "Code" , " | " , "Titel" , " | "  , "Preis" , " | "  , "Regal" , " | "  , "Jahr" , " | "  , "Genre" , " | "  , "Leange" , " | "  , "Autor" , " | "  , "ISBN"  , " | " );
        lineBreak(155);
        Film lFilm = null;
        Buch lBuch = null;
        for(int i = 0; i<zMedienanzahl; i++){
            if(zMedien[i] instanceof Film){
                lFilm = (Film) zMedien[i];
                System.out.format("%-2s %-5s %-3s %-6s %-3s %-5s %-3s %-20s %-3s %-5s %-3s %-6s %-3s %-4s %-3s %-10s %-3s %-6s %-3s %-15s %-3s %-17s %-2s  %n",
                        "| " , i , " | ", "Film" , " | ", lFilm.gibCode() , " | ", lFilm.gibTitel(), " | ", lFilm.gibPreis() , " | ",  lFilm.gibRegal() , " | ", lFilm.gibJahr(), " | ", lFilm.gibGenre() , " | " , lFilm.gibLeange() , " | ",  "-" , " | ", "-" , " |");
            }
            else{
                lBuch = (Buch) zMedien [i];
                System.out.format("%-2s %-5s %-3s %-6s %-3s %-5s %-3s %-20s %-3s %-5s %-3s %-6s %-3s %-4s %-3s %-10s %-3s %-6s %-3s %-15s %-3s %-17s %-2s  %n",
                        "| " , i , " | ", "Buch" , " | ", lBuch.gibCode() , " | ", lBuch.gibTitel(), " | ", lBuch.gibPreis() , " | ",  lBuch.gibRegal() , " | ", lBuch.gibJahr(), " | ", "-" , " | " , "-" , " | ",  lBuch.gibAutor() , " | ", lBuch.gibISBN() , " |");
            }
        }
        System.out.println();

    }

    public void gibKundenAus(int pKundennummer){
        Kunde lKunde = zKunden[sucheKunden(pKundennummer)];
        System.out.println();
        System.out.printf("%-2s %-12s %-3s %-20s %-3s %-20s %-3s %-15s %-2s %n", "| " , "Kundennummer", " | " , "Name", " | " , "Adresse", " | " , "Rechnungsbetrag" , " |");
        lineBreak(87);
        System.out.format("%-2s %-12s %-3s %-20s %-3s %-20s %-3s %-15s %-2s %n",
                "| ", lKunde.gibKundennummer() , " | " ,  lKunde.gibName() , " | " , lKunde.gibAdresse() , " | " , lKunde.gibOffenerBetrag(), " |");
    }

    public void gibMedienAus(int pJahr1, int pJahr2){

    }

    public boolean loescheKunde(int pKundennummer){
        Kunde lKunde = gibKunden(pKundennummer);
        if(lKunde== null)return false;
        String lName = zKunden[sucheKunden(pKundennummer)].gibName();
        for(int i = sucheKunden(pKundennummer); i<zKundenanzahl; i++)zKunden [i] = zKunden [i+1];
        zKundenanzahl--;
        System.out.println("\n[Kunde] " + lName + " wurde gelöscht");
        return true;
    }

    public boolean loescheMedium(int pCode){
        if(!istMediumvorhanden(pCode))return false;
        for(int i = sucheMedium(pCode); i<zMedienanzahl; i++) zMedien [i] = zMedien [i+1];
        zMedienanzahl--;
        System.out.println("\nMedium: " +  pCode + " wurde gelöscht");
        return true;
    }

    public boolean nimmBuchAuf(int pCode, double pPreis, int pJahr, String pRegal, String pTitel, String pAutor, String pISBN){
        if(istMediumvorhanden(pCode))return false;
        Buch lBuch = new Buch(pCode, pPreis, pJahr, pRegal, pTitel, pAutor, pISBN);
        zMedien [zMedienanzahl] = lBuch;
        zMedienanzahl++;
        System.out.println("\n[Buch] " + pTitel + " wurde angelegt");
        return true;
    }

    public boolean nimmFilmAuf(int pCode, double pPreis, int pJahr, String pRegal, String pTitel ,int pLeange,String pGenre){
        if(istMediumvorhanden(pCode))return false;
        Film lFilm = new Film(pCode, pPreis, pJahr, pRegal, pTitel, pLeange, pGenre);
        zMedien [zMedienanzahl] = lFilm;
        zMedienanzahl++;
        System.out.println("\n[Film] " + pTitel + " wurde angelegt");
        return true;
    }

    public boolean nimmKundenAuf(String pName, String pAdresse){
        if(istKundeVorhanden(pName)){
            System.out.println("\n{Error} " + pName + " ist schon vorhanden und konnte nicht angelegt werden");
            return false;
        }
        zKunden [zKundenanzahl] = new Kunde(pName, ( zKundenanzahl + 1000), pAdresse);
        zKundenanzahl++;
        System.out.println("\n[Kunde] "+ pName + " wurde angelegt");
        return true;
    }

    /* -------------------------------------- */
    /* Verleih                                */
    /* -------------------------------------- */

//    TODO
//     -Datum Richtig formatieren
//     -Suchen Methode austauschen


    public boolean verleihen(int pKundennummer, int pMediencode){
        if(istKundeVorhanden(pKundennummer)){
            System.out.println("\n{Error} Es konnte kein Kunden mit der Kundennummer: " + pKundennummer + " gefunden werden");
            return false;
        }
        if(!istMediumvorhanden(pMediencode)){
            System.out.println("\n{Error} Es konnte kein Medium mit dem Mediumcode: " + pMediencode + " gefunden werden");
            return false;
        }
        zAusleihe [zAusleihanzahl] = new Leihbeziehung( zKunden[sucheKunden(pKundennummer)] , zMedien[sucheMedium(pMediencode)], (new GregorianCalendar().getTimeInMillis()));
        zAusleihanzahl++;
        System.out.println("\n[Verleih] Der/Die Kunde(in) " + zKunden[sucheKunden(pKundennummer)].gibName() + " leiht jetzt das Medium mit dem Titel " + zMedien[sucheMedium(pMediencode)].gibTitel());
        return true;
    }

    public boolean zahleEin(int pKundennummer, double pBetrag){
        if(gibKunden(pKundennummer) != null || (gibKunden(pKundennummer).gibOffenerBetrag()-pBetrag) > 0){
            gibKunden(pKundennummer).RechnungBegleichen(pBetrag);
            return true;
        }
        return false;
    }

    public int werLeiht(int pMediencode){
        for(int i = 0; i < zAusleihanzahl; i++){
            if (zAusleihe[i].gibMediencode()==pMediencode){
                return  zAusleihe[i].gibKundennummer();
            }
        }
        return -1;
    }

//  TODO Ausleihpreis wird  falsch gesetzt

    public boolean zurückgeben(int pMediencode){
        if(!istMediumvorhanden(pMediencode)){
            System.out.println("\n{Error} Das Medium konnte nicht gefunden werden");
            return false;
        }
        if(werLeiht(pMediencode) == -1){
            System.out.println("\n{Error} Das Medium wird noch nicht ausgeliehen");
            return false;
        }
        int lMediumIdx = sucheMedium(pMediencode);
        String lTitle = zMedien[lMediumIdx].gibTitel();
        zKunden[sucheKunden(werLeiht(pMediencode))].neueRechnungAnschreiben(zMedien[lMediumIdx].gibPreis());
        for(int i = 0; i>zAusleihanzahl; i++){
            zAusleihe[i] = zAusleihe [i+1];
        }
        zAusleihanzahl--;
        System.out.println("\n[Medium] " + lTitle + " wurde wieder zurückgegeben");
        return true;
    }

    public void liesAusleihvorgaengeEin(){
        try {
            BufferedReader lLeser = new BufferedReader(new FileReader("./sample/stock/ausleihe.csv"));
            String lZeile = "";
            Kunde lKunde;
            while ((lZeile = lLeser.readLine()) != null) {
                String[] lArray = lZeile.split(";");
                if(gibKunden(Integer.getInteger(lArray[1])) != null){
                    if(gibMedium(Integer.getInteger(lArray[2])) != null){

                    }
                }else{
                    System.out.println("{Error} Kunde mit der Nummer " + lArray[1] + " konnte nicht gefunden werden");
                }
            }
        }
        catch(Exception e){
                System.out.println("{Error} Datei konnte nicht angelegt werden");
                System.out.println("{Debug}" + e);
        }
    }

    public void liesKundendatenEin(){

    }

    public void liesMediendatenEin(){

    }

    public void speichereAusleihen(){
        try {
            FileWriter fileWriter = new FileWriter("./src/sample/stock/ausleihe.csv");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            String fileContent = "Index;Kundenname;Mediumtitel;Leihgebühr;Ausleihdatum\n";

            Leihbeziehung lLB = null;
            for(int i=0; i<zAusleihanzahl;i++){
                lLB = zAusleihe[i];
                fileContent = fileContent + i + ";" + lLB.gibKunde().gibKundennummer() + ";" + lLB.gibMedium().gibTitel() + ";" + lLB.gibAktulleLeihgebuehr() + ";" + lLB.gibAusleihdatumFormatiert() + "\n";
            }
            printWriter.print(fileContent);
            printWriter.close();
            System.out.println("[Explorer] Datei wurde angelegt");
        }catch (Exception e){
            System.out.println("{Error} Datei konnte nicht angelegt werden");
        }
    }

    public void speichereKundendaten(){
        try {
            FileWriter fileWriter = new FileWriter("./src/sample/stock/kunden.csv");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            String fileContent = "Index;Kudennummer;Name;Adresse;Rechnungsbetrag\n";
            Kunde lKunde;
            for(int i=0; i<zKundenanzahl;i++){
                lKunde = zKunden[i];
                fileContent = fileContent + i + ";" + lKunde.gibKundennummer() + ";" + lKunde.gibName() + ";" + lKunde.gibAdresse() + ";" + lKunde.gibOffenerBetrag() + "\n";
            }
            printWriter.print(fileContent);
            printWriter.close();
            System.out.println("[Explorer] Datei wurde aktualisiert");
        }catch (Exception e){
            System.out.println("{Error} Datei konnte nicht angelegt werden");
        }
    }

    public void speichereMediendaten(){
        try {
            FileWriter fileWriter = new FileWriter("./src/sample/stock/medien.csv");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            String fileContent = "Index;Code;Titel;Preis;Regal;Jahr;Genre;Leange;Autor;ISBN\n";
            Buch lBuch = null;
            Film lFilm = null;
            for(int i=0; i<zMedienanzahl;i++){
                if(zMedien[i] instanceof Film){
                    lFilm = (Film) zMedien[i];

                    fileContent = fileContent + i + ";" + lFilm.gibCode() + ";" + lFilm.gibTitel() + ";" + lFilm.gibPreis() + ";" + lFilm.gibRegal() + ";" + lFilm.gibJahr()  + ";" + lFilm.gibGenre() + ";" + lFilm.gibLeange() + "\n";

                }
                if(zMedien[i] instanceof Buch){
                    lBuch = (Buch) zMedien[i];
                    fileContent = fileContent + i + ";" + lBuch.gibCode() + ";" + lBuch.gibTitel() + ";" + lBuch.gibPreis() + ";" + lBuch.gibRegal() + ";" + lBuch.gibJahr()  + ";;;" + lBuch.gibAutor() + ";" + lBuch.gibISBN() + "\n";
                }
            }
            printWriter.print(fileContent);
            printWriter.close();
            System.out.println("[Explorer] Datei wurde aktualisiert");
        }catch (Exception e){
            System.out.println(e);
            System.out.println("{Error} Datei konnte nicht angelegt werden");
        }
    }

    public Kunde gibKunden(int pKundennummer){
        for(int i = 0; i<zKundenanzahl; i++)
            if(zKunden[i].gibKundennummer() == pKundennummer)
                return zKunden[i];
        return null;
    }

    public Medium gibMedium(int pCode){
        for(int i = 0; i<zKundenanzahl; i++)
            if(zMedien[i].gibCode() == pCode)
                return zMedien[i];
        return null;
    }

//  Zusatzmethoden
    private int sucheMedium(int pCode){
        for(int i = 0; i<zMedienanzahl; i++)
            if(zMedien[i].gibCode() == pCode)
                return i;
        return -1;
    }

    private boolean istMediumvorhanden(int pCode) {
        for(int i = 0; i<zMedienanzahl; i++)
            if(zMedien[i].gibCode() == pCode)
                return true;
        return false;
    }

    public int sucheKunden(String pName){
        for(int i = 0; i<zKundenanzahl; i++)
            if(zKunden[i].gibName().equals(pName))
                return i;
        return -1;
    }

    public int sucheKunden(int pKundennummer){
        for(int i = 0; i<zKundenanzahl; i++)
            if(zKunden[i].gibKundennummer() == (pKundennummer))
                return i;
        return -1;
    }

    private boolean istKundeVorhanden(String pName){
        for(int i = 0; i<zKundenanzahl; i++)
            if(zKunden[i].gibName().equals(pName))
                return true;
            return false;
    }

    private boolean istKundeVorhanden(int pKundennummer){
        if(zKunden[sucheKunden(pKundennummer)] == null )return false;
        return true;
    }

    private void lineBreak(int pLaenge){
        for(int i =0; i<pLaenge; i++){
            System.out.print("═");
        }
        System.out.println();
    }



    public boolean verleihen(int pKundennummer, int pMediencode, int pZeitdifferenz){
        if(!istKundeVorhanden(pKundennummer)){
            System.out.println("\n{Error} Es konnte kein Kunden mit der Kundennummer: " + pKundennummer + " gefunden werden");
            return false;
        }
        if(!istMediumvorhanden(pMediencode)){
            System.out.println("\n{Error} Es konnte kein Medium mit dem Mediumcode: " + pMediencode + " gefunden werden");
            return false;
        }
        zAusleihe [zAusleihanzahl] = new Leihbeziehung( zKunden[sucheKunden(pKundennummer)] , zMedien[sucheMedium(pMediencode)], new GregorianCalendar().getTimeInMillis() -pZeitdifferenz);
        zAusleihanzahl++;
        System.out.println("\n[Verleih] Der/Die Kunde(in) " + zKunden[sucheKunden(pKundennummer)].gibName() + " leiht jetzt das Medium mit dem Titel " + zMedien[sucheMedium(pMediencode)].gibTitel());
        return true;
    }

//    Konsolen User Interface

    public void starteInterface(){
        boolean run = true;
        String Befehl;
        while (run){
            Befehl = sInput("Dein Befehl:");
            Befehl = Befehl.toLowerCase();
            switch(Befehl){
                case "kl":
                case "kundenliste": gibAlleKundenAus(); break;
//                case "speicherkunden": speichereKundendaten();break;
                case "+kunde":
                case "neuer kunde": nimmKundenAufKonsole(); break;
                case "-kunde":
                case "loesche kunde": loescheKundeKonsole(); break;
                case "ml":
                case "medienliste": gibAlleMedienAus(); break;
                case "sm":
                case "speichere medium": speichereMediendaten();break;
                case "aa": liesAusleihvorgaengeEin();break;
                case "+medium":
                case "neues medium": nimmMediumAufKonsole(); break;
                case "-medium":
                case "loesche Medium": loescheMediumKonsole();break;
                case "al":
                case "ausleihliste": gibAlleAusleihenAus(); break;
                case "verleihen": verleihenKonsole();break;
                case "hilfe": hilfeUI(); break;
//                case "sausleihe": speichereAusleihen();break;
                case "stop":
                case "e":
                case "exit":
                    run = false;
                    System.out.println("- Das Konsolen Interface wurde beendet -");
                    break;

                default: System.out.println("{Error} Der Befehl konnte nicht gefunden weden. Gib \"hilfe\" ein um eine Liste von Befehlen zu erhalten");
            }
        }
    }

    private void nimmKundenAufKonsole(){
        String lKunden = sInput("Kundenname:");
        String lAdresse = sInput("Adresse:");
        nimmKundenAuf(lKunden, lAdresse);
    }

    private void loescheKundeKonsole(){
        loescheKunde(iInput("Kundennummer des zu loeschenden Kunden"));
    }

    private void nimmMediumAufKonsole(){
        int lCode;
        double lPreis;
        int lJahr;
        String lRegal;
        String lTitel;
        String lAutor;
        String lISBN;
        int lLeange;
        String lGenre;
        String lSchauspieler;
        boolean listBuch = false;
        boolean listFilm = false;
        boolean lWeiterenSchauspieler;

        while(!listBuch && !listFilm){
            String lFrage = sInput("Buch oder Film").toLowerCase();
            switch(lFrage){
                case "buch": listBuch = true;break;
                case "film": listFilm = true;break;
                default: System.out.println("Bitte entweder Buch oder Film auswaehlen");
            }
        }

        lTitel = sInput("Titel:");
        lCode = iInput("Code:");
        lPreis = dInput("Preis:");
        lJahr = 1001;
        do{
            if(lJahr != 1001) System.out.println("Bitte ein gueltiges Jahr eingeben");
            lJahr = iInput("Jahr:");
        }while (lJahr<1000 && lJahr<2500);
        lRegal = sInput("Regal:");

        if(listBuch){
            lAutor = sInput("Autor:");
            lISBN = sInput("ISBN:");
            nimmBuchAuf(lCode,lPreis,lJahr,lRegal,lTitel,lAutor,lISBN);
        }
        if(listFilm){
            lLeange = iInput("Laenge:");
            lGenre = sInput("Genre:");
            nimmFilmAuf(lCode,lPreis,lJahr,lRegal,lTitel,lLeange,lGenre);
        }
    }

    private void loescheMediumKonsole(){
        loescheMedium(iInput("Mediumcode des zu loeschenden Medium:"));
    }

    private void verleihenKonsole(){
        verleihen(iInput("Kundennummer:"),iInput("Mediumcode:"));
    }

    private void hilfeUI(){
        System.out.println("Noch nicht verfügbar");
    }
}
