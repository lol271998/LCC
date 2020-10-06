#include<stdio.h>
#include<string.h>
#include<stdlib.h>

int main(int argc, char** argv){

  int count = 0;
  
  for(int i = 1; i<argc; i++){
    for(int j = 0; argv[i][j]!='\0'; j++){
      count++;
    }
    printf("%d\n",count);
    count = 0;
  }
}
