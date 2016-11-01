#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <pwd.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int main(int argc, char **argv) {
//extern char **environ;
char *result;
//int i=0;

result = getenv(argv[1]);
printf("%s",result);


exit(EXIT_SUCCESS);
}

