package tpcorba.exo3;

/**
 *	Generated from IDL interface "allocateur"
 *	@author JacORB IDL compiler V 2.2, 7-May-2004
 */

public final class allocateurHolder	implements org.omg.CORBA.portable.Streamable{
	 public allocateur value;
	public allocateurHolder()
	{
	}
	public allocateurHolder (final allocateur initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type()
	{
		return allocateurHelper.type();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = allocateurHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		allocateurHelper.write (_out,value);
	}
}
