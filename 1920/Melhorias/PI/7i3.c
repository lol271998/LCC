#include<stdio.h>
#include<ctype.h>
#include<string.h>

int todos_letras(char str[]){
  int size = strlen(str);
  if(size == 0) return 0;
  else{
    for(int i = 0; i<size; i++){
      if(!isalpha(str[i])) return 0;
    }
  }
  return 1;
}

int main(void){
  char str[] = "1";
  if(todos_letras(str) == 1) printf("Tem só letras\n");
  else printf("Não tem só letras\n");
  return 0;
}
