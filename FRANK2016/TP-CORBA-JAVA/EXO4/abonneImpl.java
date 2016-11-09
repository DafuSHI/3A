package tpcorba.exo4;
import org.omg.CORBA.*;
import java.io.*;
import java.lang.*;
import java.util.*;
import org.omg.PortableServer.*;

public class abonneImpl extends abonnePOA{
	private int numero;
	private String nom_prenom;

	public int numero(){
		return numero;
	} 

	public String nom_prenom(){
		return nom_prenom;
	}
}