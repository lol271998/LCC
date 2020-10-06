#include <stdio.h>
double aprox_pi(int n)
{
	double soma,parc,num;
	soma=0;
	parc=0;
	num=1;
	for (int i=0;i<=n;i++)
	{
		num=num*(-1);
		parc-=num/((2*i)+1);
	}
	soma=4*parc;
	return soma;
}
int main(void)
{
	printf("%f",aprox_pi(10));
}