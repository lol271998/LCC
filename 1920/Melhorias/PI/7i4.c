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

int main(void){
  char str[] = "asdasd";

  if(algum_digito(str) == 1) printf("Tem pelo menos um algarismo\n");
  else printf("Não tem nenhum algarismo\n");
  return 0;
}
