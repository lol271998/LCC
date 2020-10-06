#include <stdio.h>
int main(void) {
int a, b, c, maior;
printf("Introduza os três valores: \n");
scanf("%d %d %d", &a, &b, &c);
if(a>=b)
maior=a;
else
maior=b;
if (c>=maior)
maior=c;
printf("%d\n", maior); // imprimir o resultado
}