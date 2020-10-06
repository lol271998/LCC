#include<assert.h>
#include<stdio.h>
#include<ctype.h>
#include<string.h>

int pot(int n,int res){
  for(int i = 0;i<n-1; i++) res*=10;
  return res;
}

int decimal(char str[]){
  int num = 0;
  int size = strlen(str);
  for(int i = 0;i<size; i++){
    assert(str[i]>='0' && str[i]<='9');
    int al = str[i] - '0';
    int pote = pot(size-i,1);
    num = num + (pote*al);
  }
  return num;
}

int main(void){
  char str[] = "1234";
  printf("Numero: %d\n",decimal(str));  
  return 0;
}
