package sample.background;

import java.util.GregorianCalendar;

public class Leihbeziehung {
    Kunde zKunde;
    long zAusleihdatum;
    Medium zMedium;

    public Leihbeziehung(Kunde pKunde, Medium pMedium, long pAusleihdatum){
        zKunde = pKunde;
        zMedium = pMedium;
        zAusleihdatum = pAusleihdatum;
    }

    public double gibAllesAufKonsoleAus(){
        long lZeitdifferenz = (new GregorianCalendar()).getTimeInMillis()-zAusleihdatum;
        return zMedium.gibPreis() * lZeitdifferenz / (24*60*60*1000);
    }

    public double gibAktulleLeihgebuehr(){

    }

    public long gibAusleihdatum(){

    }

    public int gibKundennummer(){

    }

    public int gibMediencoce(){

    }
}
