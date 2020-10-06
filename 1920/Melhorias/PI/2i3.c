//Lê o raio e calcula o volume da esfera
#include <stdio.h>

int main(void){
	float r,res;
	scanf("%f",&r);
	res = (4.0/3.0)*3.14*(r*r*r);
	printf("res: %f \n",res);

}