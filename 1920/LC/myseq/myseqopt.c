#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#define MAX 999


//Verifica se é Int ou não
int typeCheck( char* str ) {
  for ( int i=0; str[i]!='\0'; i++ )
    if ( str[i] == '.' )
      return 1;

  return 0;
}

void combination1 ( int n, int k, float l ) {
  for( int i=n; i<=l; i+=k )
    printf("%d\n",i);
}
//Se forem doubles
void combination2 ( double n, double k, double l, int prec ){
  for ( double i=n; i<l+0.000001; i+=k )
    printf("%.*f\n",prec,i);
}

// caso onde o inicio e o incr são inteiros e inc < 0
void combination3 ( int n, int k, double l )
{
  for( int i=n; i>=l; i+=k )
    printf("%d\n",i);
}


// caso onde o inicio e o inc são double e inc < 0
// acho que por causa do truncamento se eu puser i>=l
// a função não funciona para n==2.4, k==-0.1 e l==2.0
// o metodo que resolvi implementar para resolver isto foi
// dizer i>l+k pois k<0
void combination4 ( double n, double k, double l, int prec )
{
  for ( double i=n; i>l-0.000001; i+=k )
    printf("%.*f\n",prec, i);
}

int precision( char* n )
{
  int c=0;

  for ( int i=0; n[i]!='\0'; i++ )
    {
      if ( n[i-1]=='.' )
	c++;

      else if ( c>0 )
	c++;
    }
  return c;
}
    
int main(int argc, char** argv)
{
  if ( argc==2 )
    combination1( 1, 1, atof(argv[1]) );

  else if ( argc==3 )
    {
      if ( typeCheck(argv[1]) ) // doubles
	{
	  int prec = precision(argv[1]);
	  combination2( atof(argv[1]), 1, atof(argv[2]), prec );
	}

      else // inteiros
	combination1( atoi(argv[1]), 1, atof(argv[2]) );
    }

  else if ( argc==4 )
    {
      if ( typeCheck(argv[1]) || typeCheck(argv[2]) ) // numeros double
	{
	  int prec = precision(argv[2]);
	  if ( argv[2][0]=='-' ) // incremento negativo
	    combination4( atof(argv[1]), atof(argv[2]), atof(argv[3]), prec );

	  else // incremento positivo
	    combination2( atof(argv[1]), atof(argv[2]), atof(argv[3]), prec );
	}
      else // numeros inteiros
	{
	  if ( argv[2][0]=='-' ) // incremento negativo
	    combination3( atoi(argv[1]), atoi(argv[2]), atof(argv[3]) );

	  else // incremento positivo
	    combination1( atoi(argv[1]), atoi(argv[2]), atof(argv[3]) );
	}
    }
	      
  return 0;
}
