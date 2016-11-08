package tpcorba.exo2;

import org.omg.PortableServer.POA;

/**
 *	Generated from IDL interface "calcul"
 *	@author JacORB IDL compiler V 2.2, 7-May-2004
 */

public class calculPOATie
	extends calculPOA
{
	private calculOperations _delegate;

	private POA _poa;
	public calculPOATie(calculOperations delegate)
	{
		_delegate = delegate;
	}
	public calculPOATie(calculOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
	public tpcorba.exo2.calcul _this()
	{
		return tpcorba.exo2.calculHelper.narrow(_this_object());
	}
	public tpcorba.exo2.calcul _this(org.omg.CORBA.ORB orb)
	{
		return tpcorba.exo2.calculHelper.narrow(_this_object(orb));
	}
	public calculOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(calculOperations delegate)
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
	public void incrementer(org.omg.CORBA.IntHolder data)
	{
_delegate.incrementer(data);
	}

	public void ajouteMemoire(double donnee)
	{
_delegate.ajouteMemoire(donnee);
	}

	public void soustraitMemoire(double donnee)
	{
_delegate.soustraitMemoire(donnee);
	}

	public void decrementer(org.omg.CORBA.IntHolder data)
	{
_delegate.decrementer(data);
	}

	public void multiplieMemoire(double donnee)
	{
_delegate.multiplieMemoire(donnee);
	}

	public double memoire()
	{
		return _delegate.memoire();
	}

	public void miseAZero()
	{
_delegate.miseAZero();
	}

	public void diviseMemoire(double donnee) throws tpcorba.exo2.divisionParZero
	{
_delegate.diviseMemoire(donnee);
	}

}
