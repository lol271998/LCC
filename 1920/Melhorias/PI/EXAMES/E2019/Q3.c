#include<math.h>
#include<assert.h>
#include<string.h>
#include<stdio.h>

int power(int base,int exp){
  int res = 1;
  for(int i = 1; i<exp; i++){
    res *=base;
  }
  return res;

}
int binario(char str[]){
  int size = strlen(str);
  int dec = 0;
  for(int i = 0; i<size; i++){
    if(str[i] == '1') dec += power(2,size-i);
  }
  return dec;
}


int main(void){
  assert(binario("1")==1);
  assert(binario("10")==2);
  assert(binario("110")==6);
  assert(binario("1000")==8);
  assert(binario("1111")==15);
  printf("Binário de %d é %d\n",1111,binario("1111"));
  return 0;
  
}
