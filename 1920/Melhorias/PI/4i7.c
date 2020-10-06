/*Um ano é bixesto se for divisivel por 4, excepto se 
for também divisivel por 100 e não divisivel por 400*/
#include<stdio.h>


int bissexto(int n){
  if(n%4 == 0 && (n%100!=0 || n%400 == 0))
    return 1;
  else return 0;
}

int prox_bissexto(int n) {
 while(bissexto(n)!=1) n++;
 return n;
}

int main(void){
  int ano;

  scanf("%d", &ano);
  printf("O próximo bissexto de %d é: %d \n",ano,prox_bissexto(ano));
  return 0;
}
