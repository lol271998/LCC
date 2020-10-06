#include<stdio.h>

int main(void){
  int x[3] = {23,41,17};
  printf("Valor de cada indice do array: \n");
  printf("x[0] = %d\n",x[0]);
  printf("x[1] = %d\n",x[1]);
  printf("x[2] = %d\n",x[2]);
  printf("\n");

  printf("Endereço de x = %p\n",x);
  printf("*x: Valor para onde x aponta = %d\n",*x); //vec[0] = *(x+0);
  printf("\n");
  
  printf("Endereço de x+1 = %p\n",x+1);
  printf("*(x+1): Valor para onde x+1 aponta = %d\n",*(x+1)); //vec[1];
  printf("\n");

  printf("Endereço de x+2 = %p\n",x+2);
  printf("*(x+2): Valor para onde x+2 aponta  = %d\n",*(x+2)); //vec[2];
  printf("\n");
  
  printf("&(x[0]):Endereço de x[0] = %p\n",&(x[0]));
  printf("*&(x[0]): Valor para onde aponta x[0] = %d\n",*&(x[0]));
  //ERRO printf("&*(x[0]) = %d\n",&*(x[0]));
}
