package tpcorba.exo3;

import org.omg.CORBA.*;
import java.lang.*;
import org.omg.PortableServer.*;


public class allocateurImpl extends allocateurPOA
	{


	// Reference sur la POA
	//
	protected  POA poa_;


	public  allocateurImpl(POA poa)
		{
		poa_=poa;
		}

	
	public void nouveau_compte(compteHolder cpt,String titulaire,
			int numero_compte){
		try {
			compteImpl imp = new compteImpl(titulaire, numero_compte);

			org.omg.CORBA.Object obj = poa_.servant_to_reference(imp);

			cpt.value = compteHelper.narrow(obj);
			}
        catch (Exception e) {
            System.out.println(e);
        	}	

		
	}


	}
