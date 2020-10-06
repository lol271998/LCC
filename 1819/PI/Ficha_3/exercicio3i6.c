#include <stdio.h>
int main(void)
{
	int a,b,c,v;
	printf("Introduza os valores: \n");
	scanf("%d %d %d",&a,&b,&c);
	 if (a == b && a == c && b == c)
	 	printf("Resposta: Valores distintos: 0\n");
	 if ((a == b && a!= c)|(a == c && a!=b)|(b==c && b!=a))
	 	printf("Resposta: Valores distintos: 2\n");
	 if (a!=c && a!=b && b!=c)
	 	printf("Resposta: Valores distintos: 3\n");
}