#include<stdio.h>
#include<assert.h>

int mdc(int a, int b){
  assert(a>0);
  assert(b>0);
  while(a!=b){
    if(a>b) a = a-b;
    else b = b-a;
  }
  return a;
}

int main(void){
  int a,b;
  a = -12;
  b = 4;
  printf("%d\n",mdc(a,b));
}
