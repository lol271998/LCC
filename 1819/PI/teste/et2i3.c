#include <stdio.h>
int potencia(int r,int n){
	int a=0,res=1;
	if(n!=0){
		while(a<n){
			res=res*r;
			a++;
		}	
	}
	else
		res=0;
	return res;
}
int main(void){
 int resp,r,vol;
 printf("Introduza o valor do raio\n");
 scanf("%d",&r);
 resp=potencia(r,3);
 vol=((4.0/3.0)*3.14*resp);
 printf("%d\n",vol);
}