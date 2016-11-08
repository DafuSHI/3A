package tpcorba.exo3;

/**
 *	Generated from IDL interface "compte"
 *	@author JacORB IDL compiler V 2.2, 7-May-2004
 */

public final class compteHolder	implements org.omg.CORBA.portable.Streamable{
	 public compte value;
	public compteHolder()
	{
	}
	public compteHolder (final compte initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type()
	{
		return compteHelper.type();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = compteHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		compteHelper.write (_out,value);
	}
}
