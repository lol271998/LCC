#include<stdio.h>
#include<string.h>
#include<stdlib.h>

int main(int argc, char** argv){

  int soma = 0;
  
  for(int i = 0; i<argc; i++){
    soma+=atoi(argv[i]);
  }
  printf("%d\n",soma);
}
