#include<stdio.h>
#include<stdlib.h>
#define V 10
int main(void){
	int i,certo=0,valor1,valor2,rese,res,respu;
	for(i=0;i<=V;i++){
		valor1 = 1 + rand()/(RAND_MAX/10 + 1);
		valor2 = 1 + rand()/(RAND_MAX/10 + 1);
		printf("Quanto é %d ",valor1);
		printf("x %d ?\n",valor2);
		res=valor1*valor2;
		scanf("%d",&respu);
		if(res==respu){
			printf("Está certo\n");
			certo++;
		}
		else
			printf("Está errado, o valor certo é: %d\n",res);
	}
	rese=V-certo;
	printf("Tem %d respostas erradas ",rese);
	printf("e %d respostas certas\n",certo);
}