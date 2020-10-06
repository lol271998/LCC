#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <unistd.h>
#include <string.h>
#define size 999

/* Made by Énio */

/* str1    -> string que irei mudar, caso ocorra
   str2    -> string que vou usar para trocar
   lines[] -> indica a linha ou o intervalo de linhas a considerar
   ocu[]   -> indica a ocurrencia ou o intervalo a considerar  */
struct var
{
  char str1[size];
  char str2[size]; 
  int  lines[2];
  int  ocu[2];
  int linesWritten;
};

/* Esta função abre n ficheiros ao mesmo tempo.*/
void openFiles( FILE* list[], int n, char** argv )
{
  for ( int i=0; i<n; i++ )
    {
      if ( strcmp(argv[i+2], "-") == 0 )
	list[i] = stdin;

      else
	{
	  list[i] = fopen(argv[i+2], "r");
	  if ( list[i]==NULL )
	    {
	      printf("%s: No such file or directory\n", argv[i+2] );
	      exit(EXIT_FAILURE);
	    }
	}
    }
}
/* Nesta função iremos guardar o intervalo ou a linhas/ocurencias
   de interesse. 
   O raciocinio aqui é que iremos ler cada digito e coloca-lo numa string
   e depois iremos converter essa string em um numero e colocar em arr.*/
int saveArr( int start, char* arg, int* arr )
{
  char str[size];
  int  i=0, j=0;
  
  for ( i=start; arg[i]!='/'; i++ )
    {
      /* Se não for digito, chegamos ao fim do numero que estavamos a 
	 ler e a guardar em str. O que iremos fazer é converter 
	 str(string) em um numero temp(int) e depois colocar em arr*/
      if ( !isdigit(arg[i]) )
	{
	  str[j]='\0';
	  j=0;
	  int temp = atoi( str );
	  if ( arr[0]==0 || arr[0]>temp )
	      arr[0] = temp;
	  
	  if ( arr[1]==0 || arr[1]<temp )
	    arr[1] = temp;
	}
      else
	{
	  str[j]=arg[i];
	  j++;
	}
      if( arg[i]=='\0' )
	return i;
    }
  /* A ideia aqui é retornar a proxima posição para ler*/
  return i+1;
}

/* Nesta função estamos a guardar cada string dentro da nossa estrutura*/
int saveWord( int start, char* arg, char* str )
{
  int i=0, j=0;
  for ( i=start; arg[i]!='/'; i++,j++ )
    str[j] = arg[i];

  str[j]='\0'; 
  return i+1;
}

/* Esta função guarda os valores da estrutura var. 
   Iremos guardar as string a mudar e as linhas, ocurrencias que 
   vamos considerar */
void saveVar( char* arg, struct var* x )
{
  int index = 0;
  index = saveArr( index, arg, &x->lines[0] );  
  index = saveWord( index, arg, &x->str1[0] );
  index = saveWord( index, arg, &x->str2[0] );
  /* Se nada foi dito quanto as ocurrencias, por definição consideramos
     so a 1º ocurrencia.*/
  if ( arg[index]=='\0' )
    {
      x->ocu[0]=1;
      x->ocu[1]=1;
    }
  else
    saveArr( index, arg, &x->ocu[0] );
}
/* Esta é uma pequena função para ver se uma dada linha ou ocurrencia
   esta condida dentro dos parametros que lemos anteriormente
   Gostava de chamar a atenção que se ocu[0]==0 && ocu[0]==0
   significa que iremos considerar tudo, o msm raciocinio é feito para
   lines*/
int contido( int n, int arr[] )
{
  if ( arr[0]==0 && arr[1]==0 )
    return 1;

  else if ( n>=arr[0] && n<=arr[1] )
    return 1;

  else
    return 0;
}

/* Esta é uma função muito importante.
   O C tem funções muito uteis para determinar se um string esta contida
   ou é um subset de outra string, mas não existe nenhuma função
   em c que faca replace de um subset por outra string.

   O que esta função faz é imprimir tudo o que esta antes do subset
   depois imprimir a string a trocar pelo subset e depois imprimir
   tudo o que estava depois do subset.*/
void replace( char* str, struct var* x )
{
  /* strstr retorna o endereço da primeira posição da substring */
  char* subStr = strstr( str, x->str1 );
  int i;

  /* Neste ciclo estou a comparar endereços e não o conteudo e irei
     imprimir tudo o que esta antes do subset*/
  for ( i=0; &str[i]!=&subStr[0]; i++ )
    putchar(str[i]);

  /* Cheguei ao endereço do subset, então vou ignorar o subset todo
     e depois vou imprimir a str2 no seu lugar ;)*/
  for ( i=0; subStr[i]==x->str1[i] && subStr[i]!='\0'; i++ );
  
  printf("%s",x->str2);

  /* Imprimo o que esta a frente do subset.
     Nota pessoal: Parece esquesito,mas é isto que o sed da shell faz*/
  for ( i=i; subStr[i]!='\0'; i++ )
    putchar(subStr[i]);
}

/* Esta é a função que realmente junta as componentes necessarias
   e executa o trabalho*/
void sed( FILE* read, struct var* x)
{
  char str[size], ch;
  int ocu=0, i=0;

  while ( (ch=fgetc(read))!=EOF )
    {
      /* Se ch não é letra então temos uma palavra nova*/
      if ( !isalpha(ch) )
	{
	  str[i]='\0';
	  i=0;
	  if ( strstr(str, x->str1) != NULL )
	    {
	      ocu++;
	      /* Fiz fora do if pois fica mais legivel*/
	      int a = contido(x->linesWritten, x->lines);
	      int b = contido(ocu, x->ocu);
	      if ( a && b )
		replace( str, x );
	      else
		printf("%s",str);
	    }
	  else
	    printf("%s",str);

	  /* New line, e vamos zerar as ocurrencias*/
	  if ( ch=='\n' )
	    {	      
	      x->linesWritten++;
	      ocu=0;
	    }
	  putchar(ch);
	}
      else
	{
	  str[i]=ch;
	  i++;
	}
    }
}

int main(int argc, char** argv)
{
  /*-------------------------Open files--------------------------*/
  int n = argc - 2;
  if ( n==0 )
    n=1;
  
  /* FILE* list[n] é o lista de ficheiros, onde iremos ler.      */
  FILE * list[n];
  
  /* Nenhum ficheiro especificado, por definição lemos da shell */
  if ( argc-2==0 ) 
    list[0]=stdin;

  else
    openFiles( list, n, argv );
  /*-------------------------------------------------------------*/

  
  /*-----------------Saving the diferent parameters--------------*/
  struct var x = {0};
  x.linesWritten=1;

  saveVar( argv[1], &x );
  /*-------------------------------------------------------------*/

  
  /* ---------------------------sed------------------------------*/
  for ( int i=0; i<n; i++ )
    sed( list[i], &x );
  /*-------------------------------------------------------------*/

  
  return 0;
}
