#include<stdio.h>

int main(void){
  
  int valor,max;
  max = 0;
  scanf("%d",&valor);
  while(valor != 0){
    if(max<valor) max = valor;
    scanf("%d",&valor);
  }
  printf("maior: %d\n",max);
}
