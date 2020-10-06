#include<stdio.h>

int desordem(int vec[],int size){
  int count=0;
  for(int i = 0; i<size; i++){
    //printf("vec[%d] = %d\n",i,vec[i]);
    if(vec[i]>vec[i+1] && i<size-1)count++;
  }
  return count;
}

int main(void){
  int vec[] = {5,4,3,2,1,0};
  printf("%d\n",desordem(vec,6));
  return 0;
}
