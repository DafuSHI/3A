#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

#define TABSIZE 512

int main( void )
{
    char tab[TABSIZE], *s;
    s = fgets(tab, TABSIZE, stdin);
    
    int filedes[2];
    char buf[80];
    pid_t pid;
    
    pipe( filedes );
    
    if ( (pid=fork()) > 0 )
    {
        printf( "This is in the father process,here write a string to the pipe.\n" );
        sleep(1);
        close(1);
        dup(filedes[1]);
        //write( filedes[1], s, sizeof(s) );
        printf("%s",s);
        close( filedes[0] );
        close( filedes[1] );
    }
    else
    {
        printf( "This is in the child process,here read a string from the pipe.\n" );
        close(0);
        dup(filedes[0]);
        //read( filedes[0], buf, sizeof(buf) );
        read( 0, buf, sizeof(buf) );
        printf( "%s", buf );
        printf("This is the end of the son\n");
        close( filedes[0] );
        close( filedes[1] );
    }
    
    waitpid( pid, NULL, 0 );
    
    return 0;
}
