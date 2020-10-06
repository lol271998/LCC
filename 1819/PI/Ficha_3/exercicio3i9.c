#include <stdio.h>
int potencia(int x, int n)
{
	int i,a;
	a=1;
	for(i=1;i<=n;i++)
	{
		a=a*x;
	}
	return a;
}
int main (void)
{
	printf("%d\n",potencia(2,4));
}
