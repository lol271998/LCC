#include<stdio.h>

int main(void){
  int cb,cn,wc; //cbefore, cnow,wordcount;
  wc = 0;
  cb = getchar();
  cn = getchar();
  while(1){
    if(cb == EOF || cn == EOF) break;
    else{
      if(cn == ' ' || cn == '\n' || cn == '\t'){
	if(cb != ' ' && cb != '\n' && cb != '\t'){
	  wc++;
	}
      }    
    }
    cb = cn;
    cn = getchar();
  }
  printf("%d\n",wc);
}
