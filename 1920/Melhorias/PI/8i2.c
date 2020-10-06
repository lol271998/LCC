#include<stdio.h>

int ordenada(int vec[], int size){
  for(int i = 0; i<size-1; i++){
    for(int j = i+1; j<size; j++){
      if(vec[i]>vec[j]) return 0;
    }
  }
  return 1;
}

int main(void){
  int vec[] = {1,3,3,2};
  if(ordenada(vec,5)==1) printf("TRUE\n");
  else printf("FALSE\n");
  return 0;
}
