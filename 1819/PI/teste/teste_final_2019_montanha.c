#include<stdio.h>
int montanhas(char str[]){
  int sub=0, desc=0, mont=0;
  for(int i=0; str[i]!='\0'; i++){
    if(str[i]=='S') sub++;
    else {
      desc++;
      if(sub-desc==0) mont++;
    }
  }
  return mont;
}
int main(void){
	char str[]="DSSDDSSSDD";
	printf("%d\n",montanhas(str));	
}