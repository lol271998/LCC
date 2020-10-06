/*Escrever um programa que simplifica uma fração*/

#include<stdio.h>

int mdc1(int a, int b){
  int r;
  while(b!=0){
    r = a%b;
    a = b;
    b = r;
  }
  return a;
  
}

int main(void){
  int num,den,numf,denf,md;
  printf("Introduza o numerador e o denominador da fração: \n");
  num = 56;
  den = 26;
  scanf("%d %d",&num,&den);

  md = mdc1(num,den);

  numf = num/md;
  denf = den/md;

  printf("Fração simplificada: %d/%d\n",numf,denf);
 
  return 0;
}
