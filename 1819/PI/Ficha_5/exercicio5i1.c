#include <stdio.h>
#define FALSE 0
#define TRUE  1
/* Testar se um número inteiro é primo */
int primo(int n) {
   int d;
   if(n <= 1) return FALSE;
   for (d = 2; d < n; d++) {
     if (n%d == 0)  // d divide n?
       return FALSE;
    }
   return TRUE;
}
int main(void)
{
   int l,n=1;
   printf("Limite superior: \n");
   scanf("%d",&l);
   while (n<100)
   {
   	n++;
    if (primo(n))
    	printf("%d\n",n);
   }
}