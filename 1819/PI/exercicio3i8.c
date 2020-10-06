#include <stdio.h>
int main(void)
{
    int b,p,a,r;
    printf("Introduza o valor da base da potência\n");
    scanf("%d",&b);
    printf("Introduza o valor da potência\n");
    scanf("%d",&p);
    if (p!=0)
    {
      r=b;
      for (a=1;a<p;a++)
      {
               r=r*b;
      }
      printf("Resultado: ""%d\n",r);
    }
    else
      printf("Restultado: 1\n" );
}
