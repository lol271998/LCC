#include <stdio.h>
#define SIZE 10
void show_vector(char *a, int n);

int main() {
  char v[SIZE] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
  show_vector(v, SIZE);
  return 0;
}
void show_vector(char *a, int n) {
  int i;
  for (i = 0; i < n; i++) {
    /* imprima aqui os valores e endereços de cada elemento do vector */
    printf("%d\t",*(a+i));
    putchar(*(a+i));
    printf("\n");
  }
}
