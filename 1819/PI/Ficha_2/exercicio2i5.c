#include <stdio.h>
int main (void)
{
 int q,n20=0,n10=0,n5=0,n1=0;
 scanf("%d",&q);
 while (q>0)
 {
    if(q==20)
     q-=20;
     n20++;
    else
    {
     if (q%5==0)
     {
         n5++;
         q=q-n5*5;
     }
     if (q%10==0)
     {
        n10++;
        q= q-10*n10;
     }
    if (q%20!=0 && q%10!=0 && q%5!=0)
     {
        n1++;
        q=q-1;
     }
     if (q%20==0)
        {
        n20=q/20;
        q=q-n20*20;
        }
    }      
 }  
  printf(" Notas de 20: ""%d\n",n20);
  printf(" Notas de 10: ""%d\n",n10);
  printf(" Notas de 5: ""%d\n",n5);
  printf(" Moedas de 1: ""%d\n",n1 );
}