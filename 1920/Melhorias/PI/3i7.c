#include<stdio.h>
int main(void){
	int a,b,c;
	scanf("%d %d %d", &a,&b,&c);
	printf("Primeiro valor: %d\n",a);
	printf("Segundo valor: %d\n",b);
	printf("Terceiro valor: %d\n",c);
	int maior,menor,mediana;
	if(a>=b){ 
		maior = a;
		menor = b;
	}
	else{ 
		maior = b;
		menor =a;
	}
	if(c>=maior){ 
		maior = c;
	}
	else if(c<=menor) c = menor;
	
	mediana = a+b+c-maior-menor;
	printf("Mediana: %d\n",mediana);
}