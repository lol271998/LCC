/*No jogo SCRABBLE os jogadores pontuam formando palavras do dicionário com fichas
representando letras individuais. A pontuação de cada letra depende da sua raridade no
dicionário. As pontuações para o inglês são: A,E,I,L,N,O,R,T,S,U: 1 ponto; D,G: 2 pontos;
B,C,M,P: 3 pontos; F,H,V,W,Y: 4 pontos; K: 5 pontos; J,X: 8 pontos; Q,Z: 10 pontos. A
pontuação duma palavra é a soma dos pontos de letras individuais.1 Por exemplo: a palavra
"PITFALL" vale 3 + 1 + 1 + 4 + 1 + 1 + 1 = 12 pontos.
Escreva um programa que lê uma sequência de carateres de uma palavra terminada por EOF
e calcula e imprime a sua pontuação; considere que espaços ou outros carateres não-letras
valem 0 pontos.
Sugestão: defina uma função auxiliar para calcular a pontuação para um carater apenas;
pode ainda usar a instrução switch para selecionar o a pontuação de cada letra.*/
#include<stdio.h>
#include<ctype.h>
int jogo(int letra){
	int p=0;
	switch (letra){
	   case'A':case'E':case'I':case'L':case'N':case'O':
	   case'R':case'T':case'S':case'U':
		p=1;
		break;
	   case'D':case'G':
		p=2;
	    break;
	   case'B':case'C':case'M':case'P':
		p=3;
		break;
	   case'F':case'H':case'V':case'W':case'Y':
		p=4;
		break;
	   case'K':
		p=5;
		break;
	   case'J':case'X':
		p=8;
		break;
	   case'Q':case'Z':
		p=10;
		break;
	  }
	  return p;
}
int main(){
	int pontos,letra,res=0;
	letra=' ';
	while(letra!='\n'){
		letra=getchar();
		letra=toupper(letra);
		pontos=jogo(letra);
		res=res+pontos;
	}
    printf("%d",res);
}