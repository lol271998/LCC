#include<stdio.h>
#include<ctype.h>
#include<string.h>

int conta(char str[], int size){

  //int size = strlen(str);
  int c = 1;
  int maior = 1;
  int ch = str[0];
  if(size>0){
    for(int i = 1; i<size; i++){
      if(ch == str[i]){
	c++;
      }
      else{
	if(maior <= c) maior = c;
	c = 1;
	ch = str[i];
      }
    }
    if(c>=maior) maior = c;

    return maior;
  }
  return 0;
}

int main(void){

  char str[1000];
  int size = 0;
  for(int i = 0; str[i]!=EOF; i++){
    str[i] = getchar();
    printf("%d \t %c",str[i],str[i]);
   
    size++;
  }
  printf("Maior sequência = %d\n",conta(str,size));
  return 0;
  
}
