package tpcorba.exo2;

import org.omg.CORBA.*;

import java.io.*;

import java.lang.*;

import java.util.*;


public class Client {
    public static void main(String[] args) throws IOException {

        ORB orb = ORB.init(args, null);

        if (args.length != 0) {
            System.err.println("pas de parametre svp");
            System.exit(1);
        }

        ////////////////////////////////////////////////////

        String ior = null;

        try {
            String ref = "calcul.ref";
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

        calcul calc = calculHelper.narrow(obj);

        if (calc == null) {
            System.err.println("Erreur sur narrow() ");
            throw new RuntimeException();
        }

        ////////////////////////////////////////////////////
        // Invocation du serveur
        ////////////////////////////////////////////////////
        char car;


        //IntHolder resultatI = new IntHolder(param);
        IntHolder resultatI = new IntHolder(1);
        Double resultat = new Double(5);
        try
            {
                //Afficher l'etat initial de la  memoire de la calculatrice
				System.out.println(" Que faire (incrementer ou decrementer ; saisir 'i' 'd' 'v' 'a' 's' 'm' ou 'z')?  ");
                car = (char) System.in.read();



                System.out.println(" l'etat initial de la  memoire = " + calc.memoire());

				//Ajouter ici des operations sur la 
				// memoire de la calculatrice 
                if (car == 'i') {
                calc.incrementer(resultatI);

                    System.out.println(" Valeur incrementee = " + resultatI.value);
                } else if (car == 'd') {
                    calc.decrementer(resultatI);

                    System.out.println(" Valeur divisee = " + resultatI.value);
                } else if (car == 'v') {
                    try{
                    calc.diviseMemoire(resultat);
                        }
                    catch(divisionParZero ex)
                        {
                            System.err.println("Exception : division par zero" );
                            System.exit(1);
                        }

                    System.out.println(" Valeur decrementee = " + resultat);
                }else if (car == 'a') {
                    calc.ajouteMemoire(resultat);

                    System.out.println(" Valeur ajoutee = " + resultat);
                }else if (car == 's') {
                    calc.soustraitMemoire(resultat);

                    System.out.println(" Valeur soustraitee = " + resultat);
                }else if (car == 'm') {
                    calc.multiplieMemoire(resultat);

                    System.out.println(" Valeur multipliee = " + resultat);
                }else if (car == 'z') {
                    calc.miseAZero();

                    System.out.println(" Valeur a zero = " );
                }else{
                    System.out.println("  Saisir 'i' 'd' 'v' 'a' 's' 'm' ou 'z'");
                }
        }
        catch (IOException ex) {
            System.out.println("Erreur lecture commande (char)");
            System.exit(1);
        }

				// Afficher l'etat final de la 
				// memoire de la calculatrice
                System.out.println(" l'etat final de la  memoire = " + calc.memoire());

				// Regarder le fonctionnement des 
				// exceptions
				try{
				calc.diviseMemoire(0);

                        }
                catch(divisionParZero ex)
                        {
                        System.err.println("Exception : division par zero" );
                        System.exit(1);
                        }

        System.exit(0);
    }
}
