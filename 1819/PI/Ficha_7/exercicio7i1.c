#include <stdio.h>
#include <ctype.h>
void capitalizar (char  str[])
{
	int i;
	for(i=0;str[i]!='\0';i++)
	{
		str[i]=toupper(str[i]);
	}
}

int main()
{
	char text[100]="text";
	capitalizar(text);
	printf("%s\n",text);
}