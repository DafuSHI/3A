/*
 * Auteur(s):
 *
 * Cet programme refait ce que fait la commande "ls". Il donne des
 * informnations sur les caracteristiques de fichiers dont le nom est passe
 * en parametre.
 *
 * Utilisation de la primitive stat(2) et de la fonction getpwuid(3).
 */

#include <sys/types.h>
#include <sys/stat.h>
#include <pwd.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <errno.h>

/* Petite fonction qui se charge d'envoyer les messages d'erreur
   et qui ensuite "suicide" le processus. */

void erreur_grave(char *msg) {
  perror(msg);
  exit(EXIT_FAILURE);
}

/* Fonction principale (fournie avec erreur(s?)) */

int main(int argc, char **argv) {
  struct stat status, *buffer;
  int r;
// it seems there is something we must do before using pointer
  r = stat(argv[1],&status);// change from buffer to &status
  buffer=&status;
  if (r < 0)
    erreur_grave("Stat");

  //printf("Fichier %s:  mode: %X  Taille: %ld  Proprietaire: %d\n",
	//argv[1], buffer->st_mode, buffer->st_size, buffer->st_uid);
  //printf("Fichier %s:  mode: %X  Taille: %ld  Proprietaire: %s\n",
  //argv[1], buffer->st_mode, buffer->st_size, getpwuid(buffer->st_uid)->pw_name);

  struct passwd ptr;
  struct passwd *result;
  char *buf;
  size_t bufsize;
  int x;

  bufsize = sysconf(_SC_GETPW_R_SIZE_MAX);
    if (bufsize == -1)          /* Value was indeterminate */
        bufsize = 16384;        /* Should be more than enough */

 buf = malloc(bufsize);
    if (buf == NULL) {
        perror("malloc");
        exit(EXIT_FAILURE);
    }

  //ptr = getpwuid_r(buffer->st_uid);

  x= getpwuid_r(buffer->st_uid,&ptr,buf,bufsize,&result);

  printf("Fichier %s:  mode: %X  Taille: %ld  Proprietaire: %s\n",argv[1], buffer->st_mode, buffer->st_size, result->pw_uid);
  getpwuid_r(1000,&ptr,buf,bufsize,&result);
  printf("Fichier %s:  mode: %X  Taille: %ld  Proprietaire: %s\n",argv[1], buffer->st_mode, buffer->st_size, result->pw_uid);




  exit(EXIT_SUCCESS);
}
//If you want to use a *buffer than you must do XXX* one = malloc(sizeof(*one)) first to dinamically assign the place
//example: http://stackoverflow.com/questions/12958931/c-warning-x-may-be-used-uninitialized-in-this-function
//man getpwuid we see: struct passwd *getpwuid(uid_t uid); And see struct passwd we find
// char   *pw_name;       /* username */
//so commment lines 36 and 37 and: 38 39 showed the answer


 
