#include<stdio.h>
#include<string.h>
#include<stdlib.h>

int partition(int vec[], int l, int u){
  int i,m,temp;
  m = l;
  printf("partition l:%d u:%d \n",l,u);
  for(i = l+1; i<=u; i++){
    if(vec[i]<vec[l]){
      m++;
      temp = vec[i];
      vec[i] = vec[m];
      vec[m] = temp;
    }
  }
  temp = vec[l];
  vec[l] = vec[m];
  vec[m] = temp;
  printf("{");
  for(int j = l; j<u; j++){
    printf("%d,",vec[j]);
  }
  printf("%d}\n",vec[u]);
  return m;

}

void quicksort_rec(int vec[], int l, int u){
  int m;
  m = l;
  if(l>=u) return;
  printf("pivôt: vec[%d] = %d\n",m,vec[m]);
  m = partition(vec,l,u);
  printf("quicksort left \n");
  quicksort_rec(vec,l,m-1);
  printf("quicksort right \n");
  quicksort_rec(vec,m+1,u);
}

int main(void){
  int vec[] = {9,8,7,6,2,4,3,1,0,5};
  int n = 10;

  printf("{");
  for(int i = 0; i<n-1; i++){
    printf("%d,",vec[i]);
  }
  printf("%d}\n",vec[n-1]);;
  
  quicksort_rec(vec,0,n-1);

  printf("{");
  for(int j = 0; j<n-1; j++){
    printf("%d,",vec[j]);
  }
  printf("%d}\n",vec[n-1]);
  return 0;
}
