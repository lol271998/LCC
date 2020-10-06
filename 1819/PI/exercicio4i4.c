#include <stdio.h>
int main(void)
{
   float n,med,nm=0,nf=0;
   printf("Introduza valores; 0 termina.\n");
   while (n != 0)
   {
   	scanf("%f", &n);
   	nm++;
   	nf=nf+n;
   }
   med=nf/nm;
   printf("A média é: %f\n,", med);
   return 0;
}