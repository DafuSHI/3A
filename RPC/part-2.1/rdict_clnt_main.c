/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "rdict.h"


void
rdictprog_1(char *host)
{
	CLIENT *clnt;
	int  *result_1;
	char *initw_1_arg;
	int  *result_2;
	char * insertw_1_arg;
	int  *result_3;
	char * deletew_1_arg;
	int  *result_4;
	char * lookupw_1_arg;

#ifndef	DEBUG
	clnt = clnt_create (host, RDICTPROG, RDICTVERS, "udp");
	if (clnt == NULL) {
		clnt_pcreateerror (host);
		exit (1);
	}
#endif	/* DEBUG */

	result_1 = initw_1((void*)&initw_1_arg, clnt);
	if (result_1 == (int *) NULL) {
		clnt_perror (clnt, "call failed");
	}
	result_2 = insertw_1(&insertw_1_arg, clnt);
	if (result_2 == (int *) NULL) {
		clnt_perror (clnt, "call failed");
	}
	result_3 = deletew_1(&deletew_1_arg, clnt);
	if (result_3 == (int *) NULL) {
		clnt_perror (clnt, "call failed");
	}
	result_4 = lookupw_1(&lookupw_1_arg, clnt);
	if (result_4 == (int *) NULL) {
		clnt_perror (clnt, "call failed");
	}
#ifndef	DEBUG
	clnt_destroy (clnt);
#endif	 /* DEBUG */
}


int
main (int argc, char *argv[])
{
	char *host;

	if (argc < 2) {
		printf ("usage: %s server_host\n", argv[0]);
		exit (1);
	}
	host = argv[1];
	rdictprog_1 (host);
exit (0);
}