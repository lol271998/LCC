#include <stdlib.h>
#include <stdio.h>
#include <ctype.h>
#include <unistd.h>
#include <string.h>
#define size 999

/* Made by Énio*/

/* Antes de começar é necessario saber como funciona o qsort do c
   Esta função recebe 4 parametros:
   1º -> arr que queremos ordenar
   2º -> o numero de elementos a ordenar
   3º -> o tamanho de cada elemento, n*sizeof(char), sizeof(int) etc
   4º -> uma função compare. É preciso ter atenção que esta função
   compare tem que ter argumentos polimorficos. Porque? não sei
*/ 

struct var{
  /* Flags*/
  int r, n;
};

/* Estas funções compare serão usados no qsort
   compare -> ira comparar as string
   compare2 -> ira comparar numeros decimais */
int compare(const void* str1, const void* str2){
  return strcmp( (char*)str1, (char*)str2);
}

int compare2(const void* num1, const void* num2){
  return *(int*)num1 - *(int*)num2;
}

/* writeString é uma função que fui obrigado a fazer porque o codex
   esta apresentar um erro estupido. O que irei fazer aqui é
   imprimir manualmente a string, faz o mesmo que printf("%s",_) */
void writeString( char* str ){

  for (int i=0; str[i]!='\n' && str[i]!='\0'; i++) putchar(str[i]);
    putchar('\n');

}

/* Esta função busca e guarda as opções numa estrutura, var */
int getOpcoes( int argc, char** argv, struct var* x ){
  int opt;

  while ( (opt=getopt(argc, argv, "nr"))!=-1 ){
    switch(opt) {
      case 'r':
      x->r=1;
      break;
      case 'n':
      x->n=1;
    }
  }
  return optind;
}

/* Esta função ira abrir todos os ficheiros passados como
   argumentos. O numero de ficheiros é determinado atraves da 
   subtração de argc por optind (1º argumento apos as opções) */
void openFiles(int start, int end, char** argv, FILE* list[] ){
  int i=0, j=0;  
  for ( i=start; i<=end; i++, j++ ) {
    if ( strcmp( argv[i], "-") == 0 )
      list[j]=stdin;
    else
      list[j] = fopen(argv[i], "r");
    if (list[j]==NULL){
      printf("%s: File not found\n", argv[i]);
      exit(EXIT_FAILURE);
    }
  }     
}

/* Esta função ira ordenar as string contidas num conjunto de
   ficheiros.Gostaria de chamar a atenção que o codex pede
   que ordenes o conteudo de todos os ficheiros ao mesmo tempo e 
   não um a um, dai eu ter guardado o conteudo de todos os ficheiros
   em arrStr e so depois ordenar e imprimir. */

void ordString( FILE* arrFiles[], int end, struct var x ){
  char arrStr[size][size];
  int ind=0;
  for ( int i=0; i<end; i++ ){
    while ( (fgets(arrStr[ind], size-1, arrFiles[i]))!=NULL ) ind++;
  }
  
  qsort( arrStr, ind, size*sizeof(char), compare );
  
  /* se x.r então imprimos por ordem decrescente */
  if (!x.r){
    for (int i=0; i<ind; i++) writeString(arrStr[i]);
  }
  else{
    for(int i=ind-1; i>=0; i--) writeString(arrStr[i]);
  }
}

  /* Nesta função irei ordenar numeros decimais/inteiros. O printf do
  c tem uma opção engraçada %g que imprime numeros float com
  precisao depedente desses numeros, exemplo 1.0000 -> 1,
  1.00300 -> 1.003, dai a eu trabalhar apenas com numeros float. */
void ordNum( FILE* arrFiles[], int end, struct var x ){

  float arrNum[size];
  int ind=0;
  char str[size];
  for ( int i=0; i<end; i++ ){
    while ( (fgets(str, size-1, arrFiles[i]))!=NULL ){
      arrNum[ind] = atof(str);
      intnd++;
    }
  }
  
  qsort(arrNum, ind, sizeof(float), compare2);
  
  /* se x.r então imprimos por ordem decrescente */
  if(!x.r){
    for(int i=0; i<ind; i++) printf("%g\n",arrNum[i]);
  }
  else{
    for(int i=ind-1; i>=0; i--) printf("%g\n",arrNum[i]);
  }  
}

int main(int argc, char** argv){
  struct var x = {0};
  /* Start representa o indice do primeiro argumento apos opções*/
  int start = getOpcoes( argc, argv, &x );

  /* Opening several files
  tam ira representar o nº de ficheiros que temos que abrir.
  caso não sejam passados ficheiros então temos, 
  arrFiles[1]=stdin, caso contrario iremos abrir cada ficheiro
  um a um com a função openFiles*/
  int tam = argc - start;
  if ( tam==0 ) tam=1;

  FILE* arrFiles[tam];
  if ( argc - start == 0 ) arrFiles[0]=stdin;
  else openFiles(start, argc-1, argv, arrFiles);

  /* Atraves de x.n sabemos se os ficheiros são numeros ou não
     e o que fazemos aqui é rederecionar o progresso para as
     funções corretas*/
  if (!x.n) ordString( arrFiles, tam, x );
  else ordNum( arrFiles, tam, x );

  return 0;
}
