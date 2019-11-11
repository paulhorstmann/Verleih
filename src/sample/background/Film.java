package sample.background;

public class Film extends Medium {
    private int zLeange;
    private String zGenre;
    private int zSchauspieleranzahl;
    private String[] zSchauspieler = new String[50];

    public Film(int pCode, double pPreis, int pJahr, String pRegal, String pTitel ,int pLeange,String pGenre){
        super(pCode,pPreis,pJahr,pRegal,pTitel);
        zLeange = pLeange;
        zGenre = pGenre;
    }

    public void ergaenzeSchauspieler(String pName){
        for(int i=0; i<zSchauspieler.length; i++){
            if(zSchauspieler[i].equals(pName))return;
            if(zSchauspieler[i]==null){
                zSchauspieler[i] = pName;
                return;
            }
        }
    }

    public void gibAllesAufKonsoleAus(){
        System.out.print("[ Film ] Titel: " + zTitel + " | Code:" + zCode + " | Preis: " + zPreis + "Euro | Regal: " + zRegal + " | Jahr: " + zJahr + " | Genre: " + zGenre + " | Leange: " + zLeange + " | Die/Der Schauspieler(in): ");
        for(int i=0; i<zSchauspieler.length; i++){
            if(zSchauspieler[i]!=null){
                System.out.print(zSchauspieler[i] + ", ");
            }
        }
        System.out.println();
    }

    public String gibGenre(){
        return zGenre;
    }

    public int gibLeange(){
        return zLeange;
    }

    public String[] gibSchuaspieler(){
        return zSchauspieler;
    }
}
