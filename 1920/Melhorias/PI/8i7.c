#include<stdio.h>

void sort_desc(int vec[], int size){
  for(int i = 0; i<size; i++){
    int imax = i;
    for(int j = i+1; j<size; j++){
      if(vec[j]>vec[imax]) imax = j;
    }
    if(imax!=i){
      int temp = vec[i];
      vec[i] = vec[imax];
      vec[imax] = temp;
    }
  }
}

int main(void){
  int vec[] = {-2,0,-1};
  sort_desc(vec,3);
  printf("{");
  for(int i = 0; i<2; i++){
    printf("%d,",vec[i]);
  }
  printf("%d}\n",vec[2]);
  return 0;
}
