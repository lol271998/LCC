#include<stdio.h>

void insert_sort(int vec[], int n){
  int i,j;
  for(i = 1; i<n; i++){
    j = i-1;
    int x = vec[i];
    while(j>=0 && vec[j]>x){
      vec[j+1] = vec[j];
      j--;
    }
    vec[j+1] = x;
  }
}

int main(void){
  int vec[] = {1,3,0,4,2,6,5};
  printf("{");
  for(int i = 0; i<6; i++){
    printf("%d,",vec[i]);
  }
  printf("%d}\n",vec[6]);

  insert_sort(vec,7);
  
  printf("{");
  for(int i = 0; i<6; i++){
    printf("%d,",vec[i]);
  }
  printf("%d}\n",vec[6]);  
}
