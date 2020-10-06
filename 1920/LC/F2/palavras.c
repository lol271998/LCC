#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

void mensagem (char* m){
  printf("%s\n",m);
  exit(0);
}

FILE* abre_fich(char* str){
  FILE *f = fopen(str,"r");
  return f;
}

/*char* limpar(char* str){
  int i = 0, j = 0;
  //printf("Antes limpar: %s\n",str);
  for(i = 0; i<strlen(str);i++){
    if(!isalpha(str[i])){
      for(j = i; j<strlen(str); j++){
	str[j] = str[j+1];
      }
      str[j] = '\0';
    } 
  }
  //printf("Depois limpar: %s\n",str);
  return str;
  }*/

char* palavra(FILE* f){
  char *str = malloc(sizeof(char)*100);  
  char c = fgetc(f);
  int i = 0;
  //printf("\n palavra: %s \n",str);
  do{
    if(c!= ' ' && isalpha(c)){
      str[i] = c;
      c = fgetc(f);
      i++;
    }
    else if(c == EOF) return NULL;
    else break;
    
  }while(1);
  
  //char* str1 = limpar(str);
  //free(str);
  if(strlen(str)>=2) return str;
  else return palavra(f);
}

int main(int argc, char* argv[]){
  FILE *fich;
  char *pal;
  //
  if (argc != 2){
    mensagem("Uso: ./palavras ficheiro");
  }
  
  fich = abre_fich(argv[1]);
  while((pal = palavra(fich)) != NULL){
    //printf("Entrou ciclo printf\n");
    printf("%s\n", pal);
    free(pal);
  }
  fclose(fich);
}
