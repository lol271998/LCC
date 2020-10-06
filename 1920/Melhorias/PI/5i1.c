#include<stdio.h>

#define TRUE 1
#define FALSE 0

int primo(int n){
  if(n<=1) return FALSE;
  for(int i = 2; i*i<n;i++){
    if(n%i == 0)
      return FALSE;
  }
  return TRUE;
}

int main(void){
  int ls;
  printf("Limite Superior: ");
  scanf("%d",&ls);
  printf("\n");
  for(int i = 1; i<ls; i++){
    if(primo(i) == TRUE){
      printf("%d  ",i);
    }
  }
  printf("\n");
  return 0;
}
