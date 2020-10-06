#include<stdlib.h>

int main(int argc, char **argv){
  int i = 20;
  int *y = exp1();
}

int *exp1(){
  int *x = malloc(4);
   *x = 20;
  return &x; //Devolve o endereço, mas o endereço já não pertence ao programa, temos que alocar espaço para a variavel
}
