#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <pwd.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int main(int argc, char **argv) {
extern char **environ;
int i=0;

while(environ[i]){
	if(strstr(environ[i],argv[1])) //Get part of the string
		{	
			int x=0;
			while(environ[i][x] != '='){
				x++;
			}
			for(x++;x<strlen(environ[i]);x++)
				printf("%c",environ[i][x]);
	}
	i++;
}

exit(EXIT_SUCCESS);
}
//extern is used for getting an outside variable