#include<stdio.h>

int segundo_menor(int vec[], int size){
  for(int i = 0; i<size; i++){
    int imin = i;
    for(int j = i+1; j<size;j++){
      if(vec[j]<vec[imin]) imin = j;
    }
    if(imin!=i){
      int temp = vec[i];
      vec[i] = vec[imin];
      vec[imin] = temp;
    }
  }
  return vec[1];
}

int main(void){
  int vec[] = {4,3,2,5,1};
  printf("O segundo menor valor é %d\n",segundo_menor(vec,5));
  
}
