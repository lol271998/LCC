/* Re-utilizando os algoritmos apresentados na aula 17 (ordenação por seleção e por
inserção), escreva um programa completo que lê uma sequência de inteiros positivos da
entrada-padrão terminada por zero, ordena e imprime por ordem crescente.
Sugestão: a função `main` no seu programa deve declarar uma variável indexada com
um tamanho máximo (por exemplo: 1000), ler os valores, invocar a função função de ordenação
e imprimir a sequência final ordenada. Experimente ambos os algoritmos (deve obter
resultados iguais)*/
#include <stdio.h>
void insert_sort(int vec[], int n) {
  int i, j;

  for(i = 1; i < n; i++) {
    int x = vec[i];
    j = i-1;
    while(j>=0 && vec[j] > x) {
      vec[j+1] = vec[j];
      j--;
    }
    vec[j+1] = x;
  }
}

void select_sort(int vec[], int n) {
  int i, j;
  for(i = 0; i < n; i++) {
    int imin = i; // índice inicial do mínimo
    for(j = i+1; j < n; j++) {
      if(vec[j] < vec[imin]) imin = j;
    }
    // trocar o mínimo com vec[i]
    if(imin != i) {
      int temp = vec[i];
      vec[i] = vec[imin];
      vec[imin] = temp;
    }
  }
}

int main(){
  int str[10]={1,3,2,1,3,6,5,4,3,8};
  int str1[10]={1,3,2,1,3,6,5,4,3,8};
  select_sort(str,10);
  insert_sort(str1,10);
  printf("%ls\n",str);
  printf("%ls\n",str1);
  return 0;
}

