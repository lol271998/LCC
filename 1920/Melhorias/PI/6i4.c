#include<stdio.h>

void range(int vec[], unsigned size, int inicio, int incr)
{
   for(int i = 0; i<size;i++){
       vec[i] = inicio + i*incr;
       
   }
}

int main(void){

  int v[5];
  range(v,5,3,2);
  printf("{");
  for(int i = 0; i<5; i++){
    if(i == 4)  printf("%d",v[i]);
    else printf("%d,",v[i]);
  }
  printf("}\n");
  return 0;
}
