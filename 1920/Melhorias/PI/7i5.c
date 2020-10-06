#include<stdio.h>
#include<ctype.h>
#include<string.h>


int algum_digito(char str[]){
  int size = strlen(str);
  for(int i = 0; i<size; i++){
    if(isdigit(str[i])) return 1;
  }
  return 0;
}

int maiscula(char str[]){
  int size = strlen(str);
  for(int i = 0; i<size; i++){
    if(isupper(str[i])) return 1;
  }
  return 0;
}

int minuscula(char str[]){
  int size = strlen(str);
  for(int i = 0; i<size; i++){
    if(islower(str[i])) return 1;
  }
  return 0;
}

int forte(char str[]){
  int size = strlen(str);
  if(size<6) return 0;
  if(algum_digito(str) != 1) return 0;
  if((minuscula(str) == 0) ||  (maiscula(str) == 0)) return 0;
  return 1;
}

int main(void){
  char str[] = "aaaa1a";
  if(forte(str) == 1) printf("É forte\n");
  else printf("Não é forte\n");
  return 0;
}


