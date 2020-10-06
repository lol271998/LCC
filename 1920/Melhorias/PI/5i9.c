#include<stdio.h>
#include<math.h>

double aprox_pi(int n){
  int sinal;
  double res,quo;
  sinal = -1;
  res = 1;
  for(int i = 1; i<=n; i++){
    quo = 1.0/((2*i)+1);
    // printf("quo: %f\n",quo);
    res += sinal*quo;
    //printf("res: %f\n",res);
    sinal *= -1;
  }
  return 4*res;
}

int main(void){
  for(int i = 10; i<=1000000000; i*=10){
    printf("aprox %d: %f\n",i,aprox_pi(i));
    printf("math %d: %f\n",i, M_PI);
  }
  return 0;
}
