
package tpcorba.exo3;

import org.omg.CORBA.*;
import java.lang.*;


public class compteImpl extends comptePOA

	{
		private int numero_compte;
		private String titulaire;
		private double sold;
		private int nombreDeDebitetCredit;


	
	public compteImpl(String t, int num)
		{
			titulaire = t;
			numero_compte = num;
			sold = 0;
			nombreDeDebitetCredit = 0;
		}

	public void nombre_operations(IntHolder num){
		nombreDeDebitetCredit +=num.value;
	}

	public void debiter(double montant){
		this.sold -= montant;
	}

	public void crediter(double montant){
		this.sold += montant;
	}

	public double solde(){
		return sold;
	}

	public String titulaire(){
		return titulaire;
	}
	public int numero_compte(){
		return numero_compte;
	}


	public int nombreDeDebitetCredit(){
		return nombreDeDebitetCredit;
	}

	public void prelevement(double montant,compte destination){
		destination.crediter(montant);
		sold -= montant;
	}

	}


