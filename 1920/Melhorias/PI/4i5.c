#include<stdio.h>

int soma_divisores(int n) {
    int soma=0;
    for(int i = 1;i<n; i++){
        if(n%i == 0) soma += i;
    }    
    return soma;
}

int main(void){

  int n;
  printf("Introduza um valor para somar os seus divisores\n");
  scanf("%d",&n);

  printf("Soma de divisores: %d\n",soma_divisores(n));
}
