package tpcorba.exo3;


/**
 *	Generated from IDL interface "allocateur"
 *	@author JacORB IDL compiler V 2.2, 7-May-2004
 */

public class _allocateurStub
	extends org.omg.CORBA.portable.ObjectImpl
	implements tpcorba.exo3.allocateur
{
	private String[] ids = {"IDL:tpcorba/exo3/allocateur:1.0"};
	public String[] _ids()
	{
		return ids;
	}

	public final static java.lang.Class _opsClass = tpcorba.exo3.allocateurOperations.class;
	public void nouveau_compte(tpcorba.exo3.compteHolder cpt, java.lang.String titulaire, int numero_compte)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "nouveau_compte", true);
				tpcorba.exo3.compteHelper.write(_os,cpt.value);
				_os.write_string(titulaire);
				_os.write_long(numero_compte);
				_is = _invoke(_os);
				cpt.value = tpcorba.exo3.compteHelper.read(_is);
				return;
			}
			catch( org.omg.CORBA.portable.RemarshalException _rx ){}
			catch( org.omg.CORBA.portable.ApplicationException _ax )
			{
				String _id = _ax.getId();
				throw new RuntimeException("Unexpected exception " + _id );
			}
			finally
			{
				this._releaseReply(_is);
			}
		}
		else
		{
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "nouveau_compte", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			allocateurOperations _localServant = (allocateurOperations)_so.servant;
			try
			{
			_localServant.nouveau_compte(cpt,titulaire,numero_compte);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return;
		}

		}

	}

}
