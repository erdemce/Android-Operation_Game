package erdem.android.mathe;

import java.util.Random;

import erdem.android.mathe.Fragenart;

public class Frage {

    private String text_Frage;
    private int antwort;
    private Fragenart art;
    private int schwerigkeit;

    public Frage(Fragenart art,int schwerigkeit){
        this.art=art;
        this.schwerigkeit=schwerigkeit;
        if(art.ordinal()==0){bauenAddition(schwerigkeit);}
        if(art.ordinal()==1){bauenSubtraktion(schwerigkeit);}
        if(art.ordinal()==2){bauenMultiplikation(schwerigkeit);}
        if(art.ordinal()==3){bauenDivision(schwerigkeit);}
    }

    public void bauenAddition(int schwerigkeit){
        int a=51;
        if(schwerigkeit==2){
            a=501;
        }
        else if(schwerigkeit==3){
            a=5001;
        }
        Random rndm=new Random();
        int erst=rndm.nextInt(a);
        int zweit=rndm.nextInt(a);
        this.text_Frage=" "+erst+" + "+zweit+" = ";
        this.antwort=erst+zweit;
    }

    public void bauenSubtraktion(int schwerigkeit){
        int a=51;
        if(schwerigkeit==2){
            a=501;
        }
        else if(schwerigkeit==3){
            a=5001;
        }
        Random rndm=new Random();
        int erst=rndm.nextInt(a);
        int zweit=erst+rndm.nextInt(a);
        this.text_Frage=" "+zweit+" - "+erst+" = ";
        this.antwort=zweit-erst;
    }

    public void bauenMultiplikation(int schwerigkeit){
        int a=11;
        int b=11;
        if(schwerigkeit>=2){
            a=101;
        }
        if(schwerigkeit==3){
            b=101;
        }
        Random rndm=new Random();
        int erst=rndm.nextInt(a);
        int zweit=rndm.nextInt(b);
        this.text_Frage=" "+erst+" X "+zweit+" = ";
        this.antwort=erst*zweit;
    }

    public void bauenDivision(int schwerigkeit){
        int a=10;
        int b=11;
        if(schwerigkeit>=2){
            a=100;
        }
        if(schwerigkeit==3){
            b=101;
        }
        Random rndm=new Random();
        int erst=rndm.nextInt(a)+1;
        int zweit=erst*rndm.nextInt(b);
        this.text_Frage=" "+zweit+" : "+erst+" = ";
        this.antwort=zweit/erst;
    }

    public String getText_Frage() {
        return text_Frage;
    }

    public int getAntwort() {
        return antwort;
    }

    public Fragenart getArt() {
        return art;
    }

    public int getSchwerigkeit() {
        return schwerigkeit;
    }
}
