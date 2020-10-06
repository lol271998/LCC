#include <stdio.h>

int encontra(int vec[], int size, int val)
{
	int i;
	for(i=0;i<size;i++)
		if (vec[i]==val)
			printf("1");
		else
			printf("0");
}
int main(void)
{
	int vec[5]={1,2,3,4,5};
	encontra(vec, 5, 1);
}