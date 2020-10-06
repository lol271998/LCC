/*Escreva um programa que lê repetidamente carateres até encontrar uma mudança de
linha (\n) e contabiliza o número total de letras (isto é, carateres de 'A' a 'Z' e de 'a' a
'z'). Exemplo (em sublinhado o texto introduzido pelo utilizador):
Ola, Mundo!
A frase contém 8 letra(s)
Sugestão: usar getchar() para ler um carater de cada vez.*/
#include<stdio.h>
int main(void){
	int letra,c;
	printf("Introduza o texto\n");
	letra=getchar();
	while(letra!='\n'){
		if(letra>='A'&& letra<='z')
			c++;
		letra=getchar();		
	}
	printf("A frase contém %d letra(s)\n",c);
}