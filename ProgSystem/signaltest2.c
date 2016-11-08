#include <signal.h>
#include <stdio.h>
#include <unistd.h>
#include <string.h>
void handler (int n){
	printf("Signal numero %d\n",n);
}

int main(){
	for(;;){
		signal(SIGQUIT,handler);
		sleep(60);
	}
}