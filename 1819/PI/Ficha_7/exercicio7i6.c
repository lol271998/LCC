#include <stdio.h>
#include <ctype.h>
#include <string.h>
int potencia(int x, int n)
{
  int i,a;
  a = 1;
  for(  i =1; 
        i<=n;
        i++)
    {
      a*=x;
    }
    return a;
}
int decimal(char str[])
{
    int i,n,l,num,numd,numf;
    char b;
    numf=0;
    n=0;
    for (l=strlen(str)-1;str[l]!='\0';l--)
    {
        b = str[l]-'0';
        num = b;
        numd=num*potencia(10,n);
        numf=numf+numd;
        n++;
    }
    printf("%d\n",numf);
}
int main ()
{
    decimal("");
}