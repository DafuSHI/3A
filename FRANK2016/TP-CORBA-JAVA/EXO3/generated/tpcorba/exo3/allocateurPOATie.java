package tpcorba.exo3;

import org.omg.PortableServer.POA;

/**
 *	Generated from IDL interface "allocateur"
 *	@author JacORB IDL compiler V 2.2, 7-May-2004
 */

public class allocateurPOATie
	extends allocateurPOA
{
	private allocateurOperations _delegate;

	private POA _poa;
	public allocateurPOATie(allocateurOperations delegate)
	{
		_delegate = delegate;
	}
	public allocateurPOATie(allocateurOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
	public tpcorba.exo3.allocateur _this()
	{
		return tpcorba.exo3.allocateurHelper.narrow(_this_object());
	}
	public tpcorba.exo3.allocateur _this(org.omg.CORBA.ORB orb)
	{
		return tpcorba.exo3.allocateurHelper.narrow(_this_object(orb));
	}
	public allocateurOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(allocateurOperations delegate)
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
	public void nouveau_compte(tpcorba.exo3.compteHolder cpt, java.lang.String titulaire, int numero_compte)
	{
_delegate.nouveau_compte(cpt,titulaire,numero_compte);
	}

}
