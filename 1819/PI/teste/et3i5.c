/*Escreva um programa que lê 3 valores inteiros da entrada-padrão e escreve o valor máximo,
o valor mínimo e a amplitude (i.e. o valor máximo menos o valor mínimo). Exemplos:
Primeiro valor: 12
Segundo valor: 3
Terceiro valor: 27
Valor máximo: 27
Valor mínimo: 3
Amplitude: 24*/
#include<stdio.h>
int main(void){
	int va,vb,vc,amp,maior,menor;
	printf("Introduza os 3 valores: \n");
	scanf("%d %d %d",&va,&vb,&vc);
	printf("Primeiro valor: %d\n",va);
	printf("Segundo valor: %d\n",vb);
	printf("Terceiro valor: %d\n",vc);
		if(va>=vb) maior=va;
		else maior=vb;
		if(vc>=maior) maior=vc;
		if(va<=vb) menor=va;
		else menor=vb;
		if(vc<=menor) menor=vc;
	printf("Valor máximo: %d\n",maior);
	printf("Valor mínimo: %d\n",menor);
	amp=maior-menor;
	printf("Amplitude: %d\n",amp);






}