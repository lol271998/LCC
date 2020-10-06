#include <stdio.h>
#include <stdlib.h>
int *readarray(int n){
 int *v = (int*)malloc(n*sizeof(int)); 
 
 printf("Introduza os valores do array: ");
 for (int i=0; i<n; i++){
 	scanf("%d", &v[i]);
 	//v[i] = num;
 }
 return v;
}
int *somaarrays(int *a, int *b, int n) {
 /* A completar:
 deverá retornar um novo array
 com a soma dos arrays arrays a e b,
 elemento a elemento
 */
	//int vec[100];
	//int vec1[100];
	//int vec2[100];
	int *sum = (int*)malloc(n*sizeof(int)); //determina o tamanho do array
	for(int i = 0; i < n; i++){
		//a = &vec[i];
		//b = &vec1[i];
		sum[i] = a[i]+b[i];
		//sum = &vec[i];
		//sum++;
	}
	return sum;
}
void printarray(int *v, int n){
 // A completar:
 // deverá imprimir os elementos de v
	for(int i = 0;i < n; i++){
		printf(" %d",v[i]);
	}
}
int main(){
 int n;
 int *va, *vb, *vr;
 printf("Introduza os limites dos arrays: ");
 scanf("%d", &n);
 va = (int*)malloc(n*sizeof(int));
 vb = (int*)malloc(n*sizeof(int));
 vr = (int*)malloc(n*sizeof(int));
 va = readarray(n);
 vb = readarray(n);
 vr = somaarrays(va, vb, n);
 printarray(va, n);
 printarray(vb, n);
 printarray(vr, n);
 return 0;
}