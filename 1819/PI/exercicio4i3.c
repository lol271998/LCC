#include <stdio.h>

int main(void) 
{
   int n, max;
   printf("Introduza valores; 0 termina.\n");
   max=0;
   while (n != 0)
   {
   	scanf("%d", &n);
   if (n>max)
   	max=n;
   }
   printf("O máximo é: %d\n,", max);
   return 0;
}