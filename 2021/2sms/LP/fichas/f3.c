#include "listaINT.h"
#include "listaSTRING.h"
#include <stdio.h>
#include <stdlib.h>

//gcc -g -Wall -o a3.out f3.c lista.c 

/*
*
* Desenvolva um programa que armazene um conjunto de números usando uma lista ligada. 
* Os valores a armazenar devem ser pedidos ao utilizador.
* Após a construção da lista, visualize-a no ecrã. 
* Para tal, Crie a função imprimir que imprime no ecrã a lista ligada de inteiros 
* que recebe como parâmetro.
*
*/

void ex31() {

	int n;
	List l = cria_lista();

	printf("Quantos numeros vai introduzir: ");
	scanf("%d",&n);

	for(int i = 0; i<n; i++) {
		int num;
		scanf("%d",&num);
		insere_lista_fim(l,num);
	}

	imprime_lista(l);
	printf("\n");
	free(l);
}


/*
*
* Crie uma função que transforme uma estrutura estática array 
* (de N elementos do tipo float), numa
* estrutura dinâmica Lista, simplesmente ligada.
*
*/

void ex32(int a[],int n) {
    
    List l = cria_lista();

    for(int i = 0; i<n; i++) insere_lista_ordenado(l, a[i]);
    
    imprime_lista(l);

}
/*
*
* Desenvolva agora um programa que armazene por ordem 
* crescente um conjunto de números usando
* uma lista ligada. Os valores a armazenar devem ser pedidos
* ao utilizador. Após a construção da lista visualize-a no ecrã.
*
*/
void ex33() {

	int n;
	List l = cria_lista();

	printf("Quantos numeros vai introduzir: ");
	scanf("%d",&n);

	for(int i = 0; i<n; i++) {
		int num;
		scanf("%d",&num);
		insere_lista_ordenado(l,num);
	}

	imprime_lista(l);
	printf("\n");
	free(l);

}

/*
* Crie as estruturas de dados e funções para criação 
* de listas ligadas de palavras. Deve fazê-lo como uma
* biblioteca nova usando ficheiros header que possam 
* ser importados/incluídos em outros programas.
*     a) Crie uma função que, dadas duas listas ligadas de 
*        palavras, concatene as duas listas, gerando o 
*        resultado na primeira lista, eliminando a segunda
*        lista. As palavras devem ficar ordenadas por ordem
*        alfabética na lista final. No caso de haver palavras
*        repetidas,estas só devem aparecer uma vez na lista
*        final
*/

void ex34() {

}


int main() {
	//int a[] = {3,2,3,4,5};
	ex34();
	return 0;
}