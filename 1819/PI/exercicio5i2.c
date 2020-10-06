#include <stdio.h>
/* Calcular o mdc de dois inteiros usando
   o algoritmo de Euclides (2ª versão)
   */
int main(void)
{
  int r,a,b,i=1;
  scanf("%d %d",&a,&b);
  printf("mdc(%d,",a);
  printf("%d)= ",b);
   while (a != b) 
   {
     if(a > b)
         a = a - b;
      else
         b = b - a;
    printf("mdc(%d,",a);
    printf("%d)= ",b);
    i++;
    }
    printf("%d\n",b);
    printf("Numero de interações: %d\n",i);
}

