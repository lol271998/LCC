#include<stdio.h>
#include<stdlib.h>

int main(void){
  int n; 
  for(int i = 0; i<100; i++){
    printf("Numero random entre 0 e 9: %d\n",rand()%10);
    printf("Numero random entre 1 e 10: %d\n",1+rand()%10);
    printf("Numero random entre 1 e 100: %d\n",1+rand()%100);
    printf("Numero random entre -10 e 10: %d\n",-10+rand()%10);
    printf("Numero random entre 0.0 e 1.0: %f\n",((double)rand()/RAND_MAX*1.0+0.0));
    printf("Numero random entre 0.0 e 1.0: %f\n",((double)rand()/RAND_MAX*2.0-1.0));
    do{
      n = rand()%101;
	}while(n%2!=0);
      printf("Numero random par entre 0 e 100: %d\n",n); 
  }
}
