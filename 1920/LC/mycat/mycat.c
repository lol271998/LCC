#include<stdio.h>
#include<string.h>
#include <unistd.h>
int count = 1;

void print_input(){
  char c = getc(stdin);
  do{
    putc(c,stdout);
    c = getc(stdin);
  }while(c!=EOF);
}

void print(char* fname,int n,int b,int s){
  FILE *f = fopen(fname,"r");
  char c,cr;
  c = fgetc(f);
  cr = '\n';
  int adj = 0;
  while(c!=EOF){
    //Opção n;
    if(n == 1 && cr =='\n' && adj == 0){
      printf("%6d\t",count);
      count++;
    }
    //Opção b;
    if(b == 1 && cr =='\n' && c != '\n'){
      printf("%6d\t",count);
      count++;
    }
    //Opção s
    if(s == 1 && cr =='\n' && c == '\n'){
      adj++;
    }

    if(adj > 1 && cr =='\n' && c == '\n'){
      cr = c;
      c = fgetc(f);
    }

    else{
      putc(c,stdout);
      cr = c;
      c = fgetc(f);
    }
    if(cr == '\n' && c !='\n') adj = 0;
  }
  fclose(f);
}

int main(int argc, char* argv[]){
  int nflag = 0,bflag = 0,sflag = 0,opt;
  if(argc == 1 || strcmp(argv[1],"-") == 0){
    print_input();
    return 0;
  }
  while((opt = getopt(argc,argv,"nbs"))!=-1){
    switch(opt){

    case 'n':
      nflag++;
      break;
      
    case 'b':
      bflag++;
      break;
      
    case 's':
      sflag++;
      break;
    }
  }

  //Sem opções
  if(sflag == bflag && bflag == nflag && nflag == 0) opt = 0;//Sem opções
  else opt = 1;
  
  for(int i = 1+opt; i<argc; i++){
    if(i%2==opt && strcmp("-",argv[i]) == 0){ //Os ficheiros e ler do input
      print_input();
    }
    else{
      print(argv[i],nflag,bflag,sflag);	  	  
    }
  }
  return 0;
}
