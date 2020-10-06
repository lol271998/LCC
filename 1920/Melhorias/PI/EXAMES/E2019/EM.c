#include<stdio.h>
#include<stdlib.h>

int f(int n){
  if(n == 0) return 1;
  else if(n%2 == 1) return 3*f(n-1);
  else return 2*f(n-1);
}

//Q1 - a) Deve terminar com return 0, para indicar que não ocorreu nenhum erro.
//Q2 - b) Pré processamento, compilação e ligação do ficheiro binário.
//Q5 - c) c>= 'A' && c<='Z'
int main(void){
  /*printf("Q3 - 11%%3+10/2 = %d\n",11%3+10/2);
  printf("Q4 - 11/3+10%%2 =  %d\n",11/3+10%2);
  printf("Q7:\n");
  for(int k = 1; k<=100;k++){
    if(!(k%2 == 0 || k%3 == 0)) printf("%d\n",k);
  }
  printf("Q8:\n");
  for(int k = 1; k<=100;k++){
    if((k%2 == 0 || k%3 == 0)) printf("%d\n",k);
    }*/
  /*
  printf("{");
  for(int i = 0;i<50; i++){
    int r = rand()%10-5;
    printf("%d,",r);
    if(i == 49) printf("%d}\n",r);
    }*/
  printf("resultado f(3) = %d\n",f(3));
}
