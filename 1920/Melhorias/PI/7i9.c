#include<stdio.h>
#include<string.h>

int contar_maiores(int vec[], int size, int val){
  int count = 0;
  for(int i = 0; i<size; i++){
    if(vec[i]>val) count++;
  }
  return count;
}

int main(void){
  int vec[] = {1,2,3,4,5,6,7};
  printf("Quantos são maiores: %d\n",contar_maiores(vec,7,4));
  return 0;
}

