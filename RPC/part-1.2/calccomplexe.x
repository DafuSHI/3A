
/* Declarations en RPCL du programme de calculatrice de base*/
struct complexe {
  int pentiere ;
  float pimaginaire;
 };


program CALCCOMPPROG {		    /* nom du programme                  */
    version CALCVERS {		    /* num�ro de version                 */
    struct complexe INIT (complexe) = 1;
	struct complexe ADD(complexe)  = 2;  /* premi�re proc�dure du programme   */ 
	struct complexe MUL (complexe) = 3;  /* seconde proc�dure                 */
    
    } = 1;			    /* num�ro de la version du programme */
} = 0x30090949;			    /* num�ro de programme               */

