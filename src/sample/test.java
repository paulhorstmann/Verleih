package sample;

import sample.background.Mediothek;

public class test {
    Mediothek nM = new Mediothek();
    public test(boolean pKunden , boolean pMedium , boolean pLeihbeziehung){

        if (pKunden){
            nM.nimmKundenAuf("Michael Fisher", "Eichendorffstr. 33");
            nM.nimmKundenAuf("Martina Drescher", "Ruschestrasse 36");
            nM.nimmKundenAuf("Kathrin Reinhardt", "Meininger Strasse 42");
            nM.nimmKundenAuf("Markus Burger", "Bleibtreustraße 74");
            nM.nimmKundenAuf("Laura Egger", "Mühlenstrasse 79");
            nM.nimmKundenAuf("Peter Kruger", "Gotzkowskystrasse 74");
            nM.nimmKundenAuf("Jens Frey", "Guentzelstrasse 30");
            nM.nimmKundenAuf("Jörg Aachen", "Hans-Grade-Allee 41");
            nM.nimmKundenAuf("Marie Theiss", "Gubener Str. 13");
            nM.nimmKundenAuf("Annett Maier", "Flotowstr. 79");
            nM.nimmKundenAuf("Juliane Schwarz", "Gotthardstrasse 61");
            nM.loescheKunde(1003);
            nM.gibAlleKundenAus();
        }

        if (pMedium){
            nM.nimmFilmAuf(8002, 0.5, 1994, "E34", "Die Verurteilten", 144, "Drama");
            nM.nimmBuchAuf(5045, 3.59 , 2000 , "B46", "Sophies Welt" , "Jostein Gaarder", "978-3423620000");
            nM.gibAlleMedienAus();
        }

        if(pLeihbeziehung){
            nM.verleihen(1002, 8002,12);
            nM.gibAlleAusleihenAus();
            nM.zurückgeben(8002);
            nM.gibAlleAusleihenAus();;
        }

        nM.gibAlleKundenAus();

        nM.starteInterface();
    }
}
