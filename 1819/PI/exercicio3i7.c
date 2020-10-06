#include <stdio.h>
int main (void)
{
	int a,b,c,maior,menor,med;
	printf("Introduza 3 valores: \n");
	scanf("%d %d %d",&a,&b,&c);
	 if (a>=b)
	 	maior = a;
	 else
	 	maior = b;
	 if (c>=maior)
	 	maior = c;
	 if (a<=b)
	 	menor = a;
	 else
	 	menor = b;
	 if (c<menor)
	 	menor =c;
	med=(a+b+c)-(maior+menor);
    printf("Primeiro valor: ""%d\n",a);
    printf("Segundo valor: ""%d\n",b);
    printf("Terceiro valor: ""%d\n",c);
    printf("Mediana: ""%d\n",med);
}