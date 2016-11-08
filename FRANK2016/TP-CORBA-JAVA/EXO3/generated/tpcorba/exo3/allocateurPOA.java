package tpcorba.exo3;

/**
 *	Generated from IDL interface "allocateur"
 *	@author JacORB IDL compiler V 2.2, 7-May-2004
 */


public abstract class allocateurPOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, tpcorba.exo3.allocateurOperations
{
	static private final java.util.Hashtable m_opsHash = new java.util.Hashtable();
	static
	{
		m_opsHash.put ( "nouveau_compte", new java.lang.Integer(0));
	}
	private String[] ids = {"IDL:tpcorba/exo3/allocateur:1.0"};
	public tpcorba.exo3.allocateur _this()
	{
		return tpcorba.exo3.allocateurHelper.narrow(_this_object());
	}
	public tpcorba.exo3.allocateur _this(org.omg.CORBA.ORB orb)
	{
		return tpcorba.exo3.allocateurHelper.narrow(_this_object(orb));
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
			case 0: // nouveau_compte
			{
				tpcorba.exo3.compteHolder _arg0= new tpcorba.exo3.compteHolder();
				_arg0._read (_input);
				java.lang.String _arg1=_input.read_string();
				int _arg2=_input.read_long();
				_out = handler.createReply();
				nouveau_compte(_arg0,_arg1,_arg2);
				tpcorba.exo3.compteHelper.write(_out,_arg0.value);
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
