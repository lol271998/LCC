#include<assert.h>
#include<stdio.h>

void inserir(int vec[], int n, int x){
  int j = n-1;
  int temp;
  //int n1 = n;
  printf("n = %d\n", n);
  for(int i = 0; i<n; i++){
    temp = vec[i];
    for(int k = i+1; k<n; k++){
      printf("vec[%d] = %d; temp = %d\n",k,vec[k],temp);
      assert(vec[k]>=temp);
    }
  }
  while(j>=0 && vec[j]>x){
    vec[j+1] = vec[j];
    j--;
  }
  vec[j+1] = x;
  printf("n = %d\n",n);
  for(int i = 0; i<n; i++){
    vec[i] = temp;
    for(int k = i+1; k<n; k++){
      printf("vec[%d] = %d; temp = %d\n",k,vec[k],temp);
      assert(vec[k]>=temp);
    }
  }
}

int main(void){
  int vec[] = {1,2,3,4,5};
  inserir(vec,5,4);
  return 0;
}
