/*Modifique a função que implementa ordenação por seleção apresentada na aula 16
para ordenar por ordem decrescente.*/
#include<stdio.h>
void select_sort_decr(int vec[], int n) {
  int i, j;
  for(i = 0; i < n; i++) {
    int imax = i; // índice inicial do maximo
    for(j = i+1; j < n; j++) {
      if(vec[j] > vec[imax]) imax = j;
    }
    // trocar o máx com vec[i]
    if(imax != i) {
      int temp = vec[i];
      vec[i] = vec[imax];
      vec[imax] = temp;
    }
  }
}

int main(){
  int str[10]={1,3,2,1,3,6,5,4,3,8};
  select_sort_decr(str,10);
  printf("{");
  for(int i=0;i<9;i++){
  	if(i<8)
  	printf("%d,",str[i]);
  	else
  	printf("%d",str[i]);
  }
  printf("}");
}