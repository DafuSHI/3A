package tpcorba.exo3;

/**
 *	Generated from IDL interface "compte"
 *	@author JacORB IDL compiler V 2.2, 7-May-2004
 */


public abstract class comptePOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, tpcorba.exo3.compteOperations
{
	static private final java.util.Hashtable m_opsHash = new java.util.Hashtable();
	static
	{
		m_opsHash.put ( "_get_numero_compte", new java.lang.Integer(0));
		m_opsHash.put ( "_get_solde", new java.lang.Integer(1));
		m_opsHash.put ( "prelevement", new java.lang.Integer(2));
		m_opsHash.put ( "debiter", new java.lang.Integer(3));
		m_opsHash.put ( "_get_titulaire", new java.lang.Integer(4));
		m_opsHash.put ( "crediter", new java.lang.Integer(5));
		m_opsHash.put ( "nombre_operations", new java.lang.Integer(6));
	}
	private String[] ids = {"IDL:tpcorba/exo3/compte:1.0"};
	public tpcorba.exo3.compte _this()
	{
		return tpcorba.exo3.compteHelper.narrow(_this_object());
	}
	public tpcorba.exo3.compte _this(org.omg.CORBA.ORB orb)
	{
		return tpcorba.exo3.compteHelper.narrow(_this_object(orb));
	}
	public org.omg.CORBA.portable.OutputStream _invoke(String method, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.ResponseHandler handler)
		throws org.omg.CORBA.SystemException
	{
		org.omg.CORBA.portable.OutputStream _out = null;
		// do something
		// quick lookup of operation
		java.lang.Integer opsIndex = (java.lang.Integer)m_opsHash.get ( method );
		if ( null == opsIndex )
			throw new org.omg.CORBA.BAD_OPERATION(method + " not found");
		switch ( opsIndex.intValue() )
		{
			case 0: // _get_numero_compte
			{
			_out = handler.createReply();
			_out.write_long(numero_compte());
				break;
			}
			case 1: // _get_solde
			{
			_out = handler.createReply();
			_out.write_double(solde());
				break;
			}
			case 2: // prelevement
			{
				double _arg0=_input.read_double();
				tpcorba.exo3.compte _arg1=tpcorba.exo3.compteHelper.read(_input);
				_out = handler.createReply();
				prelevement(_arg0,_arg1);
				break;
			}
			case 3: // debiter
			{
				double _arg0=_input.read_double();
				_out = handler.createReply();
				debiter(_arg0);
				break;
			}
			case 4: // _get_titulaire
			{
			_out = handler.createReply();
			_out.write_string(titulaire());
				break;
			}
			case 5: // crediter
			{
				double _arg0=_input.read_double();
				_out = handler.createReply();
				crediter(_arg0);
				break;
			}
			case 6: // nombre_operations
			{
				org.omg.CORBA.IntHolder _arg0= new org.omg.CORBA.IntHolder();
				_out = handler.createReply();
				nombre_operations(_arg0);
				_out.write_long(_arg0.value);
				break;
			}
		}
		return _out;
	}

	public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte[] obj_id)
	{
		return ids;
	}
}
