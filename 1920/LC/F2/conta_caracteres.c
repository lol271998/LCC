#include<stdio.h>
#include<string.h>
#include<stdlib.h>

int main(int argc, char** argv){
  FILE* f1 = fopen(argv[1],"r");
  int count = 0;
  int c = ' ';
  do{
    c = fgetc(f1);
    if(c == EOF) break;
    else{
      count++;
      //printf("%d\n",c);
    }
  }while(1);
  
  fclose(f1);

  FILE* f2 = fopen(argv[2],"w");
  fprintf(f2,"O ficheiro tem %d caracteres\n",count);

  fclose(f2);
  return 0;
}
