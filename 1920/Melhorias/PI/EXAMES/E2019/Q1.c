#include <stdio.h>

int soma_divs(int val){
  printf("Entrou");
  int i = 0;
  int sum = 0;
  for(i = 1;i<val;i++){
    if(val%i == 0){
      printf("i = %d, sum = %d\n",i,sum);
      sum +=i;
    }
  }
  return sum;
}

int main(void){

  int val;
  printf("Introduza um numero\n");
  scanf("%d",&val);
  printf("\n");
  printf("A soma dos divisores é: %d\n",soma_divs(val));
  return 0;

}
