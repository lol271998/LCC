#include<stdio.h>
#include<stdlib.h>

#define N 100
int repetidos(int vec[], int size){
  int count = 0;
  int val;
  for(int i = 0; i<size; i++){
    val = vec[i];
    for(int j = i+1; j<size;j++){
      if(vec[j] == val) count++;
    }
  }
  return count;
}


int main(void){
  int vec[N];
  for(int i = 0; i<N; i++){
    vec[i] = 1 + rand()/(RAND_MAX/365+1);
  }
  for(int i = 0; i<N; i++) printf("vec[%d] = %d\n",i,vec[i]);
  printf("pessoas que fazem anos no mesmo dia %d\n",repetidos(vec,N));
}
