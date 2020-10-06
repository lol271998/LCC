#include <stdio.h>
int main(void)
{
	int a,b,c;
	printf("Introduza os 3 lados\n");
	scanf("%d %d %d",&a,&b,&c);
	if (a==b && a==c)
	{
	printf("Primeiro lado: %d\n",a);
	printf("Segundo lado: %d\n",b);
	printf("Terceiro lado: %d\n",c);
	printf("Triângulo equilatero\n");
	return 0;
	}
	if (a==b && a!=c || a==c && a!=b || b==c)
	{
	printf("Primeiro lado: %d\n",a);
	printf("Segundo lado: %d\n",b);
	printf("Terceiro lado: %d\n",c);
	printf("Triângulo isósceles\n");
	return 0;
	}
	else
	{
	printf("Primeiro lado: %d\n",a);
	printf("Segundo lado: %d\n",b);
	printf("Terceiro lado: %d\n",c);
	printf("Triângulo escaleno\n");
	return 0;
	}
}
