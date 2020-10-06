#include<stdio.h>
#include<stdlib.h>

int ocorre(int vec[], int size, int val){
  for(int i = 0; i<size; i++){
    if(vec[i] == val){
      return 1;
    } 
  }
    return 0;
}

int main(){

  int vec[10],res;
  for(int i = 0; i<10; i++){
    vec[i] = i*9;
  }
  res = ocorre(vec,10,17);
  if(res == 1) printf("Ocorre\n");
  else printf("Não Ocorre\n");
}
