package sample.background;
import java.util.GregorianCalendar;

public class Leihbeziehung {
    private Kunde zKunde;
    private long zAusleihdatum;
    private Medium zMedium;

    public Leihbeziehung(Kunde pKunde, Medium pMedium, long pAusleihdatum){
        zKunde = pKunde;
        zMedium = pMedium;
        zAusleihdatum = pAusleihdatum;
    }

    public void gibAllesAufKonsoleAus(){
        System.out.println("Kunde:" + zKunde.gibName());
        System.out.println("Medium: " + zMedium.gibTitel() + zMedium.gibCode());
        System.out.println("Ausgeliehen am " + zAusleihdatum + gibAusleihdatumFormatiert());
    }

    public double gibAktulleLeihgebuehr(){
        long lZeitdifferenz = (new GregorianCalendar().getTimeInMillis() -zAusleihdatum );
        return zMedium.gibPreis() * (lZeitdifferenz / (24*60*60*1000));
    }

    public long gibAusleihdatum(){
        return zAusleihdatum;
    }

    public String gibAusleihdatumFormatiert(){
        return String.valueOf(zAusleihdatum);
    }

    public int gibKundennummer(){
        return zKunde.gibKundennummer();
    }

    public int gibMediencode(){
        return zMedium.gibCode();
    }

//    Zusätzliche Hilfsmethoden (nicht in der Dukomentation)

    public Kunde gibKunde(){
        return zKunde;
    }

    public Medium gibMedium(){
        return zMedium;
    }
}
