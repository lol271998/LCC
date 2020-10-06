/*Escreva uma função int calc(char str[]) que implementa uma mini-calculadora: a
cadeia de carateres dada tem sempre 3 carateres correspondentes a dois algarismos decimais
('0' até '9') e um sinal de operação no meio ('+', '-', '*'). A função deve calcular o
valor da expressão e retornar o inteiro correspondente.
Exemplos: calc("5-3") dá 2; calc("2*3") dá 6.*/
#include<stdio.h>
int calc(char str[]){
	int res,num1,num2;
	num1=str[0]-'0';
	num2=str[2]-'0';
	switch(str[1]){
		case '+':
		res=num1+num2;
		case '-':
		res=num1-num2;
		case '*':
		res=num1*num2;
	}
	return res;
}
int main(void){
	char str[3]="0*6";
	printf("O resultado é %d\n",calc(str));
}