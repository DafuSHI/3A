/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "calccomplexe.h"
struct complexe x;

struct complexe *
init_1_svc(complexe *argp, struct svc_req *rqstp)
{
	static struct complexe  result;
	x.pentiere = (*argp).pentiere;
	x.pimaginaire = (*argp).pimaginaire;
	/*
	 * insert server code here
	 */
	result = x;
	return &result;
}

struct complexe *
add_1_svc(complexe *argp, struct svc_req *rqstp)
{
	static struct complexe  result;
	x.pentiere += (*argp).pentiere;
	x.pimaginaire += (*argp).pimaginaire;
	/*
	 * insert server code here
	 */
	result = x;
	return &result;
}

struct complexe *
mul_1_svc(complexe *argp, struct svc_req *rqstp)
{
	static struct complexe  result;

	/*
	 * insert server code here
	 */

	return &result;
}