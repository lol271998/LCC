#include<stdio.h>

int main(void){
  int i;
  int c;
  c = getchar();
  
  while(c!='\n'){
    if((c>='A' && c<='Z')||(c>='a' && c<='z')) i++;
    c = getchar();
  }
  printf("A frase contem %d letra(s)\n", i);
  return 0;

}
