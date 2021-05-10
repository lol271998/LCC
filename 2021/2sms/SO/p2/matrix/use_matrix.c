#include <stdio.h>
#include "matrix.h"

int main() {

  matrix* m1 = matrix_new(2,2);
  matrix* m2 = matrix_new(2,2);
  for (size_t i = 0; i < 2; i++) {
    for (size_t j = 0; j < 2; j++) {
      matrix_set(i,j,j*2+i,m1);
      matrix_set(i,j,i+j+1,m2);
    }
  }
  matrix* ms = matrix_sub(m1,m2);
  matrix* mm = matrix_mul(m1,m2);
  matrix* mt = matrix_trans(m1);

  matrix_print(m1);
  printf("\n");
  matrix_print(m2);
  printf("\n");
  matrix_print(ms);
  printf("\n");
  matrix_print(mm);
  printf("\n");
  matrix_print(mt);

  return 0;
}
