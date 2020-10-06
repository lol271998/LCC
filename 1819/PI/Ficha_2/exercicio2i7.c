#include <stdio.h>
int main(void)
{
	int a, b, c, maior;
	scanf("%d %d %d", &a, &b, &c);
	if (a>=b)
		maior=a;
	else
		maior=b;
	if (maior<=c)
		maior=c;
	printf("%d\n", maior);
}
