#include <stdio.h>
#include <ctype.h>
int todas_letras(char str[])
{
	int i,d;
	for(i=0;str[i]!='\0';i++)
	{
	   if(isalpha(str[i]))
	   	d=0;
	   else
	   {
	   	d=1;
	    break;
	   }
	}
	return d;
}

int main()
{
	int r;
	r=todas_letras("asdasdas1dasd");
	printf("%d\n",r);
}
