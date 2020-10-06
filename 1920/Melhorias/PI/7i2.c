#include<stdio.h>
#include<ctype.h>

void inverter(char str[],int size){
  int j, i = 0;
  j = size -1;
  while(i<j){
    char ch = str[i];
    str[i] = str[j];
    str[j] = ch;
    i++;
    j--;
  }
}

int palindromo(char str[]){
  int i = 0;
  while(str[i]!= '\0') i++;
  char strc[i];
  for(int j = 0; j<i; j++){
    strc[j] = str[j];
  }
  inverter(strc,i);
  for(int j = 0; j<i; j++){
    if(strc[j] != str[j]) return 0;
  }
  return 1;
}

int main(void){
  char str[] = "";
  if(palindromo(str) != 1) printf("Não é Palindromo\n");
  else printf("É Palindromo\n");
  return 0;
}
