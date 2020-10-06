#include<stdio.h>

void bubblesort(int vec[], int n){
  for(int i = 1; i<n; i++){
    if(vec[i-1] > vec[i]){
      int temp = vec[i];
      vec[i] = vec[i-1];
      vec[i-1] = temp;
      i=0;
    }
  }
}

int main(void){
  int vec[] = {8,3,5,2,3,0,1};
  printf("{");
  for(int i = 0; i<6; i++){
    printf("%d,",vec[i]);
  }
  printf("%d}\n",vec[6]);
  bubblesort(vec,7);

  printf("{");
  for(int i = 0; i<6; i++){
    printf("%d,",vec[i]);
  }
  printf("%d}\n",vec[6]);
}
