#include <stdio.h>
int main(void)
{
	int n;
	scanf("%d",&n);
		if (n%4 == 0 && n%100!= 0)
			return 1;
		else
			return 0;
}