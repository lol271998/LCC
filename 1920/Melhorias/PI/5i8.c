#include<stdio.h>

double serie_log(double x, int n){
  double res,resx;
  int s;
  res = x;
  resx = res;
  s = -1;
  for(int i = 2; i<=n; i++){
    resx = resx*x;
    res += s*(resx/i);
    s *= -1;
  }
  return res;
}

int main(void){
  printf("x = -0.25; n = 1 : %f\n",serie_log(.5,3));
}
