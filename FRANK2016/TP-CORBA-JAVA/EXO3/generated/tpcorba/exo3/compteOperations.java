package tpcorba.exo3;

/**
 *	Generated from IDL interface "compte"
 *	@author JacORB IDL compiler V 2.2, 7-May-2004
 */


public interface compteOperations
{
	/* constants */
	/* operations  */
	int numero_compte();
	java.lang.String titulaire();
	double solde();
	void nombre_operations(org.omg.CORBA.IntHolder nombre);
	void debiter(double montant);
	void crediter(double montant);
	void prelevement(double montant, tpcorba.exo3.compte destination);
}
