
/* Declarations en RPCL du programme de calculatrice de base*/
struct complexe {
  int pentiere ;
  float pimaginaire;
 };


program CALCCOMPPROG {		    /* nom du programme                  */
    version CALCVERS {		    /* numéro de version                 */
    struct complexe INIT (complexe) = 1;
	struct complexe ADD(complexe)  = 2;  /* premiére procédure du programme   */ 
	struct complexe MUL (complexe) = 3;  /* seconde procédure                 */
    
    } = 1;			    /* numéro de la version du programme */
} = 0x30090949;			    /* numéro de programme               */

