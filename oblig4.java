
import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.lang.NumberFormatException;
import java.util.Iterator;
import java.util.NoSuchElementException;
class Oblig4 {
    @SuppressWarnings("unchecked") 
	public static void main (String args []) throws FileNotFoundException {
        Read rd = new Read();
        rd.readFile();  // read from the file.
        rd.menu(); // show the menu
        
    }
} // end of Oblig4




interface Piller {
public int antallstorrelse();

}

interface Injeksjon {
public int antallstorrelse ();
}

interface Liniment{
public int antallstorrelse();
}


abstract class Legemiddel  {
String navn;
int pris;
int unikNo; 
String LegemiddelNavn;
   
   Legemiddel ( String LegemiddelNavn, int unikNo, int pris ) {
        
         this.LegemiddelNavn= LegemiddelNavn;
         this.unikNo = unikNo;
         this.pris = pris;
         
    }
    public void skrivUtLegemiddler() {
        
        System.out.println( unikNo + " " + LegemiddelNavn +" " + " "+ pris);
    } 
    public String legeMName(){
        return LegemiddelNavn;
    }
    public String legeMForm(){
       return null;

    }
    public String legeMType(){
        return null;
    }


    public int legeMPris(){
        return pris;
    }

    public int antallstorrelse(){
        return 0;
    }


}

abstract class Narkotisk extends  Legemiddel  { // CLASS TYPE A
    int sterkNo;
    
    

    Narkotisk (  String LegemiddelNavn, int unikNo, int pris, int sterkNo){
        super(LegemiddelNavn,unikNo,pris);
        this.sterkNo = sterkNo;

       
    }
}

class NarkotiskInjekksjon extends Narkotisk implements Injeksjon {
    int hvorMye;
    final String form;
    String type;
    
    
    NarkotiskInjekksjon (  String LegemiddelNavn, int unikNo, int pris, int sterkNo, int hvorMye){
        super(LegemiddelNavn,unikNo,pris, sterkNo);
        this.hvorMye = hvorMye;
        form = " injeksjon";
        
         
    }
    

    public void skrivUtLegemiddler() {
        if (this instanceof Narkotisk) {
            type = "a";
        }
    System.out.println( unikNo + " " + LegemiddelNavn + " "+ form +" " + type + " "+ pris +" "+ hvorMye +" "+sterkNo);
    } 

    public int antallstorrelse (){return hvorMye;}
    public String legeMForm(){
        return form;
    }

}

class NarkotiskPiller extends Narkotisk implements Piller {
    int antallPill;
    final String form;
    String type;
    
    NarkotiskPiller (String LegemiddelNavn, int unikNo, int pris, int sterkNo, int antallPill){
         super(LegemiddelNavn,unikNo,pris, sterkNo);
         
         this.antallPill = antallPill;
         form = "pille";
         
    }
   public void skrivUtLegemiddler() {
    if (this instanceof Narkotisk) {
            type = "a";
        }
        System.out.println( unikNo + " " + LegemiddelNavn + " "+ form +" " + type + " "+ pris +" "+ antallPill +" "+sterkNo);
    }
    public int antallstorrelse(){
        return antallPill;
    }
    public String legeMForm(){
        return form;
    }

}

class NarkotiskLiniment extends Narkotisk implements Liniment {

    int hvorMange;
    final String form;
    String type;
   
    NarkotiskLiniment ( String LegemiddelNavn, int unikNo, int pris, int sterkNo, int hvorMange ){
        super(LegemiddelNavn,unikNo,pris, sterkNo);
        this. hvorMange = hvorMange;
        form = "liniment";
        
    }
    public void skrivUtLegemiddler() {
    if (this instanceof Narkotisk) {
            type = "a";
        }
        System.out.println( unikNo + " " + LegemiddelNavn + " "+ form +" " + type + " "+ pris +" "+ hvorMange +" "+sterkNo);
    }
    public int antallstorrelse(){ return hvorMange;}
    public String legeMForm(){
        return form;
    }

}



abstract class Vannedanende extends  Legemiddel{ // CLASS TYPE B
    
    int vanneNo;
   Vannedanende (  String LegemiddelNavn, int unikNo, int pris, int vanneNo){
        super(LegemiddelNavn,unikNo,pris);
        this.vanneNo = vanneNo;
    }
}


