#include <stdio.h>
#include <string.h>
void ordenar(char str[])
{
	int i,l,j,letra;
	l=strlen(str);
	for (i=1;i<l;i++)
	{
	  letra=str[i];
	  j = i-1;
	
	  while(j>=0 && str[j]>letra)
	    {
	      str[j+1] = str[j];
	      j--;
	    }
	  str[j+1]= letra;
	}
	// str[l]='\0';
}

int main()
{
	char a[20]="ALGORITMO";
	ordenar(a);
}
