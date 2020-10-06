#include<stdio.h>

int mediana(int a, int b, int c){
    int maior, menor, mediana;

    if(a>=b){
        maior = a;
        menor = b;
    }
    else{
        maior = b;
        menor = a;
    }
    if(c>=maior){
        maior = c;
    }
    else if(c<=menor) menor = c;
    mediana = a+b+c-menor-maior;
    return mediana;
}

int partition(int vec[], int l, int u){
  int i,m,temp;
  int med = mediana(vec[l],vec[u],vec[(l+u)/2]);
  for(i = l; i<u; i++){
    printf("vec[%d] = %d\n",i,vec[i]);
    if(vec[i] == med){
      m = i;
    }
  }
  if(i<u) m = l;
  printf("m = %d\n",m);
  printf("u = %d\n",u);
  printf("med = %d\n",med);
  printf("--------------------\n");
  temp = vec[m];
  vec[m] = vec[l];
  vec[l] = temp;
  for(i = l+1; i<=u; i++){
    if(vec[i]<vec[l]) {
      m++;
      temp = vec[i];
      vec[i] = vec[m];
      vec[m] = temp;
    }
  }

  temp = vec[l];
  vec[l] = vec[m];
  vec[m] = temp;
 
  return m;
}

void quicksort_rec(int vec[], int l, int u){
  int m;
  m = l;
  if(l>=u)
    return;

  m = partition(vec,l,u);

  quicksort_rec(vec,l,m-1);

  quicksort_rec(vec,m+1,u);
  
}

int main(void){
  int vec[] = {9,8,7,6,2,4,3,1,0,5};
  int n = 10;

  printf("{");
  for(int i = 0; i<n-1; i++){
    printf("%d,",vec[i]);
  }
  printf("%d}\n",vec[n-1]);

  quicksort_rec(vec,0,n-1); //Inicio e fim do vetor

  printf("{");
  for(int i = 0; i<n-1; i++){
    printf("%d,",vec[i]);
  }
  printf("%d}\n",vec[n-1]);
  return 0;
}
