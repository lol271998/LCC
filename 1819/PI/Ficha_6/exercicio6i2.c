#include <stdio.h>
#include <stdlib.h>
#define num_perguntas 10
int random_1 (void)
{
	int a,b;
      a = 1 + (int)((double)rand() /((double)RAND_MAX+1)*9);
      return a;
      b = 1 + (int)((double)rand() /((double)RAND_MAX+1)*9);
      return b;
}
int main(void)
{
	int i,a,b,res,ic=0,ie=0,c;
	for(i=0;i<num_perguntas;i++)
	{
		a=random_1();
		b=random_1();
		c=a*b;
		printf("Quanto é %d",a);
		printf("*%d?\n",b);
		scanf("%d",&res);
		if (res==c)
		{
			printf("Certo!\n");
			ic++;
		}
		else
		{
			printf("Errado! O resultado é %d \n",c);
			ie++;
		}
	}
	printf("Numero de respostas erradas: %d\n",ie);
	printf("Numero de respostas certas: %d\n",ic);
}