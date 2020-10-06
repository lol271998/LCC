#include<stdio.h>

void select_sort(int vec[],int size){
  int temp;
  for(int i = 0; i<size; i++){
    for(int j = 0; j<size; j++){
      if(vec[i]>=vec[j]){
	temp = vec[i];
	vec[i] = vec[j];
	vec[j] = temp;
      }
    }
  }
}

int main(void){
  int vec[5] = {1,2,3,4,5};
  select_sort(vec,5);
  printf("{");
  for(int i = 0; i<4; i++){
    printf("%d,",vec[i]);
  }
  printf("%d}\n",vec[4]);
  return 0;
}
