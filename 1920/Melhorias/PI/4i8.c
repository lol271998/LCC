/*Escrever um programa que lê um inteiro não negativo e imprime os seus digitos binários */
#include<stdio.h>

int binario(int n){
  int numb,resto;
  int i = 1;
  numb = 0;
  while(n != 0){

    resto = n%2;
    n /= 2;
    numb += resto*i;
    i *=10;
    printf("resto: %d, i: %d, numb = %d, n=%d \n",resto,i,numb,n);
  }
  return numb;
}

int main(void){
  int num;
  printf("Introduza um numero para passar para binário\n");
  scanf("%d",&num);
  printf("%d em binário é %d\n",num,binario(num));
    
}
