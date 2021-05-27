#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/mman.h>
#include <errno.h>

void do_work(int np,const char* fname, int m, int k, int* parciais) {

  printf("Child %d Doing work\n",np);
  //printf("%s\n",fname);
  FILE *fp = fopen(fname,"r");
  if(fp == NULL) {
    printf("Cannot open file \n");
    return;
  }
  
  char* line = NULL;
  long unsigned int tamanho= 0;
  getline(&line,&tamanho,fp);
  int size = atoi(line);
  //printf("size: %d\n",size);

  for(int i = 0; i<size; i++) {
    getline(&line,&tamanho,fp);
    printf("i: %d, m: %d, np: %d\n",i,m,np);
    if((i%m) == np) {
      printf("%s\n",line);
      char* tok = strtok(line," ");
      while(tok != NULL) {
        if(k<atoi(tok)) {
          parciais[np]++;
        }
        tok = strtok(NULL," ");
      }
    }
    free(line);
    line = NULL;
    tamanho = 0;
  }
  
  fclose(fp);
}

int main(int argc, char const *argv[]) {

  if(argc != 4) {
    printf("Not enough or too many arguments \n");
    return 1;
  }
  int m = atoi(argv[2]),k = atoi(argv[3]);
  
  int* parciais = (int*)mmap(NULL,m*sizeof(int),PROT_READ | PROT_WRITE, MAP_SHARED | MAP_ANONYMOUS, -1, 0);
  for(int i = 0; i<m; i++) 
    parciais[i] = 0;

  pid_t pid;
  for(int i = 0; i<m; i++) {
    pid = fork();
    //printf("pid: %d\n",pid);
    if(pid == 0) {
      do_work(i,argv[1],m,k,parciais);
      exit(0);
    }
  }
  for(int i = 0; i<m; i++) {
    wait(NULL);
  }
  int sum = 0;
  for(int i = 0; i<m; i++) {
    printf("parciais[%d]: %d\n",i,parciais[i]);
    sum+=parciais[i];
  }
  printf("%d\n",sum);
}
/*
  if 1.mod.m == nr processo filho
  for(int i = 0; i<P; i++) {
    if(fork() == 0) {
      do_word(...);
      exit(...);
    }
  }
  int* parciais = (int*)mmap(NULL,m*sizeof(int),PROT_READ | PORT_WRITE, MAP_SHARED | MAP_ANONYMOUS, -1,0);

*/