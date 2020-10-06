#include<stdio.h>

void select_sort(int vec[], int n){
  int i,j;
  for(i = 0; i<n; i++){
    int imin = i;
    for(j = i+1; j<n; j++){
      if(vec[j]<=vec[imin]) imin = j;
    }
    if(i!=imin){
      int temp = vec[i];
      vec[i] = vec[imin];
      vec[imin] = temp;
    }
  }
}

int main(void){
  int vec[] = {1,4,2,6,2,9,5,0,2};
  printf("\n");
  printf("{");
  for(int i = 0; i<8; i++) printf("%d,",vec[i]);
  printf("%d}\n",vec[8]);
  select_sort(vec,9);
  printf("{");
  for(int i = 0; i<8; i++) printf("%d,",vec[i]);
  printf("%d}\n",vec[8]);
}
