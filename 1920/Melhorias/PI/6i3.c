#include <stdio.h>
#include <stdlib.h>

int main(void){

  int numero,numero1;
  numero = 1 + rand()/(RAND_MAX/1000+1);
  do{
    scanf("%d",&numero1);
    if(numero>numero1) printf("Demasiado baixo!\n");
    else if(numero<numero1) printf("Demasiado alto!\n");
  }while(numero!=numero1);

  printf("Está Certo!\n");
  return 0;

}
