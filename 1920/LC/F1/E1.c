#include<stdio.h>

int main(void){
  int l = 5;
  int *p = &l;
  printf("l: %d\n",l);
  printf("p: %ls\n",p);
  p++;
  printf("l: %d\n",l);
  printf("p: %ls\n",p);
  *p++ = 0;
  printf("l: %d\n",l);
  printf("p: %ls\n",p);

  // Exemplo;
  int i = 10;
  int *x;
  x = &i;
  printf("x: %d\n",*x); //Valor para o qual o x aponta;
  printf("x: %p\n",x);  //Valor do endereço x;

  return 0;
}
