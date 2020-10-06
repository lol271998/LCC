#include <stdio.h>
#include <ctype.h>
int algum_digito(char str[])
{
	int i,d;
	for(i=0;str[i]!='\0';i++)
	{
	   if(isdigit(str[i]))
	   {
	   	d=0;
	    break;
	   }
	   else
	   {
	   	d=1;
	   	continue;
	   }
	}
	return d;
}

int main()
{
	int r;	
	r=algum_digito("asdas1dasdasd1");
	printf("%d\n",r);
}