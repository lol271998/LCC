#include<stdio.h>
#include<stdlib.h>

#define N 10

int main(void){
  int a,b,res,res1,certa;
  certa = 0;
  for(int i = 0; i<N; i++){
    a = 1 + rand()/(RAND_MAX/9+1);
    b = 1 + rand()/(RAND_MAX/9+1);
    res = a*b;
    printf("Quanto é %d*%d? \n",a,b);
    scanf("%d",&res1);
    if(res==res1){
      printf("Está Certo!\n");
      certa++;
    }
    else
      printf("Errado!O resultado é %d\n",res);
  }
  printf("%d Certas, %d Erradas\n",certa,(N-certa));
  return 0;
}
