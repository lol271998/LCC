/*Escreva uma função int decimal(char str[]) que converte uma cadeia de carateres
com algarismos de 0 a 9 no valor inteiro decimal correspondente. Por exemplo:
decimal("1234") deve dar retornar o inteiro 1234.*/
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