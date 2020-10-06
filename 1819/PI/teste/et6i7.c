/*6.7 Escreva um programa que lê carateres e contabiliza o número de vezes de ocorreu cada
letra (A a Z) ignorando a distinção entre maiúsculas e minúsculas. No final deve imprimir
uma tabela com as contagens:
A: 3 B: 2 C: 2 D: 1 E: 7 ...
Sugestão: utilize uma variável indexada com 26 elementos para contabilizar a contagem das
letras. Pode ainda converter cada carater para maíuscula para evitar ter de tratar letras
minúsculas (ver o último exemplo da aula 10).*/
#include<stdio.h>
#include<ctype.h>
int indice(int vec[], int ch){
	int i=0;
	while(i<26){
		if(vec[i]==ch)
			break;
	i++;
	}
	return i;
}
int main(void){
	int vec1[26],ch,ind,i;
	int vec[26]={'A','B','C','D','E','F','G','H','I','J'
			,'K','L','M','N','O','P','Q','R','S','T',
			 'U','V','W','X','Y','Z'};
	for(i=0;i<=26;i++) vec1[i]=0;
	do{
		ch=getchar();
		ch=toupper(ch);
		ind=indice(vec,ch);
		vec1[ind]=vec1[ind]+1;
	}while(ch!='\n');
	for(i=0;i<26;i++){
		printf("%d ",putchar(vec[i]));
		printf(": %d\n",vec1[i]);
	}
}