#ifndef LISTA_INT_H_INCLUDED
#define LISTA_INT_H_INCLUDED

#define ITEM_TYPE int

typedef struct lnode *List;
typedef struct lnode{
    ITEM_TYPE info;
    List next;
} List_node;

List cria_lista(void);
List destroi_lista(List list);
int lista_vazia(List);
int lista_cheia(List);
void procura_lista (List lista, ITEM_TYPE chave, List *ant, List *atual);
void insere_lista_ordenado(List lista, ITEM_TYPE item);
void insere_lista(List lista,ITEM_TYPE item);
void insere_lista_fim(List lsita,ITEM_TYPE it);
void elimina_lista(List lista, ITEM_TYPE it);
List pesquisa_lista(List lista, ITEM_TYPE it);
void imprime_lista(List lista);

/*
*
* Desenvolva um programa que armazene um conjunto de números usando uma lista ligada. 
* Os valores a armazenar devem ser pedidos ao utilizador.
* Após a construção da lista, visualize-a no ecrã. 
* Para tal, Crie a função imprimir que imprime no ecrã a lista ligada de inteiros 
* que recebe como parâmetro.
*
*/
void ex31();

/*
*
* Crie uma função que transforme uma estrutura estática array 
* (de N elementos do tipo float), numa
* estrutura dinâmica Lista, simplesmente ligada.
*
*/
void ex32(int array[],int n);

#endif // LISTA_INT_H_INCLUDED
