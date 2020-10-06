#include<stdio.h>

int potencia(int x, int n){
   int res=1;
   
   for(int i = 0; i<n; i++){
       res = res*x;
   }
   return res;
}

int main(void){
	printf("2³ = %d\n", potencia(2,3));
}