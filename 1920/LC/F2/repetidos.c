#include<stdio.h>
#include<stdlib.h>

struct elemento{
  int valor; // um inteiro lido
  int ocorrencias; // numero de vezes que esse inteiro foi lido
};

typedef struct elemento ELEMENTOS;
ELEMENTOS *a = NULL;
int elems = 0;

void add_inc(ELEMENTOS *elems, int *count, int val) {
  for(int i = 0;i < *count; i++){
    if(elems[i].valor == val) {
      elems[i].ocorrencias ++;
      printf("elems[%d].occorrencias %d\n",i,elems[i].ocorrencias);
      return;
    }
  }
  
  elems[*count].valor = val;
  elems[*count].ocorrencias = 1;
  *count++;
}

int main(){

  int n,val,i;
  scanf("%d\n",&n);
  
  if (n > 0) a = malloc(n*sizeof(ELEMENTOS));
  for(i= 0; i < n; i++){
    scanf("%d\n",&val);
    add_inc(a, &elems, val);
  }
  //printf("Ocorrências: %d\n", elems.ocorrencias);
}
