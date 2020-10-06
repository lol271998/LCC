#include<string.h>
#include<stdio.h>

void ordenar(char str[]){
  int n = strlen(str);
  int temp;
  for(int i = 0; i<n; i++){
    temp = str[i];
    for(int j = 0; j<n; j++){
      if(str[i]<str[j]){
	temp = str[i];
	str[i] = str[j];
	str[j] = temp;
      }
    }
  }
}

int main(void){
  char str[] = "ALGORITMO";
  int n = strlen(str);
  ordenar(str);
  for(int i = 0; i<n; i++){
    putchar(str[i]);
  }
  printf("\n");
}
