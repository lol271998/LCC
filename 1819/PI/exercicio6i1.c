#include <stdlib.h>
#include <stdio.h>

int main(void)
{
  int i=0,N=10,d; 
  while(i<N)
  {
      d = 1 + (int)((double)rand() /((double)RAND_MAX+1)*9);
      printf("%d\n", d);
      i++;
  }
}
