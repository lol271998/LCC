#include<stdio.h>
#include<string.h>
void getopt();

void print_input(){
  char c = getc(stdin);
  do{
    putc(c,stdout);
    c = getc(stdin);
  }while(c!=EOF);
}

void openprint(char* str){
  FILE *f = fopen(str,"r");
  int c = fgetc(f);
  do{
    putchar(c);
    c = fgetc(f);
  }while(c!=EOF);
  fclose(f);
}

void printinfile(char* fn1, char* fn2){
  FILE *f1 = fopen(fn1,"r");
  FILE *f2 = fopen(fn2,"w");
  char c = fgetc(f1);
  while(c!=EOF){
    fputc(c,f2);
    c = fgetc(f1);
  }
}

void printlines(char* str){
  FILE *f = fopen(str,"r");
  int c = fgetc(f);
  int count = 1;
  printf("%6d\t",count);
  do{
    if(c!='\n') putchar(c);
    else{
      printf("%6d\t",count);
      putchar(c);
    }
    c = fgetc(f);
  }while(c!=EOF);
  fclose(f);
}

int main(int argc, char* argv[]){
  //printf("%d\n",argc);
  //Ler input
  if(argc == 1 || strcmp("-",argv[1]) == 0){
    print_input();
  }
  //Não é ler do input
  else if(argc>1){
    //Caso seja para escrever num ficheiro
    for(int i = 1; i<argc; i++){
      if(argv[i][0] == '>'){
	for(int j = 1; j<i; j++){
	  printinfile(argv[j],argv[i+1]);
	}
	return 0;
      } 
    }
    if(argv[1][0] == '-'){
      if(argv[1][1] == 'n') printlines(argv[2]);
    }
    else{ //Abrir ficheiros e imprimir ou imprimir nos ficheiros
      for(int i = 1; i<argc; i++){
	//printf("i = %d \n",i);
	if(i%2==0 && strcmp("-",argv[i]) == 0){
	  print_input();
	}
	else openprint(argv[i]);
      }
    }
  }
  return 0;
}
