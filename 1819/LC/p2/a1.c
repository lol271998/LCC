#include<stdio.h>
#include<stdlib.h>
int main (int argc,char **argv){ // argc é uma palavra reservada de c que calcula o numero de elementos de um array
	
	int res=0,num;		
		for(int i=1;i<argc;i++){
			num = atoi(argv[i]);
			res = num + res;
		}
	printf("%d\n",res);
	return 0;
}
