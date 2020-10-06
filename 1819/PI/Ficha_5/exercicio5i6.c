#include <stdio.h>
#include <ctype.h>
int main (void)
{
	int ch,a,b;
	a='!';
	do
	{
	 ch=getchar();
	if (ch!=EOF)
	{
		if(a==' ' && ch!=' ')
			putchar(toupper(ch));
		else
			putchar(ch);

	}
	a=ch;	
	} 
	while (ch!=EOF);
		return 0;
}