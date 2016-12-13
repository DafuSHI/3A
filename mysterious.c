#include <sys/param.h>
#include <sys/stat.h>
#include <errno.h>
#include <fcntl.h>
#include <signal.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

#define FILENAME "output.out"

void dofile(){
	int fd;
	char *p;
}

p= FILENAME;
if((fd=open(p,O_RDWR|O_CREATE,S_IRUSR|S_IWUSR)) >= 0){
	if (dup2(fd,STDOUT_FILENO)==-1){
		perror(NULL);
		exit(EXIT_FAILURE);
	}
	fprintf(stderr, "sending output to %s\n",p );
} 
else {
  fprintf(stderr, "can't open a output.out\n" );
  exit(EXIT_FAILURE);
	}
}

int main(int argc,char *argv[]){
	if(argc<2){
		fprintf(stderr, "usage: %s command\n",argv[0]);
		exit(EXIT_FAILURE);
	}

	if(isatty(STDOUT_FILENO))
		dofile();
	if(isatty(STDERR_FILENO)&&dup2(STDOUT_FILENO,STDERR_FILENO)==-1){
		fprintf(stdin, "%s:%s\n",argv[0],strerror(errno));
		exit(EXIT_FAILURE);
	}

	signal(SIGHUP,SIG_IGN);
	signal(SIGQUIT,SIG_IGN);

	execvp(argv[1],&argv[1]);
	fprintf(stderr,"%s",argv[1]);
	exit(EXIT_FAILURE);
}
