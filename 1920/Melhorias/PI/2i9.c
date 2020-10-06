//Escreva o programa anterior da forma ((((3x+ 2)x−5)x−1)x+ 7)x−6

#include<stdio.h>

int main(void){
	float x,res;
	scanf("%f",&x);
	res = ((((3*x+2)*x-5)*x-1)*x+7)*x-6; 
	printf("res: %f\n",res);
}