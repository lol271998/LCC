/*Escreva um programa para ler carateres da entrada-padrão e escrever na saída-padrão
convertendo para maiúsculas todas as letras minúsculas que ocorrem imediatamente depois
de um espaço. Por exemplo: o texto (onde os espaços estão assinalados )
---to be or not to be, that is the question.
deve ser transformado em
---to Be Or Not To Be, That Is The Question.
Sugestão: utilize duas variáveis distintas para guardar os dois últimos carateres lidos (desta
forma pode facilmente testar se o carater anterior foi um espaço). Pode ainda utilizar funções
de biblioteca para testes e conversões de letras (ver a aula 10).*/
#include<stdio.h>
#include<ctype.h>
int main(void){
	int letra1,letra2;
	letra1=getchar();
	letra2=getchar();
	while(letra1!='\n' || letra2!='\n'){
		if(letra1==' ' && letra2==' '){
				letra2=toupper(letra2);
				putchar(letra2);
		}
		if(letra2==' ')
			letra1=toupper(letra1);
		else{
			putchar(letra1);
			putchar(letra2);
		}
		letra1=getchar();
		letra2=getchar();
	}
}

//exercicio_codex
#include <stdio.h>
#include <ctype.h>
int main (void)
{
	int ch,a;
	a='!';
	do
	{
	 ch=getchar();
	if (ch!=EOF)
	{
		if(a==' ' && ch!=' ')
			putchar(toupper(ch));
		else
			putchar(ch);

	}
	a=ch;	
	} 
	while (ch!=EOF);
		return 0;
}