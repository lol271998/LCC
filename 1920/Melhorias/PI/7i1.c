#include<stdio.h>
#include<ctype.h>

void capitalizar(char str[]){
  for(int i = 0; str[i]!='\0'; i++){
    str[i] = toupper(str[i]);
  }
}

int main(void){

  char str[10000];
  int i = 0;
  int c;
  
  do{
    c = getchar();
    str[i] = c;
    i++;
  }while(c!='\0');
  capitalizar(str);
  for(int i = 0; str[i]!='\0'; i++) putchar(str[i]);
  return 0;
}
