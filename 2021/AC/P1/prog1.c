#include<stdio.h>
#define VALUE 10

int main() {
	
	int i, mult_table[10];

   for (i = 0; i < 10; i++) {
      mult_table[i] = i * VALUE;
      printf("%d\n",mult_table[i]);
   }
   
   return 0;
}