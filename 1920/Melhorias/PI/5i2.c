#include<stdio.h>

int main(void){
  int a,b,i,r;
  printf("Introduza os dois numeros: ");
  scanf("%d %d", &a,&b);
  printf("mdc(%d,%d) = ",a,b);
  for(i = 0; b!=0;i++){
    r=a%b;
    a = b;
    printf("mdc(%d,%d) = ",a,b);
    b = r;
  }
  printf("%d\n",a);
  printf("%d iterações\n",i);
  return 0;
}
