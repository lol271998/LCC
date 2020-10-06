/*Escreva um programa que lê uma sequência de valores inteiros positivos terminada por
-1 e no final escreve toda a sequência mas sem repetidos.
Sugestão: guarde os valores numa variável indexada à medida que são lidos; de cada vez que
lê um novo valor pode verificar se já é repetido (e nesse caso não o guarde novamente). No
final imprima todos os valores guardados. Pode usar a função do exercício 6.5 para testar
se um valor lido ocorre entre os anteriores (i.e., se é repetido).*/
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
   int i=0,vec[20],valor;
   	do{
    	if(i==0){
   			scanf("%d",&valor);
    		vec[i]=valor;
    	}
   		else{
   			scanf("%d",&valor);
   			int res=ocorre(vec,i,valor);
    			if(res==0){
    				vec[i]=valor;
   				}
   				else
   					i--;
 		}
 	 i++;
    }while(valor!=-1);
   for(int j=0;vec[j]!=-1;j++) printf("%d\n",vec[j]);
}