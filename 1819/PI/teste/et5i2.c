/*Modifique a implementação do algoritmo de Euclides usando subtrações sucessivas
(aula teórica 7) para imprimir uma linha de texto com os valores dos inteiros a, b em cada
iteração; no final deve ainda imprimir o m.d.c. e o número de iterações efetuadas. Exemplos
para mdc(12,18) e mdc(36,21):
mdc(12,18) = mdc(12,6) = mdc(6,6) = 6
3 iterações
mdc(36,21) = mdc(15,21) = mdc(15,6) = mdc(9,6) = mdc(3,6) = mdc(3,3) = 3
6 iterações*/
#include<stdio.h>
int mdc(int a, int b)
{
   int num=1;
   printf("mdc(%d,",a);
   printf("%d) =",b);
   while (a != b) {
     if(a > b)
         a = a - b;
      else
         b = b - a;
     printf(" mdc(%d",a);
     printf(",%d) = ",b);
     num++;
   }
   printf("%d\n",a);
   printf("%d interações\n",num);
   return a; // a, b são iguais
}
int main(void){
	mdc(12,18);
}