
package tpcorba.exo3;

import org.omg.CORBA.*;
import java.lang.*;


public class compteImpl extends comptePOA

	{
		private int numero_compte;
		private String titulaire;
		private double sold;

	public compteImpl(String t, int num)
		{
			titulaire = t;
			sold = num;
		}


	}


