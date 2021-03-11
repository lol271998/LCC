#include "listaINT.h"
#include <stdio.h>
#include <stdlib.h>

List cria_lista (void) {
    List aux;
    aux = (List) malloc (sizeof (List_node));
    if (aux != NULL) {
        aux->info = 0;
        aux->next = NULL;
    }
return aux;
}

List destroi_lista(List lista) {
    List temp_ptr;
    while (lista_vazia (lista) == 0) {
        temp_ptr = lista;
        lista= lista->next;
        free (temp_ptr);
    }
    free(lista);
    return NULL;
}

List pesquisa_lista (List lista, ITEM_TYPE it) {
    List ant;
    List atual;
    procura_lista (lista, it, &ant, &atual);
    return (atual);
}

int lista_vazia(List lista) {
    return (lista->next == NULL ? 1 : 0);
}

int lista_cheia (List lista) {
    return 0;
}

void procura_lista (List lista, ITEM_TYPE chave, List *ant, List *atual) {
    *ant = lista; *atual = lista->next;
    while ((*atual) != NULL && (*atual)->info < chave) {
        *ant = *atual;
        *atual = (*atual)->next;
    }
    if ((*atual) != NULL && (*atual)->info != chave)
        *atual = NULL; /* Se elemento não encontrado*/
}

void elimina_lista (List lista, ITEM_TYPE it) {

    List ant1;
    List atual1;
    procura_lista(lista, it, &ant1, &atual1);

    if (atual1 != NULL) {
        ant1->next = atual1->next;
        free (atual1);
    }
}

void insere_lista_ordenado(List lista, ITEM_TYPE it) {
    List no;
    List ant, inutil;
    no = (List) malloc (sizeof (List_node));
    if (no != NULL) {
        no->info = it;
        procura_lista (lista, it, &ant, &inutil);
        no->next = ant->next;
        ant->next = no;
    }
}

//Insere no inicio
void insere_lista(List lista, ITEM_TYPE it) {
    List no;
    List ptr;

    no = (List)malloc(sizeof(List_node));
    
    if(no != NULL){
        
        no->info = it;
        no->next = NULL; 
        
        for(ptr = lista; ptr->next != NULL; ptr = ptr->next);
        
        ptr->next = no;
    }
}

//Insere o elemento no fim 
void insere_lista_fim(List lista,ITEM_TYPE it) {
    List temp = lista;
    List no;
    no = (List)malloc(sizeof (List_node));

    if(no!=NULL){
        no->info=it;
        no->next=NULL;

        while(temp->next != NULL) temp =temp->next;
        temp ->next =no;
    }
}


void imprime_lista (List lista) {
    List l = lista->next; /* Salta o header */
    //printf("%d",l->info);
    while (l){
        printf("%d ", l->info);
        l=l->next;
    }
}