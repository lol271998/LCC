#include<stdio.h>

int main(void){
  int num,i;
  i = 2;
  printf("Numero inteiro: ");
  scanf("%d",&num);
  printf("%d :",num);
  while(num!=1){
    if(num%i == 0){
      num /= i;
      printf(" %d",i);
    }
    else i++;
  }
  printf("\n");
}