class VannedanendePiller extends Vannedanende implements Piller{
    int antallPill;
    final String form;
    String type;
    VannedanendePiller ( String LegemiddelNavn, int unikNo, int pris, int vanneNo, int antallPill){
        super(LegemiddelNavn,unikNo,pris, vanneNo);
        this.antallPill = antallPill;
        form = "pille";
    }
    public void skrivUtLegemiddler() {
        if (this instanceof Vannedanende) {
            type = "b";
        }
    System.out.println( unikNo + " " + LegemiddelNavn + " "+ form +" " + type + " "+ pris +" "+ antallPill +" "+vanneNo);
    }

    public int antallstorrelse(){return antallPill;}

    public String legeMForm(){
        return form;
    }

}


class VannedanendeInjeksjon extends Vannedanende implements Injeksjon{

    int hvorMye;
    final String form;
    String type;

    VannedanendeInjeksjon (String LegemiddelNavn, int unikNo, int pris, int vanneNo, int hvorMye){
        super(LegemiddelNavn,unikNo,pris, vanneNo);
        this.hvorMye = hvorMye;
        form = "injeksjon";
    }
    public void skrivUtLegemiddler() {
        if (this instanceof Vannedanende) {
            type = "b";
        }
        System.out.println( unikNo + " " + LegemiddelNavn + " "+ form +" " + type + " "+ pris +" "+ vanneNo +" "+hvorMye);
    }
    public int antallstorrelse (){ return hvorMye;}
    
    public String legeMForm(){
        return form;
    }

}

class VannedanendeLiniment extends Vannedanende implements Liniment {
    int hvorMange;
    final String form;
    String type;
    VannedanendeLiniment ( String LegemiddelNavn, int unikNo, int pris, int vanneNo, int hvorMange ){
        super(LegemiddelNavn,unikNo,pris, vanneNo);
        this.hvorMange= hvorMange;
        form = "liniment";
    }

    public void skrivUtLegemiddler() {
        if (this instanceof Vannedanende) {
            type = "b";
        }
        System.out.println( unikNo + " " + LegemiddelNavn + " "+ form +" " + type + " "+ pris +" "+ vanneNo +" "+hvorMange);
    }

    public int antallstorrelse(){return hvorMange;}
   
    public String legeMForm(){
        return form;
    }

}


abstract class Vanlige extends  Legemiddel{  // CLASS TYPE C

    Vanlige ( String LegemiddelNavn, int unikNo, int pris){
        super(LegemiddelNavn,unikNo,pris);
    }
    
}

class VanligePiller extends Vanlige implements Piller {
    int antallPill;
    final String form;
    String type;
VanligePiller (String LegemiddelNavn, int unikNo, int pris, int antallPill){
    super(LegemiddelNavn,unikNo,pris);
    this.antallPill = antallPill;
    form = "pille";
    }
    public void skrivUtLegemiddler() {
        if (this instanceof Vanlige) {
            type = "c";
        }
    System.out.println( unikNo + " " + LegemiddelNavn + " "+ form +" " + type + " "+ pris +" "+ antallPill);
    }

    public int antallstorrelse(){return antallPill;}
    public String legeMForm(){
        return form;
    }

}

class VanligeInjeksjon extends Vanlige implements Injeksjon {
    int hvorMye;
    final String form;
    String type;
    VanligeInjeksjon (String LegemiddelNavn, int unikNo, int pris, int hvorMye ){
    super(LegemiddelNavn,unikNo,pris);
    this.hvorMye = hvorMye;
    form = "injeksjon";
    }
    public void skrivUtLegemiddler() {
        if (this instanceof Vanlige) {
            type = "c";
        }
    System.out.println( unikNo + " " + LegemiddelNavn + " "+ form +" " + type + " "+ pris +" "+ hvorMye);
    }
    public int antallstorrelse (){return hvorMye;}
    public String legeMForm(){
        return form;
    }

}

class VanligeLiniment extends Vanlige implements Liniment {
    int hvorMange;
    final String form;
    String type;
VanligeLiniment (String LegemiddelNavn, int unikNo, int pris, int hvorMange ){
        super(LegemiddelNavn,unikNo,pris);
        this.hvorMange = hvorMange;
        form = "liniment";
    }
    public void skrivUtLegemiddler() {
        if (this instanceof Vanlige) {
            type = "c";
        }
    System.out.println( unikNo + " " + LegemiddelNavn + " "+ form +" " + type + " "+ pris +" "+ hvorMange);
    }
    public int antallstorrelse(){ return hvorMange;}
    public String legeMForm(){
        //return type;
        return form;
    }

} // END OF LEGEMIDDEL AND ITS SUBCLASSES




 // end of class Respt

