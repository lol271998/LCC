#include<stdio.h>
#include<ctype.h>
#include<string.h>

void normalizar(char str[]){
  int n = strlen(str);
  int j,i = 0;
  while(i<n){
    if(!isalpha(str[i])){
      n--;
      for(j = i; j<n; j++){
	str[j] = str[j+1];
      }
      str[j] = '\0';
    }
    else i++;
  }
  for(int i = 0; i<n; i++){
    str[i] = toupper(str[i]);
  }
}

void ordenar(char str[]){
  int n = strlen(str);
  for(int i = 0; i<n; i++){
    int temp = str[i];
    for(int j = i; j<n; j++){
      if(str[i]>str[j]){
	temp = str[i];
	str[i] = str[j];
	str[j] = temp;
     
      }
    }
  }
}


int anagramas(char str1[],char str2[]){
  normalizar(str1);
  normalizar(str2);
  if(strlen(str1)!=strlen(str2)) return 0;
  else printf("Pass Strlen(str1) == Pass Strlen(str2)\n");
  ordenar(str1);
  ordenar(str2);
  for(int i = 0; i<strlen(str1); i++){
    if(str1[i] != str2[i]){
      putchar(str1[i]);
      putchar('\t');
      putchar(str2[i]);
      printf("\n");
      return 0;
    }
  }
  return 1;
}


int main(void){
  char str1[] = "Quid est    veritas?";
  char str2[] = "Est vir qui adest";
  if(anagramas(str1,str2)!=1)printf("Não é anagrama \n");
  else printf("É anagrama \n");

  for(int i = 0; i<strlen(str1); i++){
    putchar(str1[i]);
  }
  printf("\n");
  
  for(int i = 0; i<strlen(str1); i++){
    putchar(str2[i]);
  }
  printf("\n");
  return 0;
}
