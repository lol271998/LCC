#include<stdio.h>
#include<string.h>

void eliminar(char str[],char ch){
  int n,temp;
  n = strlen(str);
  for(int i = 0; i<n; i++){
    if(str[i] == ch){
      for(int j = i; j<n; j++){
	temp = str[j+1];
	str[j] = temp;
      }
      str[n-1] = '\0';
      break;
    }
  }
}

int main(void){
  char str[] ="AC2";
  eliminar(str,'2');
  for(int i = 0; i<strlen(str); i++){
    printf("%c",str[i]);
  }
  printf("\n");
  return 0;
}
