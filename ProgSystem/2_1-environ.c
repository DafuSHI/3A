#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <pwd.h>
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv) {
extern char **environ;
int i=0;

while(environ[i]){
	printf("%s\n", environ[i++]);
}

exit(EXIT_SUCCESS);
}
//extern is used for getting an outside variable