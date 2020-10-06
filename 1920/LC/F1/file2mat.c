#include<stdio.h>
#include<string.h>
#include<stdlib.h>

int main(int argc, char** argv) {

  FILE* f = fopen(argv[1],"r");
  int l=0,c=0,mp=0;
  
  fscanf(f,"%d %d",&l,&c);

  for(int i = 0; i<l*c;i++){
    fscanf(f,"%d",&mp);
    printf("%d \t",mp);
  }

  printf("\n");

  fclose(f);
  return 0;  

}
