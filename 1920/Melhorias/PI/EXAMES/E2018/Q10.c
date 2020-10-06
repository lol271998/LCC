#include<stdio.h>

int fun(char *ptr) {
  int n = 0;
  while(*ptr !='\0') {
    if(*ptr !=' '&& *ptr !='\n')
       n++;
    ptr++;
  }
  return n;
}

int main(void){
  char *ptr = "OLA    D ";
  printf("%d\n",fun(ptr));
}
