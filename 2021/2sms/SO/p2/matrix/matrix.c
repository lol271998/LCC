#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "matrix.h"
/* implementation of the matrix API */
matrix* matrix_new(int n, int m) {
  matrix* u = (matrix*) malloc(sizeof(matrix));
  u->n = n;
  u->m = m;
  u->vals = (double*) malloc ((u->n * u->m) * sizeof(double));
  return u;
}

matrix* matrix_new_random(int n, int m, double min, double max) {
  matrix* u = (matrix*) malloc(sizeof(matrix));
  u->n = n;
  u->m = m;
  u->vals = (double*) malloc ((u->n * u->m) * sizeof(double));
  int i, j;
  double range = max - min;
  double div = RAND_MAX / range;
  for(i = 0; i < u->n; i++)
    for(j = 0; j < u->m; j++)
      matrix_set(i, j, min + (rand() / div), u);
  return u;
}

void matrix_print(matrix* u) {
  for(int i = 0; i< u->n; i++) {
    printf("|");
    for (int j = 0; j < u->m; j++) {
      if(j!= u->m - 1) printf("%f, ",matrix_get(i,j,u));
      else printf("%f",matrix_get(i,j,u));
    }
    printf("|\n");
  }
}

double matrix_get(int i, int j, matrix* u){
  return *(u->vals + i * u->m + j);
}

void matrix_set(int i, int j, double val, matrix* u){
  *(u->vals + i * u->m + j) = val;
}

matrix* matrix_add(matrix* u, matrix* v){
  int i, j;
  matrix* w = matrix_new(u->n, u->m);
  for (i = 0; i < u->n; i++ )
    for (j = 0; j < u->m; j++ )
      matrix_set(i, j, matrix_get(i, j, u) + matrix_get(i, j, v), w);
  return w;
}

matrix* matrix_sub(matrix* u, matrix* v){
  if(u->n != v->n || u->m != v->m) perror("Matrizes não podem ser subtraidas");
  matrix* res = matrix_new(u->n,u->m);
  for (int i = 0; i < u->n; i++) {
    for(int j = 0; j < u->m; j++) {
      matrix_set(i,j,matrix_get(i,j,u) - matrix_get(i,j,v),res);
    }
  }
  return res;
}

matrix* matrix_mul(matrix* u, matrix* v){
  matrix* m = matrix_new_random(u->n, v->m,0.0,0.0);
  for(int i = 0; i<u->n; i++) {
    for(int j = 0; j<v->m; j++) {
      matrix_set(i,j,0.0,m);
      for(int k = 0; k<u->m; k++) {
        matrix_set(i,j,(matrix_get(i,j,m)+(matrix_get(i,k,u)*matrix_get(k,j,v))),m);
      }
    }
  }
  return m;
}

matrix* matrix_trans(matrix* u){
  matrix* mt = matrix_new(u->m,u->n);
  for(int j = 0; j<u->m; j++) {
    for(int i = 0; i<u->n; i++) {
      matrix_set(i,j,matrix_get(j,i,u),mt);
    }
  }
  return mt;
}