class BlaResept extends Resept {
    String farge;

    BlaResept(int reseptUnikNo,int pernumber, String legename, int legemidnumber, int reit){
        super(reseptUnikNo, pernumber, legename, legemidnumber, reit);
        }
        
        public void printAll() {
            if (this instanceof BlaResept) {
            farge = "b";
            }

        System.out.println("Resept er skrevet ut av lege "+legename);
        System.out.println("Reiten igjen er: "+reit+" og fargen er "+farge);
        
    }
    
}
class HvitResept extends Resept {
    String farge;
    HvitResept(int reseptUnikNo, int pernumber, String legename, int legemidnumber, int reit){
        super(reseptUnikNo, pernumber, legename, legemidnumber, reit);
    }
         public void printAll() {

        if (this instanceof HvitResept) {
            farge = "h";
        }

        System.out.println("Resept er skrevet ut av lege "+legename);
        System.out.println("Reiten igjen er: "+reit+" og fargen er "+farge);
        
    }
        

}

interface legeAvtale {
   public int checkAvtale ();
    
}
interface Lik {
    
    public boolean samme( String s);
    
    
}

// class Leger
class Leger implements  Comparable<Leger>, Lik, legeAvtale {
	public String unikNavn;
    int anumber;
    int snumber;
   public Leger next;
   EldsteForstReseptListe legResBeholder = new EldsteForstReseptListe  ();
   

    Leger(String unikNavn, int snumber, int anumber){
        this.unikNavn = unikNavn;
        this.snumber=snumber;
        this.anumber=anumber;
        }

   
    public String finneNavn(){return unikNavn; }


    public void skrivUt() {System.out.println( unikNavn+ "\t"+snumber+ "\t"+anumber);}

    public boolean samme(String s) {
        if(unikNavn.equals(s))
        return true;
        else 
        return false;

    } 


    public int checkAvtale(){
    return anumber;

    }

    public int compareTo(Leger d){
        return (this.unikNavn).compareTo(d.unikNavn);
    }
    
} // end of class Leger


class SpesialistLeger extends Leger  {
   // int snumber;
    SpesialistLeger (String unikNavn, int snumber, int anumber){
        super (unikNavn,snumber, anumber);
        
    }

}


// class Person
class Person {
	String navn;
	int personUniktNo;
    String gender;
    YngsteForstReseptListe  persResBeholder = new YngsteForstReseptListe ();
   
    Person(int personUniktNo, String navn, String gender){
        this.personUniktNo = personUniktNo;
        this.navn = navn;
        this.gender=gender;
    }
    public void skrivUtPerson() {System.out.println(personUniktNo +"\t" +navn + "\t" + gender);}

    public int finnPersonNo() { return personUniktNo;}
    public String finnPersonName(){ return navn;}
    public String finnPersonKjonn(){ return gender;}




} // end of the class Person


interface  AbsraktTabell <T > {
     public boolean settIn(int index, T t);
    
    T findObjekt (int index);
    public Iterator <T> iterator ();
   
    }

// class Tabell
class Tabell <T> implements AbsraktTabell  <T>   {

    int index;
    int lengde;
    private T[] elements;

    Tabell( int lengde) {
    elements = (T[])new Object [lengde];
    }
    
    public boolean settIn( int index, T t ){ // adding object based on the specified index
        if(elements.length > index) {
            
        elements[index] = t; 
        return true; 

        } else {

             return false;
         }

    }
    
    
    public T findObjekt (int index ) { // find object based on the specified index
         return elements [index];
    }
     @Override 
    public Iterator <T> iterator ( ) {
        return new ItarateTabell ();
        
    }
    

    private class ItarateTabell implements Iterator <T> { // iterator
        private int i = 0;
        private ItarateTabell () {
            while (i < elements.length && elements [i]== null) {
                i++;
            }
        }
        
    @Override 
    public boolean hasNext (){
        return i<elements.length;
    }
    @Override 
    public T next (){
        if(i < elements.length){
            T n = elements[i];
            do {
                i++;
            } 
            while (i < elements.length && elements [i]== null);
            return n;

        } else {
            throw new NoSuchElementException();
        }
    }

    @Override 
    public void remove () {
        throw new UnsupportedOperationException("Invalid operation for sorted list.");
        }

    } 
   // @SuppressWarnings ("unchecked")

} // End of class Tabell



