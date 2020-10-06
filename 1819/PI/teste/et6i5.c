/*6.5 Escreva uma função int ocorre(int vec[], int size, int val) que procura um
valor val no elementos de um vector vec. Se o valor ocorre como um dos elementos do
vector, o resultado deve ser 1; caso contrário deve ser 0.*/
#include<stdio.h>
int ocorre(int vec[], int size, int val){
	int i;
	for(i=0;i<=size;i++){
		if(vec[i]==val){
			i=1;
			break;
		}
	}
	if(i!=1) i=0;
	return i;
}
int main(){
	int vec[5]={1,2,3,7,5},res;
	res=ocorre(vec,5,9);
	if(res==1) printf("Existe\n");
	else printf("Não existe\n");
}
