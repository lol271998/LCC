/* Escreva uma função int palindromo(char str[]) que testa se uma cadeia de carateres
é um palíndromo, isto é, se tem a mesma sequência de carateres da esquerda para a
direita e vice-versa.
Sugestão: modifique a função apresentada na aula teórica 13 para inverter uma cadeia*/
#include<stdio.h>
#include<string.h>
int inverter(char str[])
{
   int i = 0, j,a;
   char str1[strlen(str)];
   j = strlen(str) - 1;
   for(i=0;i<strlen(str);i++){
   		str1[i]=str[i];
   }
   i=0;
   while (i < j) {
      char ch = str[i];
      str[i] = str[j];
      str[j] = ch;
      i ++;
      j --;
   }
   for(i=0;i<strlen(str);i++){
   		if(str[i]!=str1[i]){
   			a=0;
   			break;
   		}
   		else a=1;
   }
   return a;
}
int polindromo(char str[]){
		if(inverter(str)!=1)
			printf("Não é um polindromo\n");
		else
			printf("É um polindromo\n");
		return 0;
}
int main(void){
	char str[]="ABCBAf";
	polindromo(str);
}