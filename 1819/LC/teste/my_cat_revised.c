#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <unistd.h>
#include <getopt.h>

// Made by Énio Sousa

struct x
{
  int n; // o output deverá numerar as linhas do output
  
  int b; // o output deverá numerar apenas as linhas que não sejam vazia

  int s; // eliminar linhas adjacentes vazias
  
  int shell; // diz-nos quantas opções são para ler da shell
  
  int counter; // numero de linhas, util para imprimir
  
  int ler; // indica o numero de argumentos que nos diz para ler,
          // vai ter utilidade quando não sao passados argumentos
         // quando isto acontece les da shell
};

// esta função escreve na shell 
void escreve(struct x* list, char ch, char ch1, int adj){
  if (ch=='\n'&& ch1=='\n' && adj==1 && (*list).s==1) return;
  
  if (ch=='\n' && (*list).n==1 && (*list).b!=1){
      printf("%6d\t",(*list).counter);
      (*list).counter++; 
  }

  else if (ch=='\n' && ch1!='\n' && (*list).b==1){
      printf("%6d\t",(*list).counter);
      (*list).counter++;
  }

  putchar(ch1);
}

void readAndPrint(struct x* list, char str[]){
  char ch='\n'; // esta variavel guarda o char anteriror
  char ch1; // esta variavel guarda o char atual
  int adj=0; // diz-nos se temos linhas adjecente vazias
  (*list).ler++; // se passa aqui, indica que foi dado um arg para ler
  
  // ou seja ler da shell
  if (str[0]=='-'){
    while((ch1=getc(stdin)) != EOF){
      escreve(list,ch,ch1,adj);
	  
      if (ch=='\n' && ch1== '\n') adj=1;
      else adj=0;
      ch=ch1;
    }
  }

  else{
    FILE* read = fopen( str, "r" );
    while((ch1=getc(read)) != EOF){
      escreve(list, ch, ch1, adj);
      
      if (ch=='\n' && ch1== '\n') adj=1;
      else adj=0;
      
      ch=ch1;
    }
  }	    
}

// esta função busca as opçoes e guarda
void saveOption(struct x* list, int argc, char**argv){
  int option;

  while ((option = getopt(argc, argv, "nbs")) != -1){
    switch (option){
      case 'n':  
        (*list).n=1;
      break;

      case 'b':
        (*list).b=1;
      break;

      case 's':
        (*list).s=1;
      break;
    }
  }
}

int main(int argc, char** argv){

  struct x list = {0};
  list.counter=1;

  saveOption(&list, argc, argv);

  for (int i=1; i<argc; i++){
      if (argv[i][0]=='-' && argv[i][1]=='\0') readAndPrint(&list, "-");

      else if (argv[i][0]!='-') readAndPrint(&list,argv[i]);
  }
  // caso não seja passados argumentos lemos da shell  
  if (list.ler==0) readAndPrint(&list, "-");

  return 0;
}
