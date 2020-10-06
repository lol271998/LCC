#include <stdio.h>
int encontra(int vec[],int size,int val)
{
	int i;
	for(i=0;i<size;i++) { 
		if (vec[i]==val)
		{
			return i;
		}
	}
	return 0;
}
int main(void)
{
	int vec[100],i=0,val;
	
	while (1)
	{
		scanf("%d",&val);
		if (val==-1)
			break;
		if (encontra(vec,i,val)==0)
		{
			vec[i]=val;
			i++;
		}
	}
	return 0;
}
