
#include<stdio.h>

#define N 100

int main(void){
  double res,raiz;
  printf("Introduza a raiz\n");
  scanf("%lf",&raiz);
  res = raiz/2;
  printf("%f",res);
  for(int i = 0; i<N; i++){
    res = (1.0/2.0)*(res + (raiz/res));
    printf("%f\n",res);
  }
  
  printf("raiz de %f é %f\n",raiz,res);
  return 0;
}
