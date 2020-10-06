#include<stdio.h>

int main(void){
  char c, *cptr;
  c = 'a';
  cptr = &c;
  printf("tamanho de um char: %lu\n", sizeof(c));
  printf("tamanho do endereço de um char: %lu\n", sizeof(&c));
  printf("tamanho de um apontador para um char: %lu\n", sizeof(cptr));
  printf("tamanho do conteúdo apontado por um apontador para um char: %lu\n",
  sizeof(*cptr));
  printf("Os valores apontados pelos endereços '%p' e '%p' são '%c' e '%c'\n", &c,cptr, c,*cptr);
}
