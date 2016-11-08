/* 
 * Auteur(s):
 */

#include <signal.h>
#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <string.h>


void (*sig_avant)(int);		/* pour la question 4.3 */

void sig_quit_hdl(){
sig_avant = signal(SIGINT,sig_avant);
}

//void hdl_sys1(int n) {
//  printf("hdl_sys1: Signal recu: %d\n", n);
//}

void int1(int n) {
 printf("1111111111111111111111111\n") ;
 }

void int2(int n) {
 printf("2222222222222222222222222\n") ;
 }


 //remain correction 4.2


void travail() {
  /* Je travaille tres intensement !    */
  /* Ne cherchez pas a comprendre ;-) */
  /* Il n'y a rien a modifier ici     */
  const char msg[] = "-\\|/";
  const int sz = strlen(msg);
  int i = 0;

  for (;;) {
    write(STDOUT_FILENO, "\r", 1);
    usleep(100000);
    write(STDOUT_FILENO, " => ", 4);
    write(STDOUT_FILENO, &msg[i++], 1);
    if (i == sz) i = 0;
  }
}
void travail() __attribute__((noreturn));
/* Petit raffinement pour le compilateur: cette fonction ne termine pas */


int main() {
  printf("PID: %d\n", getpid());
  signal(SIGQUIT,sig_quit_hdl);
  signal(SIGINT,int1);
  sig_avant=signal(SIGINT,int2);
  
  travail();
}
