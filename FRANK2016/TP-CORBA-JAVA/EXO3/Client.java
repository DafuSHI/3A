package tpcorba.exo3;

import org.omg.CORBA.*;

import java.io.*;
import java.lang.*;
import java.util.*;


public class Client {
    public static void main(String[] args) throws IOException {
        ////////////////////////////////////////////////////
        ORB orb = ORB.init(args, null);

        if(args.length!=0)
               {
               System.err.println("utilisation : pas de parametre ");
               System.exit(1);
               }

        ////////////////////////////////////////////////////
        String ior = null;

        try {
            String ref = "cpt.ref";
            FileInputStream file = new FileInputStream(ref);
            BufferedReader in = new BufferedReader(new InputStreamReader(file));
            ior = in.readLine();
            file.close();
        } catch (IOException ex) {
            System.err.println("Impossible de lire fichier : `" +
                ex.getMessage() + "'");
            System.exit(1);
        }

        ////////////////////////////////////////////////////
        org.omg.CORBA.Object obj = orb.string_to_object(ior);

        if (obj == null) {
            System.err.println("Erreur sur string_to_object() ");
            throw new RuntimeException();
        }

        allocateur alloc= allocateurHelper.narrow(obj);

        if (alloc == null) {
            System.err.println("Erreur sur narrow() ");
            throw new RuntimeException();
        }

        ////////////////////////////////////////////////////
        // Invocation du serveur
        ////////////////////////////////////////////////////

        // Creation de deux comptes
        //
        compteHolder Hcpt1 = new compteHolder();
        compte cpt1;

        compteHolder Hcpt2 = new compteHolder();
        compte cpt2;

        alloc.nouveau_compte(Hcpt1,"toto",1);
        alloc.nouveau_compte(Hcpt2,"caca",2);


        cpt1=Hcpt1.value;
        cpt2=Hcpt2.value;

        System.out.println("titulaire cpt1 = " + cpt1.titulaire());
        System.out.println("titulaire cpt2 = " + cpt2.titulaire());

        System.out.println("Solde cpt1 = " + cpt1.solde());
        double money = 100.0;
        cpt1.crediter(money);
        System.out.println("Save "+ money+ " in " + cpt1.titulaire() + "'s compte");


        cpt1.prelevement(50.5,cpt2);
        System.out.println("prelevement");
        System.out.println("Solde cpt1 = " + cpt1.solde());
        System.out.println("Solde cpt2 = " + cpt2.solde());



	//***

        System.exit(0);
    }
}
