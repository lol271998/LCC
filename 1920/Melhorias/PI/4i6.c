/*Um ano é bixesto se for divisivel por 4, excepto se for também divisivel por 100 e não divisivel por 400*/
#include<stdio.h>

int bissexto(int n){
  if(n%4 == 0 && (n%100!=0 || n%400 == 0))
    return 1;
  else return 0;
}

int main(void){
  int ano;
  printf("Introduza um ano: \n");
  scanf("%d",&ano);
  if(bissexto(ano) == 1){
    printf("É bissexto \n");
  }
  else printf("Não é bissexto \n");
  return 0;
}
