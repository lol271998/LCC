#include<string.h>
#include<stdio.h>

void ordenar(char str[]){
  int n = strlen(str);
  int temp;
  for(int i = 0; i<n; i++){
    //temp = str[i];
    for(int j = 0; j<n; j++){
      if(str[i]<str[j]){
	temp = str[i];
	str[i] = str[j];
	str[j] = temp;
      }
    }
  }
}

int anagramas(char str1[], char str2[]){
  int n1 = strlen(str1);
  int n2 = strlen(str2);
  if(n1 != n2) return 0;
  ordenar(str1);
  ordenar(str2);
  for(int i = 0; i<n1; i++){
    if(str1[i] != str2[i]) return 0;
  }
  return 1;
}


int main(void){
  char str1[] = "ALGORITMO";
  char str2[] = "LARGOIMTO";
  
  int n = strlen(str1);
  if(anagramas(str1,str2) == 1) printf("É um anagrama");
  else printf("Não é anagrama");
  
  printf("\n");
}
