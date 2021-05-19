#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <errno.h>

int main(int argc, char const *argv[]) {

  if(argc != 4) {
    printf("Not enough or too many arguments \n");
    return 1;
  }

  FILE *fp = fopen(argv[1],"r");
  int n = 0,start,end;

  int m = atoi(argv[2]);
  int parcials[m];
  int fd[2];
  int k = atoi(argv[3]);
 
  fscanf(fp,"%d",&n);

  if(pipe(fd) == -1) {
    return 1;
  }
  int arr[n*n];
  for(int i = 0; i<n*n; i++) {
    fscanf(fp,"%d",&arr[i]);
    //printf("%d: %d\n",i,arr[i]);
  }

  for(int i = 0; i<m/2; i++) {
    pid_t id = fork();
    if(id == -1) return 2;
    //Proceso filho
    if(id == 0) {
      start = 0;
      end = (n*n)/2;
    } else {
      start = (n*n) / 2;
      end = (n*n);
    }

    int sum = 0;
    int i;
    for (i = start; i < end; i++) {
      sum+=arr[i];
    }
    printf("Calculated partial sum: %d\n", sum);
  }
  return 0;
}
