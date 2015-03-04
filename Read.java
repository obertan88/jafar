public class Read { //
    
        // declaring all the beholder here.
    Tabell <Person> tabper = new Tabell <Person>(20);;
    Person person = null;
    YngsteForstReseptListe  persResBeholder = new YngsteForstReseptListe();
    EldsteForstReseptListe  legResBeholder = new EldsteForstReseptListe();
    Tabell <Legemiddel> tabLmiddel= new Tabell <Legemiddel>(100);
    Legemiddel lmiddler = null;
    SortertEnkelListe <Leger> legeBeholder = new SortertEnkelListe <Leger> ( );
    Leger leg = null;
    EnkelReseptListe reseptBeholder = new EnkelReseptListe ();
    Resept resept1 = null;
    //person variables
    int personUniktNo;
    String navn;
    String gender;
    int unique; // unik lopende nummer
    int pernumber;
    int personUnique; // person unique number to keep count on the new added person
    int reseptUnique; // keep count on the new added resept.
                          
    // reading from file

    public void readFile()  
    {  
           String[] tokens = null;
    
        try 
        {
            Scanner scan = new Scanner(new FileInputStream("data2.txt"), "UTF-8");
            while(scan.hasNextLine()) 

            {
             String stn = scan.nextLine();
             String stn2 = scan.nextLine();                
            
            if(stn.contains("#"))
            {
                int y = stn.indexOf('#');  // checking the indexes of bound
                int x = stn.indexOf('(');
                String ss = stn.substring(y+1, x-1);
                ss = ss.trim();
                if(ss.equals("Personer")) // check if ss is equal to person and then create and on object of person
                {
                   
                    for(int i=0; i<6; i++)
                    { 
                       
                        Scanner s = new Scanner(stn2).useDelimiter(",");
                        int personUniktNo = s.nextInt();
                        personUnique = personUniktNo; 
                        String navn = s.next();
                        String gender = s.next();

                        person = new Person (personUniktNo,navn,gender);
                        
                        tabper.settIn(personUniktNo, person); // adding to the Tabell <Person> 

                        
                        stn2 = scan.nextLine();
                         }
                         
                        personUnique ++;

                } 
                
                else if (ss.equals("Legemidler")) // check if ss is equal to legemidler and then create and on object of legemidler
                
                 {
                    for(int i=0; i<3; i++){ 
                        tokens = stn2.split(",");
                        int len = tokens.length;                       
                        Scanner s1 = new Scanner(stn2).useDelimiter(", ");
                       if(len == 7) // reading the line that contains 7 tokens

                       {

                            int unikNo = s1.nextInt();
                            unique=unikNo;
                            String LegemiddelNavn = s1.next();
                            String form = s1.next();
                            String type = s1.next();
                            int pris = s1.nextInt();
                            int antallPill = s1.nextInt();
                            int sterkNo = s1.nextInt();
                            
                            if(form.equals("pille") && type.equals("a")) // compare if the form and type and then create NarkotiskPiller: if the type is a
                            {
                            
                            lmiddler = new NarkotiskPiller(LegemiddelNavn, unikNo,pris, sterkNo,antallPill);
                            tabLmiddel.settIn(unikNo, lmiddler); 
                            
                            }

                            else if(form.equals("liniment") && type.equals("a"))
                            {
                               
                                lmiddler = new NarkotiskLiniment(LegemiddelNavn, unikNo,pris, sterkNo,antallPill); // create nakotisk liniment
                                tabLmiddel.settIn(unikNo, lmiddler); // adding to the beholder
                               

                            }
                            else if(form.equals("injeksjon") && type.equals("a")){
                                lmiddler = new NarkotiskInjekksjon (LegemiddelNavn, unikNo,pris, sterkNo,antallPill);
                                tabLmiddel.settIn(unikNo, lmiddler); 
                            } 
                            else if (form.equals("pille") && type.equals("b")){
                                lmiddler = new VannedanendePiller (LegemiddelNavn, unikNo,pris,sterkNo, antallPill);
                                tabLmiddel.settIn(unikNo, lmiddler); 
                             
                            } 
                            else if (form.equals("liniment") && type.equals("b")){
                                lmiddler = new VannedanendeLiniment (LegemiddelNavn, unikNo,pris,sterkNo, antallPill);
                                tabLmiddel.settIn(unikNo, lmiddler); 
                             
                            }
                            else {
                                lmiddler = new VannedanendeInjeksjon (LegemiddelNavn, unikNo,pris,sterkNo, antallPill);
                                tabLmiddel.settIn(unikNo, lmiddler); 
                             
                            }
                            
                            } else { // reading the line that contains 6 tokens: that is the vannlige legemidler
                            int unikNo = s1.nextInt();
                            unique=unikNo;
                            String LegemiddelNavn = s1.next();
                            String form = s1.next();
                            String type = s1.next();
                            int pris = s1.nextInt();
                            int antallPill = s1.nextInt();

                            if(form.equals("pille") && type.equals("c")){
                            lmiddler = new VanligePiller(LegemiddelNavn,unikNo, pris,antallPill);
                            tabLmiddel.settIn(unikNo, lmiddler); 
                            }
                             else if (form.equals("liniment") && type.equals("c")){
                                lmiddler = new VanligeLiniment (LegemiddelNavn,unikNo, pris,antallPill);
                                tabLmiddel.settIn(unikNo, lmiddler); 
                             } 
                             else {
                                
                                lmiddler = new VanligeInjeksjon (LegemiddelNavn,unikNo, pris,antallPill);
                                tabLmiddel.settIn(unikNo, lmiddler); 
                             }    

                                
                            }
                    
                            stn2 = scan.nextLine();
                         }
                        
                        unique++; 
                        

                }  
                 else if (ss.equals("Leger")){
                    for(int i=0; i<5; i++){ 
                       
                    Scanner slege = new Scanner(stn2).useDelimiter(", ");
                    String name = slege.next();
                    int snumber = slege.nextInt();
                    int anumber = slege.nextInt();
                    leg = new Leger(name,snumber,anumber); // creating a new leger object
                    legeBeholder.setteIn(leg); // adding to the beholder
                    stn2 = scan.nextLine();
                 }
                  
        

                } 
                else if (ss.equals("Resepter")){
                    for(int i=0; i<3; i++){ 
                       
                            Scanner s = new Scanner(stn2).useDelimiter(", ");
                            int reseptUnikNo=s.nextInt();
                            reseptUnique = reseptUnikNo;
                            String farge=s.next(); 
                            int pernumber = s.nextInt(); 
                            String legename=s.next();
                            int legemidnumber=s.nextInt();
                            int reit=s.nextInt();

                            if(farge.equals("b")){
                               resept1 = new BlaResept (reseptUnikNo,pernumber,legename,legemidnumber,reit);
                            //resept1 = new Resept (reseptUnikNo,farge,pernumber,legename,legemidnumber,reit);
                            reseptBeholder.settInResept(resept1); // adding to the main resept beholder/ enkeltreseptbeholder
                            } else {
                            resept1 = new HvitResept (reseptUnikNo,pernumber,legename,legemidnumber,reit);
                            reseptBeholder.settInResept(resept1); // adding to the main resept beholder/ enkeltreseptbeholder
                             
                            }


                            Iterator <Person> it = tabper.iterator();
                            while(it.hasNext()){
                            Person p = it.next();
                            int temp = p.finnPersonNo(); 
                            // check if the person number is equal to the person number in the resept
                            if(temp==pernumber){
                                persResBeholder.settInResept(resept1); // adding to the persons resept beholder 
                                  }

                            }

                        for (Leger p: legeBeholder) {   
                        String legNn = p.finneNavn();
                        if(legNn.equals(legename)){
                        legResBeholder.settInResept(resept1); // adding to the leger resept beholder
                                   
                            }

                        } 
                        if(scan.hasNextLine())
                            stn2 = scan.nextLine();
                         }
                          
                        stn2 = scan.nextLine();
                        reseptUnique++; 

                }
                else if (ss.equals("Slutt")) {
                    // confirm end of the file
                    System.out.println("You have reached the end of the file");
                }
                else {


                }

            }

        
        }
    
        scan.close();
    }
    catch(Exception e) {
        System.out.println("Could not read file properly");
        System.out.println("Exception e: " + e.getMessage());
        e.printStackTrace();
    }
    }


void menu(){
        int input=0;
    
    while (input!=7){
    System.out.println();        
    System.out.println("*******************************************************");        
    System.out.println("WELCOME TO  OBLIG4  PRESS 1-6 TO NAVIGATE \n");

    Scanner reader = new Scanner(System.in);
    System.out.println("1. PRINT OVERVIEW: Data from file and update \n"); 
    System.out.println("2. Create and add a new legemiddel \n"); 
    System.out.println("3. Create and add a new lege \n");  
    System.out.println("4. Create and add a new Person  \n");   
    System.out.println("5. Create and add a new Resepet \n");  
    System.out.println("6. Get LegeMiddel \n");  
    System.out.println("7. Terminate the Program \n"); 



    input = reader.nextInt();
        switch(input) {
                case 1:
             System.out.println( "UPDATED OVERVIEW: Data from file and updates"); 
                overview();
                break;

                case 2:
             System.out.println(" Legemiddel"); 
             registerNewLegeMiddler();
                break;


            case 3:
             System.out.println(" Lege"); 
             registerNewLeger();
                break;

            case 4:
             System.out.println(" Personer"); 
             registerNewPerson ();
                break;

            case 5:
             System.out.println(" Resepter"); 
             registerNewResept ();
                break;
            

             case 6:
             System.out.println(" hentLegemiddel"); 
             hentLegemiddel();
                break;
            
            case 7:
            System.out.println(" The Program has been Terminated!"); 
            System.out.println("********************************");
            System.out.println("     ");


             input=7;
                break;


            default:
                System.out.println("Option invalid! Try again");
                break;
            }
        }
    }
    



    public void hentLegemiddel() {
        Legemiddel lmidd= null;
        Resept res=null;
        Person pers =null;

        Scanner in = new Scanner (System.in);
        System.out.println("Enter the personal number");
        int pernum = in.nextInt();
        if( in.hasNextLine() ) {
            in.nextLine();
        }

        System.out.println("Enter the Resept number");
        int respNo = in.nextInt();

            res = reseptBeholder.finne(respNo);
            res.useReit();
            pers = tabper.findObjekt(pernum);
            int legeMNtemp = res.getLegeMNo();
            lmidd = tabLmiddel.findObjekt(legeMNtemp);



            if (res.getReit() != 0) {
                System.out.println("--------------------------------------------------");
                System.out.println("Resept number: " + respNo + " for " + pers.finnPersonName());
                System.out.println("Resepter en av typen " + lmidd.legeMName()+ "  "+"Antall Piller/ Milligram/ Kubikcentimeter: "+lmidd.antallstorrelse());
                System.out.println("Pris: " + lmidd.legeMPris());

                res.printAll();
            } else {
                System.out.println("Resept ugyldig!");
            }
    }

    
    void overview() { 

        System.out.println("Person");
        System.out.println("--------------------------------------------------");
        System.out.println("Person nummer" +"  " + " navn "+"    "+ "kjonn" );
        Iterator <Person> it = tabper.iterator();
        while(it.hasNext()){
         Person p = it.next();
            p.skrivUtPerson();
        
        }  

        System.out.println("Legemiddel");
        System.out.println("--------------------------------------------------");
        System.out.println( "nr" +"  " + "navn" + "  "+"form" +" " + "type" +"   " + "pris" +"   " + " mengde" +" " +"[styrke]" );

        Iterator <Legemiddel> iter = tabLmiddel.iterator();
         while(iter.hasNext()){
            Legemiddel l = iter.next();
            l.skrivUtLegemiddler();
        }


        System.out.println("Leger");
        System.out.println("--------------------------------------------------");
        System.out.println("navn" + "  "+ "spesialist" +"  " + "avtalenr");
        
        for (Leger l: legeBeholder) {   
               l.skrivUt();
        } 

        System.out.println();
        System.out.println("Leger med avtale ");
        System.out.println("--------------------------------------------------");
        for (Leger l: legeBeholder) { 
            int avtaleNo = l.checkAvtale();
            if(avtaleNo !=0 ){
            System.out.println(l.finneNavn());
            }
        }
        System.out.println();
        System.out.println("leger med avtale har skrevet følgende Narkotisk LegeMiddel");
        System.out.println("--------------------------------------------------");
               
        String lName;
        for (Leger l: legeBeholder) {   
            int avtaleNo = l.checkAvtale();
            if(avtaleNo !=0 ){
              lName =  l.finneNavn();
              int antall = 0;
               for (Resept r: reseptBeholder ) {
                    String legName = r.getName();

                    if(legName.equals(lName)){
                        int legMNo = r.getLegeMNo();   
                        Legemiddel ll=  tabLmiddel.findObjekt(legMNo);
                        if(ll instanceof Narkotisk){
                        antall ++;
                        }

                    }
                }
                System.out.println(lName + "    "+"har skrevet" +"    " + antall+ "   " + "Narkotisk Legemidler");

            }

        } 


        System.out.println();
        System.out.println("Persons med gyldig blaa Resept");
        System.out.println("------------------------------------------------------");
        for (Resept p: reseptBeholder ) {   // go through each persons resept beholder
            String fargeTemp = p.getFarge(); // get the colour
            int persNo = p.getpersMNo();    // get the person #
            Person perTemp = tabper.findObjekt(persNo); // use the # to get the object of that specific person
            int legmNo= p.getLegeMNo(); // get the legemiddel #
            Legemiddel temp = tabLmiddel.findObjekt(legmNo); // find the object of that legemiddel based on the #
            String formTemp =  temp.legeMForm(); // get the form of that legemidel 
        
            if(p instanceof BlaResept && formTemp.equals("injeksjon")){
                System.out.println(perTemp.finnPersonName()+"  " +  "har" + "   "+p.getReit() + "  " + "gyldig blaa resept og " +
                + temp.antallstorrelse () + " som er " + " " + temp.legeMForm() + "  " + "dose");
            }

        }
        System.out.println();
        System.out.println("Persons navn");
        System.out.println("------------------------------------------------------");
        
        Iterator <Person> it2 = tabper.iterator(); // got through person beholder
        while(it2.hasNext()){
            Person p = it2.next();
            System.out.println(p.finnPersonName()); // print their names
        }
        System.out.println("------------------------------------------------------");
        

        System.out.println("Persons Resept: gyldig Vannedanende legemiddler");
        System.out.println("------------------------------------------------------");
        
        int antall = 0; // count of total number of vanedannende legemidler which valid/gyldig 
        int antallForMenn = 0; // vanedannede legemidler for men
        int antallForKvinne =0; // for women
        for (Resept r: reseptBeholder ) { // go thro the resept beholder: 
            int gyldig =r.getReit();  // get the "reit"
        
            int legmNo2= r.getLegeMNo(); // get the legemiddel #
            Legemiddel temp2 = tabLmiddel.findObjekt(legmNo2); // find the object of legemiddel
            String typeTemp =  temp2.legeMType(); // get string type 
        
            if(gyldig!=0 && temp2 instanceof Vannedanende){
                antall++;                           // the count for the total numer increase each time one is found
                int persNo =  r.getpersMNo();
                Person pp = tabper.findObjekt(persNo); // find the person object 
                
                if(pp.finnPersonKjonn().equals("m")){ // check the gender of that person
                    antallForMenn ++; // if male the count for male increases
                    }
                    else {
                    antallForKvinne ++; // for women increases
                    }
                    
            }  
        } // end of for loop 
        System.out.println("Gyldig resept som er skrevet på Vannedanende Legemidler for menn er" + "  " + antallForMenn);
        System.out.println("Gyldig resept som er skrevet på Vannedanende Legemidler for kvinne er" + "  " + antallForKvinne);
        System.out.println("Totalt gyldig resept som er skrevet på Vannedanende Legemidler er " + antall);
} // end of method

void registerNewLegeMiddler() { // registration a new LegeMiddel
    
    
    Scanner read = new Scanner (System.in);
    System.out.println("Enter the type: a,b, eller c");
    String type = read.nextLine();

    if(type.equalsIgnoreCase("c")) {  // register first the c: vanlige legemiddler
        System.out.println("Enter name");
        String LegemiddelNavn  = read.next().toUpperCase();

        System.out.println("Enter form: pille, liniment, injeksjon");
        String form = read.nextLine();

        System.out.println("Enter the price");
        int pris = read.nextInt();
        if( read.hasNextLine() ) {
        read.nextLine();
         }

        System.out.println("Enter number of tablets/mengde");
        int  antallPill = read.nextInt();
        if( read.hasNextLine() ) {
        read.nextLine();
         }



        if(form.equals("pille") && type.equals("c")){
            lmiddler = new VanligePiller(LegemiddelNavn,unique, pris,antallPill);
            tabLmiddel.settIn(unique, lmiddler); 
        }
        else if (form.equals("liniment") && type.equals("c")){
            lmiddler = new VanligeLiniment (LegemiddelNavn,unique, pris, antallPill);
            tabLmiddel.settIn(unique, lmiddler); 
         } 
        else {
            lmiddler = new VanligeInjeksjon (LegemiddelNavn,unique, pris, antallPill);
            tabLmiddel.settIn(unique, lmiddler); 
         }    




    } 
    else {    // registration of new LegeMiddel type a and b

        System.out.println("Enter name");
        String LegemiddelNavn  = read.nextLine().toUpperCase();

        System.out.println("Enter form: pille, liniment, injeksjon");
        String form = read.nextLine();

        System.out.println("Enter the price");
        int pris = read.nextInt();
        if( read.hasNextLine() ) {
        read.nextLine();
         }


        System.out.println("Enter number of tablets/mengde");
        int  antallPill = read.nextInt();
        if( read.hasNextLine() ) {
        read.nextLine();
         }

        System.out.println("Enter strength level/styrke");
        int sterkNo = read.nextInt();
        

        if (type.equalsIgnoreCase("a") && form.equalsIgnoreCase("pille")){
            lmiddler = new NarkotiskPiller(LegemiddelNavn, unique,pris, sterkNo,antallPill);
             tabLmiddel.settIn(unique, lmiddler); 
        }
        else if (type.equalsIgnoreCase("a") && form.equalsIgnoreCase("liniment")){
            lmiddler = new NarkotiskLiniment (LegemiddelNavn, unique,pris, sterkNo,antallPill);
             tabLmiddel.settIn(unique, lmiddler); 
        }
        else if (type.equalsIgnoreCase("a") && form.equalsIgnoreCase("injeksjon")){
            lmiddler = new NarkotiskInjekksjon (LegemiddelNavn, unique,pris, sterkNo,antallPill);
             tabLmiddel.settIn(unique, lmiddler); 
        }
        else if (type.equalsIgnoreCase("b") && form.equalsIgnoreCase("pille")){
            lmiddler = new VannedanendePiller (LegemiddelNavn, unique,pris, sterkNo,antallPill);
             tabLmiddel.settIn(unique, lmiddler); 
        }
        else if (type.equalsIgnoreCase("b") && form.equalsIgnoreCase("liniment")){
            lmiddler = new VannedanendeLiniment  (LegemiddelNavn, unique,pris, sterkNo,antallPill);
             tabLmiddel.settIn(unique, lmiddler); 
        }
        else {
            lmiddler = new VannedanendeInjeksjon (LegemiddelNavn, unique,pris, sterkNo,antallPill);
             tabLmiddel.settIn(unique, lmiddler); 
            }

        } 
        unique++;

    } // end of the method

    void registerNewLeger (){ // register new leger/doctor
        Leger leg1;
        Scanner addLeger = new Scanner (System.in);
        System.out.println("Enter the Doctor name ");
        String nameLeg = addLeger.nextLine().toUpperCase();

        System.out.println("Enter Doctor's special number");
        int specialNo = addLeger.nextInt();

        if( addLeger.hasNextLine() ) {
        addLeger.nextLine();
        }

        System.out.println("Enter the agreement number/avtale nummer: 0 hvis ingen avtale) ");
        int  avtaleNo = addLeger.nextInt();

        leg1 = new Leger(nameLeg,specialNo,avtaleNo); // creating a new lege
        legeBeholder.setteIn(leg1);    // adding to the beholder
                  // adding to the beholder
    } // end of method

    void registerNewPerson () { // creating a new person

        Scanner addPerson = new Scanner (System.in);
        System.out.println("Enter the Person name ");
        String navn = addPerson.nextLine();

        System.out.println("Enter the gender m for male and k for female ");
        String  gender = addPerson.nextLine();


        person = new Person (personUnique,navn,gender);
        tabper.settIn(personUnique, person); // adding to the beholder

        personUnique++;
    } // end of method

    void registerNewResept (){ // register a new resept

        Scanner readRe = new Scanner (System.in);            
        System.out.println("Enter the Resept colour b for blaa or h for hvit");
        String farge = readRe.nextLine();

       
        System.out.println("Enter the Person's number");
        int pernumber = readRe.nextInt();
        if( readRe.hasNextLine() ) {
        readRe.nextLine();
        }

        
        System.out.println("Enter the Doctor's name");
        String  legename = readRe.nextLine();


        System.out.println("Enter the Legemidler number");
        int legemidnumber = readRe.nextInt();
        if( readRe.hasNextLine() ) {
        readRe.nextLine();
        }

    
        System.out.println("Enter the reit");
        int reit = readRe.nextInt();
        if( readRe.hasNextLine() ) {
        readRe.nextLine();
        }

        if (farge.equals("b")) {
        resept1 = new BlaResept (reseptUnique,pernumber,legename,legemidnumber,reit);
        reseptBeholder.settInResept(resept1); // add to the beholder
        } else {
        resept1 = new HvitResept (reseptUnique,pernumber,legename,legemidnumber,reit);
        reseptBeholder.settInResept(resept1); // add to the beholder
        
        }

       Iterator <Person> it = tabper.iterator();
        while(it.hasNext()){
        Person p = it.next();
        int temp = p.finnPersonNo(); 
        // check if the person number is equal to the person number in the resept
        if(temp==pernumber){
            persResBeholder.settInResept(resept1); // adding to the persons resept beholder 
              }

        }

        for (Leger p: legeBeholder) {   
        String legNn = p.finneNavn();
        if(legNn.equals(legename)){
        legResBeholder.settInResept(resept1); // adding to the leger resept beholder
                   
            }

        }

        reseptUnique++;

    }

    
} // end of the class Read

