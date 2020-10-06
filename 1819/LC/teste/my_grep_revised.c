#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <getopt.h>
#define MAX 1000

// Made by Énio Sousa

struct x
{
  int i; // ignora maiusculas e minusculas
  int v; // imprime as linha onde o padrao nao esta contido
  int l; // imprime apena os nomes dos ficheiros onde a procura teve suc
  int c; // imprime o nº de linhas onde a proc teve suc

  // esta variavel indica o primeiro indice depois das opções.
  // o optget do c altera a ordem dos argumentos, tudo o que é
  // opções passa para frente e o resto é passado pra tras
  // exemplo: my_grep -a ola hello -b hola -c
  // fica em: my_grep -a -b -c ola hello hola
  // e o optind indica a primeira posição apos a ultima opção
  int index;

};


void saveOption( struct x *list, int argc, char** argv )
{
  int opt;

  while ( (opt=getopt(argc, argv, "ivlc")) != -1 ) 
    {
      switch (opt)
	{
	case 'i':
	  list->i++;
	  break;

	case 'v':
	  list->v++;
	  break;

	case 'l':
	  list->l++;
	  break;

	case 'c':
	  list->c++;
	  break;
	}
    }
  
  if ( optind > argc - 1 )
    {
      printf("Utilização: my_grep [OPÇÃO]... PADRÃO [FICHEIRO]...\n");
      exit(EXIT_FAILURE);
    }

  else
    list->index = optind;
}

// se i==1 ignoramos maiusculas e minusculas
int contido( char *phrase, char *pattern, int i )
{
  // este k vai percorrer o padrao, ele avança somente se a letra
  // na posição atual da phrase (phrase[i]) for igual a letra
  // na posição k (pattern[k])
  // se phrase[k] == '\0' entao chegamos ao fim do padrao logo
  // o padrao esta contido na frase
  int k=0;

  if ( pattern[0]=='\0' ) // o vazio esta sempre contido
    return 1;
  
  for ( int i=0; phrase[i]!='\0'; i++ )
    {
      if ( i==0 )
	{
	  if ( phrase[i]==pattern[k] )
	    {	  
	      k++;
	      if ( pattern[k]=='\0')
		return 1;  
	    }
	  else
	    k=0;
	}

      else // se i==1 transformamos as letras em minusculas e comparamos
	{
	  if ( tolower(phrase[i]) == tolower(pattern[k]) )
	    {	  
	      k++;
	      if ( pattern[k]=='\0')
		return 1;  
	    }
	  else
	    k=0;
	}
    }

  return 0;
}

int analysis( struct x *list, char *phrase, char *fileName, int *c)
{
  if ( list->l==1 )
    {
      printf("%s\n",fileName);
      return 1;
    }
	      
  else if ( list->c==1 )
    (*c)++;

  else
    printf("%s", phrase );

  return 0;
}
// atenção o codex não quer o nome dos ficheiros
// por isso esta função não os imprime,mas é de notar
// que o grep da shell o faz
void readAndPrint( struct x *list, char *pattern, char *fileName )
{
  char phrase[MAX];
  int c=0; // contador de sucesso
  
  if ( fileName[0] == '-' )
    {
      while( fgets(phrase, MAX, stdin) != NULL )
	{
	  if ( contido( phrase, pattern, list->i ) )
	    {
	      if ( list->v==0 )
	        if ( analysis( list, phrase, fileName, &c ) )
		  return;
	    }
	  else
	    {
	      if ( list->v==1 )
		if ( analysis( list, phrase, fileName, &c ) )
		  return;
	    }
	}
    }

  else
    {
      FILE *read = fopen( fileName, "r" );

      if ( read == NULL )
	{
	  printf("%s:  No such file or directo\n", fileName);
	  return;
	}
      
      while ( fgets( phrase, MAX, read ) != NULL )
	{
	  if ( contido( phrase, pattern, list->i ) )
	    {
	      if ( list->v==0 )
	        if ( analysis( list, phrase, fileName, &c ) )
		  return;
	    }
	  else
	    {
	      if ( list->v==1 )
		if ( analysis( list, phrase, fileName, &c ) )
		  return;
	    }
	}
    }

  if ( list->c==1 )
    printf("%d\n",c);
}
	
  
      
int main(int argc, char** argv)
{
  struct x list = {0};
  
  saveOption( &list, argc, argv );

  for ( int i=list.index+1; i<argc; i++ )
     readAndPrint( &list, argv[list.index], argv[i] );
  
  // se não foi dado nada para ler ;'(
  if ( argc == list.index + 1 )
    readAndPrint( &list, argv[list.index], "-" ); 
  
  return 0;
}
