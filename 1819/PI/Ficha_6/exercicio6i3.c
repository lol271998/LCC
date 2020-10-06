#include <stdlib.h>
#include <stdio.h>
int random_1(void)
{
	int a;
      a = 1 + (int)((double)rand() /((double)RAND_MAX+1)*1000);
}
int main(void)
{
	int a,b;
	printf("Escolha um numero\n");
	scanf("%d",&a);
	b=random_1();
	while (a!=b)
	{
		if (a>b)
			printf("Demasiado alto!\n");
		else
			printf("Demsaido baixo\n");
	scanf("%d",&a);
	}
	printf("Parabens, acertou!!\n");
}