interface AbstracktSortertEnkelListe <U> {

public void setteIn(U element);

public U finne(String s);

public Iterator <U> iterator ();

}


class SortertEnkelListe < U extends Comparable <U> & Lik > implements AbstracktSortertEnkelListe <U>, Iterable <U> {
    public Node foerste, siste;
    private int antall;
    
    SortertEnkelListe(){
    
    }
   
    private class Node {
     
    Node neste;
    Node forrige;
    U element;

    Node (U element) { 
        this.element = element; 
        }

    }

    public void setteIn (U element){  // adding the object to the beholder
        Node n = new Node(element);
           
        if(foerste==null){

        foerste = n;
        siste =n;
        }
        Node temp=foerste;

        if (temp.neste == null && temp.element.compareTo(element)<0){ // sette sist

            foerste.neste = n;
            siste =n;
           
         }

        else if (temp.element.compareTo(element) > 0){
        n.neste = foerste;
        foerste = n;

        }
        else {
        while(temp.neste!=null){
            if(temp.element.compareTo(element)<0 && temp.neste.element.compareTo(element)>0){
                n.neste = temp.neste;
                temp.neste =n;
                } else {
                    temp = temp.neste;
                }
        
            }
       
        }
        antall ++; 
        
    }



    
       
    public U finne(String s){ // find an object based on the given string 
        Node n = foerste;

    for (int i = antall; i>0; i--) {
        
        if (n.element.samme(s)) {
          return n.element;
        } else {
        n = n.neste;
        }   
    }
        return null;
    }

    @Override 
    public Iterator <U> iterator ( ) {
        return new Sortert ();
        
    }
    
    public class Sortert implements Iterator<U> { // Iterator
        Node temp;
        Sortert(){temp = foerste;}
        
        @Override 
        public boolean hasNext( ) {
            return temp != null;

            
        
        }
        @Override 
        public U next ( ) {
            
            U retur = temp.element;
            temp = temp.neste;
            return retur;
           
        }
        @Override 
        public void remove ( ){
          
        }
    }

} // end of SortertEnkelListe class


class EnkelReseptListe implements Iterable <Resept> {
    public Node foerste, siste;
    public int antall;
    
    EnkelReseptListe (){
    siste = foerste;

    }

    protected class Node { 
    int reseptNo;   
    Node neste;
    Resept t;

        Node (Resept t) { 
        this.t = t; 

            }
    
        }

	public void settInResept(Resept t) { // add Resept to the beholder
    Node n = new Node(t);
    if(foerste==null) {
        foerste = n;
        siste = n;
        }   else {
            n.neste = foerste;
            foerste = n;
        }
        
	}

	public Resept finne (int reseptNo ) { // find the resept based on the resept number
        Node n = foerste;
         while(n!=null){

            if(n.t.hentResept() == reseptNo){
            return n.t;
            } 
            else {
            n = n.neste;
            
            }
        }
        return null;

    }

    
    //@SuppressWarnings("unchecked") 
    @Override 
    public Iterator <Resept> iterator ( ) {
        return new Enkel();
        
    }
    
    protected class Enkel implements Iterator<Resept> {
        
        boolean check;
        Node temp;
        Enkel (){temp = foerste;}
        @Override 
        
        public boolean hasNext( ) {
           return temp != null;
            
        }
        @Override 
        public Resept next ( ) {
                if(temp!=null){
            Resept retur = temp.t;
           temp = temp.neste;
           
            return retur;
            }
            else {
                throw new NoSuchElementException(); 
            }
        }
        @Override 
        public void remove ( ){
            
            
        }
    }
} // end of EnkelReseptListe



class EldsteForstReseptListe extends EnkelReseptListe {
    // FIFO
	public void settInResept(Resept t) { // adds the leger respet
         Node n = new Node(t);

    if(foerste==null) {
        foerste = n;
        siste = n;
        }   else {
    siste.neste = n;
    siste = n;
       }
	}
       
} // end of EldsteForstReseptListe

class YngsteForstReseptListe  extends EnkelReseptListe {
	// add persons resepter as LIFO
   public void settInResept(Resept t) {
    Node n = new Node(t);
    if(foerste==null) {
        foerste = n;
        siste = n;
        }   else {
            n.neste = foerste;
            foerste = n;
        }
	}

} // End of YngsteForsteReseptListe
