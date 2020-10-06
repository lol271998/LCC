#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<ctype.h>
#define size 10


void esp (char *s){
  char *str = malloc(strlen(s));
  strcpy(str,s);
  for(int i = 0; i<size; i++){
    if(!(isalpha(str[i]))) str[i] = ' ';
  }
}

char* esp1(char *s){
  
  return s;
}

int main(void){
  char *str = "A, ah Ah!";
  char *stra = "A, ah Ah!";
  esp(str);
  char* str1 = esp1(stra);
  printf("%s \n",str);
  printf("%s \n",str1);
  return 0;
}



