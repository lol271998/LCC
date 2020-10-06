#include<stdio.h>
int main(void){
	int la,lb,lc;
	printf("Introduza os 3 lados dos triangulos: \n");
	scanf("%d %d %d",&la,&lb,&lc);
	printf("Primeiro lado: %d\n",la);
	printf("Segundo lado: %d\n",lb);
	printf("Terceiro lado: %d\n",lc);
		if((la==lb) && (la==lc)){ 
			printf("Triangulo Equilatero\n");
			return 0;
		}
		if(((la==lb) && (lb!=lc)) || ((lc==lb) && (lc!=la)) || ((la==lc) && (la!=lb))){
			printf("Triangulo Isósceles\n");
			return 0;
		}
		else
			printf("Triangulo Escaleno\n");		
}