#include <stdio.h>
#include "mpi.h"

#if defined(__GNUC__) && (__GNUC__ >= 3)
#define ATTRIBUTE(x) __attribute__(x)
#else
#define ATTRIBUTE(x) /**/
#endif

#define MIN(_x, _y) ((_x) > (_y) ? (_y) : (_x))
#define ABS(_x) ((_x) >= 0 ? (_x) : -(_x))


/* N'hesitez pas a changer MAXX .*/
#define MAXX  1000
#define MAXY (MAXX * 3 / 4)

#define NX (2 * MAXX + 1)
#define NY (2 * MAXY + 1)

#define NBITER 550
#define DATATAG 150

static int mandel(double, double);

int dump_ppm(const char *, int[NX][NY]);
int cases[NX][NY];


int main(int argc, char *argv[])
{
  MPI_Status status;
  int i,j,k,wait_slaves,tag, num, rank, size, nbslaves;
  char inputstr [100],outstr [100];

  /* Start up MPI */

  MPI_Init(&argc, &argv);
  MPI_Comm_rank(MPI_COMM_WORLD, &rank);
  MPI_Comm_size(MPI_COMM_WORLD, &size);

  nbslaves = size -1;

  int np = (int)((2*MAXX+1)/nbslaves)+1;  //Mei ge slaves yao suan de liang

  //printf("%d",np);  This is for the correction of each slaves work

  if (rank == 0) {
    double starttime, endtime;
    starttime = MPI_Wtime();
    //int res;
    int res[2*MAXY+1];

    /* Begin User Program  - the master */
/*
for(k = 1;k <= nbslaves; k++ ) {
   //for(i = -MAXX; i <= MAXX; i++) {
    for(i = -MAXX+(k-1)*np; i < -MAXX+(k)*np; i++) {
      if (i == MAXX+1) break;
      //for(j = -MAXY; j <= MAXY; j++) {
      //MPI_Recv(&res, 1, MPI_INT, k, DATATAG, MPI_COMM_WORLD, &status);
      //cases[i + MAXX][j + MAXY] = res;
      //}
      MPI_Recv(&res, 2*MAXY+1, MPI_INT, k, DATATAG, MPI_COMM_WORLD, &status);
      for(j = -MAXY; j <= MAXY; j++) {
      cases[i + MAXX][j + MAXY] = res[MAXY+j];
      }
    }
  }

*/
int wait_lines = 2*MAXX+1;
while(wait_lines > 0){
  //printf("%d\n",wait_lines);
MPI_Recv(&res, 2*MAXY+1, MPI_INT, MPI_ANY_SOURCE, MPI_ANY_TAG, MPI_COMM_WORLD, &status);
k = status.MPI_SOURCE;
tag = status.MPI_TAG;

for(j = -MAXY; j <= MAXY; j++) {
      cases[tag][j + MAXY] = res[MAXY+j];
      }
//if(tag % np == 0 || tag == 2*MAXX)
  wait_lines--;
}

    endtime = MPI_Wtime();
    printf("This is rank %d,time spent %f\n",rank,endtime-starttime);
    dump_ppm("mandel.ppm", cases);
    printf("Fini.\n");
  }

  else {
    double starttime, endtime;
    starttime = MPI_Wtime();
    /* On est l'un des fils */
    double x, y;
    int e;
    int i=-MAXX+(rank-1)*np, j, res[2*MAXY+1], rc;

    //for(i = -MAXX; i <= MAXX; i++) {
    for(i = -MAXX+(rank-1)*np; i < -MAXX+(rank)*np; i++) {
      if (i== MAXX+1) break;
      for(j = -MAXY; j <= MAXY; j++) {
      	x = 2 * i / (double)MAXX;
      	y = 1.5 * j / (double)MAXY;
      	res[MAXY+j] = mandel(x, y);
      	//MPI_Send(&res, 1 , MPI_INT, 0, DATATAG, MPI_COMM_WORLD); 
      }
      //for(e=0;e<(2*MAXY+1);e++){
      //  printf("%d ",res[e]);
      //}
      //printf("\n");
      //printf("This is rank %d,line %d\n",rank,i+MAXX);
      //MPI_Send(&res, 2*MAXY+1 , MPI_INT, 0, DATATAG, MPI_COMM_WORLD); 
      //printf("XXXXXXXXXXXXXXXXXXXXXtag sent %d",i);
      MPI_Send(&res, 2*MAXY+1 , MPI_INT, 0, i+MAXX, MPI_COMM_WORLD);
    }
    sleep(0);
    endtime = MPI_Wtime();
    printf("This is rank %d,time spent %f\n",rank,endtime-starttime);
  }

  MPI_Finalize();
  return 0;
}



/* function to compute a point - the number of iterations 
   plays a central role here */

int
mandel(double cx, double cy)
{
  int i;
  double zx, zy;
  zx = 0.0; zy = 0.0;

  for(i = 0; i < NBITER; i++) {
    double zxx = zx, zyy = zy;
    zx = zxx * zxx - zyy * zyy + cx;
    zy = 2 * zxx * zyy + cy;
    if(zx * zx + zy * zy > 4.0)
      return i;
  }
  return -1;
}

/* the image commputer can be transformed in a ppm file so
   to be seen with xv */

int
dump_ppm(const char *filename, int valeurs[NX][NY])
{
  FILE *f;
  int i, j, rc;

  f = fopen(filename, "w");
  if(f == NULL) { perror("fopen"); exit(1); }
  fprintf(f, "P6\n");
  fprintf(f, "%d %d\n", NX, NY);
  fprintf(f, "%d\n", 255);
  for(j = NY - 1; j >= 0; j--) {
    for(i = 0; i < NX; i++) {
      unsigned char pixel[3];
      if(valeurs[i][j] < 0) {
	pixel[0] = pixel[1] = pixel[2] = 0;
      } else {
	unsigned char val = MIN(valeurs[i][j] * 12, 255);
	pixel[0] = val;
	pixel[1] = 0;
	pixel[2] = 255 - val;
      }
      rc = fwrite(pixel, 1, 3, f);
      if(rc < 0) { perror("fwrite"); exit(1); }
    }
  }
  fclose(f);
  return 0;
}
 
