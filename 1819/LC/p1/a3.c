#include<stdio.h>
int main(void){
  int x[3]={23,41,17};
  for(int i=0;i<=2;i++){
    printf("O valor de x[%d] ",i);
    printf("é %d\n",x[i]);
  }
  printf("Valor de x é %p\n",x);
  printf("Valor de *x é %d\n",*x);
  printf("Valor de x+1 é %p\n",(x+1)); //Imprime o endereço de memória 1 byte à frente
  printf("Valor de *(x+1) é %d\n",*(x+1)); //Incrementa o valor de *x
  printf("Valor de x+2 é %p\n", x+2); //Imprime o endereço de memória dois bytes à frente
  printf("Valor de *(x+2) é %d\n", *(x+2)); // Incrementa o valor de *x duas vezes
  printf("Valor de &(x[0]) é %p\n", &(x[0])); // Imprime o endereço de memória de x[0]
  printf("Valor de *&(x[0]) é %d\n",*&(x[0]));//Imprime o conteudo 
  //printf("Valor de &*(x[0]) é %p\n",&*(x[0]));//Erro
}
