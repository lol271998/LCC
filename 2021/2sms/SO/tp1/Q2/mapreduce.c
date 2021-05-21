#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/mman.h>
#include <errno.h>

void do_work(int np,const char* fname, int m, int k, int* parciais) {
  
  FILE *fp = fopen(fname,"r");
  if(fp == NULL) {
    printf("Cannot open file \n");
    return;
  }

  char* line = NULL;

  int size = 4;
  fscanf(fp,"%d",&size); //usar getline
  fgetc(fp); //'\n'
  for(int i = 0; i<size; i++) {
    getline(&line,NULL,fp);
    if(i%m == np) {
      for(int j = 0; j<size; j++) {
        char* tok;
        tok = strtok(line," ");
        while(tok != NULL) {
          if(k<atoi(tok)) parciais[i]++;
          tok = strtok(NULL," ");
        }
      }
    }
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
  for(int i = 0; i<m; i++)parciais[i] = 0;

  for(int i = 1; i<m; i++) {
    if(fork() == 0) {
      do_work(i,argv[1],m,k,parciais);
      exit(0);
    }
  }
  int sum = 0;
  for(int i = 0; i<m; i++) {
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