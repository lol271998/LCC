#include<stdio.h>

void insert_sort(int vec[], int n){
  int i,j;
  for(i = 1; i<n; i++){
    int x = vec[i];
    j = i-1;
    while(j>=0 && vec[j]>x){
      vec[j+1] = vec[j];
      j--;
    }
    vec[j+1] = x;
  }
}

void select_sort(int vec[], int n){
  int i,j;
  for(i = 0; i<n; i++){
    int imin = i;
    for(j = i+1; j<n; j++){
      if(vec[imin]>vec[j]) imin = j;
    }
    if(imin!=i){
      int temp = vec[i];
      vec[i] = vec[imin];
      vec[imin] = temp;
    }
  }
}


int kmin(int k, int vec[], int n){
  select_sort(vec,n);
  for(int i = 0; i<n; i++){
    if(k==i) return vec[i];
  }
  return 0;
}

int main(void){
  int vec[] = {17,11,30,17,40};
  for(int i = 0; i<5; i++){
    printf("kmin(%d) = %d\n",i,kmin(i,vec,5));
  }
}
