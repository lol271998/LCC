#include<stdio.h>
#include<string.h>
#include<stdlib.h>

int main(int argc, char** argv) {

  int val = 0;
  int l = atoi(argv[1]);
  int c = atoi(argv[2]);

 
  FILE* f = fopen(argv[3],"w");
  
  //int* mp = malloc(l*c*sizeof(int));

  fprintf(f,"%d %d",l,c);

  for(int i = 0; i<l*c; i++){
    scanf("%d", &val);
    fprintf(f," %d",val);
  }
  fprintf(f,"\n");
  fclose(f);
}
