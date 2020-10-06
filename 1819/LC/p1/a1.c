#include<stdio.h>
int main (void){
  int i = 5;
  int *p=&i; //Guardar o endereço da variavel i no apontador *p
  printf("O Valor de i %d\n",i);
  printf("O valor de *p é %d\n",*p);
  printf("O endereço de p é %p\n",p);
  printf("Valor do endereço de memória onde está i é %p\n",&i);
  p++;
  printf("O valor de p++ é %p\n",p); //Muda o endereço de memória
  *p++=0;
  printf("O valor de *p++ é %d\n",*p++);
}
//º A variavel p é um endereço de memória
//º Se executar p++ mudo o endereço de memória
//º Se executar *p++=0 ocorre falha de segmentação

