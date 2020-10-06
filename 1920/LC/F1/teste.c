#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int main(int argc, char** argv){
  char* qqcoisa = "blabala";
  char* copy;

  copy = qqcoisa;
  qqcoisa[3] = 'A';

  printf("%s\n",qqcoisa);
}
