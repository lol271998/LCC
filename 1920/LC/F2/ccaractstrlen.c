#include<stdio.h>
#include<string.h>
#include<stdlib.h>

int main(int argc, char** argv){
  for(int i = 1; i<argc; i++){
    int c = strlen(argv[i]);
    printf("%d\n",c);
  }
}
