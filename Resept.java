public class Resept {
   
    int reseptUnikNo;
    String farge; // Blaa er gratis
    int pernumber; 
    String legename;
    int legemidnumber;
    int reit;
    private Legemiddel lmpeker;
    
        Resept(int reseptUnikNo,int pernumber, String legename, int legemidnumber, int reit){
        this.reseptUnikNo = reseptUnikNo;
        this.pernumber=pernumber;
        this.legename=legename;
        this.legemidnumber=legemidnumber;
        this.reit=reit;
    }
    public void printAll() {

        System.out.println("Resept er skrevet ut av lege "+legename);
        System.out.println("Reiten igjen er: "+reit+" og fargen er "+farge);
        
    }
    public void useReit() {
        reit--;
    }
    public int getReit() {
        return reit;
    }
    public int getLegeMNo() {
        return legemidnumber;
    }
    public int getpersMNo() {
        return pernumber;
    }
    public String getFarge() {
        return farge;
    }
    public String getName() {
        return legename;
    }



    public void skrivUtResept() {System.out.println(reseptUnikNo+ " "+" "+ pernumber+" "+legename+" "+ legemidnumber+" "+reit);}
    
    public int hentResept(){return reseptUnikNo;}


}