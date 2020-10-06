#include<stdio.h>
#include<stdlib.h>
#include<getopt.h>
#include<ctype.h>
//Output
// linhas palavras bytes 
struct x{
  //Flags
  int l; //Linhas

  int w; //Palavras

  int b; //Bytes

  int L; //Linha mais comprida
  //Totais
  int nb,nl,nw,nL;

  int temp_nL; //Para comparar o tamanho da linha

  int nRead; //Para ver se foi dado algum argumento para ler da shell
};

void option(struct x *list,int argc, char* argv[]){

  int opt;
  while((opt = getopt(argc,argv,"clwL"))!=-1){
    switch(opt){
      case 'c':
        list->b = 1; //Opção dos bytes
      break;

      case 'l':
        list->l = 1; //Opção linhas
      break;

      case 'w':
        list->w = 1; //Opção palavras
      break;

      case 'L':
        list->L = 1; //Opção Linha mais comprida
        break;
    }
  }
  //Se não foi dada nenhuma opção
  if(list->b!=1 && list->l!=1 && list->w!=1 && list->L!=1){
    list->b = 1;
    list->l = 1;
    list->w = 1;
  }
  //printf("argc: %d optnid: %d\n", argc, optind);
  list->nRead = argc - optind; //Quando nRead = 1; significa que tem opções
  //printf("nRead: %d\n",list->nRead); 
}

void count( struct x *temp, char ch, char ch1){
  temp->nb++; //Conta o numero de bytes

  if(isspace(ch1) && !isspace(ch)){
    temp->nw++;
    //printf("isspace");
  }

  if(ch1 == '\n'){
    temp->nl++;
    temp->temp_nL = 0;
  }
  else temp->temp_nL++;

  if(temp->nL < temp->temp_nL) temp->nL = temp->temp_nL; //Actualizar a maior linha

}

void escreve(struct x *temp, struct x*list, char *str){
  //Para verificar se é para escrever com espaço ou não
  int c = 0;
  
  if(list->l){
    printf("%d",temp->nl);
    c = 1;
  }

  if(list->w){
    if(c==1) printf(" %d",temp->nw);
    else printf("%d",temp->nw);
    c = 1;
  }

  if(list->b){
    if(c==1) printf(" %d",temp->nb);
    else printf("%d",temp->nb);
  }

  if(list->L){
    if(c==1) printf(" %d", temp->nL);
    else printf("%d",temp->nL);
  }

  printf("%s\n",str); //Escreve o nome do ficheiro
}

void add(struct x *temp, struct x *list){
  list->nb += temp->nb;
  list->nl += temp->nl;
  list->nw += temp->nw;

  if(list->nL < temp->nL) list ->nL = temp->nL;

}


void readAndPrint(struct x* list, char* str){
  char ch = '\n';
  char ch1;

  struct x temp = {0};

  //Ler do input
  if(str[0] == '-' || str[0] == ' '){
    while((ch1=getc(stdin))!=EOF){
      count (&temp,ch,ch1);
      ch = ch1;
    }
  }

  //Abrir o ficheiro
  else{
    FILE* file = fopen(str,"r");
    if(file==NULL){
      fprintf(stderr, "%s: No such file or directory\n",str);
      return;
    }

    while((ch1=getc(file))!=EOF){
      count(&temp,ch,ch1);
      ch=ch1;
    }
    fclose(file);
  }

  escreve(&temp, list, ""); //Escreve na shell, com ou sem opções

  add(&temp,list);

}

int main(int argc, char* argv[]){

  struct x list = {0};
  //Guardar opções
  option(&list,argc,argv);

  for(int i = 1; i<argc; i++){
    //Se é para ler do input ou se é um ficheiro 
    if((argv[i][0] == '-' && argv[i][1] == '\0') || (argv[i][0] != '-')) readAndPrint(&list, argv[i]);
  }
  //Caso seja só um ficheiro
  if (list.nRead == 0) readAndPrint(&list, " ");

  else if(list.nRead>1) escreve(&list,&list, " total");
  return 0;
}