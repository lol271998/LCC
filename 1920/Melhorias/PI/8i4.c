#include<stdio.h>
#define MAX 1000

void ordenarsel(int vec[],int size){
  int temp;
  for(int i = 0; i<size-1; i++){
    int imin = i;
    for(int j = i+1; j<size-1; j++){
      if(vec[j]<vec[imin]) imin = j;
    }
    if(i!=imin){
      temp = vec[imin];
      vec[imin] = vec[i];
      vec[i] = temp;
    }
  }
}

void ordenarins(int vec[], int size){
  int temp;
  for(int i = 0; i<size-1; i++){
    for(int j = 0; j<size; j++){
      if(vec[i]<=vec[j]){
	temp = vec[i];
	vec[i] = vec[j];
	vec[j] = temp;
      }
    }
  }
}

int main(void){
  int n,count;
  int vec[MAX],vec1[MAX];
  count = 0;
  do{
    scanf("%d",&n);
    //printf("%d\n",n);
    vec[count]=n;
    count++;
  }while(n!=0);
  //printf("stop\n");

  for(int i = 0; i<count-1; i++){
    vec1[i] = vec[i];
  }  

  ordenarsel(vec,count);
  ordenarins(vec1,count);

  printf("Ordenação por seleção\n");
  printf("{");
  for(int i = 0; i<count-1; i++){
    if(i!=count-2) printf("%d,",vec[i]);
    else printf("%d}\n",vec[i]);
  }

  printf("Ordenação por inserção\n");
  printf("{");
  for(int i = 0; i<count-1; i++){
    if(i!=count-2) printf("%d,",vec1[i]);
    else printf("%d}\n",vec1[i]);
  }
  
  return 0;
}
