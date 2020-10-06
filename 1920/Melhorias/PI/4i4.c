#include<stdio.h>

int main(void){

  float soma,media,i,valor;

  soma = 0;
  media = 0;
  i = 0;
  printf("Introduza o valor\n");
  scanf("%f",&valor);
  while(valor!=0){
    soma += valor;
    i++;
    scanf("%f",&valor);
  }
  media = soma/i;
  printf("Média: %f\n",media);
}
