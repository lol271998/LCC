#include <stdio.h>
#include <ctype.h>
int main(void)
{
	char ch;
	int i=0;
	ch=getchar();
	while (ch!='\n')
	{
		putchar(ch);
		ch=getchar();
		if (ch!=' ')
			i++;
	}
	printf("\n");
	printf("Tem %i ",i);
	printf("caracteres");
}