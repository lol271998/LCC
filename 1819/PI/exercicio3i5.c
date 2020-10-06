#include <stdio.h>
int main (void)
{
	int a,b,c,maior,menor,amp;
	printf("Introduza 3 valores\n");
	scanf("%d %d %d",&a,&b,&c);
	 if (a>=b)
		maior = a;
	 else 
		maior = b;
	 if (maior<=c)
		maior = c;
	 if (a<=b)
	 	menor = a;
	 else
	 	menor = b;
	 if (maior<c)
	 	menor=c;
	 amp = maior-menor;
	printf("Primeiro valor: ""%d\n",a);
	printf("Segundo valor: ""%d\n",b);
	printf("Terceiro valor: ""%d\n",c);
	printf("Maior valor: ""%d\n",maior);
	printf("Menor valor: ""%d\n",menor);
	printf("Amplitude: ""%d\n",amp);
}
