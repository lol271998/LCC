#include <stdio.h>
#include "matrix.h"

int main() {

  matrix* m1 = matrix_new_random(5,5,5.0,10.0);
  matrix* m2 = matrix_new_random(5,5,5.0,10.0);
  matrix* ms = matrix_sub(m1,m2);

  matrix_print(m1);
  printf("\n");
  matrix_print(m2);
  printf("\n");
  matrix_print(ms);

  return 0;
}
