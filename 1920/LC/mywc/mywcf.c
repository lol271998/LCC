#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <getopt.h>

struct x{
  // -------------------option flags-----------------------
  int c;
  int l;
  int w;
  int L;

  // -------------------total count-------------------------
  int nc, nl, nw, nL;

  int temp_nL;
  
  int nRead; 
};


void saveOption(struct x *list, int argc, char** argv){
  int opt;

  while ((opt=getopt(argc, argv,"clwL"))!=-1){
    switch ( opt ){
      case 'c':
        list->c=1;
      break;

      case 'l':
        list->l=1;
      break;

      case 'w':
        list->w=1;
      break;

      case 'L':
        list->L=1;
      break;
    }
  }

  if (!list->c && !list->l && !list->w && !list->L){
      list->c=1;
      list->l=1;
      list->w=1;
  }
  list->nRead = argc - optind;
}

void add (struct x *temp, struct x *list){
  list->nc += temp->nc;
  list->nl += temp->nl;
  list->nw += temp->nw;
  
  if (list->nL < temp->nL) list->nL = temp->nL;
}
 
void escreve(struct x *temp, struct x*list, char *str){
  int c=0;
  if (list->l){
      printf("%d", temp->nl); 
      c=1;
    }

  if (list->w){
    if (c==1) printf(" %d", temp->nw);
    else printf("%d", temp->nw);
    c=1;
  }

  if (list->c){
      if (c==1) printf(" %d", temp->nc);
      else printf("%d", temp->nc);
      c=1;
  }
  
  if (list->L){
      if (c==1)	printf(" %d", temp->nL);
      else printf("%d", temp->nL);
  }
  
  printf("%s\n",str);
}

void count( struct x *temp, char ch, char ch1 ){
  temp->nc++;

  if (isspace(ch1) && !isspace(ch)){
    temp->nw++;
  } 

  if (ch1 == '\n'){
      temp->nl++;
      temp->temp_nL=0;
  }
  else temp->temp_nL++;

  if (temp->nL < temp->temp_nL) temp->nL = temp->temp_nL;

}   


void readAndPrint(struct x* list, char* str){
  char ch='\n';
  char ch1;

  struct x temp = {0};
  

  if (str[0]=='-' || str[0]==' '){
    while((ch1=getc(stdin))!= EOF){
      count( &temp, ch, ch1 );
	    ch=ch1;
    }
  }

  else{
    FILE* read = fopen(str, "r");
    if (read==NULL){
      fprintf(stderr,"%s: No such file or directory\n",str);
    return;
    }
        
    while((ch1=getc(read))!= EOF){
      count( &temp, ch, ch1 );
      ch=ch1;
    }
    fclose(read);
  }

  escreve(&temp, list, ""); 

  add(&temp, list); 
}


int main(int argc, char** argv){
  struct x list = {0};

  saveOption(&list, argc, argv); 
  
  for (int i=1; i<argc; i++){ 
      if ((argv[i][0]=='-' && argv[i][1]=='\0')||(argv[i][0]!='-')) readAndPrint(&list, argv[i]);
  }
 
  if (list.nRead==0) readAndPrint( &list, " " ); 

  else if (list.nRead > 1)
    escreve(&list, &list, " total");
  return 0;
}
