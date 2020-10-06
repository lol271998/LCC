#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <unistd.h>
#include <getopt.h>

struct x{
	
  /*-----------------------OPÇÕES-----------------------*/

  int n; // O output numera as linhas do output

  int b; // O output numera as linhas não vazias do output

  int s; // Elimina as linhas vazias adjacentes

  /*----------------------------------------------------*/

  int shell; // Diz quantas opções da shell devem ser lidas

  int counter; // Numero de linhas, util para imprimir
	
  int ler;   // Indica o numero de argumentos a ler
  // Vai ser util, quando não são passados argumentos
  // Isto acontece quando se lê da shell

};

void saveOption(struct x* list, int argc, char **argv){
  int option;

  // Marcar com 1 o valor da opção 
  while((option = getopt(argc,argv,"nbs"))!=-1){
    switch(option){
    case 'n':
      (*list).n = 1;
      break;

    case 'b':
      (*list).b = 1;
      break;

    case 's':
      (*list).s = 1;
      break;
    }
  }
}

// Escreve na shell
void escreve(struct x* list, char ch, char ch1, int adj){

  // Elimina as linhas vazias
  if(ch=='\n' && ch1=='\n' && adj==1 && (*list).s==1) return;

  // Numerar as linhas
  if(ch=='\n' && (*list).n==1 && (*list).b!=1){
    printf("%6d\t",(*list).counter);
    (*list).counter++;
  }

  // Numerar as linhas não vazias
  else if(ch=='\n' && ch1!='\n' && (*list).b==1){
    printf("%6d\t",(*list).counter);
    (*list).counter++;
  }
  putchar(ch1);
}


void readAndPrint(struct x* list, char str[]){ // str vai ser o nome do ficheiro ou vai ser "-"
  char ch='\n';  // Variavel que guarda o caracter anterior
  char ch1; 	   // Variavel que guarda o caracter actual
  int adj=0;     // Variavel que indica se temos linhas vazias ou não
  (*list).ler++; // Se passa aqui, significa que foi dado um argumento para ler

  // Ler da bash, porque o simbolo é só '-'
  if(str[0]=='-')
    while((ch1=getc(stdin)) != EOF){
			
      escreve (list,ch,ch1,adj);

      //Vê se existem linhas vazias
      if(ch=='\n' && ch1=='\n') adj = 1;
      else adj = 0;

      ch=ch1;
    }
  else{
    FILE* fp = fopen(str, "r");
    while((ch1=fgetc(fp))!=EOF){ 
      escreve(list,ch,ch1,adj);
			
      if(ch == '\n' && ch1 == '\n') adj = 1;
      else adj = 0;
			
      ch = ch1;

    }
  }
}

int main(int argc, char **argv){

  struct x list = {0}; // Igualar as variaveis no struct a 0 e dar o nome list ao struct
  list.counter=1; 	 // Dar o numero de linhas igual a 1

  saveOption(&list, argc, argv); // Guardar a variavel

  for(int i = 1; i<argc; i++){
    // Caso o só seja escrito o caracter
    if(argv[i][0] == '-' && argv[i][1] == '\0') readAndPrint(&list, "-");

    // Caso o carcter não seja -, vai apenas ler o texto e escrever na bash
    else if(argv[i][0]!='-') readAndPrint(&list, argv[i]);
  }
  if(list.ler == 0) readAndPrint(&list, "-");

  return 0;
}
