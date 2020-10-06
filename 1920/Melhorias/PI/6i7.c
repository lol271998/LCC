#include<stdio.h>
#include<ctype.h>
#define N 26

int main(void){


  int vletras[N],vc[N];
  vletras[0] = 'A';
  for(int i = 1; i<N; i++) vletras[i] = vletras[i-1] + 1;
  for(int i = 0; i<N; i++) vc[i] = 0;

  int c;
  do{
    c = getchar();
    c = toupper(c);
    for(int i = 0; i<N; i++){
      if(c == vletras[i]){
	vc[i]++;
      }
    }
  }while(c != '\n');

  for(int i = 0; i<N; i++){
    putchar(vletras[i]);
    printf(": %d\n",vc[i]);
  }

  return 0;
}
