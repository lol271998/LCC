#include <stdio.h>
int main(void)
{
	int num1,den1,num2,den2,somanum,somaden;
	printf("Inserir o primeiro numerador: \n");
	scanf("%d",&num1);
	printf("Inserir o primeiro denominador: \n");
	scanf("%d",&den1);
	printf("Inserir o segundo numerador: \n");
	scanf("%d",&num2);
	printf("Inserir o segundo denominador: \n");
	scanf("%d",&den2);
	if (den1==den2)
	{
		somanum=num1+num2;
		printf("%d/%d",num1,den1);
		printf("+%d/%d",num2,den2);
		printf("=%d/%d\n",somanum,den1);
	}
	else
	{
		somanum=(num1*den2)+(num2*den1);
		somaden=(den1*den2);
		printf("%d/%d",num1,den1);
		printf("+%d/%d",num2,den2);
		printf("=%d/%d\n",somanum,somaden);
	}
}