package tpcorba.exo3;

import org.omg.PortableServer.POA;

/**
 *	Generated from IDL interface "compte"
 *	@author JacORB IDL compiler V 2.2, 7-May-2004
 */

public class comptePOATie
	extends comptePOA
{
	private compteOperations _delegate;

	private POA _poa;
	public comptePOATie(compteOperations delegate)
	{
		_delegate = delegate;
	}
	public comptePOATie(compteOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
	public tpcorba.exo3.compte _this()
	{
		return tpcorba.exo3.compteHelper.narrow(_this_object());
	}
	public tpcorba.exo3.compte _this(org.omg.CORBA.ORB orb)
	{
		return tpcorba.exo3.compteHelper.narrow(_this_object(orb));
	}
	public compteOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(compteOperations delegate)
	{
		_delegate = delegate;
	}
	public POA _default_POA()
	{
		if (_poa != null)
		{
			return _poa;
		}
		else
		{
			return super._default_POA();
		}
	}
	public int numero_compte()
	{
		return _delegate.numero_compte();
	}

	public double solde()
	{
		return _delegate.solde();
	}

	public void prelevement(double montant, tpcorba.exo3.compte destination)
	{
_delegate.prelevement(montant,destination);
	}

	public void debiter(double montant)
	{
_delegate.debiter(montant);
	}

	public java.lang.String titulaire()
	{
		return _delegate.titulaire();
	}

	public void crediter(double montant)
	{
_delegate.crediter(montant);
	}

	public void nombre_operations(org.omg.CORBA.IntHolder nombre)
	{
_delegate.nombre_operations(nombre);
	}

}
