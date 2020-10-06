#include <stdio.h>
#include <stdlib.h>

int* readarray(int n){
  int i;
  int *v = malloc(sizeof(int)*(n));
  for (i=0; i<n-1; i++){
    scanf("%d\n", v+i);
  }
  scanf("%d",v+i);
  return v;
}
int* somaarrays(int *a, int *b, int n) {
  /* A completar:
     deverá retornar um novo array
     com a soma dos arrays arrays a e b,
     elemento a elemento
  */
  int *s = malloc(sizeof(int)*(n));

  for(int i = 0; i<n; i++){
    s[i] = a[i] + b[i];
  }
  return s;
}
int printarray(int *v, int n){
  // A completar:
  // deverá imprimir os elementos de v
  printf("{%d",v[0]);
  for(int i = 1; i<n-1; i++){
    printf(",%d",v[i]);
  }
  printf(",%d}\n",v[n-1]);
  return 0;
}
int main(){
  int n;
  int *va, *vb, *vr;
  scanf("%d\n", &n);
  va = readarray(n);
  vb = readarray(n);
  vr = somaarrays(va, vb, n);
  printarray(va, n);
  printarray(vb, n);
  printarray(vr, n);
  return 0;
}
