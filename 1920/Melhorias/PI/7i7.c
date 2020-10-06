#include<stdio.h>
#include<ctype.h>
#include<string.h>

int calculadora(char str[]){
  int size = strlen(str);
  if(size>3) return 0;
  int a,b;
  a = str[0]-'0';
  b = (int)str[2]-'0';
  switch(str[1]){
  case '+':
    return a+b;
    break;
  case '*':
    return a*b;
    break;
  case '-':
    return a-b;
    break;
  }
  return 0;
}

int main(void){

  char str[] = "5*7";
  printf("Resultado: %d\n",calculadora(str));
  return 0;
}
